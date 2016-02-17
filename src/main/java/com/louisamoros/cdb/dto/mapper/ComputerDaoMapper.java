package com.louisamoros.cdb.dto.mapper;

import com.louisamoros.cdb.dto.ComputerDto;
import com.louisamoros.cdb.exception.IntegrityException;
import com.louisamoros.cdb.model.Computer;

/**
 * Computer mapper between dto and model.
 *
 * @author louis
 */
public class ComputerDaoMapper {

    /**
     * Convert ComputerDao element to Computer model.
     *
     * @param <ComputerDto>
     * @return <Computer>
     */
    public static Computer toComputer(ComputerDto computerDto) {

        if (computerDto == null) {
            throw new IntegrityException("A computer dto can't be empty.");
        }
        return null;
    }

    /**
     * Convert Computer model to ComputerDao element.
     *
     * @param <Computer>
     * @return <ComputerDto>
     */
    public static ComputerDto toComputerDto(Computer computer) {

        if (computer == null) {
            throw new IntegrityException("A computer can't be empty.");
        }
        return null;
    }

}
