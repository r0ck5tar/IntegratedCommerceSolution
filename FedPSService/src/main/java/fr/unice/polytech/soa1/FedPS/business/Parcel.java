/*

Copyright Baglio Michaël M2 IFI/AL -> Webservice : FedPS

 */

package fr.unice.polytech.soa1.FedPS.business;
import java.util.Random ;
import javax.xml.bind.annotation.*;


@XmlType
public class Parcel{

    private String parcelID ;
    private String pickUpAddress;
    private String deliveryAddress;
    private Dimensions dimensions;
    private double weight;
    private Random rand = new Random();
        


    public Parcel(){
	parcelID = "" ; 
	pickUpAddress = "";
	deliveryAddress = "";
	dimensions = new Dimensions();

	weight = 0; 
    }

    public Parcel(String pUp , String deli , Dimensions d, double wei){
	parcelID = "#151"+rand.nextInt(50000)+"FPS"+rand.nextInt(10000)+"Z";
	pickUpAddress = pUp ;
	deliveryAddress = deli ; 
	dimensions = d;
	weight = wei; 
    }

	public String getParcelID(){
	return parcelID;
    }

    public void setParcelID(String id){
	this.parcelID = id ;
    }
    @XmlElement(name="pick_up_address")
	public String getPickUpAddress(){
	return pickUpAddress;
    }
    
    public void setPickUpAddress(String pUp){
	this.pickUpAddress = pUp;
    }
    @XmlElement(name="delivery_address")
	public String getDeliveryAddress(){
	return deliveryAddress;
    }

    public void setDeliveryAddress(String deli){
	this.deliveryAddress = deli ;
    }
    @XmlElement(name="parcel_dimensions")
	public Dimensions getDimensions(){
	return dimensions;
    }

    public void setDimensions(Dimensions d ){
	this.dimensions = d ;
    }
    @XmlElement(name="parcel_weight")
	public double getWeight(){
	return weight;
    }

    public void setWeight(double wei){
	this.weight = weight;
    }
    

}
