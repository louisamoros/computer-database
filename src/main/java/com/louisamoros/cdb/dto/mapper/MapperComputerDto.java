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
public class MapperComputerDto {

  /**
   * To computer.
   *
   * @param computerDto the computer dto
   * @return the computer
   */
  public static Computer toComputer(ComputerDto computerDto) {

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
        .discontinued(discontinued).introduced(introduced).id(computerDto.getComputerId()).build();

    return computer;

  }

  /**
   * To computer list.
   *
   * @param computersDto the computers dto
   * @return the list
   */
  public static List<Computer> toComputerList(List<ComputerDto> computersDto) {
    return computersDto.stream().map(MapperComputerDto::toComputer).collect(Collectors.toList());
  }

  /**
   * To computer dto.
   *
   * @param computer the computer
   * @return the computer dto
   */
  public static ComputerDto toComputerDto(Computer computer) {

    ComputerValidator.validate(computer);
    ComputerDto computerDto = new ComputerDto.Builder(computer.getName())
        .companyId(computer.getCompany().getId()).companyName(computer.getCompany().getName())
        .computerId(computer.getId()).introduced(String.valueOf(computer.getIntroduced()))
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
    return computers.stream().map(MapperComputerDto::toComputerDto).collect(Collectors.toList());
  }

}
