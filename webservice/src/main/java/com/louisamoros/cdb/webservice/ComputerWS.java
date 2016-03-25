package com.louisamoros.cdb.webservice;

import com.louisamoros.cdb.model.Computer;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by louis on 25/03/16.
 */
@WebService
@SOAPBinding(style= SOAPBinding.Style.DOCUMENT)
public interface ComputerWS {

    /**
     * Webservice method to get all computers.
     * @return list of computers
     */
    @WebMethod
    List<Computer> findAll();

}
