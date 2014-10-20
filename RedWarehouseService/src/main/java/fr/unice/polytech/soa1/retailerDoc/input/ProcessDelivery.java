package fr.unice.polytech.soa1.retailerDoc.input;

import fr.unice.polytech.soa1.business.DataAccessObject;
import fr.unice.polytech.soa1.business.DayLog;
import fr.unice.polytech.soa1.retailerDoc.UnsupportedArgumentFault;
import fr.unice.polytech.soa1.retailerDoc.output.Information;
import fr.unice.polytech.soa1.retailerDoc.output.JobResult;
import fr.unice.polytech.soa1.retailerDoc.output.ListOfInformation;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 08/10/14.
 */
@XmlType(name="process_delivery")
public class ProcessDelivery extends RetailerInput {

    private List<DeliveryDocument> deliveryDocuments;

    public ProcessDelivery(){}

    @XmlElementWrapper(name="delivery")
    @XmlElement(name="product", required = true)
    public List<DeliveryDocument> getDeliveryDocuments() {
        return deliveryDocuments;
    }
    public void setDeliveryDocuments(List<DeliveryDocument> deliveryDocuments) {
        this.deliveryDocuments = deliveryDocuments;
    }



    @Override
    protected JobResult run(DataAccessObject dao) throws BadJobFault, UnsupportedArgumentFault {
        ListOfInformation result = new ListOfInformation();
        result.setData(new ArrayList<>());

        for(DeliveryDocument deliveryDocument : getDeliveryDocuments()){
            dao.getDayLogs().add(new DayLog("31231313313", "delivery", deliveryDocument.getHour(), deliveryDocument.getMinutes(), deliveryDocument.getProductRef(),deliveryDocument.getWidth(),deliveryDocument.getHeight(),deliveryDocument.getDepth(),deliveryDocument.getQuantity()));
            Information information = new Information("pickup of "+deliveryDocument.getProductRef() + " tomorrow at "+ deliveryDocument.getHour()+"h" + deliveryDocument.getMinutes()+ "m is registered");
            result.getData().add(information);
        }

        return result;
    }

    @Override
    protected void check() throws BadJobFault, UnsupportedArgumentFault {
        for(DeliveryDocument deliveryDocument : getDeliveryDocuments()){
            if(deliveryDocument.getProductRef() ==null | deliveryDocument.getHour() == 0
                    | deliveryDocument.getMinutes() == 0 | deliveryDocument.getWarehouseId() == null
                    | deliveryDocument.getDepth() == 0
                    | deliveryDocument.getHeight() == 0
                    | deliveryDocument.getDepth() == 0){
                throw new BadJobFault("Null data provided!");
            }
        }
    }
}
