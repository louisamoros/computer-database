package com.louisamoros.cdb.cli;

import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.service.CompanyService;
import org.apache.commons.cli.CommandLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Cli analyzer handle commands for the company.
 */
public final class CliCompany {

    /**
     * Logback logger for the class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CliCompany.class);

    /**
     * The cli computer constructor.
     */
    private CliCompany() {
        super();
    }

    /**
     * Manage static method to handle command.
     * @param cmd the command
     * @param companyService the company service
     */
    public static void manage(final CommandLine cmd, final CompanyService companyService) {

        if (cmd.hasOption("g") && "all".equals(cmd.getOptionValue("g"))) { // GET
            LOGGER.info("Command: GET ALL");
            List<Company> companies = companyService.getAll();
            companies.forEach(company -> System.out.println(company));
        } else if (cmd.hasOption("d")) { // DELETE
            LOGGER.info("Command: DELETE id->" + cmd.getOptionValue("d"));
            companyService.delete(Integer.parseInt(cmd.getOptionValue("d")));
        } else { // WRONG METHOD
            LOGGER.info("Company action: -g all, -d <id> (delete id)");
        }

    }

}
