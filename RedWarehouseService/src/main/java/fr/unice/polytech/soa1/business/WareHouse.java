package fr.unice.polytech.soa1.business;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by user on 05/10/14.
 */

@XmlType
@XmlRootElement(name = "warehouse")
public class WareHouse {
    private String address;
    private String zip;
    private String city;
    private String id;
    private String location;

    public WareHouse(){}

    public WareHouse(String address, String zip, String city, String id, String location) {
        this.address = address;
        this.zip = zip;
        this.city = city;
        this.id = id;
        this.location = location;
    }

    @XmlElement(name="address")
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @XmlElement(name="zip")
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }

    @XmlElement(name="city")
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @XmlElement(name="id")
    @XmlID
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name="location")
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
