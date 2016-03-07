package com.louisamoros.cdb.controller;

import com.louisamoros.cdb.controller.util.PageDtoCreator;
import com.louisamoros.cdb.controller.util.QueryParams;
import com.louisamoros.cdb.dto.CompanyDto;
import com.louisamoros.cdb.dto.ComputerDto;
import com.louisamoros.cdb.dto.PageDto;
import com.louisamoros.cdb.dto.mapper.MapperCompanyDto;
import com.louisamoros.cdb.dto.mapper.MapperComputerDto;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.CompanyService;
import com.louisamoros.cdb.service.ComputerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/computer")
public class ComputerPageController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ComputerPageController.class);

  @Autowired
  private ComputerService computerService;

  @Autowired
  private CompanyService companyService;

  /**
   * Gets the page list computer.
   *
   * @param model the model
   * @param page the page
   * @param perPage the per page
   * @param orderBy the order by
   * @param order the order
   * @param search the search
   * @return the page list computer
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String getPageListComputer(Model model,
      @RequestParam(value = "p", required = false) Integer page,
      @RequestParam(value = "pp", required = false) Integer perPage,
      @RequestParam(value = "orderby", required = false) String orderBy,
      @RequestParam(value = "order", required = false) String order,
      @RequestParam(value = "s", required = false) String search) {

    LOGGER.info("get page /computer/list");
    int count = computerService.count();
    PageDto pageDto = PageDtoCreator.create(page, perPage, "computer/list", orderBy, order, search,
        count);
    // @formatter:off
    QueryParams queryParams = new QueryParams
        .Builder()
        .offset(pageDto.getOffset())
        .limit(pageDto.getLimit())
        .order(pageDto.getOrder())
        .orderBy(pageDto.getOrderBy())
        .search(pageDto.getSearch())
        .build();
    // @formatter:on
    List<Computer> computers = computerService.get(queryParams);
    List<ComputerDto> computersDto = MapperComputerDto.toComputerDtoList(computers);
    model.addAttribute("computersDto", computersDto);
    model.addAttribute("page", pageDto);
    return "computer/list";

  }

  /**
   * Gets the page create computer.
   *
   * @return the page create computer
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public String getPageCreateComputer(Model model) {

    LOGGER.info("get page /computer/new");
    List<Company> companies = companyService.getAll();
    List<CompanyDto> companiesDto = MapperCompanyDto.toCompanyDtoList(companies);
    model.addAttribute("companiesDto", companiesDto);
    return "computer/create";

  }

  /**
   * Gets the page edit computer.
   *
   * @param model the model
   * @param computerId the computer id
   * @return the page edit computer
   */
  @RequestMapping(value = "/edit/{computerId}", method = RequestMethod.GET)
  public String getPageEditComputer(Model model, @PathVariable int computerId) {

    LOGGER.info("get page /computer/edit/" + computerId);
    Computer computer = computerService.get(computerId);
    ComputerDto computerDto = MapperComputerDto.toComputerDto(computer);
    List<Company> companies = companyService.getAll();
    List<CompanyDto> companiesDto = MapperCompanyDto.toCompanyDtoList(companies);
    model.addAttribute("companiesDto", companiesDto);
    model.addAttribute("computerDto", computerDto);
    return "computer/edit";

  }

  /**
   * Gets the page delete computer.
   *
   * @param computerId the id
   * @return the page delete computer
   */
  @RequestMapping(value = "/delete/{computerId}", method = RequestMethod.GET)
  public String getPageDeleteComputer(@PathVariable int computerId) {

    LOGGER.info("get page /computer/delete/" + computerId);
    return "computer/delete";

  }

}
