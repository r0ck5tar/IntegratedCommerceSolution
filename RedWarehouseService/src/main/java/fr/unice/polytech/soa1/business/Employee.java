package fr.unice.polytech.soa1.business;

import javax.xml.bind.annotation.*;

/**
 * Created by user on 05/10/14.
 **/

@XmlType
@XmlRootElement(name = "employee")
public class Employee {
    private String firstName;
    private String lastName;
    private String id;

    public Employee(){}

    public Employee(String firstName, String lastName, String id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    @XmlElement(name="first_name")
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement(name="last_name")
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlAttribute(name="id")
    @XmlID
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
