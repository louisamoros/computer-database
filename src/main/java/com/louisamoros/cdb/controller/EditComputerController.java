package com.louisamoros.cdb.controller;

import com.louisamoros.cdb.controller.util.ComputerRestRequest;
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
 * The Class EditComputerController.
 */
@WebServlet(name = "computerEdit", value = "/computer/edit")
public class EditComputerController extends AbstractController {

  private static final long serialVersionUID = 1L;
  private static final Logger LOGGER = LoggerFactory.getLogger(EditComputerController.class);
  private static final String EDIT_COMPUTER = "/WEB-INF/jsp/editComputer.jsp";

  @Autowired
  private CompanyService companyService;

  @Autowired
  private ComputerService computerService;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LOGGER.info("GOTO >>> editComputer.jsp");
    int computerId = ComputerRestRequest.getValidId(request.getParameter("id"));
    Computer computer = computerService.get(computerId);
    ComputerDto computerDto = MapperComputerDto.toComputerDto(computer);
    List<Company> companies = companyService.getAll();
    List<CompanyDto> companiesDto = MapperCompanyDto.toCompanyDtoList(companies);
    request.setAttribute("companies", companiesDto);
    request.setAttribute("computer", computerDto);
    RequestDispatcher rd = request.getRequestDispatcher(EDIT_COMPUTER);
    rd.forward(request, response);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LOGGER.info("DO POST computer update... id:" + request.getParameter("computerId"));
    ComputerDto computerDto = new ComputerDto.Builder(request.getParameter("computerName"))
        .computerId(Integer.parseInt(request.getParameter("computerId")))
        .companyId(Integer.parseInt(request.getParameter("companyId")))
        .discontinued(request.getParameter("discontinued"))
        .introduced(request.getParameter("introduced")).build();
    LOGGER.error(computerDto.toString());
    ComputerDtoValidator.validate(computerDto);
    Computer computer = MapperComputerDto.toComputer(computerDto);
    int computerUpdatedId = computerService.update(computer);
    LOGGER.info("UPDATED ComputerId : " + computerUpdatedId);
    response.sendRedirect("/cdb/computer");

  }

}
