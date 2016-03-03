package com.louisamoros.cdb.controller;

import com.louisamoros.cdb.dto.CompanyDto;
import com.louisamoros.cdb.dto.ComputerDto;
import com.louisamoros.cdb.dto.mapper.MapperCompanyDto;
import com.louisamoros.cdb.dto.mapper.MapperComputerDto;
import com.louisamoros.cdb.dto.validator.ComputerDtoValidator;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.CompanyService;
import com.louisamoros.cdb.service.ComputerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The Class AddComputerController.
 */
@WebServlet(name = "computerNew", value = "/computer/new")
public class AddComputerController extends AbstractController {

  private static final long serialVersionUID = 2184299382015455686L;
  private static final Logger LOGGER = LoggerFactory.getLogger(AddComputerController.class);
  private static final String ADD_COMPUTER = "/WEB-INF/jsp/addComputer.jsp";

  @Autowired
  private CompanyService companyService;

  @Autowired
  private ComputerService computerService;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LOGGER.info("GOTO >>> addComputer.jsp");
    List<Company> companies = companyService.getAll();
    List<CompanyDto> companiesDto = MapperCompanyDto.toCompanyDtoList(companies);
    request.setAttribute("companies", companiesDto);
    RequestDispatcher rd = request.getRequestDispatcher(ADD_COMPUTER);
    rd.forward(request, response);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LOGGER.info("DO POST computer creation...");
    ComputerDto computerDto = new ComputerDto.Builder(request.getParameter("name"))
        .companyId(Integer.parseInt(request.getParameter("companyId")))
        .discontinued(request.getParameter("discontinued"))
        .introduced(request.getParameter("introduced")).build();
    ComputerDtoValidator.validate(computerDto);
    Computer computer = MapperComputerDto.toComputer(computerDto);
    int computerCreatedId = computerService.create(computer);
    LOGGER.info("CREATED ComputerId : " + computerCreatedId);
    response.sendRedirect("/cdb/computer");

  }

}
