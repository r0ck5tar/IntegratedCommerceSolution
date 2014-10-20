package fr.unice.polytech.soa1.binluqma.teamforce.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hakim on 05/10/14.
 */
public interface PrivateService {
    @Path("/orders")
    @GET
    public Response viewOrders();

    @Path("/orders/{id}")
    @GET
    public Response findOrderById();

    @Path("/customers")
    @GET
    public Response viewCustomers();

    @Path("/customers/{id}")
    @GET
    public Response findCustomerById(@PathParam("id") int id);

    @Path("/customers/{first}/{last}")
    @GET
    public Response findCustomerByName(@PathParam("first") String firstName, @PathParam("last") String lastName);

    @Path("/customers/{id}")
    @PUT
    public Response updateCustomer(@PathParam("id") int id);

    @Path("/orders/{orderid}")
    @PUT
    public Response updateOrder(@PathParam("orderid") int orderId);

    @Path("/customers/{id}")
    @DELETE
    public Response deleteCustomer(@PathParam("id") int id);

    @Path("/orders/{orderid}")
    @DELETE
    public Response deleteOrder(@PathParam("orderid") int orderId);

    @Path("/suggestions")
    @GET
    public Response getAllProductSuggestions();

    @Path("/suggestions/{id}")
    @GET
    public Response getProductSuggestionsForCustomer(@PathParam("id") int id);
}

@XmlRootElement(name = "listofsuggestions")
class ListOfSuggestedProducts {
    private List<SuggestedProducts> suggestedProducts;

    public ListOfSuggestedProducts() {
        suggestedProducts = new ArrayList<>();
    }

    @XmlElement(name = "suggestedproducts")
    public List<SuggestedProducts> getSuggestedProducts() { return suggestedProducts; }
    public void setSuggestedProducts(List<SuggestedProducts> suggestedProducts) { this.suggestedProducts = suggestedProducts; }
}

@XmlRootElement(name = "suggestions")
class SuggestedProducts {
    private int customerId;
    private String customerName;
    private List<ProductInfo> products;

    public SuggestedProducts() {
        products = new ArrayList<>();
    }

    @XmlElement(name = "customerId")
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    @XmlElement(name = "customerName")
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    @XmlElement(name = "products")
    public List<ProductInfo> getProducts() { return products; }
    public void setProducts(List<ProductInfo> products) { this.products = products; }
}
