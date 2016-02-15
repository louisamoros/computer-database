package com.louisamoros.cdb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.louisamoros.cdb.service.ComputerService;
import com.louisamoros.cdb.service.impl.ComputerServiceImpl;
import com.louisamoros.cdb.util.Page;

/**
 * Servlet implementation class ComputersServlet
 */
@WebServlet("/dashboard")
public class ComputerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(ComputerController.class);
	private ComputerService computerService;
	private static final String COMPUTERS_DASHBOARD = "/WEB-INF/jsp/dashboard.jsp";
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ComputerController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		computerService = ComputerServiceImpl.INSTANCE;
		int steps = Page.stepsVerification(request.getParameter("steps"));
		int offset = Page.offsetVerification(request.getParameter("offset"));
		request.setAttribute("computers", computerService.getComputers(offset, steps));
		request.setAttribute("numberOfComputers", computerService.getNumberOfComputers());
		request.setAttribute("steps", steps);
		request.setAttribute("offset", offset);
		LOGGER.debug("GET computers offset=" + offset + " and steps=" + steps);
		RequestDispatcher rd = request.getRequestDispatcher(COMPUTERS_DASHBOARD);
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
