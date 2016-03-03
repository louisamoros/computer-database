package com.louisamoros.cdb.controller.util;

import com.louisamoros.cdb.controller.exception.RestRequestException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComputerRestRequest {

  private static Pattern regExIdPattern = Pattern.compile("([0-9]*)");
  private static int validId;

  /**
   * Gets the valid id.
   *
   * @param id the id
   * @return the valid id
   */
  public static int getValidId(String id) {

    Matcher matcher = regExIdPattern.matcher(id);
    if (matcher.find()) {
      validId = Integer.parseInt(matcher.group(1));
    } else {
      throw new RestRequestException("Invalid computer id.");
    }
    return validId;

  }

}