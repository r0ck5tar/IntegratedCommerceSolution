package fr.unice.polytech.soa1.binluqma.teamforce.business;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hakim on 06/10/14.
 */
public class Order {
    private int orderId;
    //Map of product IDs to quantities
    private Map<String, Integer> productQuantities;
    private OrderStatus status;
    private Address deliveryAddress;

    public Order() { productQuantities = new HashMap<String, Integer>(); }

    public Map<String, Integer> getProductQuantities() {
        return productQuantities;
    }

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }

    public Address getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(Address deliveryAddress) { this.deliveryAddress = deliveryAddress; }
}
