package com.louisamoros.cdb.util;

public class Page {
	
	private static int offset = 0;
	private static int steps = 10;

	public static int stepsVerification(String stp) {
		int stepInt = steps;
		if(stp != null) {
			stepInt = Integer.parseInt(stp);
		}
		if(stepInt != 10 && stepInt != 50 && stepInt != 100) {
			stepInt = steps;
		}
		return stepInt;
	}
	
	public static int offsetVerification(String ofst) {
		int offsetInt = offset;
		if(ofst != null) {
			offsetInt = Integer.parseInt(ofst);
		}
		if(offsetInt < 0) {
			offsetInt = offset;
		}
		return offsetInt;
	}

}
