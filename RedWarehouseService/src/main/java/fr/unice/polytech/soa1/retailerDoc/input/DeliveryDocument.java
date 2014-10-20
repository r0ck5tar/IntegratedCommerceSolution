package fr.unice.polytech.soa1.retailerDoc.input;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by user on 08/10/14.
 */
@XmlType(name="delivery_document")
public class DeliveryDocument {
    private int hour;
    private int minutes;
    private int width;
    private int height;
    private int depth;
    private int quantity;
    private String productRef;
    private String warehouseId;

    public DeliveryDocument(){}

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

    @XmlElement(name="width", required = true)
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    @XmlElement(name="height", required = true)
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    @XmlElement(name="depth", required = true)
    public int getDepth() {
        return depth;
    }
    public void setDepth(int depth) {
        this.depth = depth;
    }

    @XmlElement(name="quantity", required = true)
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @XmlElement(name="product_ref", required = true)
    public String getProductRef() {
        return productRef;
    }
    public void setProductRef(String productRef) {
        this.productRef = productRef;
    }

    @XmlElement(name="warehouse_id", required = true)
    public String getWarehouseId() {
        return warehouseId;
    }
    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }


}
