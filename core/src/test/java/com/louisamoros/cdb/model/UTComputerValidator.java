package com.louisamoros.cdb.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.Set;

/**
 * Unit test class to test computer validation model.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-core-context.xml")
public class UTComputerValidator {

    @Resource
    private Validator validator;

    @Test
    public void validComputer() {
        Computer computer = new Computer.Builder("computer").build();
        Set<ConstraintViolation<Computer>> constraintViolations = validator.validate(computer);
        Assert.assertEquals(0, constraintViolations.size());
        Assert.assertNotNull(computer);
    }

    @Test
    public void nameNull() {
        try {
            new Computer.Builder(null).build();
            Assert.fail("Expected ConstraintViolationException wasn't thrown.");
        }
        catch (ConstraintViolationException e) {
            Assert.assertEquals(1, e.getConstraintViolations().size());
        }
    }


    @Test
    public void wrongOrderDate() {
        try {
            new Computer.Builder("computer")
                    .introduced(LocalDate.of(1992, 9, 21))
                    .discontinued(LocalDate.of(1992, 9, 20))
                    .build();
            Assert.fail("Expected ConstraintViolationException wasn't thrown.");
        }
        catch (ConstraintViolationException e) {
            Assert.assertEquals(1, e.getConstraintViolations().size());
        }
    }

}