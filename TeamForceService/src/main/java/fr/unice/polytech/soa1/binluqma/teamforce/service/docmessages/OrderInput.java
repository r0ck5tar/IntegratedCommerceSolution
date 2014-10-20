package fr.unice.polytech.soa1.binluqma.teamforce.service.docmessages;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hakim on 08/10/14.
 */
@XmlType
public class OrderInput {
    private int customerId;
    private List<ProductOrder> productOrders;

    public OrderInput() {
        productOrders = new ArrayList<>();
    }

    @XmlElement(name = "customerid", required = true)
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    @XmlElement(name = "product", required = true)
    public List<ProductOrder> getProductOrders() { return productOrders; }
    public void setProductOrders(List<ProductOrder> productOrders) { this.productOrders = productOrders; }
}
