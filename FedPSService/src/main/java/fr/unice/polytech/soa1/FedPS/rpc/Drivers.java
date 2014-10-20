/*

Copyright Baglio Michaël M2 IFI/AL -> Webservice : FedPS

 */

package fr.unice.polytech.soa1.FedPS.rpc;
import fr.unice.polytech.soa1.FedPS.business.Status;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(targetNamespace="http://informatique.polytech.unice.fr/soa1/FedPS/rpc/private")
    public interface Drivers{
	
	@WebMethod(operationName = "consult_round_itinerary")
	    @WebResult(name = "itinerary")
	    public ArrayList<String> consultRoundItinerary(@WebParam(name = "driver_id") int driverID);

	@WebMethod(operationName = "scan_parcel")
	    @WebResult(name = "scan")
	    public String parcelScan(@WebParam(name ="parcel_id") String parcelID,@WebParam(name="new_status") Status newStatus) throws UnknownParcelFault;
    }