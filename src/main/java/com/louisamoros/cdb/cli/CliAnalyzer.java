
package com.louisamoros.cdb.cli;

import com.louisamoros.cdb.service.CompanyService;
import com.louisamoros.cdb.service.ComputerService;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Cli analyzer handle commands of the cli.
 */
public class CliAnalyzer {

  /**
   * Logback logger for the class.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(CliAnalyzer.class);

  /**
   * Commands attribute where the commands are.
   */
  private final String[] commands;

  /**
   * Options attributes use with apache cli.
   */
  private Options options = new Options();

  /**
   * Instantiates a new cli analyzer.
   *
   * @param cmds the string array of commands
   */
  public CliAnalyzer(final String... cmds) {

    this.commands = cmds;
    options.addOption("h", "help", false, "Show help.");
    // ELEMENT
    options.addOption("e", "element", true, "Element you want to act on <required>.");
    // ACTIONS
    options.addOption("g", "get", true, "Command to GET the element.");
    options.addOption("c", "create", false, "Command to CREATE the element.");
    options.addOption("d", "delete", true, "Command to DELETE the element.");
    options.addOption("u", "update", true, "Command to UPDATE the element.");
    options.addOption("count", false, "Command to COUNT number of element.");
    // PARAMS
    options.addOption("n", "name", true, "Arg NAME of the element.");
    options.addOption("din", true, "Arg DATE INTRODUCED of the element.");
    options.addOption("dout", true, "Arg DATE DISCONTINUED of the element.");
    options.addOption("idc", true, "Arg ID COMPANY of the element.");

  }

  /**
   * Parse method will decompose commands to handle the request.
   * @param companyService the company service
   * @param computerService the computer service
   */
  public final void parse(final CompanyService companyService, final ComputerService computerService) {

    CommandLineParser parser = new BasicParser();
    CommandLine cmd = null;

    try {

      cmd = parser.parse(options, commands);

      // ask for help
      if (cmd.hasOption("h")) {
        help();
      }

      // choose element
      if (cmd.hasOption("e")) {
        LOGGER.info("Element:" + cmd.getOptionValue("e"));
        if ("computer".equals(cmd.getOptionValue("e"))) {
          CliComputer.manage(cmd, computerService);
        } else if ("company".equals(cmd.getOptionValue("e"))) {
          CliCompany.manage(cmd, companyService);
        } else {
          LOGGER.error("Invalid element");
        }
      } else {
        LOGGER.warn("Element is required. -e");
      }

    } catch (org.apache.commons.cli.ParseException e) {
      LOGGER.error("Failed to parse comand line properties", e);
      help();
    }

    if (!cmd.hasOption("h") && !cmd.hasOption("e")) {
      LOGGER.info("Cli can't read your command (-h, -help for help)");
      help();
    }

  }

  /**
   * Help method print cli command help.
   */
  private void help() {
    HelpFormatter formater = new HelpFormatter();
    formater.printHelp("CLI", options);
  }
}
