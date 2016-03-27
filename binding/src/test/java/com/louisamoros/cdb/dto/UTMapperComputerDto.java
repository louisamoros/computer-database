package com.louisamoros.cdb.dto;

import com.louisamoros.cdb.dto.mapper.MapperCompanyDto;
import com.louisamoros.cdb.dto.mapper.MapperComputerDto;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.model.Computer;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

/**
 * Mapper unit testing class.
 */
public class UTMapperComputerDto {

    @Test
    public void toComputer() {
        ComputerDto computerDto = new ComputerDto.Builder("computer")
                .computerId((long) 1)
                .discontinued(LocalDate.of(1992, 9, 21).toString())
                .introduced(LocalDate.of(1992, 9, 21).toString())
                .companyId((long) 1)
                .companyName("company")
                .build();
        Computer computer = MapperComputerDto.toComputer(computerDto);
        Assert.assertEquals(computerDto.getComputerName(), computer.getComputerName());
        Assert.assertEquals(computerDto.getComputerId(), computer.getComputerId());
        Assert.assertEquals(computerDto.getCompanyName(), computer.getCompany().getCompanyName());
        Assert.assertEquals(computerDto.getCompanyId(), computer.getCompany().getCompanyId());
        Assert.assertNotNull(computer.getDiscontinued());
        Assert.assertNotNull(computer.getIntroduced());
    }

    @Test
    public void toComputerDto() {
        Computer computer = new Computer.Builder("computer")
                .id((long) 1)
                .discontinued(LocalDate.of(1992, 9, 21))
                .introduced(LocalDate.of(1992, 9, 21))
                .company(new Company.Builder().name("company").id((long) 1).build())
                .build();
        ComputerDto computerDto = MapperComputerDto.toComputerDto(computer);
        Assert.assertEquals(computerDto.getComputerName(), computer.getComputerName());
        Assert.assertEquals(computerDto.getComputerId(), computer.getComputerId());
        Assert.assertEquals(computerDto.getCompanyName(), computer.getCompany().getCompanyName());
        Assert.assertEquals(computerDto.getCompanyId(), computer.getCompany().getCompanyId());
        Assert.assertNotNull(computer.getDiscontinued());
        Assert.assertNotNull(computer.getIntroduced());
    }


}
