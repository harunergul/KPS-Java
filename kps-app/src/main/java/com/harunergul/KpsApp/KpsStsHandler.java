package com.harunergul.KpsApp;

import java.io.PrintStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.ProtocolException;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.c14n.Canonicalizer;
import org.apache.xml.security.c14n.InvalidCanonicalizerException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import tr.gov.nvi.kps.sts.NviConfiguration;
import tr.gov.nvi.kps.sts.NviConfigurationItem;
import tr.gov.nvi.kps.sts.NviStsHandler;
import tr.gov.nvi.kps.sts.client.NviTokenProvider;
import tr.gov.nvi.kps.sts.client.NviTokenProviderService;
import tr.gov.nvi.kps.sts.client.token.NviConstants;
import tr.gov.nvi.kps.sts.client.token.NviNamespaces;
import tr.gov.nvi.kps.sts.client.token.NviSecurityToken;
import tr.gov.nvi.kps.sts.client.utilities.Helper;

public class KpsStsHandler implements SOAPHandler<SOAPMessageContext> {

	static {
		org.apache.xml.security.Init.init();
	}
	private static PrintStream out = System.out;

	@Override
	public boolean handleMessage(SOAPMessageContext messageContext) {

		boolean outbound = (Boolean) messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		if (outbound) {
			try {
				SOAPMessage msg = messageContext.getMessage();

				String appliesTo = (String) messageContext.get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);

				if (NviConfiguration.Instance.hasConfiguration(appliesTo)) {
					NviConfigurationItem config = NviConfiguration.Instance.getConfiguration(appliesTo);

					NviTokenProviderService tokenProviderService = NviTokenProvider.Instance
							.getService(config.getTokenServiceEndpoint(), appliesTo);
					NviSecurityToken token = tokenProviderService.getToken(config.getUsername(), config.getPassword());

					applySecurityToken(msg, token);
				}

				return true;
			} catch (NoSuchAlgorithmException ex) {
				Logger.getLogger(NviStsHandler.class.getName()).log(Level.SEVERE, null, ex);

				throw new ProtocolException("Unable to find the specified algorithm.", ex);
			} catch (InvalidAlgorithmParameterException ex) {
				Logger.getLogger(NviStsHandler.class.getName()).log(Level.SEVERE, null, ex);

				throw new ProtocolException("Invalid algorithm parameters specified.", ex);
			} catch (MarshalException ex) {
				Logger.getLogger(NviStsHandler.class.getName()).log(Level.SEVERE, null, ex);

				throw new ProtocolException("Unable to marshal XML signature.", ex);
			} catch (XMLSignatureException ex) {
				Logger.getLogger(NviStsHandler.class.getName()).log(Level.SEVERE, null, ex);

				throw new ProtocolException("Unable to build XML signature.", ex);
			} catch (SOAPException ex) {
				Logger.getLogger(NviStsHandler.class.getName()).log(Level.SEVERE, null, ex);

				throw new ProtocolException("SOAP operation failed.", ex);
			} catch (InvalidKeyException ex) {
				Logger.getLogger(NviStsHandler.class.getName()).log(Level.SEVERE, null, ex);

				throw new ProtocolException("Key is not valid.", ex);
			} catch (InvalidCanonicalizerException ex) {
				Logger.getLogger(NviStsHandler.class.getName()).log(Level.SEVERE, null, ex);

				throw new ProtocolException("Canonicalizer not found.", ex);
			} catch (CanonicalizationException ex) {
				Logger.getLogger(NviStsHandler.class.getName()).log(Level.SEVERE, null, ex);

				throw new ProtocolException("Canonicalization failed.", ex);
			}
		}

		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<QName> getHeaders() {
		final QName securityHeader = new QName(
	            "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd",
	            "Security",
	            "wsse");

	        final Set<QName> headers = new HashSet<>();
	        headers.add(securityHeader);

	        // notify the runtime that this is handled
	        return headers;
	}

	private void applySecurityToken(SOAPMessage message, NviSecurityToken token)
			throws SOAPException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, MarshalException,
			XMLSignatureException, InvalidKeyException, InvalidCanonicalizerException, CanonicalizationException {
		SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
		buildNamespaces(envelope);

		SOAPHeader header = envelope.getHeader();
		if (header == null) {
			envelope.addHeader();
		}

		buildMessageHeader(envelope.getHeader(), token);
	}

