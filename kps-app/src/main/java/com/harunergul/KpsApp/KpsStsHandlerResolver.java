package com.harunergul.KpsApp;

import java.util.Collections;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

public class KpsStsHandlerResolver implements HandlerResolver {
	public final static KpsStsHandlerResolver Instance = new KpsStsHandlerResolver();

	private List<Handler> defaultList;

	private KpsStsHandlerResolver() {
		defaultList = Collections.singletonList((Handler) new KpsStsHandler());
	}

	public List<Handler> getHandlerChain(PortInfo portInfo) {
		return defaultList;
	}

}
