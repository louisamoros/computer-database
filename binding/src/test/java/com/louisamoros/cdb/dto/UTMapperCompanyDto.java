package com.louisamoros.cdb.dto;

import com.louisamoros.cdb.dto.mapper.MapperCompanyDto;
import com.louisamoros.cdb.model.Company;
import org.junit.Assert;
import org.junit.Test;

/**
 * Mapper unit testing class.
 */
public class UTMapperCompanyDto {

    @Test
    public void toCompany() {
        CompanyDto companyDto = new CompanyDto.Builder().name("company").id((long) 1).build();
        Company company = MapperCompanyDto.toCompany(companyDto);
        Assert.assertEquals(companyDto.getName(), company.getCompanyName());
        Assert.assertEquals(companyDto.getId(), company.getCompanyId());
    }

    @Test
    public void toCompanyDto() {
        Company company = new Company.Builder().name("company").id((long) 1).build();
        CompanyDto companyDto = MapperCompanyDto.toCompanyDto(company);
        Assert.assertEquals(companyDto.getName(), company.getCompanyName());
        Assert.assertEquals(companyDto.getId(), company.getCompanyId());
    }


}
