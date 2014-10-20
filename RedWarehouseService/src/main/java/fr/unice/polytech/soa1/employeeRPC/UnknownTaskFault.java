package fr.unice.polytech.soa1.employeeRPC;

import javax.xml.ws.WebFault;

/**
 * Created by user on 06/10/14.
 */
@WebFault(name="UnknownTask", targetNamespace = "http://informatique.polytech.unice.fr/soa1/employeeRPC/private")
public class UnknownTaskFault extends Exception {

    private static final long serialVersionUID = 6647532542732631049L;

    public UnknownTaskFault(String id) {
        super("task not found for employee: [" + id + "]");
    }
}
