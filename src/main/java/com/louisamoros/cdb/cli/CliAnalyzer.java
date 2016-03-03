package com.louisamoros.cdb.cli;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CliAnalyzer {

  private static final Logger LOGGER = LoggerFactory.getLogger(CliAnalyzer.class);
  private String[] args = null;
  private Options options = new Options();

  /**
   * Instantiates a new cli analyzer.
   *
   * @param args the args
   */
  public CliAnalyzer(String[] args) {

    this.args = args;
    options.addOption("h", "help", false, "Show help.");
    // ELEMENT
    options.addOption("e", "element", true, "Element you want to act on <required>.");
    // ACTIONS
    options.addOption("g", "get", false, "Command to GET the element.");
    options.addOption("c", "create", false, "Command to CREATE the element.");
    options.addOption("d", "delete", false, "Command to DELETE the element.");
    options.addOption("u", "update", false, "Command to UPDATE the element.");
    // PARAMS
    options.addOption("id", "id", true, "Arg ID of the element.");
    options.addOption("n", "name", true, "Arg NAME of the element.");
    options.addOption("din", "date-in", true, "Arg DATE INTRODUCED of the element.");
    options.addOption("dout", "date-out", true, "Arg DATE DISCONTINUED of the element.");
    options.addOption("idc", "id-company", true, "Arg ID COMPANY of the element.");

  }

  /**
   * Parses the.
   */
  public void parse() {

    CommandLineParser parser = new BasicParser();
    CommandLine cmd = null;

    try {

      cmd = parser.parse(options, args);

      // ask for help
      if (cmd.hasOption("h")) {
        help();
      }

      // choose element
      if (cmd.hasOption("e")) {
        LOGGER.info("Element:" + cmd.getOptionValue("e"));
        if ("computer".equals(cmd.getOptionValue("e"))) {
          ComputerCli.manage(cmd);
        } else if ("company".equals(cmd.getOptionValue("e"))) {
          CompanyCli.manage(cmd);
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

  private void help() {
    HelpFormatter formater = new HelpFormatter();
    formater.printHelp("CLI", options);
  }
}
