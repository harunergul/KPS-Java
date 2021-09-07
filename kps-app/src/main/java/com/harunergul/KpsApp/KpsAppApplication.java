package com.harunergul.KpsApp;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBElement;

import com.harunergul.KpsApp.dto.KpsTCKisiDurumBilgisiDTO;
import com.harunergul.KpsApp.dto.KpsTcKisiKayitYeriBilgisiDTO;
import com.harunergul.KpsApp.dto.KpsYabanciKisiDurumBilgisiDTO;

import tr.gov.nvi.kps._2011._01._01.Parametre;
import tr.gov.nvi.kps._2011._01._01.TCKisiDurumBilgisi;
import tr.gov.nvi.kps._2011._01._01.TCKisiKayitYeriBilgisi;
import tr.gov.nvi.kps._2011._01._01.TCKisiTemelBilgisi;
import tr.gov.nvi.kps._2011._01._01.TarihBilgisi;
import tr.gov.nvi.kps._2011._01._01.YabanciKisiDurumBilgisi;
import tr.gov.nvi.kps._2011._01._01.YabanciKisiTemelBilgisi;
import tr.gov.nvi.kps._2021._04._01.ArrayOfBilesikKutukBilgileri;
import tr.gov.nvi.kps._2021._04._01.ArrayOfBilesikKutukSorgulaKimlikNoSorguKriteri;
import tr.gov.nvi.kps._2021._04._01.BilesikKutukBilgileri;
import tr.gov.nvi.kps._2021._04._01.BilesikKutukBilgileriSonucu;
import tr.gov.nvi.kps._2021._04._01.BilesikKutukSorgulaKimlikNoServis;
import tr.gov.nvi.kps._2021._04._01.BilesikKutukSorgulaKimlikNoSorguKriteri;
import tr.gov.nvi.kps._2021._04._01.MaviKartKisiKutukleri;
import tr.gov.nvi.kps._2021._04._01.TCCuzdanBilgisi;
import tr.gov.nvi.kps._2021._04._01.TCKK;
import tr.gov.nvi.kps._2021._04._01.TCKisiBilgisi;
import tr.gov.nvi.kps._2021._04._01.TCVatandasiKisiKutukleri;
import tr.gov.nvi.kps._2021._04._01.YabanciKisiBilgisi;
import tr.gov.nvi.kps._2021._04._01.YabanciKisiKutukleri;
import tr.gov.nvi.kps.sts.NviConfiguration;
import tr.gov.nvi.kps.sts.NviConfigurationItem;

public class KpsAppApplication {

	public static void main(String[] args) {

		System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "999999");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold", "999999");

		NviConfigurationItem item = new NviConfigurationItem();
		String stsEndPointURI = "https://kimlikdogrulama.nvi.gov.tr/Services/Issuer.svc/IWSTrust13";
		String kpsEndPointURI = "https://kpsv2.nvi.gov.tr/Services/RoutingService.svc";
//		kpsEndPointURI = "http://kpsv2test.nvi.gov.tr/Services/RoutingService.svc";
		item.setTokenServiceEndpoint(stsEndPointURI);


		KpsKimlikBilgisiDTO kimlik = new KpsKimlikBilgisiDTO();

