package com.louisamoros.cdb.controller;

import com.louisamoros.cdb.dto.ComputerDto;
import com.louisamoros.cdb.dto.mapper.MapperComputerDto;
import com.louisamoros.cdb.dto.validator.ComputerDtoValidator;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.ComputerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Spring controller for computer model.
 */
@Controller
@RequestMapping("/api/computer")
public class ComputerController {

  /**
   * Logger for the class.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(ComputerController.class);

  /**
   * Autowired spring injection of computer service.
   */
  @Autowired
  private ComputerService computerService;

  /**
   * Method to get the list of computers.
   *
   * @return jsp page redirection
   */
  @RequestMapping(value = "", method = RequestMethod.GET)
  public final String getComputers() {
    LOGGER.info("get /api/computer");
    return "redirect:/computer/list";
  }

  /**
   * Method to get the computer based on its id.
   *
   * @param computerId the computer id
   * @return jsp page redirection
   */
  @RequestMapping(value = "/{computerId}", method = RequestMethod.GET)
  public final String getComputer(@PathVariable("computerId") final int computerId) {

    LOGGER.info("get /api/computer/" + computerId);
    return "computer/list";

  }

  /**
   * Method to create a computer.
   *
   * @param computerDto the computer dto
   * @return jsp page redirection
   */
  @RequestMapping(value = "", method = RequestMethod.POST)
  public final String createComputer(final ComputerDto computerDto) {

    LOGGER.info("post /api/computer");
    ComputerDtoValidator.validate(computerDto);
    Computer computer = MapperComputerDto.toComputer(computerDto);
    computerService.create(computer);
    return "redirect:/computer/list";

  }

  /**
   * Method to delete a computer based on its id.
   *
   * @param selection the selection of computer to delete
   * @return jsp page redirection
   */
  @RequestMapping(value = "/delete", method = RequestMethod.POST)
  public final String deleteComputer(
      @RequestParam(value = "selection", required = false) final String selection) {

    LOGGER.info("delete /api/computer");
    String[] ids = null;
    if (selection != null) {
      ids = selection.split(",");
    }
    if (ids != null && ids.length > 0) {
      for (int i = 0; i < ids.length; i++) {
        computerService.delete(Integer.parseInt(ids[i]));
      }
    }
    return "redirect:/computer/list";

  }

  /**
   * Method to update a computer based on its id.
   *
   * @param computerId  the computer id
   * @param computerDto the computer dto
   * @return jsp page redirection
   */
  @RequestMapping(value = "/{computerId}", method = RequestMethod.POST)
  public final String updateComputer(@PathVariable("computerId") final int computerId,
      ComputerDto computerDto) {

    LOGGER.info("post /api/computer/" + computerId);
    ComputerDtoValidator.validate(computerDto);
    Computer computer = MapperComputerDto.toComputer(computerDto);
    computerService.update(computer);
    return "redirect:/computer/list";

  }

}
