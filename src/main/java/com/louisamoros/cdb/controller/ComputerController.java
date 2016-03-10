package com.louisamoros.cdb.controller;

import com.louisamoros.cdb.controller.util.PageDtoCreator;
import com.louisamoros.cdb.controller.util.QueryParams;
import com.louisamoros.cdb.dto.CompanyDto;
import com.louisamoros.cdb.dto.ComputerDto;
import com.louisamoros.cdb.dto.PageDto;
import com.louisamoros.cdb.dto.mapper.MapperCompanyDto;
import com.louisamoros.cdb.dto.mapper.MapperComputerDto;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.CompanyService;
import com.louisamoros.cdb.service.ComputerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import javax.validation.Valid;

/**
 * Spring controller for computer pages.
 */
@Controller
@RequestMapping("/computer")
public class ComputerController {

    /**
     * Logger for the class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ComputerController.class);

    /**
     * Autowired spring injection of computer service.
     */
    @Autowired
    private ComputerService computerService;

    /**
     * Autowired spring injection of company service.
     */
    @Autowired
    private CompanyService companyService;

    /**
     * Gets the page list computer.
     * @param model the model
     * @param page the page
     * @param perPage the per page
     * @param orderBy the order by
     * @param order the order
     * @param search the search
     * @return jsp page list computer
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public final String getPageListComputer(final Model model,
            @RequestParam(value = "p", required = false) final Integer page,
            @RequestParam(value = "pp", required = false) final Integer perPage,
            @RequestParam(value = "orderby", required = false) final String orderBy,
            @RequestParam(value = "order", required = false) final String order,
            @RequestParam(value = "s", required = false) final String search) {

        LOGGER.info("get /computer/list");
        int count = computerService.count();
        PageDto pageDto = PageDtoCreator.create(page, perPage, "computer/list", orderBy, order,
                search, count);
        // @formatter:off
        QueryParams queryParams = new QueryParams
            .Builder()
            .offset(pageDto.getOffset())
            .limit(pageDto.getLimit())
            .order(pageDto.getOrder())
            .orderBy(pageDto.getOrderBy())
            .search(pageDto.getSearch())
            .build();
        // @formatter:on
        List<Computer> computers = computerService.get(queryParams);
        List<ComputerDto> computersDto = MapperComputerDto.toComputerDtoList(computers);
        model.addAttribute("computersDto", computersDto);
        model.addAttribute("page", pageDto);
        return "computer/list";

    }

    /**
     * Gets the page creation computer.
     * @param model the model
     * @return jsp page creation computer
     */
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public final String getPageCreateComputer(final Model model) {

        LOGGER.info("get page /computer/new");
        List<Company> companies = companyService.getAll();
        List<CompanyDto> companiesDto = MapperCompanyDto.toCompanyDtoList(companies);
        model.addAttribute("computerDto", new ComputerDto());
        model.addAttribute("companiesDto", companiesDto);
        return "computer/create";

    }

    /**
     * Create the computer and return page list.
     * @param model the model
     * @param computerDto the computer dto
     * @param result the binding result of computer dto validation
     * @return jsp page creation computer
     */
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public final String postPageCreateComputer(@Valid final ComputerDto computerDto,
            final BindingResult result, final Model model) {
        LOGGER.info("post /computer/new");
        if (result.hasErrors()) {
            return "computer/create";
        } else {
            Computer computer = MapperComputerDto.toComputer(computerDto);
            computerService.create(computer);
            return "redirect:/computer/list";
        }
    }

    /**
     * Gets the page edit computer.
     * @param model the model
     * @param computerId the computer id
     * @return jsp page edit computer
     */
    @RequestMapping(value = "/edit/{computerId}", method = RequestMethod.GET)
    public final String getPageEditComputer(final Model model, @PathVariable final int computerId) {

        LOGGER.info("get page /computer/edit/" + computerId);
        Computer computer = computerService.get(computerId);
        ComputerDto computerDto = MapperComputerDto.toComputerDto(computer);
        List<Company> companies = companyService.getAll();
        List<CompanyDto> companiesDto = MapperCompanyDto.toCompanyDtoList(companies);
        model.addAttribute("companiesDto", companiesDto);
        model.addAttribute("computerDto", computerDto);
        return "computer/edit";

    }

    /**
     * Update computer the page edit computer.
     * @param model the model
     * @param computerId the computer id
     * @param computerDto the computer dto
     * @param result the binding result of the validation
     * @return jsp page edit computer
     */
    @RequestMapping(value = "/edit/{computerId}", method = RequestMethod.POST)
    public final String postEditComputer(@PathVariable("computerId") final int computerId,
            @Valid final ComputerDto computerDto, final BindingResult result, final Model model) {

        LOGGER.info("post /computer/edit/" + computerId);
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "computer/edit";
        } else {
            Computer computer = MapperComputerDto.toComputer(computerDto);
            computerService.update(computer);
            return "redirect:/computer/list";
        }

    }

    /**
     * Gets the page delete computer.
     * @param selection the ids selection of computer to delete
     * @return jsp page delete computer
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public final String deleteComputer(
            @RequestParam(value = "selection", required = false) final String selection) {

        LOGGER.info("delete /computer/delete");
        String[] ids = null;
        if (selection != null) {
            ids = selection.split(",");
        }
        if (ids != null && ids.length > 0) {
            for (int i = 0; i < ids.length; i++) {
                computerService.delete(Integer.parseInt(ids[i]));
            }
        }
        return "redirect:/computer/list";

    }

}
