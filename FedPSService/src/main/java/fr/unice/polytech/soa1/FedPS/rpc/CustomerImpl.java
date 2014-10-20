/*

Copyright Baglio Michaël M2 IFI/AL -> Webservice : FedPS

 */
package fr.unice.polytech.soa1.FedPS.rpc;
import fr.unice.polytech.soa1.FedPS.business.Parcel;
import fr.unice.polytech.soa1.FedPS.business.Quote;
import fr.unice.polytech.soa1.FedPS.business.Data;
import fr.unice.polytech.soa1.FedPS.business.Status;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.ejb.EJB;

@Stateless(name = "Customer-Public-RPC")
@WebService(targetNamespace = "http://informatique.polytech.unice.fr/soa1/FedPS/rpc/public",
		portName = "CustomerRPCPublicPort",
		serviceName = "CustomerRPCPublicService",
		endpointInterface = "fr.unice.polytech.soa1.FedPS.rpc.Customer")
    public class CustomerImpl implements Customer{
	
	@EJB private Data data;


	@Override 
	public Quote parcelDeliveryRequest(Parcel p,String pickUpDate){
	    	Quote q = new Quote(p,pickUpDate);
	    	return q.getQuote();//+ " |Delivery Scheduled ! ";
	}


	@Override
	public Quote  askForQuote(Parcel p,String pickUpDate){
	    Quote q = new Quote(p,pickUpDate);
	    return q.getQuote();
	}

	@Override
	public Quote parcelDeliveryRequestWithPromo(Parcel p,String pickUpDate,int promoCode){
	    Quote q = new Quote(p,pickUpDate,promoCode);
	    return q.getQuote() ;
	}

	@Override
	public Quote askForQuoteWithPromo(Parcel p,String pickUpDate,int promoCode){
	    Quote q = new Quote(p,pickUpDate,promoCode);
	    return q.getQuote() ;
	}

	@Override
	public Status followParcelDelivery(String parcelID){
	    return data.getParcelStatus().get(parcelID);
	}
    }
