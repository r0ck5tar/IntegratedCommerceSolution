package fr.unice.polytech.soa1.retailerDoc;



import fr.unice.polytech.soa1.retailerDoc.output.*;
import fr.unice.polytech.soa1.retailerDoc.input.*;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by user on 28/09/14.
 */

@WebService(targetNamespace = "http://informatique.polytech.unice.fr/soa1/retailer/public")
public interface RetailerDoc {
    @WebMethod(operationName = "submit" )
    @WebResult(name = "result")
    public JobResult dispatch(@WebParam(name = "request") RetailerInput input) throws UnsupportedArgumentFault, BadJobFault;

}
