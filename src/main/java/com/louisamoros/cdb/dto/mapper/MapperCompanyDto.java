package com.louisamoros.cdb.dto.mapper;

import com.louisamoros.cdb.dto.CompanyDto;
import com.louisamoros.cdb.exception.IntegrityException;
import com.louisamoros.cdb.model.Company;

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

        if (companyDto == null) {
            throw new IntegrityException("A company dto can't be empty.");
        }
        return null;
    }

    /**
     * Convert Company model to CompanyDao element.
     *
     * @param <Company>
     * @return <CompanyDto>
     */
    public static CompanyDto toCompanyDto(Company company) {

        if (company == null) {
            throw new IntegrityException("A company can't be empty.");
        }
        return null;
    }

}
