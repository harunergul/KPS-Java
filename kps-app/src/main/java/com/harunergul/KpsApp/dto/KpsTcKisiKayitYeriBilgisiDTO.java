package com.harunergul.KpsApp.dto;

import com.harunergul.KpsApp.Parameter;

public class KpsTcKisiKayitYeriBilgisiDTO {

	private Integer aileSiraNo;
	private Integer bireySiraNo;
	private Parameter cilt;
	private Parameter il;

	public Integer getAileSiraNo() {
		return aileSiraNo;
	}

	public void setAileSiraNo(Integer aileSiraNo) {
		this.aileSiraNo = aileSiraNo;
	}

	public Integer getBireySiraNo() {
		return bireySiraNo;
	}

	public void setBireySiraNo(Integer bireySiraNo) {
		this.bireySiraNo = bireySiraNo;
	}

	public Parameter getCilt() {
		return cilt;
	}

	public void setCilt(Parameter cilt) {
		this.cilt = cilt;
	}

	public Parameter getIl() {
		return il;
	}

	public void setIl(Parameter il) {
		this.il = il;
	}

	public Parameter getIlce() {
		return ilce;
	}

	public void setIlce(Parameter ilce) {
		this.ilce = ilce;
	}

	private Parameter ilce;

}
