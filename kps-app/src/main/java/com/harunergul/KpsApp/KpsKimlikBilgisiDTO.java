package com.harunergul.KpsApp;

import java.util.Date;

import com.harunergul.KpsApp.dto.KpsTCKisiDurumBilgisiDTO;
import com.harunergul.KpsApp.dto.KpsTcKisiKayitYeriBilgisiDTO;
import com.harunergul.KpsApp.dto.KpsYabanciKisiDurumBilgisiDTO;

public class KpsKimlikBilgisiDTO {

	private KimlikTipi kimlikTipi;
	private Long tcKimlikNo;
	private String ad;
	private String anneAd;
	private String babaAd;
	private String soyad;
	private Parameter cinsiyet;
	private Date dogumTarihi;
	private String dogumYeri;
	private Parameter kanGurubu;
	private String seriNo;
	private Date sonGecerlilikTarih;
	private Boolean surucuBelgeYuklendiMi;
	private Date surucuBelgeYuklenmeTarih;
	private String verenMakam;
	private Parameter medeniHal;

	private Long cuzdanKayitNo;
	private Parameter cuzdanVerilmeNeden;
	private Integer cuzdanNo;
	private String cuzdanSeriNo;
	private Parameter verildigiIlce;
	
	private Integer dogumYerKod; //Hangi ulke oldugunu belirtir.
	private KpsTcKisiKayitYeriBilgisiDTO kayitYeriBilgisiDTO;
	private KpsTCKisiDurumBilgisiDTO durumBilgisiDTO; //tc vatandasi icin
	private KpsYabanciKisiDurumBilgisiDTO yabanciKisiDurumBilgisiDTO;
	

	private Parameter uyruk;

	public Long getTcKimlikNo() {
		return tcKimlikNo;
	}

	public void setTcKimlikNo(Long tcKimlikNo) {
		this.tcKimlikNo = tcKimlikNo;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getAnneAd() {
		return anneAd;
	}

	public void setAnneAd(String anneAd) {
		this.anneAd = anneAd;
	}

	public String getBabaAd() {
		return babaAd;
	}

	public void setBabaAd(String babaAd) {
		this.babaAd = babaAd;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public Parameter getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(Parameter cinsiyet) {
		this.cinsiyet = cinsiyet;
	}

	public Date getDogumTarihi() {
		return dogumTarihi;
	}

	public void setDogumTarihi(Date dogumTarihi) {
		this.dogumTarihi = dogumTarihi;
	}

	public Parameter getKanGurubu() {
		return kanGurubu;
	}

	public void setKanGurubu(Parameter kanGurubu) {
		this.kanGurubu = kanGurubu;
	}

	public String getSeriNo() {
		return seriNo;
	}

	public void setSeriNo(String seriNo) {
		this.seriNo = seriNo;
	}

	public Date getSonGecerlilikTarih() {
		return sonGecerlilikTarih;
	}

	public void setSonGecerlilikTarih(Date sonGecerlilikTarih) {
		this.sonGecerlilikTarih = sonGecerlilikTarih;
	}

	public Boolean getSurucuBelgeYuklendiMi() {
		return surucuBelgeYuklendiMi;
	}

	public void setSurucuBelgeYuklendiMi(Boolean surucuBelgeYuklendiMi) {
		this.surucuBelgeYuklendiMi = surucuBelgeYuklendiMi;
	}

	public Date getSurucuBelgeYuklenmeTarih() {
		return surucuBelgeYuklenmeTarih;
	}

	public void setSurucuBelgeYuklenmeTarih(Date surucuBelgeYuklenmeTarih) {
		this.surucuBelgeYuklenmeTarih = surucuBelgeYuklenmeTarih;
	}

	public String getVerenMakam() {
		return verenMakam;
	}

	public void setVerenMakam(String verenMakam) {
		this.verenMakam = verenMakam;
	}

	public KimlikTipi getKimlikTipi() {
		return kimlikTipi;
	}

	public void setKimlikTipi(KimlikTipi kimlikTipi) {
		this.kimlikTipi = kimlikTipi;
	}

	public Parameter getUyruk() {
		return uyruk;
	}

	public void setUyruk(Parameter uyruk) {
		this.uyruk = uyruk;
	}

	public Parameter getMedeniHal() {
		return medeniHal;
	}

	public void setMedeniHal(Parameter medeniHal) {
		this.medeniHal = medeniHal;
	}

	public String getDogumYeri() {
		return dogumYeri;
	}

	public void setDogumYeri(String dogumYeri) {
		this.dogumYeri = dogumYeri;
	}

	public Long getCuzdanKayitNo() {
		return cuzdanKayitNo;
	}

	public void setCuzdanKayitNo(Long cuzdanKayitNo) {
		this.cuzdanKayitNo = cuzdanKayitNo;
	}

	public Parameter getCuzdanVerilmeNeden() {
		return cuzdanVerilmeNeden;
	}

	public void setCuzdanVerilmeNeden(Parameter cuzdanVerilmeNeden) {
		this.cuzdanVerilmeNeden = cuzdanVerilmeNeden;
	}

	public Integer getCuzdanNo() {
		return cuzdanNo;
	}

	public void setCuzdanNo(Integer cuzdanNo) {
		this.cuzdanNo = cuzdanNo;
	}

	public String getCuzdanSeriNo() {
		return cuzdanSeriNo;
	}

	public void setCuzdanSeriNo(String cuzdanSeriNo) {
		this.cuzdanSeriNo = cuzdanSeriNo;
	}

	public Parameter getVerildigiIlce() {
		return verildigiIlce;
	}

	public void setVerildigiIlce(Parameter verildigiIlce) {
		this.verildigiIlce = verildigiIlce;
	}

	public KpsTcKisiKayitYeriBilgisiDTO getKayitYeriBilgisiDTO() {
		return kayitYeriBilgisiDTO;
	}

	public void setKayitYeriBilgisiDTO(KpsTcKisiKayitYeriBilgisiDTO kayitYeriBilgisiDTO) {
		this.kayitYeriBilgisiDTO = kayitYeriBilgisiDTO;
	}

	public KpsTCKisiDurumBilgisiDTO getDurumBilgisiDTO() {
		return durumBilgisiDTO;
	}

	public void setDurumBilgisiDTO(KpsTCKisiDurumBilgisiDTO durumBilgisiDTO) {
		this.durumBilgisiDTO = durumBilgisiDTO;
	}

	public KpsYabanciKisiDurumBilgisiDTO getYabanciKisiDurumBilgisiDTO() {
		return yabanciKisiDurumBilgisiDTO;
	}

	public void setYabanciKisiDurumBilgisiDTO(KpsYabanciKisiDurumBilgisiDTO yabanciKisiDurumBilgisiDTO) {
		this.yabanciKisiDurumBilgisiDTO = yabanciKisiDurumBilgisiDTO;
	}

	public Integer getDogumYerKod() {
		return dogumYerKod;
	}

	public void setDogumYerKod(Integer dogumYerKod) {
		this.dogumYerKod = dogumYerKod;
	}

	
	
	
}
