package com.harunergul.KpsApp;

public class TestPersonProvider {

	private static TestPersonProviderHelper helper = new TestPersonProviderHelper();

	public static KpsPersonDTO getTCUyrukluKapali(int index) {
		 return helper.getTCUyrukluKapaliList().get(0);
	}
	
	public static void main(String ...args) {
		KpsPersonDTO person = TestPersonProvider.getTCUyrukluKapali(2);
		System.out.println(person);
	}
}
