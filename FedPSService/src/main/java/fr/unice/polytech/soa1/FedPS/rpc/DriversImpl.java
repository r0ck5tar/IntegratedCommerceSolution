/*

Copyright Baglio Michaël M2 IFI/AL -> Webservice : FedPS

*/

package fr.unice.polytech.soa1.FedPS.rpc;
import fr.unice.polytech.soa1.FedPS.business.Data;
import fr.unice.polytech.soa1.FedPS.business.Status;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;



@Stateless(name = "Drivers-Private-RPC")
@WebService(targetNamespace = "http://informatique.polytech.unice.fr/soa1/FedPS/rpc/private",
		portName = "DriversRPCPrivatePort",
		serviceName = "DriversRPCPrivateService",
		endpointInterface = "fr.unice.polytech.soa1.FedPS.rpc.Drivers")

    public class DriversImpl implements Drivers{
	
	@EJB private Data data;

	@Override 
	public ArrayList<String> consultRoundItinerary(int driverID){
	    if(driverID == 42){
		return data.getRoundItinerary();
	    }else{
		return null ;
	    }
	    
	}

	@Override
	public String parcelScan(String parcelID,Status newStatus) throws UnknownParcelFault{
	    if(!data.getParcelStatus().isEmpty()){
		data.getParcelStatus().put(parcelID,newStatus);
		return "New Status for : "+ parcelID + " : "+data.getParcelStatus().get(parcelID) ;
	    }else{
		throw new UnknownParcelFault(parcelID);
	    }
	}

    }