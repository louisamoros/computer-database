package com.louisamoros.cdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Home controller class.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    /**
     * Get the home page.
     * @return home page
     */
    @RequestMapping(method = RequestMethod.GET)
    public final String getPageHome() {
        return "home";
    }


}
