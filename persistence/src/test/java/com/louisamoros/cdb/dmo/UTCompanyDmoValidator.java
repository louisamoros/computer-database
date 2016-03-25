package com.louisamoros.cdb.dmo;

import com.louisamoros.cdb.model.Company;
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
@ContextConfiguration("classpath:test-core-context.xml")
public class UTCompanyDmoValidator {

    @Resource
    private Validator validator;

    @Test
    public void validCompany() {
        Company company = new Company.Builder().build();
        Set<ConstraintViolation<Company>> constraintViolations = validator.validate(company);
        Assert.assertEquals(0, constraintViolations.size());
        Assert.assertNotNull(company);
    }

}
