package tr.gov.nvi.kps.sts.client.utilities;

import java.util.UUID;

import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;

import tr.gov.nvi.kps.sts.client.token.NviConstants;
import tr.gov.nvi.kps.sts.client.token.NviNamespaces;

public class AddressingHelper {

	private AddressingHelper() {
		
	}
	
	public static String constructAddressingHeaders(SOAPHeader header, String action, String endpointUri) throws SOAPException {
		String messageId = buildMessageId();
		
		SOAPElement actionElement = header.addChildElement(NviConstants.TAG_ACTION, NviNamespaces.NS_ADDRESSING_PREFIX);
		actionElement.addAttribute(NviConstants.ATT_MUSTUNDERSTAND_NAME, "1");
		actionElement.addTextNode(action);
		
		SOAPElement messageIdElement = header.addChildElement(NviConstants.TAG_MESSAGE_ID, NviNamespaces.NS_ADDRESSING_PREFIX);
		messageIdElement.addTextNode(messageId);
		
		SOAPElement replyToElement = header.addChildElement(NviConstants.TAG_REPLY_TO, NviNamespaces.NS_ADDRESSING_PREFIX);
		SOAPElement replyToAddressElement = replyToElement.addChildElement(NviConstants.TAG_ADDRESS, NviNamespaces.NS_ADDRESSING_PREFIX);
		replyToAddressElement.addTextNode(NviConstants.CST_ANONYMOUS_ADDRESS);
		
		SOAPElement toElement = header.addChildElement(NviConstants.TAG_TO, NviNamespaces.NS_ADDRESSING_PREFIX);
		toElement.addAttribute(NviConstants.ATT_MUSTUNDERSTAND_NAME, "1");
		toElement.addTextNode(endpointUri);
		
		return messageId;
	}
	
	private static String buildMessageId() {
		return String.format("urn:uuid:%s", UUID.randomUUID().toString());
	}
	
}
