package com.louisamoros.cdb.controller.util;

import com.louisamoros.cdb.dto.PageDto;
import com.louisamoros.cdb.dto.validator.PageDtoValidator;

/**
 * The Class PageDtoCreator.
 */
public class PageDtoCreator {

	/** The Constant MAX_TO_SHOW. */
	private static final int MAX_TO_SHOW = 5;

	/**
	 * Creates the.
	 *
	 * @param page the page
	 * @param perPage the per page
	 * @param uri the uri
	 * @param count the count
	 * @return the page dto
	 */
	public static PageDto create(String page, String perPage, String uri, int count) {

		int p = PageDtoValidator.validatePage(page);
		int pp = PageDtoValidator.validatePerPage(perPage);

		int offset = (p - 1) * pp + 1;
		int limit = pp;
		int totalPage = Math.abs(count / pp);
		int startingPage = Math.max(p - MAX_TO_SHOW / 2, 1);
		int endingPage = startingPage + MAX_TO_SHOW;

		if (endingPage > totalPage + 1) {
			int diff = endingPage - totalPage;
			startingPage -= diff - 1;
			if (startingPage < 1) {
				startingPage = 1;
			}
			endingPage = totalPage + 1;
		}

		PageDto pageDto = new PageDto.Builder().page(p).perPage(pp).limit(limit).offset(offset).count(count)
				.startingPage(startingPage).endingPage(endingPage).totalPage(totalPage).uri(uri).build();

		return pageDto;

	}

}
