package com.louisamoros.cdb.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.CompanyService;
import com.louisamoros.cdb.service.ComputerService;
import com.louisamoros.cdb.service.impl.CompanyServiceImpl;
import com.louisamoros.cdb.service.impl.ComputerServiceImpl;

/**
 * Servlet implementation class NewComputer
 */
@WebServlet("/addComputer")
public class AddComputer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(AddComputer.class);
	private static final String COMPUTERS_ADD = "/WEB-INF/jsp/addComputer.jsp";
	private static final String COMPUTERS_DASHBOARD = "/WEB-INF/jsp/dashboard.jsp";
	private CompanyService companyService;
	private ComputerService computerService;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddComputer() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		companyService = CompanyServiceImpl.INSTANCE;
		LOGGER.debug("doGET addComputer");
		request.setAttribute("companies", companyService.getCompanies());
		RequestDispatcher rd = request.getRequestDispatcher(COMPUTERS_ADD);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		computerService = ComputerServiceImpl.INSTANCE;
		LOGGER.debug("doPost addComputer");
		Company company = new Company("");
		String name = request.getParameter("name");
		LocalDate introducedDate = null;
		LocalDate discontinuedDate = null;

		if(request.getParameter("companyId") != null) {
			company.setCompanyId(Integer.parseInt(request.getParameter("companyId")));
		}
		if(!request.getParameter("introducedDate").isEmpty()) {
			introducedDate = LocalDate.parse(request.getParameter("introducedDate"));
		}
		if(!request.getParameter("discontinuedDate").isEmpty()) {
			discontinuedDate = LocalDate.parse(request.getParameter("discontinuedDate"));
		}
		
		Computer computer = new Computer(company, name, introducedDate, discontinuedDate);
		computerService.createComputer(computer);
		RequestDispatcher rd = request.getRequestDispatcher(COMPUTERS_DASHBOARD);
		rd.forward(request, response);
	}

}
