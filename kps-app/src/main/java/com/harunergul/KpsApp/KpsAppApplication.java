package com.harunergul.KpsApp;

import javax.xml.bind.JAXBElement;

import tr.gov.nvi.kps._2021._04._01.ArrayOfBilesikKutukSorgulaKimlikNoSorguKriteri;
import tr.gov.nvi.kps._2021._04._01.BilesikKutukSorgulaKimlikNoServis;
import tr.gov.nvi.kps._2021._04._01.BilesikKutukSorgulaKimlikNoSorguKriteri;
import tr.gov.nvi.kps.sts.NviConfiguration;
import tr.gov.nvi.kps.sts.NviConfigurationItem;

public class KpsAppApplication {

	public static void main(String[] args) {
		
		System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "999999");
		
		NviConfigurationItem item = new NviConfigurationItem();
		String stsEndPointURI = "https://kimlikdogrulama.nvi.gov.tr/Services/Issuer.svc/IWSTrust13";
		String kpsEndPointURI = "https://kpsv2.nvi.gov.tr/Services/RoutingService.svc";
		item.setTokenServiceEndpoint(stsEndPointURI);
		item.setUsername("22526655878");
		item.setPassword("Alper1992".toCharArray());

		NviConfiguration.Instance.clear();
		NviConfiguration.Instance.addConfiguration(kpsEndPointURI, item);
		
		BilesikKutukSorgulaKimlikNoServis bilesikKutukSorgulamaServis = KPSClientFactory.Instance.getBilesikKutukSorgulaKimlikNoServis();
		
		
		sorgula(bilesikKutukSorgulamaServis, 13, 5, 1992, 14041461416L);
		
	}

	private static void sorgula(BilesikKutukSorgulaKimlikNoServis bilesikKutukSorgulamaServis, int month, int day, int year, Long identificationNo ) {
		tr.gov.nvi.kps._2021._04._01.ObjectFactory factory =new tr.gov.nvi.kps._2021._04._01.ObjectFactory();
		
		ArrayOfBilesikKutukSorgulaKimlikNoSorguKriteri value;
		JAXBElement<Integer> _month = factory.createBilesikKutukSorgulaKimlikNoSorguKriteriDogumAy(month);
		JAXBElement<Integer> _day = factory.createBilesikKutukSorgulaKimlikNoSorguKriteriDogumGun(day);
		JAXBElement<Integer> _year =  factory.createBilesikKutukSorgulaKimlikNoSorguKriteriDogumYil(year);
		JAXBElement<Long> _identificationNo  = factory.createBilesikKutukBilgileriKimlikNo(identificationNo);
		
		value = new  ArrayOfBilesikKutukSorgulaKimlikNoSorguKriteri();
		BilesikKutukSorgulaKimlikNoSorguKriteri kriter = new BilesikKutukSorgulaKimlikNoSorguKriteri();
		kriter.setDogumAy(_month);
		kriter.setDogumGun(_day);
		kriter.setDogumYil(_year);
		kriter.setKimlikNo(_identificationNo);
		value.getBilesikKutukSorgulaKimlikNoSorguKriteri().add(kriter);
		bilesikKutukSorgulamaServis.sorgula(value);
	}

}
