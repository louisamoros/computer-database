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
	 * @param orderBy the order by
	 * @param order the order
	 * @param search the search
	 * @param count the count
	 * @return the page dto
	 */
	public static PageDto create(String page, String perPage, String uri, String orderBy, String order, String search,
			int count) {

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

		String ob = "computer.name";
		if ("company.name".equals(orderBy) || "computer.introduced".equals(orderBy)
				|| "computer.discontinued".equals(orderBy)) {
			ob = orderBy;
		}

		String o = "asc";
		if ("desc".equals(order)) {
			o = order;
		}

		PageDto pageDto = new PageDto.Builder().page(p).perPage(pp).limit(limit).offset(offset).count(count)
				.startingPage(startingPage).endingPage(endingPage).totalPage(totalPage).uri(uri).orderBy(ob).order(o)
				.search(search).build();

		return pageDto;

	}

}
