package com.louisamoros.cdb.dto.validator;

/**
 * The Class PageDtoValidator.
 */
public final class PageDtoValidator {

    /**
     * The page dto validator constructor.
     */
    private PageDtoValidator() {
        super();
    }

    /**
     * Validate page.
     *
     * @param page the p
     * @return the int
     */
    public static int validatePage(final Integer page) {
        int pageInt = 1;
        if (page != null) {
            if (page > 0) {
                pageInt = page;
            }
        }
        return pageInt;
    }

    /**
     * Validate per page.
     *
     * @param perPage the per page
     * @return the int
     */
    public static int validatePerPage(final Integer perPage) {
        int perPageInt = 10;
        if (perPage != null) {
            if (perPage == 50 || perPage == 100) {
                perPageInt = perPage;
            }
        }
        return perPageInt;
    }

}
