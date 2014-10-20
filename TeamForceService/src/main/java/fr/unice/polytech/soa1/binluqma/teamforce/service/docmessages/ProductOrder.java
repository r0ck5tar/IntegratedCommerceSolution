package fr.unice.polytech.soa1.binluqma.teamforce.service.docmessages;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Hakim on 08/10/14.
 */
@XmlType
public class ProductOrder {
    private String id;
    private int quantity;

    @XmlElement(name = "productid")
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    @XmlElement(name = "quantity"                                                                                                                      )
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
