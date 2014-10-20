package fr.unice.polytech.soa1.binluqma.teamforce.service;

import fr.unice.polytech.soa1.binluqma.teamforce.business.OrderStatus;
import fr.unice.polytech.soa1.binluqma.teamforce.business.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hakim on 05/10/14.
 */
public interface OrderService {
    @Path("/catalogues")
    @GET
    public Response catalogues();

    @Path("/catalogues/{edition}")
    @GET
    public Response viewCatalogue(@PathParam("edition") String edition);

    @Path("/products")
    @GET
    public Response products();

    @Path("/products/{id}")
    @GET
    public Response viewProduct(@PathParam("id") String id);

    @Path("/customers/{id}/orders")
    @GET
    public Response viewCustomerOrders(@PathParam("id") int id);

    @Path("/customers/{id}/orders/{orderid}")
    @GET
    public Response viewCustomerOrder(@PathParam("id") int id, @PathParam("orderid") int orderId);

    @Path("/orders/{orderid}")
    @GET
    public Response viewOrder(@PathParam("orderid") int orderId);

    @Path("/customers/{id}/orders")
    @POST
    public Response createOrder();

    //Update order by adding or removing products, subject to order status
    @Path("/customers/{id}/orders/{orderid}")
    @PUT
    public Response updateOrder(@PathParam("id") int id, @PathParam("orderid") int orderId);

    @Path("customers/{id}/orders/{orderid}")
    @DELETE
    public Response deleteOrder(@PathParam("id") int id, @PathParam("orderid") int orderId);

}

@XmlRootElement(name = "catalogues")
class ListOfCatalogues {
    private List<String> catalogues;
    @XmlElement(name = "link")
    public List<String> getCatalogues() { return catalogues; }
    public void setCatalogues(List<String> catalogues) { this.catalogues = catalogues; }

    public ListOfCatalogues() { catalogues = new ArrayList<>(); }
}

@XmlRootElement(name = "products")
class ListOfProducts {
    private List<ProductInfo> products;
    @XmlElement(name = "product")
    public List<ProductInfo> getProducts() { return products; }
    public void setProducts(List<ProductInfo> products) { this.products = products; }

    public ListOfProducts() { products = new ArrayList<>(); }
}

@XmlRootElement(name = "product")
class ProductInfo {
    private String id;
    private float price;
    private String link;

    public ProductInfo() {}

    public ProductInfo(String id, float price) {
        this.id = id;
        this.price = price;
    }

    @XmlElement(name = "id")
    public String getId() { return id; }
    public void setId() { this.id = id; }

    @XmlElement(name = "price")
    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }

    @XmlElement(name = "link")
    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }
}

@XmlRootElement(name = "address")
class AddressInfo {
    private String line1;
    private String line2;
    private String zip;
    private String city;
    private String type;

    AddressInfo() { }

    AddressInfo(String line1, String line2, String zip, String city, String type) {
        this.line1 = line1;
        this.line2 = line2;
        this.zip = zip;
        this.city = city;
        this.type = type;
    }

    @XmlElement(name = "line1")
    public String getLine1() { return line1; }
    public void setLine1(String line1) { this.line1 = line1; }

    @XmlElement(name = "line2")
    public String getLine2() { return line2; }
    public void setLine2(String line2) { this.line2 = line2; }

    @XmlElement(name = "zip")
    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }

    @XmlElement(name = "city")
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    @XmlElement(name = "type")
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}

@XmlRootElement(name ="orders")
class ListOfOrders {
    //Links to order resources
    private List<String> orders;
    @XmlElement(name = "order")
    public List<String> getOrders() { return orders; }
    public void setOrders(List<String> orders) { this.orders = orders; }

    public ListOfOrders() { orders = new ArrayList<>();}
}

@XmlRootElement(name = "orders")
class FullListOfOrders {
    private List<OrderInfo> orders;
    @XmlElement(name = "order")
    public List<OrderInfo> getOrders() { return orders; }
    public void setOrders(List<OrderInfo> orders) { this.orders = orders; }

    public FullListOfOrders() { orders = new ArrayList<>(); }
}

@XmlRootElement(name = "orderinfo")
class OrderInfo {
    private int orderId;
    private List<ProductQuantity> productQuantities;
    private String link;
    private OrderStatus status;
    private AddressInfo deliveryAddress;

    @XmlElement(name = "id")
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    @XmlElement(name = "link")
    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }

    @XmlElement(name = "product")
    public List<ProductQuantity> getProductQuantities() { return productQuantities; }
    public void setProductQuantities(List<ProductQuantity> productQuantities) { this.productQuantities = productQuantities; }

    @XmlElement(name = "orderstatus")
    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }

    @XmlElement(name = "deliveryaddress")
    public AddressInfo getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(AddressInfo deliveryAddress) { this.deliveryAddress = deliveryAddress; }

    public OrderInfo() {
        productQuantities = new ArrayList<>();
    }

    OrderInfo(int orderId) {
        this();
        this.orderId = orderId;
    }
}

@XmlRootElement(name = "productquantity")
class ProductQuantity {
    private String productId;
    private int Quantity;
    private float totalPrice;
    private String link;

    @XmlElement(name = "id")
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    @XmlElement(name = "quantity")
    public int getQuantity() { return Quantity; }
    public void setQuantity(int quantity) { Quantity = quantity; }

    @XmlElement(name = "totalprice")
    public float getTotalPrice() { return totalPrice; }
    public void setTotalPrice(float totalPrice) { this.totalPrice = totalPrice; }

    @XmlElement(name = "link")
    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }

    public ProductQuantity() {}

    ProductQuantity(String productId, int quantity, float totalPrice) {
        this.productId = productId;
        Quantity = quantity;
        this.totalPrice = totalPrice;
    }
}
