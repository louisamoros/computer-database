package com.louisamoros.cdb.dto.mapper;

import com.louisamoros.cdb.dto.CompanyDto;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.service.validator.CompanyValidator;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The Class MapperCompanyDto.
 */
public final class MapperCompanyDto {

    /**
     * The mapper company dto constructor.
     */
    private MapperCompanyDto() {
        super();
    }

    /**
     * Transform a company dto to a company model.
     *
     * @param companyDto
     * @return company
     */
    public static Company toCompany(final CompanyDto companyDto) {

        Company company = new Company.Builder().id(companyDto.getId()).name(companyDto.getName())
                .build();
        return company;

    }

    /**
     * Transform a company model to a company dto.
     *
     * @param company
     * @return company dto
     */
    public static CompanyDto toCompanyDto(final Company company) {

        CompanyValidator.validate(company);
        CompanyDto companyDto = new CompanyDto.Builder().id(company.getCompanyId())
                .name(company.getCompanyName()).build();
        return companyDto;

    }

    /**
     * Transform a list of company model to a list of company dto.
     *
     * @param companies
     * @return list of company dto
     */
    public static List<CompanyDto> toCompanyDtoList(final List<Company> companies) {
        return companies.stream().map(MapperCompanyDto::toCompanyDto).collect(Collectors.toList());
    }

}
