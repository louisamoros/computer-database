package com.louisamoros.cdb.webservice.impl;

import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.ComputerService;
import com.louisamoros.cdb.webservice.ComputerWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by louis on 25/03/16.
 */
@Component
@WebService(endpointInterface = "com.louisamoros.cdb.webservice.ComputerWS")
public class ComputerWSImpl implements ComputerWS {

    @Autowired
    private ComputerService computerService;

    @Override
    public final List<Computer> findAll() {
        return computerService.findAll();
    }

}
