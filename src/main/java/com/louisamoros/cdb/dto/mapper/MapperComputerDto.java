package com.louisamoros.cdb.dto.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.louisamoros.cdb.dto.ComputerDto;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.validator.ComputerValidator;

/**
 * The Class MapperComputerDto.
 */
public class MapperComputerDto {

    private static final Logger LOGGER = LoggerFactory.getLogger(MapperComputerDto.class);

    /**
     * To computer.
     *
     * @param computerDto the computer dto
     * @return the computer
     */
    public static Computer toComputer(ComputerDto computerDto) {

        LOGGER.debug("Mapper from computerDto :" + computerDto);
        LocalDate introduced = null;
        LocalDate discontinued = null;

        if (computerDto.getIntroduced() != null && !computerDto.getIntroduced().isEmpty()) {
            introduced = LocalDate.parse(computerDto.getIntroduced());
        }
        if (computerDto.getDiscontinued() != null && !computerDto.getDiscontinued().isEmpty()) {
            discontinued = LocalDate.parse(computerDto.getDiscontinued());
        }

        Company company = null;
        if (computerDto.getCompanyId() != 0) {
            company = new Company.Builder().id(computerDto.getCompanyId()).name(computerDto.getCompanyName()).build();
        }

        Computer computer = new Computer.Builder(computerDto.getComputerName()).company(company)
                .discontinued(discontinued).introduced(introduced).id(computerDto.getComputerId()).build();
        LOGGER.debug("Mapper to computer: " + computer);

        return computer;

    }

    /**
     * To computer list.
     *
     * @param computersDto the computers dto
     * @return the list
     */
    public static List<Computer> toComputerList(List<ComputerDto> computersDto) {

        List<Computer> computers = new ArrayList<>();
        computersDto.forEach (computerDto -> computers.add(toComputer(computerDto)));
        return computers;

    }

    /**
     * To computer dto.
     *
     * @param computer the computer
     * @return the computer dto
     */
    public static ComputerDto toComputerDto(Computer computer) {

        ComputerValidator.validate(computer);
        ComputerDto computerDto = new ComputerDto.Builder(computer.getName()).companyId(computer.getCompany().getId())
                .companyName(computer.getCompany().getName()).computerId(computer.getId())
                .introduced(String.valueOf(computer.getIntroduced()))
                .discontinued(String.valueOf(computer.getDiscontinued())).build();
        return computerDto;

    }

    /**
     * To computer dto list.
     *
     * @param computers the computers
     * @return the list
     */
    public static List<ComputerDto> toComputerDtoList(List<Computer> computers) {

        List<ComputerDto> computersDto = new ArrayList<>();
        computers.forEach(computer -> computersDto.add(toComputerDto(computer)));
        return computersDto;

    }

}
