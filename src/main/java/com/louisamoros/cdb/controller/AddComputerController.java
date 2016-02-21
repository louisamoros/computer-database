package com.louisamoros.cdb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.louisamoros.cdb.dto.CompanyDto;
import com.louisamoros.cdb.dto.mapper.MapperCompanyDto;
import com.louisamoros.cdb.model.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.louisamoros.cdb.dto.ComputerDto;
import com.louisamoros.cdb.dto.mapper.MapperComputerDto;
import com.louisamoros.cdb.dto.validator.ComputerDtoValidator;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.CompanyService;
import com.louisamoros.cdb.service.ComputerService;
import com.louisamoros.cdb.service.impl.CompanyServiceImpl;
import com.louisamoros.cdb.service.impl.ComputerServiceImpl;

/**
 * Servlet implementation class NewComputer
 */
@WebServlet(name = "/computer/new", value = "/computer/new")
public class AddComputerController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LoggerFactory.getLogger(AddComputerController.class);
    private CompanyService companyService = CompanyServiceImpl.INSTANCE;
    private ComputerService computerService = ComputerServiceImpl.INSTANCE;
    private static final String ADD_COMPUTER = "/WEB-INF/jsp/addComputer.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LOGGER.debug("GOTO >>> addComputer.jsp");
        List<Company> companies = companyService.getAll();
        List<CompanyDto> companiesDto = MapperCompanyDto.toCompanyDtoList(companies);
        request.setAttribute("companies", companiesDto);
        RequestDispatcher rd = request.getRequestDispatcher(ADD_COMPUTER);
        rd.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LOGGER.debug("DO POST computer creation...");
        ComputerDto computerDto = new ComputerDto.Builder(request.getParameter("name"))
                .companyId(Integer.parseInt(request.getParameter("companyId")))
                .discontinued(request.getParameter("discontinued"))
                .introduced(request.getParameter("introduced"))
                .build();
        ComputerDtoValidator.validate(computerDto);
        Computer computer = MapperComputerDto.toComputer(computerDto);
        int computerCreatedId = computerService.create(computer);
        LOGGER.debug("CREATED ComputerId : " + computerCreatedId);
        response.sendRedirect("/computer");

    }

}