		BilesikKutukBilgileriSonucu sonuc = birlesikKutukSorgula(person);
		Parametre hataBilgisi = sonuc.getHataBilgisi().getValue();
		if (hataBilgisi != null) {
			Integer hataKodu = hataBilgisi.getKod().getValue();
			String aciklama = hataBilgisi.getAciklama().getValue();
			System.out.println("Hata Kodu     : " + hataKodu);
			System.out.println("Hata Aciklama : " + aciklama);
		} else {
			ArrayOfBilesikKutukBilgileri arrayOfkutukBilgileri = sonuc.getSorguSonucu().getValue();
			List<BilesikKutukBilgileri> bilesikKutukBilgileri = arrayOfkutukBilgileri.getBilesikKutukBilgileri();
			for (BilesikKutukBilgileri bilesikKutukBilgileri2 : bilesikKutukBilgileri) {
				hataBilgisi = bilesikKutukBilgileri2.getHataBilgisi().getValue();
				if (hataBilgisi != null) {
					Integer kod = hataBilgisi.getKod().getValue();
					String aciklama = hataBilgisi.getAciklama().getValue();
					System.out.println("Hata Kodu     : " + kod);
					System.out.println("Hata Aciklama : " + aciklama);
				}

				TCVatandasiKisiKutukleri tcVatandasiKisiKutukleri = bilesikKutukBilgileri2.getTCVatandasiKisiKutukleri()
						.getValue();

				TCKK tckkBilgisi = tcVatandasiKisiKutukleri.getTCKKBilgisi().getValue();
				if (tckkBilgisi.getAd().getValue() != null) {

					TCCuzdanBilgisi ncBilgisi = tcVatandasiKisiKutukleri.getNufusCuzdaniBilgisi().getValue();

					if (ncBilgisi != null) {
						kimlik.setCuzdanKayitNo(ncBilgisi.getCuzdanKayitNo().getValue());
						kimlik.setDogumYeri(ncBilgisi.getDogumYer().getValue());
						kimlik.setCuzdanNo(ncBilgisi.getNo().getValue());
						kimlik.setCuzdanSeriNo(ncBilgisi.getSeri().getValue());
						kimlik.setVerildigiIlce(getParameter(ncBilgisi.getVerildigiIlce().getValue()));
						kimlik.setCuzdanVerilmeNeden(getParameter(ncBilgisi.getCuzdanVerilmeNeden().getValue()));
					}
					
					
					
					
					kimlik.setKimlikTipi(KimlikTipi.TC_UYRUKLU);
					kimlik.setTcKimlikNo(tckkBilgisi.getTCKimlikNo().getValue());
					kimlik.setAd(tckkBilgisi.getAd().getValue());
					kimlik.setAnneAd(tckkBilgisi.getAnneAd().getValue());
					kimlik.setBabaAd(tckkBilgisi.getBabaAd().getValue());
					kimlik.setCinsiyet(getParameter(tckkBilgisi.getCinsiyet().getValue()));
					kimlik.setDogumTarihi(getDate(tckkBilgisi.getDogumTarih().getValue()));
					kimlik.setKanGurubu(getParameter(tckkBilgisi.getKanGrubu().getValue()));
					kimlik.setSeriNo(tckkBilgisi.getSeriNo().getValue());
					kimlik.setSonGecerlilikTarih(getDate(tckkBilgisi.getSonGecerlilikTarih().getValue()));
					kimlik.setSoyad(tckkBilgisi.getSoyad().getValue());
					kimlik.setSurucuBelgeYuklendiMi(tckkBilgisi.getSurucuBelgeYuklendiMi().getValue());
					kimlik.setSurucuBelgeYuklenmeTarih(getDate(tckkBilgisi.getSurucuBelgeYuklenmeTarih().getValue()));
					kimlik.setVerenMakam(tckkBilgisi.getVerenMakam().getValue());

					fillTemelBilgisi(kimlik, tcVatandasiKisiKutukleri.getKisiBilgisi().getValue());
				}

				MaviKartKisiKutukleri maviKartliKisiKutukleri = bilesikKutukBilgileri2.getMaviKartliKisiKutukleri()
						.getValue();
				YabanciKisiKutukleri yabanciKisiKutukleri = bilesikKutukBilgileri2.getYabanciKisiKutukleri().getValue();
				YabanciKisiBilgisi yabanciKisiBilgisi = yabanciKisiKutukleri.getKisiBilgisi().getValue();
				YabanciKisiTemelBilgisi yabanciKisiTemelBilgisi = yabanciKisiBilgisi.getTemelBilgisi().getValue();
				if (yabanciKisiTemelBilgisi != null && yabanciKisiTemelBilgisi.getAd().getValue() != null) {
					kimlik.setKimlikTipi(KimlikTipi.YABANCI_UYRUKLU);
					kimlik.setTcKimlikNo(yabanciKisiBilgisi.getKimlikNo().getValue());
					kimlik.setAd(yabanciKisiTemelBilgisi.getAd().getValue());
					kimlik.setSoyad(yabanciKisiTemelBilgisi.getSoyad().getValue());
					kimlik.setAnneAd(yabanciKisiTemelBilgisi.getAnneAd().getValue());
					kimlik.setBabaAd(yabanciKisiTemelBilgisi.getBabaAd().getValue());
					kimlik.setCinsiyet(getParameter(yabanciKisiTemelBilgisi.getCinsiyet().getValue()));
					kimlik.setDogumTarihi(getDate(yabanciKisiBilgisi.getDogumTarih().getValue()));
					kimlik.setUyruk(getParameter(yabanciKisiBilgisi.getUyruk().getValue()));
					kimlik.setDogumYerKod(yabanciKisiBilgisi.getDogumYerKod().getValue());

					YabanciKisiDurumBilgisi dto = yabanciKisiBilgisi.getDurumBilgisi().getValue();
 					KpsYabanciKisiDurumBilgisiDTO durumBilgisiDTO = new KpsYabanciKisiDurumBilgisiDTO();
					durumBilgisiDTO.setDurum(getParameter(dto.getDurum().getValue()));
					durumBilgisiDTO.setMedeniHal(getParameter(dto.getMedeniHal().getValue()));
					
					kimlik.setYabanciKisiDurumBilgisiDTO(durumBilgisiDTO);
					

				}
			}
		}

	}

	private static void fillTemelBilgisi(KpsKimlikBilgisiDTO kimlik, TCKisiBilgisi kisiBilgisi) {

		TCKisiTemelBilgisi temelBilgisi = kisiBilgisi.getTemelBilgisi().getValue();
		if (temelBilgisi != null) {
			kimlik.setAd(temelBilgisi.getAd().getValue());
			kimlik.setAnneAd(temelBilgisi.getAnneAd().getValue());
			kimlik.setBabaAd(temelBilgisi.getBabaAd().getValue());
			kimlik.setSoyad(temelBilgisi.getSoyad().getValue());
			kimlik.setCinsiyet(getParameter(temelBilgisi.getCinsiyet().getValue()));
			kimlik.setDogumTarihi(getDate(temelBilgisi.getDogumTarih().getValue()));
			kimlik.setDogumYeri(temelBilgisi.getDogumYer().getValue());
		}
		
		TCKisiKayitYeriBilgisi kayitYeriBilgisi = kisiBilgisi.getKayitYeriBilgisi().getValue();
		if(kayitYeriBilgisi!=null) {
			KpsTcKisiKayitYeriBilgisiDTO kybDTO = new KpsTcKisiKayitYeriBilgisiDTO();
			kybDTO.setAileSiraNo(kayitYeriBilgisi.getAileSiraNo().getValue());
			kybDTO.setBireySiraNo(kayitYeriBilgisi.getBireySiraNo().getValue());
			kybDTO.setCilt(getParameter(kayitYeriBilgisi.getCilt().getValue()));
			kybDTO.setIl(getParameter(kayitYeriBilgisi.getIl().getValue()));
			kybDTO.setIlce(getParameter(kayitYeriBilgisi.getIlce().getValue()));
			
			kimlik.setKayitYeriBilgisiDTO(kybDTO);
		}
		
		TCKisiDurumBilgisi durumBilgisi = kisiBilgisi.getDurumBilgisi().getValue();
		if(durumBilgisi!=null) {
			KpsTCKisiDurumBilgisiDTO dto = new KpsTCKisiDurumBilgisiDTO();
			dto.setDin(getParameter(durumBilgisi.getDin().getValue()));
			dto.setDurum(getParameter(durumBilgisi.getDurum().getValue()));
			dto.setMedeniHal(getParameter(durumBilgisi.getMedeniHal().getValue()));
			dto.setOlumTarihi(getDate(durumBilgisi.getOlumTarih().getValue()));
			kimlik.setDurumBilgisiDTO(dto);
		}
	}

	private static Date getDate(TarihBilgisi tarihBilgisi) {
		Calendar cal = Calendar.getInstance();
		if (tarihBilgisi != null) {
			if (tarihBilgisi.getAy().getValue() != null) {
				cal.set(Calendar.MONTH, tarihBilgisi.getAy().getValue() - 1);
			}
			if (tarihBilgisi.getGun().getValue() != null) {
				cal.set(Calendar.DAY_OF_MONTH, tarihBilgisi.getGun().getValue());
			}
			if (tarihBilgisi.getYil().getValue() != null) {
				cal.set(Calendar.YEAR, tarihBilgisi.getYil().getValue());
			}

		}
		return cal.getTime();
	}

	private static Parameter getParameter(Parametre parameter) {
		Parameter par = new Parameter();
		if (parameter != null) {
			par.setKod(parameter.getKod().getValue());
			par.setValue(parameter.getAciklama().getValue());
		}
		return par;
	}

	private static BilesikKutukBilgileriSonucu birlesikKutukSorgula(KpsPersonDTO personDTO) {
		BilesikKutukSorgulaKimlikNoServis bilesikKutukSorgulamaServis = KPSClientFactory.Instance
				.getBilesikKutukSorgulaKimlikNoServis();
		tr.gov.nvi.kps._2021._04._01.ObjectFactory factory = new tr.gov.nvi.kps._2021._04._01.ObjectFactory();

		ArrayOfBilesikKutukSorgulaKimlikNoSorguKriteri value;
		JAXBElement<Integer> month = factory.createBilesikKutukSorgulaKimlikNoSorguKriteriDogumAy(personDTO.month);
		JAXBElement<Integer> day = factory.createBilesikKutukSorgulaKimlikNoSorguKriteriDogumGun(personDTO.day);
		JAXBElement<Integer> year = factory.createBilesikKutukSorgulaKimlikNoSorguKriteriDogumYil(personDTO.year);
		JAXBElement<Long> identificationNo = factory.createBilesikKutukBilgileriKimlikNo(personDTO.identificationNo);

		value = new ArrayOfBilesikKutukSorgulaKimlikNoSorguKriteri();
		BilesikKutukSorgulaKimlikNoSorguKriteri kriter = new BilesikKutukSorgulaKimlikNoSorguKriteri();
		kriter.setDogumAy(month);
		kriter.setDogumGun(day);
		kriter.setDogumYil(year);
		kriter.setKimlikNo(identificationNo);
		value.getBilesikKutukSorgulaKimlikNoSorguKriteri().add(kriter);
		return bilesikKutukSorgulamaServis.sorgula(value);
	}

}
