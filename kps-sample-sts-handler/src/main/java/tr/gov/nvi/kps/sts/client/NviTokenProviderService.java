package tr.gov.nvi.kps.sts.client;

import java.util.HashMap;
import java.util.Map;

import javax.xml.soap.SOAPException;

import tr.gov.nvi.kps.sts.client.token.NviSecurityToken;
import tr.gov.nvi.kps.sts.client.token.NviSecurityTokenClient;

public class NviTokenProviderService {

    private final Object syncObject = new Object();
    private String endpointUri = null;
    private String appliesToUri = null;
    private final Map<String, NviSecurityToken> allTokens = new HashMap<String, NviSecurityToken>();
    private volatile NviSecurityTokenClient tokenRequester = null;

    public NviTokenProviderService(String endpointUri, String appliesToUri) {
        this.endpointUri = endpointUri;
        this.appliesToUri = appliesToUri;
    }

    public NviSecurityToken getToken(String username, char[] password)
            throws SOAPException {
        NviSecurityToken currentToken = allTokens.get(username);

        if (currentToken == null || currentToken.isValid() == false) {
            synchronized (syncObject) {
                currentToken = allTokens.get(username);

                if (currentToken == null || currentToken.isValid() == false) {
                    allTokens.put(username, getTokenRequester().requestToken(username, password));
                }
            }
        }
        
        return allTokens.get(username);
    }

    private NviSecurityTokenClient getTokenRequester() {
        if (tokenRequester == null) {
            synchronized (syncObject) {
                if (tokenRequester == null) {
                    tokenRequester = new NviSecurityTokenClient(endpointUri, appliesToUri);
                }
            }
        }

        return tokenRequester;
    }
}
