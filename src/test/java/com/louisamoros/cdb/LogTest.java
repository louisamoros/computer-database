package com.louisamoros.cdb;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {

	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger(LogTest.class);
		logger.debug("Hello world.");

	}

//	public static void main(String[] args) {
//		Logger logger = LoggerFactory.getLogger(LogTest.class);
//		logger.debug("Hello world.");
//
//		// print internal state
////		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
////		StatusPrinter.print(lc);
//	}

}
