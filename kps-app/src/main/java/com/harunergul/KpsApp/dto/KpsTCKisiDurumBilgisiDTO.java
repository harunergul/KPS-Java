package com.harunergul.KpsApp.dto;

import java.util.Date;

import com.harunergul.KpsApp.Parameter;

public class KpsTCKisiDurumBilgisiDTO {
	private Parameter din;
	private Parameter durum;
	private Parameter medeniHal;
	private Date olumTarihi;

	public Parameter getDin() {
		return din;
	}

	public void setDin(Parameter din) {
		this.din = din;
	}

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
