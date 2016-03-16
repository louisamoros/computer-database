package com.louisamoros.cdb.service.impl;

import com.louisamoros.cdb.controller.util.Params;
import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.model.QComputer;
import com.louisamoros.cdb.service.ComputerService;
import com.louisamoros.cdb.service.validator.ComputerValidator;
import com.mysema.query.types.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Spring service computer implementation.
 */
@Service
public class ComputerServiceImpl implements ComputerService {

    @Autowired
    private ComputerDao computerRepository;

    @Override
    public final List<Computer> findAll() {
        return (List<Computer>) computerRepository.findAll();
    }

    @Override
    public final Computer findOne(final long computerId) {
        return computerRepository.findOne(computerId);
    }

    @Override
    public final Page<Computer> findAll(final Params params) {
        System.out.println(params);
        Pageable pageRequest = new PageRequest(params.getPage(), params.getSize(),
                params.getOrder(), "companyName");
        Predicate searchFilter = QComputer.computer.computerName.contains(params.getSearch())
                .or(QComputer.computer.company.companyName.contains(params.getSearch()));
        return computerRepository.findAll(searchFilter, pageRequest);
    }

    @Override
    public final Computer create(final Computer computer) {
        ComputerValidator.validate(computer);
        return computerRepository.save(computer);
    }

    @Override
    public final Computer update(final Computer computer) {
        ComputerValidator.validate(computer);
        return computerRepository.save(computer);
    }

    @Override
    public final void delete(final long computerId) {
        computerRepository.delete(computerId);
    }

}
