package com.louisamoros.cdb.controller;

import com.louisamoros.cdb.controller.util.MapperParams;
import com.louisamoros.cdb.controller.util.Params;
import com.louisamoros.cdb.dto.ComputerDto;
import com.louisamoros.cdb.dto.PageDto;
import com.louisamoros.cdb.dto.mapper.MapperComputerDto;
import com.louisamoros.cdb.dto.mapper.MapperPageDto;
import com.louisamoros.cdb.model.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Locale;

/**
 * Home controller class.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public final String getPageHome(final Locale locale, final Model model) {
        return "home";
    }


}
