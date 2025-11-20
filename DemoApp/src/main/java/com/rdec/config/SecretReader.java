package com.rdec.config;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class SecretReader {

	//this fn is only used when your app uses regions.
	
	static Locale getLocale(String lang, String region) {
//		Locale locale = new Locale(lang, region);
		Locale locale = Locale.of(lang, region);
		return locale;
	}
	
	public static String secretReader(String key, String lang, String region) {
		ResourceBundle rb = ResourceBundle.getBundle("appSecrets", getLocale(lang, region));
		return rb.getString(key);
	}
	
	static String ERROR_LOG(String msg) {
		String COLOR = "\u001B[33m";
		return COLOR +getDateTime(0) + " TYPE : ERROR " + msg;
	}
	
	static void INFO_LOG() {
		
	}
	
	static void SUCCESS_LOG() {
		
	}
	
	static String getDateTime(int style) {
		Date dt = new Date();
		DateFormat dtf = DateFormat.getDateInstance(style, Locale.of("fr", "FR"));
		return dtf.format(dt);
	}
	
	public static void main(String a []) {
		System.out.println(ERROR_LOG("LOGIN FAILED"));
	}
}
