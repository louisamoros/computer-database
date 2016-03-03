package com.louisamoros.cdb.cli;

import com.louisamoros.cdb.service.CompanyService;
import com.louisamoros.cdb.service.ComputerService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Scanner;

public class ComandLineInterface {

  /**
   * The main method.
   *
   * @param args the arguments
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public static void main(String... args) {

    boolean end = true;
    Scanner scanner = new Scanner(System.in);

    try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
        "classpath:application-context.xml")) {
      ComputerService computerService = context.getBean(ComputerService.class);
      CompanyService companyService = context.getBean(CompanyService.class);
    }

    while (end) {

      System.out.print("Command: ");
      String command = scanner.nextLine();
      System.out.println(String.format("%s", command));
      String[] commands = command.split(" ");
      new CliAnalyzer(commands).parse();
      System.out.println(" ");

    }

    scanner.close();

  }

}
