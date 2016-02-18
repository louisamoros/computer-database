package com.louisamoros.cdb.controller.util;

import com.louisamoros.cdb.dto.PageDto;
import com.louisamoros.cdb.dto.validator.PageDtoValidator;

/**
 * Create <PageDto> by validating attributes via <PageValidator> and calculating
 * other useful attributes such as offset and limit.
 * 
 * @author louis
 *
 */
public class PageDtoCreator {

	public static PageDto create(String p, String pp) {

		int page = PageDtoValidator.validatePage(p);
		int perPage = PageDtoValidator.validatePerPage(pp);
		int offset = (page - 1) * perPage + 1;
		int limit = perPage;

		PageDto pageDto = new PageDto.Builder().page(perPage).perPage(perPage).limit(limit).offset(offset).build();

		return pageDto;

	}

}
