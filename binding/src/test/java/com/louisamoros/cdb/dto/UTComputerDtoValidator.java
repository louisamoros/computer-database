package com.louisamoros.cdb.dto;

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
@ContextConfiguration("classpath:test-binding-context.xml")
public class UTComputerDtoValidator {

    @Resource
    private Validator validator;

    @Test
    public void validComputerDto() {
        ComputerDto computerDto = new ComputerDto.Builder("computer").build();
        Set<ConstraintViolation<ComputerDto>> constraintViolations = validator.validate(computerDto);
        Assert.assertEquals(0, constraintViolations.size());
        Assert.assertNotNull(computerDto);
    }

    @Test
    public void nameNull() {
        try {
            new ComputerDto.Builder(null).build();
            Assert.fail("Expected ConstraintViolationException wasn't thrown.");
        }
        catch (ConstraintViolationException e) {
            Assert.assertEquals(1, e.getConstraintViolations().size());
        }
    }


    @Test
    public void wrongOrderDate() {
        try {
            new ComputerDto.Builder("computer")
                    .introduced(LocalDate.of(1992, 9, 21).toString())
                    .discontinued(LocalDate.of(1992, 9, 20).toString())
                    .build();
            Assert.fail("Expected ConstraintViolationException wasn't thrown.");
        }
        catch (ConstraintViolationException e) {
            Assert.assertEquals(1, e.getConstraintViolations().size());
        }
    }

}