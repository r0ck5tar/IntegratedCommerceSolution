package fr.unice.polytech.soa1.binluqma.teamforce.service.docmessages;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/*
    For creating orders
 */

@XmlType(name = "recommendedproduct")
public class CatalogueProductInfo {
    private String id;
    private float price;

    @XmlElement(name = "id", required = true)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    @XmlElement(name = "price", required = false)
    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }
}