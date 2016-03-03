package com.louisamoros.cdb.cli;

import com.louisamoros.cdb.service.CompanyService;

import org.apache.commons.cli.CommandLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CompanyCli {

  private static final Logger LOGGER = LoggerFactory.getLogger(CompanyCli.class);

  @Autowired
  private CompanyService companyService;

  /**
   * Manage.
   *
   * @param cmd the cmd
   */
  public static void manage(CommandLine cmd) {
    // GET
    if (cmd.hasOption("g")) {
      //
    } else if (cmd.hasOption("d")) {
      // delete company
    } else {
      LOGGER.info("Company action: -g all (get all), -d <id> (delete id)");
    }
  }

}
