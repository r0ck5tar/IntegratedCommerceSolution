/*

Copyright Baglio Michaël M2 IFI/AL -> Webservice : FedPS

*/

package fr.unice.polytech.soa1.FedPS.rpc;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.HashMap;

@WebService(targetNamespace="http://informatique.polytech.unice.fr/soa1/FedPS/rpc/private")
public interface Management{
    @WebMethod(operationName = "consult_parcel_stats")
    @WebResult(name = "stats")
	public HashMap consultParcelStats() throws UnknownParcelFault;

    @WebMethod(operationName= "send_discount_code")
	@WebResult(name = "discount")
	public String sendDiscountToCustomers(@WebParam(name = "customers_mailing_list") ArrayList<String> mailingList , @WebParam(name = "discount_offer") int discountPercentage);

    @WebMethod(operationName = "partnership_confirmation")
	@WebResult(name = "partnership")
	public String confirmPartnership(@WebParam(name = "partner_mail")String partnerMail , @WebParam(name = "partnership_code") String partnershipCode);
	    
	
}

