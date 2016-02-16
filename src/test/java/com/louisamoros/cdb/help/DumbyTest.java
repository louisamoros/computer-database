package com.louisamoros.cdb.help;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DumbyTest {
	
	private static Logger LOGGER = LoggerFactory.getLogger(DumbyTest.class);
	
	@Test
	public void dumbyTest() {
		LOGGER.debug("I am a working dumby test...");
		Assert.assertTrue(true);
	}
	
}