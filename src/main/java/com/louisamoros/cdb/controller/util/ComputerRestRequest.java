package com.louisamoros.cdb.controller.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.louisamoros.cdb.controller.exception.RestRequestException;

public class ComputerRestRequest {

	// Accommodate two requests, one for all resources, another for a specific
	// resource
	private Pattern regExAllPattern = Pattern.compile("/computer");
	private Pattern regExIdPattern = Pattern.compile("/computer/([0-9]*)");

	private Integer id;

	public ComputerRestRequest(String pathInfo) throws RestRequestException {

		// regex parse pathInfo
		Matcher matcher;

		// Check for ID case first, since the All pattern would also match
		matcher = regExIdPattern.matcher(pathInfo);
		if (matcher.find()) {
			id = Integer.parseInt(matcher.group(1));
			return;
		}

		matcher = regExAllPattern.matcher(pathInfo);
		if (matcher.find()) {
			return;
		}

		throw new RestRequestException("Invalid computer REST URI.");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}