	private void buildNamespaces(SOAPEnvelope envelope) throws SOAPException {
//		envelope.addNamespaceDeclaration("s", "http://www.w3.org/2003/05/soap-envelope" );
//		envelope.addNamespaceDeclaration("u","http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
//		envelope.addNamespaceDeclaration("dsig","http://www.w3.org/2000/09/xmldsig#");
//		
		
		envelope.addNamespaceDeclaration(NviNamespaces.NS_ADDRESSING_PREFIX, NviNamespaces.NS_ADDRESSING);
		envelope.addNamespaceDeclaration(NviNamespaces.NS_ENVELOPE_PREFIX, NviNamespaces.NS_ENVELOPE);
		envelope.addNamespaceDeclaration(NviNamespaces.NS_POLICY_PREFIX, NviNamespaces.NS_POLICY);
		envelope.addNamespaceDeclaration(NviNamespaces.NS_SECURITY_PREFIX, NviNamespaces.NS_SECURITY);
		envelope.addNamespaceDeclaration(NviNamespaces.NS_SECURITY_UTIL_PREFIX, NviNamespaces.NS_SECURITY_UTIL);
		envelope.addNamespaceDeclaration(NviNamespaces.NS_TRUST_PREFIX, NviNamespaces.NS_TRUST);
		envelope.addNamespaceDeclaration(NviNamespaces.NS_XML_SIGNATURE_PREFIX, NviNamespaces.NS_XML_SIGNATURE);
	}

	private void buildMessageHeader(SOAPHeader header, NviSecurityToken token)
			throws SOAPException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, MarshalException,
			XMLSignatureException, InvalidKeyException, InvalidCanonicalizerException, CanonicalizationException {
		SOAPElement securityElement = header.addChildElement(NviConstants.TAG_SECURITY, NviNamespaces.NS_SECURITY_PREFIX);
		securityElement.setAttributeNS(NviNamespaces.NS_ENVELOPE, NviNamespaces.NS_ENVELOPE_PREFIX + ":" + NviConstants.ATT_MUSTUNDERSTAND, "1");

		// Build Time Stamp...
		SOAPElement timestampElement = securityElement.addChildElement(NviConstants.TAG_TIMESTAMP, NviNamespaces.NS_SECURITY_UTIL_PREFIX);
		timestampElement.addAttribute(NviConstants.ATT_TIMESTAMP_ID, "_0");
		SOAPElement createdElement = timestampElement.addChildElement(NviConstants.TAG_TIMESTAMP_CREATED,
				NviNamespaces.NS_SECURITY_UTIL_PREFIX);
		SOAPElement expiresElement = timestampElement.addChildElement(NviConstants.TAG_TIMESTAMP_EXPIRES,
				NviNamespaces.NS_SECURITY_UTIL_PREFIX);

		Calendar created = Calendar.getInstance();
		Calendar expires = (Calendar) created.clone();
		expires.add(Calendar.MINUTE, 5);

		createdElement.addTextNode(Helper.formatDate(created.getTime()));
		expiresElement.addTextNode(Helper.formatDate(expires.getTime()));

		Node securityTokenNode = token.getSecurityToken().cloneNode(true);
		Node importedSecurityTokenNode = header.getOwnerDocument().importNode(securityTokenNode, true);
		securityElement.appendChild(importedSecurityTokenNode);

		buildSimpleSignature(securityElement, timestampElement, token);
	}

