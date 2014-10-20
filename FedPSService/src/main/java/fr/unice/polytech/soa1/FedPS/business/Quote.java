/*

Copyright Baglio Michaël M2 IFI/AL -> Webservice : FedPS

 */
package fr.unice.polytech.soa1.FedPS.business;

import javax.xml.bind.annotation.XmlType;


@XmlType(name="QuoteClass")
public class Quote {
	
	private Parcel parcel ;
	private double price ;
	private String pickUpDate ;
	private double pickUpTime;
	private String deliveryDate ;
	private double ETA;

	public Quote() {
	    parcel = new Parcel();
	    price = 0 ;
	    pickUpDate = "" ;
	    pickUpTime = 0;
	    deliveryDate = "";
	    ETA = 0 ;
	}

	public Quote(Parcel p , String pUp ){
	    parcel = p;
	    pickUpDate = pUp ;
	    computingPrice();
	    deliveryService();
	}

	public Quote(Parcel p , String pUp ,int promoCode){
	    parcel = p;
	    pickUpDate = pUp ;
	    computingPriceWithPromo(promoCode);
	    deliveryService();
	}

	public void computingPrice(){
	    setPrice(24);
	}

	public void computingPriceWithPromo(int promoCode){
		if(promoCode == 1234){
			setPrice(20);
		}else{
			System.out.println("Wrong Promotion Code => Normal Price");
			setPrice(24);
		}
	}

	public void deliveryService(){
	    setPickUpTime(10.30) ;
	    setDeliveryDate("2014-9-15") ;
	    setETA(16.15);
	}

       
	public String QuoteToString(){
	    return "Quote :Transport from "+this.parcel.getPickUpAddress()+" to "+this.parcel.getDeliveryAddress()+ " , pick up date : "+getPickUpDate()+ " at "+getPickUpTime()+ " , delivery scheduled on "+getDeliveryDate()+ " , ETA : "+getETA()+" . Price :"+getPrice()+ ". ";
	}

    public Quote getQuote(){
	return this;
    }

	public Parcel getParcel(){
	    return parcel;
	}

	public void setParcel(Parcel p){
	    this.parcel = p;
	}

	public double getPrice(){
	    return price;
	}

	public void setPrice(double p){
	    this.price = p ; 
	}

	public String getPickUpDate(){
	    return pickUpDate;
	}

	public void setPickUpDate(String p){
	    this.pickUpDate = p ;
	}

	public double getPickUpTime(){
	    return pickUpTime;
	}
	
	public void setPickUpTime(double p){
	    this.pickUpTime = p ;
	}

	public String getDeliveryDate() {
	    return deliveryDate;
	}

	public void setDeliveryDate(String dd){
	    this.deliveryDate = dd ;
	}

	public double getETA(){
	    return ETA;
	}
	
	public void setETA(double eta){
	    this.ETA = eta;
	}
	


    }
