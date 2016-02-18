package com.louisamoros.cdb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.louisamoros.cdb.controller.util.PageDtoCreator;
import com.louisamoros.cdb.dto.ComputerDto;
import com.louisamoros.cdb.dto.PageDto;
import com.louisamoros.cdb.dto.mapper.MapperComputerDto;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.ComputerService;
import com.louisamoros.cdb.service.impl.ComputerServiceImpl;

/**
 * Servlet implementation class ComputersServlet
 */
@WebServlet("/computer")
public class ListComputerController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(ListComputerController.class);
	private ComputerService computerService = ComputerServiceImpl.INSTANCE;
	private static final String LIST_COMPUTER = "/WEB-INF/jsp/listComputer.jsp";
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListComputerController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LOGGER.debug("GOTO >>> lisComputer.jsp");
		String page = request.getParameter("p");
		String perPage = request.getParameter("pp");
		PageDto pageDto = PageDtoCreator.create(page, perPage);
		List<Computer> computers = computerService.get(pageDto.getOffset(), pageDto.getLimit());
		List<ComputerDto> computersDto = MapperComputerDto.toComputerDtoList(computers);
		RequestDispatcher rd = request.getRequestDispatcher(LIST_COMPUTER);
		rd.forward(request, response);
		
	}

}
