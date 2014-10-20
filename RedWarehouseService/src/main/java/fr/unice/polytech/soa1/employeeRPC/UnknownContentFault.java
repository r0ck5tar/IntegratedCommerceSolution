package fr.unice.polytech.soa1.employeeRPC;

import javax.xml.ws.WebFault;

/**
 * Created by user on 06/10/14.
 */

@WebFault(name="UnknownContent", targetNamespace = "http://informatique.polytech.unice.fr/soa1/employeeRPC/private")
public class UnknownContentFault extends Exception{
    private static final long serialVersionUID = 6647532542732631049L;

    public UnknownContentFault(String value) {
        super("Unknown Content: [" + value + "]");
    }
}
