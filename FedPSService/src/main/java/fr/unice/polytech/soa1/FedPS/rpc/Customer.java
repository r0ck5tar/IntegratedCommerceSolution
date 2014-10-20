/*

  Copyright Baglio Michaël M2 IFI/AL -> Webservice : FedPS

*/
package fr.unice.polytech.soa1.FedPS.rpc;
import  fr.unice.polytech.soa1.FedPS.business.*;

import javax.jws.*;

@WebService(targetNamespace="http://informatique.polytech.unice.fr/soa1/FedPS/rpc/public")
    public interface Customer{
	
	@WebMethod(operationName = "ask_for_transport")
	    @WebResult(name = "transport")
	    public Quote parcelDeliveryRequest(@WebParam(name = "parcel") Parcel p ,@WebParam(name = "pick_up_date") String pickUpDate);

	@WebMethod(operationName = "ask_for_quote")
	    @WebResult(name = "quote")
	    public Quote  askForQuote(@WebParam(name = "parcel") Parcel p ,@WebParam(name = "pick_up_date") String pickUpDate);


	@WebMethod(operationName = "ask_for_transport_with_promo_code")
	    @WebResult(name = "promo_transport")
	    public Quote  parcelDeliveryRequestWithPromo(@WebParam(name = "parcel") Parcel p ,@WebParam(name = "pick_up_date") String pickUpDate,@WebParam(name = "promo_code")int promoCode);

	@WebMethod(operationName = "ask_for_quote_with_promo_code")
	    @WebResult(name = "promo_quote")
	    public Quote askForQuoteWithPromo(@WebParam(name = "parcel") Parcel p ,@WebParam(name = "pick_up_date") String pickUpDate,@WebParam(name = "promo_code")int promoCode);


	@WebMethod(operationName = "follow_parcel_delivery")
	    @WebResult(name = "follow")
	    public Status followParcelDelivery(@WebParam(name = "parcel_id") String parcelID);
    }