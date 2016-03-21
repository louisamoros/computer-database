package com.louisamoros.cdb.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    /**
     * Get the admin page.
     * @param model the model
     * @return admin page
     */
    @RequestMapping(value = "admin", method = RequestMethod.GET)
    public final String adminPage(final ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "admin";
    }

    /**
     * Get the access denied page.
     * @param model the model
     * @return denied page
     */
    @RequestMapping(value = "denied", method = RequestMethod.GET)
    public final String accessDeniedPage(final ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "denied";
    }

    /**
     * Get the login page.
     * @return login page
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public final String loginPage() {
        return "login";
    }

    /**
     * Get the logout page.
     * @param request the http request
     * @param response the http response
     * @return the redirect to login with logout param
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public final String logoutPage(final HttpServletRequest request, final HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    /**
     * Get the current connected user.
     * @return the username.
     */
    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

}


