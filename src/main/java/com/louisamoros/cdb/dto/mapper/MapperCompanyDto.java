package com.louisamoros.cdb.dto.mapper;

import com.louisamoros.cdb.dto.CompanyDto;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.service.validator.CompanyValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class MapperCompanyDto.
 */
public class MapperCompanyDto {

  /**
   * To company.
   *
   * @param companyDto the company dto
   * @return the company
   */
  public static Company toCompany(CompanyDto companyDto) {

    Company company = new Company.Builder().id(companyDto.getId()).name(companyDto.getName())
        .build();
    return company;

  }

  /**
   * To company dto.
   *
   * @param company the company
   * @return the company dto
   */
  public static CompanyDto toCompanyDto(Company company) {

    CompanyValidator.validate(company);
    CompanyDto companyDto = new CompanyDto.Builder().id(company.getId()).name(company.getName())
        .build();
    return companyDto;
  }

  /**
   * To company dto list.
   *
   * @param companies the companies
   * @return the list
   */
  public static List<CompanyDto> toCompanyDtoList(List<Company> companies) {

    List<CompanyDto> companiesDto = new ArrayList<>();
    companies.forEach(company -> companiesDto.add(toCompanyDto(company)));
    return companiesDto;

  }

}
