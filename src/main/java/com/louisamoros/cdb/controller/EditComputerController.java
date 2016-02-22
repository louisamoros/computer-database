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
import com.louisamoros.cdb.service.impl.CompanyServiceImpl;
import com.louisamoros.cdb.service.impl.ComputerServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The Class EditComputerController.
 */
@WebServlet(name = "/computer/edit", value = "/computer/edit")
public class EditComputerController extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private static final Logger LOGGER = LoggerFactory.getLogger(EditComputerController.class);
  private CompanyService companyService = CompanyServiceImpl.INSTANCE;
  private ComputerService computerService = ComputerServiceImpl.INSTANCE;
  private static final String EDIT_COMPUTER = "/WEB-INF/jsp/editComputer.jsp";

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LOGGER.debug("GOTO >>> editComputer.jsp");
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

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LOGGER.debug("DO POST computer update... id:" + request.getParameter("computerId"));
    ComputerDto computerDto = new ComputerDto.Builder(request.getParameter("computerName"))
        .computerId(Integer.parseInt(request.getParameter("computerId")))
        .companyId(Integer.parseInt(request.getParameter("companyId")))
        .discontinued(request.getParameter("discontinued"))
        .introduced(request.getParameter("introduced")).build();
    LOGGER.error(computerDto.toString());
    ComputerDtoValidator.validate(computerDto);
    Computer computer = MapperComputerDto.toComputer(computerDto);
    int computerUpdatedId = computerService.update(computer);
    LOGGER.debug("UPDATED ComputerId : " + computerUpdatedId);
    response.sendRedirect("/computer");

  }

}
