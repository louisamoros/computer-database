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

/**
 * Servlet implementation class NewComputer
 */
@WebServlet("/computer/new")
public class AddComputerController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(AddComputerController.class);
//	private CompanyService companyService = CompanyServiceImpl.INSTANCE;
//	private ComputerService computerService = ComputerServiceImpl.INSTANCE;
	private static final String LIST_COMPUTER = "/WEB-INF/jsp/listComputer.jsp";
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
		RequestDispatcher rd = request.getRequestDispatcher(ADD_COMPUTER);
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.debug("CREATE Computer");
		RequestDispatcher rd = request.getRequestDispatcher(LIST_COMPUTER);
		rd.forward(request, response);

	}

}
