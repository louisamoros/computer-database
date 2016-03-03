package com.louisamoros.cdb.controller;

import com.louisamoros.cdb.service.ComputerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "computerDelete", value = "/computer/delete")
public class DeleteComputerController extends AbstractController {

  private static final long serialVersionUID = 3182800033475023069L;
  private static final Logger LOGGER = LoggerFactory.getLogger(DeleteComputerController.class);

  @Autowired
  private ComputerService computerService;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LOGGER.info("DO POST computer delete... ids:" + request.getParameter("selection"));
    String[] ids = null;
    if (request.getParameter("selection") != null) {
      ids = request.getParameter("selection").split(",");
    }
    if (ids != null && ids.length > 0) {
      for (int i = 0; i < ids.length; i++) {
        computerService.delete(Integer.parseInt(ids[i]));
      }
    }
    response.sendRedirect("/cdb/computer");

  }

}
