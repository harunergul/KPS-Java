package com.harunergul.KpsApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class KpsPersonDTO {
	public Integer month;
	public Integer day;
	public Integer year;
	public Long identificationNo;

	public KpsPersonDTO() {
	}

	public KpsPersonDTO(Long identificationNo, String birthDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

		Calendar cal = Calendar.getInstance();
		try {
			Date personBirthDate = dateFormat.parse(birthDate);
			cal.setTime(personBirthDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		this.identificationNo = identificationNo;
		this.day = cal.get(Calendar.DAY_OF_MONTH);
		this.month = cal.get(Calendar.MONTH) + 1;
		this.year = cal.get(Calendar.YEAR);
	}

}
