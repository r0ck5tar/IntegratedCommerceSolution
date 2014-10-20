/*

Copyright Baglio Michaël M2 IFI/AL -> Webservice : FedPS

 */

package fr.unice.polytech.soa1.FedPS.business;



import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;


@Singleton(name = "FedPS-DB-Mock")
    public class Data{
	
	private ArrayList<String> roundItinerary;
	private HashMap<String,Status> parcelStatus ; 
	private ArrayList<Parcel> parcelList;
	
	public ArrayList<String> getRoundItinerary(){
	    return roundItinerary;
	}

	public HashMap<String,Status> getParcelStatus(){
		
	    return parcelStatus;
		
	}

	
	
	public Data(){
	    init();
	}

	private void init(){
	    
	    //Itinerary
	    roundItinerary = new ArrayList<String>(Arrays.asList(
					      "#1|343-1977 Nulla Rd.|6720|pickup|Risa Eaton|#1515213FPS547Z",
					      "#2|510-2487 Egestas. St.|86960|pickup|Sage Rocha|#15147895FPS41Z",
					      "#3|Ap #287-4367 Libero Rd.|71252|delivery|Dustin Davenport|#15112FPS8999Z",
					      "#4|729-3045 Sed Avenue|03039|pickup|Yvette Jacobson|#1512FPS478Z",
					      "#5|P.O. Box 774, 7965 Enim Street|95308|delivery|Ursula Walsh|#15112000FPS1000Z"));

	    //Parcel

	    Parcel p1 = new Parcel("Ap #179-6813 In St.|59300|Galmaarden","4418 Cum St.|86901|Pitt Meadows",new Dimensions(4,2.1,1.3),12.3);
	    Parcel p2 =	new Parcel("P.O. Box 119, 9819 Nulla Avenue|36206|Leonding","P.O. Box 655, 9806 Consectetuer Rd.|47269|San Lorenzo",new Dimensions(2,2,1),6);
	    Parcel p3 = new Parcel("669-9468 Nibh. St.|12966|Moradabad","658-3790 Velit. Rd.|17587|Patna",new Dimensions(4,1,1),10.2);
	    Parcel p4 = new Parcel("893-2515 Sed Avenue|38529|Markham","2090 Amet Road|18981|Güssing",new Dimensions(2.1,1.4,3),2.1);
	    Parcel p5 = new Parcel("622-7500 Natoque Avenue|14185|Hapur","P.O. Box 298, 1514 Magna. Av.|20858|Doel",new Dimensions(1.2,4.6,1),7.5);
	    Parcel p6 = new Parcel("5276 Amet Av.|94558|Bersillies-l'Abbaye","980-352 Placerat. Ave|80630|Jandrain-Jandrenouille",new Dimensions(9,4,2),42);
	    Parcel p7 = new Parcel("P.O. Box 201, 3578 Ante. Ave|69763|Shaki","380-4872 Magna Avenue|27364|Melton Mowbray",new Dimensions(4,5,6),24);
	    Parcel p8 = new Parcel("4196 Erat St.|18329|Rocky Mountain House","409-1443 Cum St.|34098|Frankfort",new Dimensions(2.2,2.3,2.4),13.6);
	    Parcel p9 = new Parcel("8900 Enim. Ave|99802|Genval","98-1029 Lacus. Av.|78050|Galzignano Terme",new Dimensions(4,4,4),9.1);

	    p1.setParcelID("#1515213FPS547Z");
	    p2.setParcelID("#15147895FPS41Z");
	    p3.setParcelID("#15112FPS8999Z");
	    p4.setParcelID("#151741FPS562Z");
	    p5.setParcelID("#1514569FPS123Z");
	    p6.setParcelID("#1512FPS478Z");
	    p7.setParcelID("#1510FPS32Z");
	    p8.setParcelID("#1514715FPS8791Z");
	    p9.setParcelID("#15112000FPS1000Z");

	    parcelList = new ArrayList<Parcel>();
	    parcelList.add(p1);
	    parcelList.add(p2);
	    parcelList.add(p3);
	    parcelList.add(p4);
            parcelList.add(p5);
	    parcelList.add(p6);
	    parcelList.add(p7);
	    parcelList.add(p8);
	    parcelList.add(p9);


	    //ParcelStatus
	    parcelStatus = new HashMap<String,Status>();
	    parcelStatus.put("#1515213FPS547Z",Status.WAITING_FOR_PICK_UP);
	    parcelStatus.put("#15147895FPS41Z",Status.STORAGE);
	    parcelStatus.put("#15112FPS8999Z",Status.IN_TRANSIT);
	    parcelStatus.put("#151741FPS562Z",Status.ARRIVAL_SCAN);
	    parcelStatus.put("#1514569FPS123Z",Status.CUSTOMS);
	    parcelStatus.put("#1512FPS478Z",Status.WAITING_FOR_PICK_UP);
	    parcelStatus.put("#1510FPS32Z",Status.DELIVERED);
	    parcelStatus.put("#1514715FPS8791Z",Status.WAITING_FOR_PICK_UP);
	    parcelStatus.put("#15112000FPS1000Z",Status.IN_TRANSIT);
	    parcelStatus.put("#1510FPS1Z",Status.LATE_DELIVERY);
	    parcelStatus.put("#1510FPS2Z",Status.LATE_DELIVERY);
	    parcelStatus.put("#1510FPS3Z",Status.LATE_DELIVERY);
	    parcelStatus.put("#1510FPS4Z",Status.LATE_DELIVERY);
	    parcelStatus.put("#1510FPS5Z",Status.LATE_DELIVERY);
	}
    }


