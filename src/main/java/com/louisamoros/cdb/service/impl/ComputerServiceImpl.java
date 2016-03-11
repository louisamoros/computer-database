package com.louisamoros.cdb.service.impl;

import com.louisamoros.cdb.controller.Params;
import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.ComputerService;
import com.louisamoros.cdb.service.validator.ComputerValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Spring service computer implementation.
 */
@Service
public class ComputerServiceImpl implements ComputerService {

    /**
     * Autowired spring injection of computer dao.
     */
    @Autowired
    private ComputerDao computerDao;

    @Override
    public final List<Computer> getAll() {
        return computerDao.getAll();
    }

    @Override
    public final Computer get(final int computerId) {
        return computerDao.get(computerId);
    }

    @Override
    public final List<Computer> get(final Params params) {
        return computerDao.get(params);
    }

    @Override
    public final int create(final Computer computer) {
        ComputerValidator.validate(computer);
        return computerDao.create(computer);
    }

    @Override
    public final int update(final Computer computer) {
        ComputerValidator.validate(computer);
        return computerDao.update(computer);
    }

    @Override
    public final void delete(final int computerId) {
        computerDao.delete(computerId);
    }

    @Override
    public final int count(final Params params) {
        return computerDao.count(params);
    }

}
