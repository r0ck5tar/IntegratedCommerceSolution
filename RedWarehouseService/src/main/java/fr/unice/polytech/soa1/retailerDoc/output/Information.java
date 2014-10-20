package fr.unice.polytech.soa1.retailerDoc.output;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by user on 08/10/14.
 */
@XmlType(name="information")
public class Information extends JobResult{
    private String data;

    public Information(){}
    public Information(String data){this.data=data;}

    @XmlElement(name = "info")
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
}
