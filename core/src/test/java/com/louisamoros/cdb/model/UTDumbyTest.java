package com.louisamoros.cdb.model;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Dumby test class.
 */
public class UTDumbyTest {

  /**
   * Logger of the class.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(UTDumbyTest.class);

  /**
   * Just a dumby test to check if maven test are running correctly.
   */
  @Test
  public final void dumbyTest() {
    LOGGER.info("I am a working dumby test...");
    Assert.assertTrue(true);
  }

}
