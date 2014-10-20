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
@XmlType(name="process_pickup")
public class ProcessPickup extends RetailerInput {
    private List<PickupDocument> pickupDocuments;

    public ProcessPickup(){}

    @XmlElementWrapper(name="pickup")
    @XmlElement(name="product", required = true)
    public List<PickupDocument> getPickupDocument() {
        return pickupDocuments;
    }
    public void setPickupDocuments(List<PickupDocument> pickupDocuments) {
        this.pickupDocuments = pickupDocuments;
    }

    @Override
    protected JobResult run(DataAccessObject dao) throws BadJobFault, UnsupportedArgumentFault {
        ListOfInformation result = new ListOfInformation();
        result.setData(new ArrayList<>());

        for(PickupDocument pickupDocument : getPickupDocument()){
            dao.getDayLogs().add(new DayLog("31231313313","pickup",pickupDocument.getHour(),pickupDocument.getMinutes(),pickupDocument.getProductRef()));
            Information information = new Information("pickup of "+pickupDocument.getProductRef() + " tomorrow at "+ pickupDocument.getHour()+"h" + pickupDocument.getMinutes()+ "m is registered");
            result.getData().add(information);
        }

        return result;
    }

    @Override
    protected void check() throws BadJobFault{
        for(PickupDocument pickupDocument : getPickupDocument()){
            if(pickupDocument.getProductRef() ==null | pickupDocument.getHour() == 0
                    | pickupDocument.getMinutes() == 0 | pickupDocument.getWarehouseRef() == null){
                throw new BadJobFault("Null data provided!");
            }
        }
    }



}
