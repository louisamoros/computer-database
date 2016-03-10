package com.louisamoros.cdb.cli;

import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.ComputerService;

import org.apache.commons.cli.CommandLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Cli analyzer handle commands for the computer.
 */
public final class CliComputer {

    /**
     * Logback logger for the class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CliComputer.class);

    /**
     * The cli computer constructor.
     */
    private CliComputer() {
        super();
    }

    /**
     * Manage static method to handle command.
     * @param cmd the command
     * @param computerService the computer service
     */
    public static void manage(final CommandLine cmd, final ComputerService computerService) {
        if (cmd.hasOption("g") && "all".equals(cmd.getOptionValue("g"))) { // GET ALL
            LOGGER.info("Command: GET ALL");
            List<Computer> computers = computerService.getAll();
            computers.forEach(computer -> System.out.println(computer));
        } else if (cmd.hasOption("g")) { // GET
            LOGGER.info("Command: GET id->" + cmd.getOptionValue("g"));
            System.out.println(computerService.get(Integer.parseInt(cmd.getOptionValue("g"))));
        } else if (cmd.hasOption("d")) { // DELETE
            LOGGER.info("Command: DELETE id->" + cmd.getOptionValue("d"));
            computerService.delete(Integer.parseInt(cmd.getOptionValue("d")));
        } else if (cmd.hasOption("c")) { // COUNT
            LOGGER.info("NOT IMPLEMENTED");
        } else if (cmd.hasOption("u")) { // COUNT
            LOGGER.info("NOT IMPLEMENTED");
        } else { // WRONG METHOD
            LOGGER.info("Company action: -g (get all), -d <id> (delete id)");
        }
    }

}
