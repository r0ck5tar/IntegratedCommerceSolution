package fr.unice.polytech.soa1.business;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by user on 02/10/14.
 */

@XmlType
@XmlRootElement(name = "retailer")
public class Retailer {
    private String id;

    @XmlElement(name="id")
    @XmlID
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
