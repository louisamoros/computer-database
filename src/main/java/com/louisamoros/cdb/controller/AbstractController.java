package com.louisamoros.cdb.controller;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public abstract class AbstractController extends HttpServlet {

  private static final long serialVersionUID = 4054867725684197876L;

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init();
    SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
        config.getServletContext());
  }

}
