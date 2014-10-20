package fr.unice.polytech.soa1.teamLeaderREST;

import javax.xml.ws.WebFault;

/**
 * Created by user on 06/10/14.
 */
@WebFault(name="UnknownDayLogFault", targetNamespace = "http://informatique.polytech.unice.fr/soa1/calculator/doc-demo")
public class UnknownDayLogFault extends Exception {

    private static final long serialVersionUID = 6647532542732631047L;

    public UnknownDayLogFault(long eventId) {
        super("The day log event was not found. id: " + eventId);
    }
}
