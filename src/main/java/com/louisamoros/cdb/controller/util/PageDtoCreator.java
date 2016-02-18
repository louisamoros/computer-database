package com.louisamoros.cdb.controller.util;

import com.louisamoros.cdb.dto.PageDto;
import com.louisamoros.cdb.dto.validator.PageDtoValidator;

/**
 * The Class PageDtoCreator.
 */
public class PageDtoCreator {

	/**
	 * Creates the.
	 *
	 * @param page the page
	 * @param perPage the per page
	 * @param count the count
	 * @return the page dto
	 */
	public static PageDto create(String page, String perPage, int count) {

		int p = PageDtoValidator.validatePage(page);
		int pp = PageDtoValidator.validatePerPage(perPage);
		int offset = (p - 1) * pp + 1;
		int limit = pp;

		PageDto pageDto = new PageDto.Builder().page(p).perPage(pp).limit(limit).offset(offset).count(count).build();

		return pageDto;

	}

}
