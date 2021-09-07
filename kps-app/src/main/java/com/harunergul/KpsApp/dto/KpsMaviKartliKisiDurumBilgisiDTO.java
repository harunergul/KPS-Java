package com.harunergul.KpsApp.dto;

import java.util.Date;

import com.harunergul.KpsApp.Parameter;

public class KpsMaviKartliKisiDurumBilgisiDTO {
	private Parameter durum;
	private Parameter medeniHal;
	private Date olumTarihi;

	public Parameter getDurum() {
		return durum;
	}

	public void setDurum(Parameter durum) {
		this.durum = durum;
	}

	public Parameter getMedeniHal() {
		return medeniHal;
	}

	public void setMedeniHal(Parameter medeniHal) {
		this.medeniHal = medeniHal;
	}

	public Date getOlumTarihi() {
		return olumTarihi;
	}

	public void setOlumTarihi(Date olumTarihi) {
		this.olumTarihi = olumTarihi;
	}
}
