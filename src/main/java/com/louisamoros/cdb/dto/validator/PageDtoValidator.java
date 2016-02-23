package com.louisamoros.cdb.dto.validator;

/**
 * The Class PageDtoValidator.
 */
public class PageDtoValidator {

  /**
   * Validate page.
   *
   * @param page the p
   * @return the int
   */
  public static int validatePage(String page) {
    int pageInt = 1;
    if (page != null) {
      if (Integer.parseInt(page) >= 0) {
        pageInt = Integer.parseInt(page);
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
  public static int validatePerPage(String perPage) {
    int perPageInt = 10;
    if (perPage != null) {
      if (Integer.parseInt(perPage) == 50 || Integer.parseInt(perPage) == 100) {
        perPageInt = Integer.parseInt(perPage);
      }
    }
    return perPageInt;
  }

}
