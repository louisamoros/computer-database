package com.louisamoros.cdb.dto.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * The Class DateValidator.
 */
public class DateValidator implements ConstraintValidator<Date, String> {

	/** The pattern. */
	private Pattern pattern;

	/** The matcher. */
	private Matcher matcher;

	/** The Constant DATE_PATTERN. */
	private static final String DATE_PATTERN = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";

	@Override
	public void initialize(Date annotation) {
		pattern = Pattern.compile(DATE_PATTERN);
	}

	@Override
	public boolean isValid(String date, ConstraintValidatorContext context) {
		
		matcher = pattern.matcher(date);
		boolean isValid = false;

		if (matcher.matches()) {

			matcher.reset();

			if (matcher.find()) {

				String day = matcher.group(1);
				String month = matcher.group(2);
				int year = Integer.parseInt(matcher.group(3));

				if (day.equals("31") && (month.equals("4") || month.equals("6") || month.equals("9")
						|| month.equals("11") || month.equals("04") || month.equals("06") || month.equals("09"))) {
					isValid = false; // only 1,3,5,7,8,10,12 has 31 days
				} else if (month.equals("2") || month.equals("02")) {
					// leap year
					if (year % 4 == 0) {
						if (day.equals("30") || day.equals("31")) {
							isValid = false;
						} else {
							return true;
						}
					} else {
						if (day.equals("29") || day.equals("30") || day.equals("31")) {
							isValid = false;
						} else {
							isValid = true;
						}
					}
				} else {
					isValid = true;
				}
			} else {
				isValid = false;
			}
		} else {
			isValid = false;
		}
		
		return isValid;
	}
}