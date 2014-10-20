package fr.unice.polytech.soa1.retailerDoc.input;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by user on 08/10/14.
 */
@XmlType(name="pickup_document")
public class PickupDocument {
    private int hour;
    private int minutes;
    private String warehouseRef;
    private String productRef;

    public PickupDocument(){}

    @XmlElement(name="hour", required = true)
    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }

    @XmlElement(name="minutes", required = true)
    public int getMinutes() {
        return minutes;
    }
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    @XmlElement(name="warehouse_ref", required = true)
    public String getWarehouseRef() {
        return warehouseRef;
    }
    public void setWarehouseRef(String warehouseRef) {
        this.warehouseRef = warehouseRef;
    }

    @XmlElement(name="product_ref", required = true)
    public String getProductRef() {
        return productRef;
    }
    public void setProductRef(String productRef) {
        this.productRef = productRef;
    }
}
