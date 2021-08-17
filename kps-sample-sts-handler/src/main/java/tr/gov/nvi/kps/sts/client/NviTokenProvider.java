package tr.gov.nvi.kps.sts.client;

import java.util.HashMap;
import java.util.Map;

public class NviTokenProvider {

    public static NviTokenProvider Instance = new NviTokenProvider();
    private final Object syncObject = new Object();
    private Map<String, NviTokenProviderService> services = new HashMap<String, NviTokenProviderService>();

    private NviTokenProvider() {
    }
    
    public void clear() {
    	synchronized (syncObject) {
    		services.clear();
		}
    }

    public NviTokenProviderService getService(String endpointUri, String appliesToUri) {
        if (services.containsKey(endpointUri) == false) {
            synchronized (syncObject) {
                if (services.containsKey(endpointUri) == false) {
                    services.put(endpointUri, new NviTokenProviderService(endpointUri, appliesToUri));
                }
            }
        }

        return services.get(endpointUri);
    }
}
