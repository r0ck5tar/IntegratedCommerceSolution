package fr.unice.polytech.soa1.binluqma.teamforce.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hakim on 19/10/14.
 */
public interface CustomerService {
    @Path("/customers/{id}")
    @GET
    public Response viewCustomer(@PathParam("id") int id);

    @Path("/customers/")
    @POST
    public Response createCustomer();

    @Path("/customers/{id}")
    @PUT
    public Response updateCustomer();

    @Path("/customers/{id}")
    @DELETE
    public Response deleteCustomer(@PathParam("id") int id);
}
@XmlRootElement(name = "customer")
class CustomerInfo {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private List<AddressInfo> addresses;
    private ListOfOrders orders;

    public CustomerInfo() {
        addresses = new ArrayList<>();
    }

    public CustomerInfo(int id, String firstName, String lastName, String email, String phone) {
        this();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    @XmlElement(name = "id")
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @XmlElement(name = "firstname")
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    @XmlElement(name = "lastname")
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    @XmlElement(name = "email")
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @XmlElement(name = "phone")
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @XmlElement(name = "orders")
    public ListOfOrders getOrders() { return orders; }
    public void setOrders(ListOfOrders orders) { this.orders = orders; }

    @XmlElement(name = "address")
    public List<AddressInfo> getAddresses() { return addresses; }
    public void setAddresses(List<AddressInfo> addresses) { this.addresses = addresses; }
}
