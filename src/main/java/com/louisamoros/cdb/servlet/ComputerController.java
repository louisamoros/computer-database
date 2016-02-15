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
@WebServlet("/computers")
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
		int perPage = Page.perPageVerification(request.getParameter("perPage"));
		int page = Page.pageVerification(request.getParameter("page"));
		request.setAttribute("computers", computerService.getComputers(page, perPage));
		request.setAttribute("numberOfComputers", computerService.getNumberOfComputers());
		request.setAttribute("perPage", perPage);
		request.setAttribute("page", page);
		LOGGER.debug("GET computers page=" + page + " and perPage=" + perPage);
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
