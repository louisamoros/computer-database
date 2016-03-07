/*
 * 
 */
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

@Controller
@RequestMapping("/api/computer")
public class ComputerContoller {

  private static final Logger LOGGER = LoggerFactory.getLogger(ComputerContoller.class);

  @Autowired
  private ComputerService computerService;

  @RequestMapping(value = "", method = RequestMethod.GET)
  public String getComputers() {
    LOGGER.info("get /api/computer");
    return "redirect:/computer/list";
  }

  @RequestMapping(value = "/{computerId}", method = RequestMethod.GET)
  public String getComputer(@PathVariable("computerId") int computerId) {
    LOGGER.info("get /api/computer/" + computerId);
    return "computer/list";
  }

  /**
   * Creates the computer.
   *
   * @param computerDto the computer dto
   * @return the string
   */
  @RequestMapping(value = "", method = RequestMethod.POST)
  public String createComputer(ComputerDto computerDto) {

    LOGGER.info("post /api/computer");
    ComputerDtoValidator.validate(computerDto);
    Computer computer = MapperComputerDto.toComputer(computerDto);
    computerService.create(computer);
    return "redirect:/computer/list";

  }

  /**
   * Delete computer.
   *
   * @param selection the selection
   * @return the string
   */
  @RequestMapping(value = "/delete", method = RequestMethod.POST)
  public String deleteComputer(
      @RequestParam(value = "selection", required = false) String selection) {

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
   * Update computer.
   *
   * @param computerId the computer id
   * @param computerDto the computer dto
   * @return the string
   */
  @RequestMapping(value = "/{computerId}", method = RequestMethod.POST)
  public String updateComputer(@PathVariable("computerId") int computerId,
      ComputerDto computerDto) {

    LOGGER.info("post /api/computer/" + computerId);
    ComputerDtoValidator.validate(computerDto);
    Computer computer = MapperComputerDto.toComputer(computerDto);
    computerService.update(computer);
    return "redirect:/computer/list";

  }

}
