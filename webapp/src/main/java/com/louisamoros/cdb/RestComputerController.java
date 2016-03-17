package com.louisamoros.cdb;

import com.louisamoros.cdb.dto.ComputerDto;
import com.louisamoros.cdb.dto.mapper.MapperComputerDto;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.ComputerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

/**
 * Spring controller for computer model.
 */
@RestController
@RequestMapping("/api/computer")
public class RestComputerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestComputerController.class);

    /**
     * Autowired spring injection of computer service.
     */
    @Autowired
    private ComputerService computerService;

    /**
     * Get list of computers.
     *
     * @return list of computers
     */
    @RequestMapping(method = RequestMethod.GET)
    public final List<ComputerDto> getComputers() {
        LOGGER.info("get /api/computer");
        List<Computer> computers = computerService.findAll();
        List<ComputerDto> computersDto = MapperComputerDto.toComputerDtoList(computers);
        return computersDto;
    }

    /**
     * Get the computer based on its id.
     *
     * @param computerId the computer id
     * @return computer
     */
    @RequestMapping(value = "/{computerId}", method = RequestMethod.GET)
    public final ComputerDto getComputer(@PathVariable("computerId") final int computerId) {
        LOGGER.info("get /api/computer/" + computerId);
        Computer computer = computerService.findOne(computerId);
        ComputerDto computerDto = MapperComputerDto.toComputerDto(computer);
        return computerDto;
    }

    /**
     * Create a computer.
     *
     * @param computerDto the computer dto
     * @param result the binding result of validation
     * @return informative string
     */
    @RequestMapping(method = RequestMethod.POST)
    public final String createComputer(@Valid final ComputerDto computerDto,
            final BindingResult result) {
        LOGGER.info("post /api/computer");
        return "API POST CREATION NOT IMPLEMENTED";
    }

    /**
     * Delete a computer based on its id.
     *
     * @param computerId the computer id to delete
     */
    @RequestMapping(value = "/{computerId}", method = RequestMethod.DELETE)
    public final void deleteComputer(@PathVariable("computerId") final int computerId) {
        LOGGER.info("delete /api/computer/" + computerId);
        computerService.delete(computerId);
    }

    /**
     * Update a computer based on its id.
     *
     * @param computerId  the computer id
     * @param computerDto the computer dto
     * @param result the binding result of validation
     * @return informative string
     */
    @RequestMapping(method = RequestMethod.PUT)
    public final String updateComputer(@PathVariable("computerId") final int computerId,
            @Valid final ComputerDto computerDto, final BindingResult result) {
        LOGGER.info("put /api/computer/" + computerId);
        Computer computer = MapperComputerDto.toComputer(computerDto);
        computerService.update(computer);
        return "redirect:/computer/list";

    }

}
