/*

  Copyright Baglio Michaël M2 IFI/AL -> Webservice : FedPS

*/

package fr.unice.polytech.soa1.FedPS.rpc;
import fr.unice.polytech.soa1.FedPS.business.Data;
import fr.unice.polytech.soa1.FedPS.business.Status;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Stateless(name = "Management-Private-RPC")
    @WebService(targetNamespace = "http://informatique.polytech.unice.fr/soa1/FedPS/rpc/private",
		portName = "ManagementRPCPrivatePort",
		serviceName = "ManagementRPCPrivateService",
		endpointInterface = "fr.unice.polytech.soa1.FedPS.rpc.Management")
    public class ManagementImpl implements Management{

	@EJB private Data data; 

	@Override
	    public HashMap<String,String> consultParcelStats() throws UnknownParcelFault{
	    HashMap<String,String> parcelStatusToString = new HashMap<String,String>();
	    if(data.getParcelStatus().isEmpty()){
		throw new UnknownParcelFault("Empty List");
	    }else{
		for(Map.Entry<String,Status> entry : data.getParcelStatus().entrySet()){
		    parcelStatusToString.put(entry.getKey(),entry.getValue().toString());  
		}
		
		return parcelStatusToString;
	    }	
	}

	
	@Override
	public String sendDiscountToCustomers(ArrayList<String> mailingList , int discountPercentage){
	    String result = "A discount code of "+ discountPercentage +"% has been sent to the following mail address : ";
	    for(int i = 0 ; i < mailingList.size() - 1 ; i++){
		result = result + mailingList.get(i) + " ,  ";
	    }
	    result = result + mailingList.get(mailingList.size() - 1) + " .";
	    return result;
	}

	@Override
	public String confirmPartnership( String partnerMail , String partnershipCode){
	    String confirmation = "The partnership with the owner of "+ partnerMail + " has been confirmed .";
	    return confirmation;
	}
	    
	
	
    }