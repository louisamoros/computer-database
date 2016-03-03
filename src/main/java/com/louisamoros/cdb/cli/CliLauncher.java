
package com.louisamoros.cdb.cli;

import com.louisamoros.cdb.service.CompanyService;
import com.louisamoros.cdb.service.ComputerService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Scanner;

/**
 * Cli launcher class.
 */
public final class CliLauncher {

  /**
   * Computer service for the cli.
   */
  private static ComputerService computerService;

  /**
   * Company service for the cli.
   */
  private static CompanyService companyService;

  /**
   * The cli launcher constructor.
   */
  private CliLauncher() {
    super();
  }

  /**
   * The main method.
   *
   * @param args the arguments
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public static void main(final String... args) {

    boolean end = true;
    Scanner scanner = new Scanner(System.in);

    try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
        "classpath:application-context.xml")) {
      computerService = context.getBean(ComputerService.class);
      companyService = context.getBean(CompanyService.class);
    }

    while (end) {

      System.out.print("Command: ");
      String command = scanner.nextLine();
      System.out.println(String.format("%s", command));
      String[] commands = command.split(" ");
      new CliAnalyzer(commands).parse(companyService, computerService);
      System.out.println(" ");

    }

    scanner.close();

  }

}
