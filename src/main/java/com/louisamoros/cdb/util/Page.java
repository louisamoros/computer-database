package com.louisamoros.cdb.util;

public class Page {
	
	private static int offset = 0;
	private static int limit = 10;
	private static int page = 1;
	private static int perpage = 10;

	public static int getOffset(String p, String pp) {
		int offsetReturn = offset;
		int pInt = page;
		int ppInt = perpage;
		if(p != null) {
			pInt = Integer.parseInt(p);
		}	
		if(pp != null) {
			ppInt = Integer.parseInt(pp);
		}
		offsetReturn = (pInt - 1) * ppInt + 1;
		return offsetReturn;
	}
	
	public static int getLimit(String pp) {
		int limitReturn = limit;
		int ppInt = perpage;
		if(pp != null) {
			ppInt = Integer.parseInt(pp);
		}
		if(ppInt == 10 || ppInt == 50 || ppInt == 100) {
			limitReturn = ppInt;
		}
		return limitReturn;
	}

}
