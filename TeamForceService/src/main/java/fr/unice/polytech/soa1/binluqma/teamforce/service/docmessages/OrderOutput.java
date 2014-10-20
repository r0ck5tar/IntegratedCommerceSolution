package fr.unice.polytech.soa1.binluqma.teamforce.service.docmessages;

import fr.unice.polytech.soa1.binluqma.teamforce.business.OrderStatus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hakim on 08/10/14.
 */
@XmlType(name = "orderresult")
public class OrderOutput {
    private List<RecommendedProductInfo> recommendedProducts;
    private OrderStatus orderStatus;

    public OrderOutput() {
        this.recommendedProducts = new ArrayList<>();
    }

    @XmlElement(name = "recommendations")
    public List<RecommendedProductInfo> getRecommendedProducts() { return recommendedProducts; }
    public void setRecommendedProducts(List<RecommendedProductInfo> recommendedProducts) { this.recommendedProducts = recommendedProducts; }

    @XmlElement(name = "orderstatus")
    public OrderStatus getOrderStatus() { return orderStatus; }
    public void setOrderStatus(OrderStatus orderStatus) { this.orderStatus = orderStatus; }
}
