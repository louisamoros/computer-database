package com.louisamoros.cdb.dto;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Unit test class to test computer validation model.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-binding-context.xml")
public class UTCompanyDtoValidator {

    @Resource
    private Validator validator;

    @Test
    public void validCompany() {
        CompanyDto companyDto = new CompanyDto.Builder().build();
        Set<ConstraintViolation<CompanyDto>> constraintViolations = validator.validate(companyDto);
        Assert.assertEquals(0, constraintViolations.size());
        Assert.assertNotNull(companyDto);
    }

}