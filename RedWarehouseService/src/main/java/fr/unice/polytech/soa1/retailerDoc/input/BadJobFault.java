package fr.unice.polytech.soa1.retailerDoc.input;

import javax.xml.ws.WebFault;

/**
 * Created by user on 02/10/14.
 */
@WebFault(name="BadJobFault", targetNamespace = "http://informatique.polytech.unice.fr/soa1/retailer/doc")
public class BadJobFault extends Exception {
    private static final long serialVersionUID = 6647532542732631149L;

    public BadJobFault(String value) {
        super("Bad Job: [" + value + "]");
    }
}
