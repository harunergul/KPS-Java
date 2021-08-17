package tr.gov.nvi.kps.sts;

import java.util.HashMap;
import java.util.Map;

import tr.gov.nvi.kps.sts.client.NviTokenProvider;

public class NviConfiguration {
    public final static NviConfiguration Instance = new NviConfiguration();

    private Map<String, NviConfigurationItem> configurationsMap = new HashMap<String, NviConfigurationItem>();
    
    private NviConfiguration() {
        
    }
    
    public void clear() {
    	configurationsMap.clear();
    	
    	NviTokenProvider.Instance.clear();
    }
    
    public boolean hasConfiguration(String appliesToUri) {
    	System.err.println("Fix here");
    	System.err.println("Hdm codevalue requesti yapilacak");
    	
    	boolean hasConfiguration = configurationsMap.containsKey(appliesToUri);
    	if(hasConfiguration) {
    		NviConfigurationItem configuration = configurationsMap.get(appliesToUri);
    	}
        return configurationsMap.containsKey(appliesToUri);
    }
    
    public NviConfigurationItem getConfiguration(String appliesToUri) {
        if (configurationsMap.containsKey(appliesToUri)) {
            return configurationsMap.get(appliesToUri);
        }
        
        return null;
    }
    
    public void addConfiguration(String appliesToUri, NviConfigurationItem config) {
        configurationsMap.put(appliesToUri, config);
    }
    
    public void removeConfiguration(String appliesToUri) {
        configurationsMap.remove(appliesToUri);
    }
    
}