	private void buildSimpleSignature(SOAPElement securityElement, SOAPElement timestampElement, NviSecurityToken token)
			throws SOAPException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, MarshalException,
			XMLSignatureException, InvalidCanonicalizerException, CanonicalizationException, InvalidKeyException {
		SOAPElement signatureElement = securityElement.addChildElement(NviConstants.TAG_SIGNATURE,
				NviNamespaces.NS_XML_SIGNATURE_PREFIX);
		SOAPElement signedInfoElement = signatureElement.addChildElement(NviConstants.TAG_SIGNEDINFO,
				NviNamespaces.NS_XML_SIGNATURE_PREFIX);

		SOAPElement canonElement = signedInfoElement.addChildElement(NviConstants.TAG_CANONALIZATION_METHOD,
				NviNamespaces.NS_XML_SIGNATURE_PREFIX);
		canonElement.setAttribute(NviConstants.ATT_ALGORITHM, NviConstants.CST_ALGORITHM_C14N);

		SOAPElement sigMethodElement = signedInfoElement.addChildElement(NviConstants.TAG_SIGNATURE_METHOD,
				NviNamespaces.NS_XML_SIGNATURE_PREFIX);
		sigMethodElement.setAttribute(NviConstants.ATT_ALGORITHM, NviConstants.CST_ALGORITHM_HMAC_SHA1);

		SOAPElement referenceElement = signedInfoElement.addChildElement(NviConstants.TAG_REFERENCE,
				NviNamespaces.NS_XML_SIGNATURE_PREFIX);
		referenceElement.setAttribute(NviConstants.ATT_URI, "#_0");
		SOAPElement transformsElement = referenceElement.addChildElement(NviConstants.TAG_TRANSFORMS,
				NviNamespaces.NS_XML_SIGNATURE_PREFIX);
		SOAPElement transformElement = transformsElement.addChildElement(NviConstants.TAG_TRANSFORM,
				NviNamespaces.NS_XML_SIGNATURE_PREFIX);
		transformElement.setAttribute(NviConstants.ATT_ALGORITHM, NviConstants.CST_ALGORITHM_C14N);
		SOAPElement digestMethodElement = referenceElement.addChildElement(NviConstants.TAG_DIGEST_METHOD,
				NviNamespaces.NS_XML_SIGNATURE_PREFIX);
		digestMethodElement.setAttribute(NviConstants.ATT_ALGORITHM, NviConstants.CST_ALGORITHM_SHA1);
		SOAPElement digestValueElement = referenceElement.addChildElement(NviConstants.TAG_DIGEST_VALUE,
				NviNamespaces.NS_XML_SIGNATURE_PREFIX);
		digestValueElement.addTextNode(Helper.encodeBytes(computeDigest(canonalize(timestampElement))));

		SOAPElement signatureValueElement = signatureElement.addChildElement(NviConstants.TAG_SIGNATURE_VALUE,
				NviNamespaces.NS_XML_SIGNATURE_PREFIX);
		signatureValueElement.addTextNode(
				Helper.encodeBytes(computeHmacSha1(canonalize(signedInfoElement), token.getProofTokenSecret())));

		SOAPElement keyInfoElement = signatureElement.addChildElement(NviConstants.TAG_KEY_INFO,
				NviNamespaces.NS_XML_SIGNATURE_PREFIX);

		Node tokenReferenceNode = token.getSecurityTokenReference().cloneNode(true);
		Node importedTokenReferenceNode = securityElement.getOwnerDocument().importNode(tokenReferenceNode, true);
		keyInfoElement.appendChild(importedTokenReferenceNode);
	}

	private byte[] canonalize(Element e) throws InvalidCanonicalizerException, CanonicalizationException {
		Canonicalizer cInstance = Canonicalizer.getInstance(CanonicalizationMethod.EXCLUSIVE);

		byte[] result = cInstance.canonicalizeSubtree(e);

		return result;
	}

	private byte[] computeDigest(byte[] input) throws NoSuchAlgorithmException {
		return MessageDigest.getInstance("SHA1").digest(input);
	}

	private byte[] computeHmacSha1(byte[] input, byte[] key) throws NoSuchAlgorithmException, InvalidKeyException {
		SecretKey keySpec = new SecretKeySpec(key, "HmacSHA1");

		Mac m = Mac.getInstance("HmacSHA1");
		m.init(keySpec);
		m.update(input);

		return m.doFinal();
	}
	
	private void logToSystemOut(SOAPMessageContext smc) {
        Boolean outboundProperty = (Boolean)
            smc.get (MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (outboundProperty.booleanValue()) {
            out.println("\nOutbound message:");
        } else {
            out.println("\nInbound message:");
        }

        SOAPMessage message = smc.getMessage();
        try {
            message.writeTo(out);
            out.println("");   // just to add a newline
        } catch (Exception e) {
            out.println("Exception in handler: " + e);
        }
    }

}
