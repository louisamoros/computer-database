package com.louisamoros.cdb.dto.mapper;

import com.louisamoros.cdb.dto.CompanyDto;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.service.validator.CompanyValidator;

/**
 * Company mapper between dto and model.
 *
 * @author louis
 */
public class MapperCompanyDto {

	/**
	 * Convert CompanyDao element to Company model.
	 *
	 * @param <CompanyDto>
	 * @return <Company>
	 */
	public static Company toCompany(CompanyDto companyDto) {

		Company company = new Company.Builder().id(companyDto.getId()).name(companyDto.getName()).build();
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
		CompanyDto companyDto = new CompanyDto.Builder().id(company.getId()).name(company.getName()).build();
		return companyDto;
	}

}
