package tr.gov.nvi.kps.sts;

import java.util.Collections;
import java.util.List;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

@SuppressWarnings("rawtypes")
public class NviDefaultHandlerResolver implements HandlerResolver { 
	public final static NviDefaultHandlerResolver Instance = new NviDefaultHandlerResolver();
	
    private List<Handler> defaultList;
    
    private NviDefaultHandlerResolver() {
        defaultList = Collections.singletonList((Handler)new NviStsHandler());
    }
    
    public List<Handler> getHandlerChain(PortInfo portInfo) {
        return defaultList;
    }
    
}
