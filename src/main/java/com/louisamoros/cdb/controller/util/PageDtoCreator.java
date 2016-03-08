package com.louisamoros.cdb.controller.util;

import com.louisamoros.cdb.dto.PageDto;
import com.louisamoros.cdb.dto.validator.PageDtoValidator;

/**
 * The Class PageDtoCreator.
 */
public final class PageDtoCreator {

    /**
     * Maximum page to show on jsp pager.
     */
    private static final int MAX_TO_SHOW = 5;

    /**
     * Private class constructor.
     */
    private PageDtoCreator() {
        super();
    }

    /**
     * Static method to create the page.
     *
     * @param page    the page
     * @param perPage the per page
     * @param uri     the uri
     * @param orderBy the order by
     * @param order   the order
     * @param search  the search
     * @param count   the count
     * @return the page dto
     */
    public static PageDto create(final Integer page, final Integer perPage, final String uri, final String orderBy, final String order, final String search, final int count) {

        int pageBuild = PageDtoValidator.validatePage(page);
        int perPageBuild = PageDtoValidator.validatePerPage(perPage);

        int offsetBuild;
        offsetBuild = (pageBuild - 1) * perPageBuild + 1;

        int limitBuild;
        limitBuild = perPageBuild;

        int totalPage = Math.abs(count / perPageBuild);
        int startingPage = Math.max(pageBuild - MAX_TO_SHOW / 2, 1);
        int endingPage = startingPage + MAX_TO_SHOW;

        if (endingPage > totalPage + 1) {
            int diff = endingPage - totalPage;
            startingPage -= diff - 1;
            if (startingPage < 1) {
                startingPage = 1;
            }
            endingPage = totalPage + 1;
        }

        String orderByBuild = "computer.name";
        if ("company.name".equals(orderBy) || "computer.introduced".equals(orderBy)
                || "computer.discontinued".equals(orderBy)) {
            orderByBuild = orderBy;
        }

        String orderBuild = "asc";
        if ("desc".equals(order)) {
            orderBuild = order;
        }

        PageDto pageDto = new PageDto.Builder().page(pageBuild).perPage(perPageBuild).limit(limitBuild)
                .offset(offsetBuild).count(count).startingPage(startingPage).endingPage(endingPage)
                .totalPage(totalPage).uri(uri).orderBy(orderByBuild).order(orderBuild).search(search)
                .build();

        return pageDto;

    }

}
