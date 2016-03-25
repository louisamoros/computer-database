package com.louisamoros.cdb.webservice;

import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.webservice.impl.ComputerWSImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by louis on 25/03/16.
 */
public final class ComputerWSPublisher {

    /**
     * Private constructor.
     */
    private ComputerWSPublisher() {
        super();
    }

    /**
     * Launch publisher main method.
     * @param args the args parameters
     */
    public static void main(final String... args) {
        ComputerWs computerWs = new ComputerWSImpl();
        Endpoint.publish("http://localhost:8083/ws", computerWs);
    }

}
