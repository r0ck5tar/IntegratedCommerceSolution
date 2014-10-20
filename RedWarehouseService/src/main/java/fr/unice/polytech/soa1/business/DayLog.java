package fr.unice.polytech.soa1.business;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by user on 05/10/14.
 */
@XmlType
@XmlRootElement(name = "day_log")
public class DayLog {
    private String eventId;
    private Kind kind;
    private int hour;
    private int minutes;
    private String productRef;
    private int quantity;
    private int height;
    private int width;
    private int depth;

    public DayLog(){}

    public DayLog(String eventId, String kind, int hour, int minutes, String productRef, int width,int height,int depth, int quantity){
        this.eventId = eventId;
        //sorry about that!
        switch (kind){
            case "pickup" : this.kind = Kind.PICKUP;
                break;
            case "delivery" : this.kind = Kind.DELIVERY;
                break;
        }
        this.kind = Kind.PICKUP;
        this.hour = hour;
        this.minutes = minutes;
        this.productRef = productRef;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.quantity = quantity;
    }

    public DayLog(String eventId,String kind, int hour, int minutes, String productRef){
        this.eventId = eventId;
        //here too
        switch (kind){
            case "pickup" : this.kind = Kind.PICKUP;
                break;
            case "delivery" : this.kind = Kind.DELIVERY;
                break;
        }
        this.hour = hour;
        this.minutes = minutes;
        this.productRef = productRef;
    }

    @XmlElement(name="event_id")
    @XmlID
    public String getEventId() {
        return eventId;
    }
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    @XmlElement(name="kind")
    public Kind getKind() {
        return kind;
    }
    public void setKind(Kind kind) {
        this.kind = kind;
    }

    @XmlElement(name="hour")
    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }

    @XmlElement(name="minutes")
    public int getMinutes() {
        return minutes;
    }
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    @XmlElement(name="product_ref")
    public String getProductRef() {
        return productRef;
    }
    public void setProductRef(String productRef) {
        this.productRef = productRef;
    }

    @XmlElement(name="quantity")
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @XmlElement(name="height")
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    @XmlElement(name="width")
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    @XmlElement(name="depth")
    public int getDepth() {
        return depth;
    }
    public void setDepth(int depth) {
        this.depth = depth;
    }
}
