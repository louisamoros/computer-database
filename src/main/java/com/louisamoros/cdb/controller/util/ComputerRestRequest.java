package com.louisamoros.cdb.controller.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.louisamoros.cdb.controller.exception.RestRequestException;

public class ComputerRestRequest {

	private static Pattern regExIdPattern = Pattern.compile("([0-9]*)");
	private static int  validId;

	public static int getValidId(String id) {
		// regex parse pathInfo
		Matcher matcher = regExIdPattern.matcher(id);
		if (matcher.find()) {
			validId = Integer.parseInt(matcher.group(1));
		} else {
			throw new RestRequestException("Invalid computer id.");
		}
		return validId;

	}

}