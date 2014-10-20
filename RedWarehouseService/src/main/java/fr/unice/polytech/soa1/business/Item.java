package fr.unice.polytech.soa1.business;

import javax.xml.bind.annotation.*;

/**
 * Created by user on 05/10/14.
 */

@XmlType
@XmlRootElement(name = "item")
public class Item {
    private String reference;
    private int floor;
    private int rack;
    private int corridor;
    private int quantity;
    private int height;
    private int width;
    private int depth;

    public Item(){}

    public Item( String reference, int floor, int corridor, int rack, int quantity, int width, int height, int depth ){
        this.reference = reference;
        this.floor = floor;
        this.rack = rack;
        this.corridor = corridor;
        this.quantity = quantity;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    @XmlAttribute(name="product_ref")
    @XmlID
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @XmlElement(name="floor")
    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @XmlElement(name="rack")
    public int getRack() {
        return rack;
    }

    public void setRack(int rack) {
        this.rack = rack;
    }

    @XmlElement(name="corridor")
    public int getCorridor() {
        return corridor;
    }

    public void setCorridor(int corridor) {
        this.corridor = corridor;
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
