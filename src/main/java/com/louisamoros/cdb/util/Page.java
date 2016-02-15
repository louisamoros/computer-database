package com.louisamoros.cdb.util;

public enum Page {
	
	INSTANCE;
	
	private static int perPage = 10;
	private static int page = 0;

	public static int perPageVerification(String pp) {
		int ret;
		int ppi = 0;
		if(pp != null) {
			ppi = Integer.parseInt(pp);
		}
		if(ppi == 10 || ppi == 50 || ppi == 100) {
			ret = ppi;
		} else {
			ret = perPage;
		}
		return ret;
	}
	
	public static int pageVerification(String p) {
		int ret = page;
		int pi = 0;
		if(p != null) {
			pi = Integer.parseInt(p);
		}
		if(pi > 0) {
			ret = pi;
		} else {
			ret = page;
		}
		return ret;
	}

}
