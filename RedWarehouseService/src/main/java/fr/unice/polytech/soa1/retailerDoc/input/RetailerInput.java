package fr.unice.polytech.soa1.retailerDoc.input;


import fr.unice.polytech.soa1.business.DataAccessObject;
import fr.unice.polytech.soa1.retailerDoc.UnsupportedArgumentFault;
import fr.unice.polytech.soa1.retailerDoc.output.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by user on 28/09/14.
 */
@XmlSeeAlso({ProcessDelivery.class, ProcessPickup.class})
public abstract class RetailerInput {


    public final JobResult process(DataAccessObject dao) throws BadJobFault, UnsupportedArgumentFault {
        check();
        return run(dao);
    }

    abstract protected JobResult run(DataAccessObject dao) throws BadJobFault, UnsupportedArgumentFault;

    abstract protected void check() throws BadJobFault, UnsupportedArgumentFault;

}
