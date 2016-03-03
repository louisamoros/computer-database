package com.louisamoros.cdb.cli;

import com.louisamoros.cdb.service.ComputerService;

import org.apache.commons.cli.CommandLine;
import org.springframework.beans.factory.annotation.Autowired;

public class ComputerCli {

  @Autowired
  private ComputerService computerService;

  public static void manage(CommandLine cmd) {
    // TODO Auto-generated method stub
  }

}
