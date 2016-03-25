package com.louisamoros.cdb.dto.mapper;

import com.louisamoros.cdb.dto.ComputerDto;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.validator.ComputerValidator;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Class MapperComputerDto.
 */
public final class MapperComputerDto {

    /**
     * The mapper computer dto constructor.
     */
    private MapperComputerDto() {
        super();
    }

    /**
     * Transform a computer dto to a computer model.
     *
     * @param computerDto the computer dto
     * @return computer
     */
    public static Computer toComputer(final ComputerDto computerDto) {

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
            company = new Company.Builder().id(computerDto.getCompanyId())
                    .name(computerDto.getCompanyName()).build();
        }

        Computer computer = new Computer.Builder(computerDto.getComputerName()).company(company)
                .discontinued(discontinued).introduced(introduced).id(computerDto.getComputerId())
                .build();

        return computer;

    }

    /**
     * Transform a list of computer dto to a list of computer model.
     *
     * @param computersDto the list of computer dto
     * @return list of computer
     */
    public static List<Computer> toComputerList(final List<ComputerDto> computersDto) {
        return computersDto.stream().map(MapperComputerDto::toComputer)
                .collect(Collectors.toList());
    }

    /**
     * Transform a computer model to a computer dto.
     *
     * @param computer the computer
     * @return computer dto
     */
    public static ComputerDto toComputerDto(final Computer computer) {

        ComputerValidator.validate(computer);
        String companyName = null;
        long companyId = 0L;

        if (computer.getCompany() != null) {
            companyName = computer.getCompany().getCompanyName();
            companyId = computer.getCompany().getId();
        }

        String introduced = "";
        String discontinued = "";

        if (computer.getIntroduced() != null) {
            introduced = computer.getIntroduced().toString();
        }
        if (computer.getDiscontinued() != null) {
            discontinued = computer.getDiscontinued().toString();
        }

        // formatter:off
        ComputerDto computerDto = new ComputerDto.Builder(computer.getName())
                .computerId(computer.getId()).companyId(companyId).companyName(companyName)
                .introduced(introduced).discontinued(discontinued).build();
        // formatter:on
        return computerDto;

    }

    /**
     * Transform a list of computer model to a list of computer dto.
     *
     * @param computers the list of computer
     * @return list of computer dto
     */
    public static List<ComputerDto> toComputerDtoList(final List<Computer> computers) {
        return computers.stream().map(MapperComputerDto::toComputerDto)
                .collect(Collectors.toList());
    }

}
