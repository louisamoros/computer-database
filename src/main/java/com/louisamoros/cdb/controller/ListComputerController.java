package com.louisamoros.cdb.controller;

import com.louisamoros.cdb.controller.util.PageDtoCreator;
import com.louisamoros.cdb.controller.util.QueryParams;
import com.louisamoros.cdb.dto.ComputerDto;
import com.louisamoros.cdb.dto.PageDto;
import com.louisamoros.cdb.dto.mapper.MapperComputerDto;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.ComputerService;
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
 * The Class ListComputerController.
 */
@WebServlet(name = "/computer", value = "/computer")
public class ListComputerController extends HttpServlet {

  private static final long serialVersionUID = -1500697912744651041L;
  private static final Logger LOGGER = LoggerFactory.getLogger(ListComputerController.class);
  private ComputerService computerService = ComputerServiceImpl.INSTANCE;
  private static final String LIST_COMPUTER = "/WEB-INF/jsp/listComputer.jsp";

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LOGGER.debug("GOTO >>> lisComputer.jsp");
    String page = request.getParameter("p");
    String perPage = request.getParameter("pp");
    String orderBy = request.getParameter("orderby");
    String order = request.getParameter("order");
    String search = request.getParameter("s");
    int count = computerService.count();
    PageDto pageDto = PageDtoCreator.create(page, perPage, "computer", orderBy, order, search,
        count);
    QueryParams qp = new QueryParams.Builder().offset(pageDto.getOffset()).limit(pageDto.getLimit())
        .order(pageDto.getOrder()).orderBy(pageDto.getOrderBy()).search(pageDto.getSearch())
        .build();
    List<Computer> computers = computerService.get(qp);
    List<ComputerDto> computersDto = MapperComputerDto.toComputerDtoList(computers);
    request.setAttribute("computers", computersDto);
    request.setAttribute("page", pageDto);
    RequestDispatcher rd = request.getRequestDispatcher(LIST_COMPUTER);
    rd.forward(request, response);

  }

}
