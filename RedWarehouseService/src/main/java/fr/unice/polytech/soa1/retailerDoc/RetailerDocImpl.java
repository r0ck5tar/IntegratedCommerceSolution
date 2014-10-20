package fr.unice.polytech.soa1.retailerDoc;



import fr.unice.polytech.soa1.business.DataAccessObject;
import fr.unice.polytech.soa1.business.DayLog;
import fr.unice.polytech.soa1.business.Kind;
import fr.unice.polytech.soa1.retailerDoc.output.*;
import fr.unice.polytech.soa1.retailerDoc.input.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;
import java.util.Random;
import java.util.stream.LongStream;

/**
 * Created by user on 01/10/14.
 */
@Stateless(name = "retailer-public")
@WebService(targetNamespace = "http://informatique.polytech.unice.fr/soa1/retailer/public",
        portName = "RetailerPort",
        serviceName = "RetailerDocService",
        endpointInterface = "fr.unice.polytech.soa1.retailerDoc.RetailerDoc")
public class RetailerDocImpl implements RetailerDoc {
    @EJB
    private DataAccessObject dao;

    @Override
    public JobResult dispatch(RetailerInput input) throws UnsupportedArgumentFault, BadJobFault {
        return input.process(dao);
    }

    private void check(DeliveryDocument input) throws UnsupportedArgumentFault {
        if (input == null)
            throw new UnsupportedArgumentFault(null);

        //more test must follow
    }
}
