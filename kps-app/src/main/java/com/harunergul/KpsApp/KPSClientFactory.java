package com.harunergul.KpsApp;

import javax.xml.ws.soap.AddressingFeature;

import tr.gov.nvi.kps._2021._04._01.BilesikKutukSorgulaKimlikNoServis;
import tr.gov.nvi.kps._2021._04._01.BilesikKutukSorgulaKimlikNoServis_Service;

public class KPSClientFactory {
	
	public static KPSClientFactory Instance = new KPSClientFactory();
    private final Object syncObject = new Object();

	
	private volatile BilesikKutukSorgulaKimlikNoServis_Service bilesikKutukSorgulaService = null;
	
	private KPSClientFactory(){
		super();
	}
	
	public BilesikKutukSorgulaKimlikNoServis getBilesikKutukSorgulaKimlikNoServis() {
		
		if(bilesikKutukSorgulaService==null) {
			synchronized (syncObject) {
				bilesikKutukSorgulaService = new BilesikKutukSorgulaKimlikNoServis_Service();;
			}
		}
		return bilesikKutukSorgulaService.getCustomBindingBilesikKutukSorgulaKimlikNoServis(new AddressingFeature());
	}
	

}
