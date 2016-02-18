package com.louisamoros.cdb.dto.validator;

/**
 * Verify via static method different attributes of PageDto.
 * @author louis
 *
 */
public class PageDtoValidator {

	/**
	 * Validation method for page. It has to be greater or equal to 0.
	 * @param <String> page
	 * @return int page
	 */
	public static int validatePage(String p) {
		int page = 0;
		if(p != null) {
			if(Integer.parseInt(p) >= 0) {
				page = Integer.parseInt(p);
			}
		}
		return page;
	}
	
	/**
	 * Validation method for perPage. It has to be equal to 10, 50 or 100.
	 * @param <String> perPage
	 * @return int perPage
	 */
	public static int validatePerPage(String pp) {
		int perPage = 10;
		if(pp != null) {
			int i = Integer.parseInt(pp);
			if(i == 50 || i == 100) {
				perPage = i;
			}
		}
		return perPage;
	}
	
}
