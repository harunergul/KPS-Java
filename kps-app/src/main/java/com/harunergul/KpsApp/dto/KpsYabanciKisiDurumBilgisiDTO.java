package com.harunergul.KpsApp.dto;

import com.harunergul.KpsApp.Parameter;

public class KpsYabanciKisiDurumBilgisiDTO {

	private Parameter durum;
	private Parameter medeniHal;

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

}
