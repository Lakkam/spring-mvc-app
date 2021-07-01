package com.lakkam.springmvcdemo;

public class TestLogic {

	public static void main(String[] args) {

		String[] autoPolicyzipCodes = { "560100", "560094" };
		String zipCode = "560100";
		boolean isAutoZipCode = false;
		for (String zipCodes : autoPolicyzipCodes) {
			System.out.println(zipCodes);
			if (zipCode.equalsIgnoreCase(zipCodes)) {
				isAutoZipCode = true;
				break;
			} else {
				isAutoZipCode = false;
			}
		}
		
		System.out.println(isAutoZipCode);

	}

}
