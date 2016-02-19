package com.louisamoros.cdb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
@WebServlet("/computer/new")
public class AddComputerController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(AddComputerController.class);
	private CompanyService companyService = CompanyServiceImpl.INSTANCE;
	private ComputerService computerService = ComputerServiceImpl.INSTANCE;
	private static final String ADD_COMPUTER = "/WEB-INF/jsp/addComputer.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddComputerController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.debug("GOTO >>> addComputer.jsp");
		request.setAttribute("computers", companyService.getAll());
		RequestDispatcher rd = request.getRequestDispatcher(ADD_COMPUTER);
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.debug("CREATE Computer...");
		ComputerDto computerDto = new ComputerDto.Builder(request.getParameter("name"))
				.companyId(Integer.parseInt(request.getParameter("companyId")))
				.discontinued(request.getParameter("discontinued"))
				.introduced(request.getParameter("introduced"))
				.build();
		LOGGER.debug(computerDto.toString());
		ComputerDtoValidator.validate(computerDto);
		Computer computer = MapperComputerDto.toComputer(computerDto);
		int computerCreatedId = computerService.create(computer);
		LOGGER.debug("CREATED ComputerId : " + computerCreatedId);
		response.sendRedirect("/computer");

	}

}
