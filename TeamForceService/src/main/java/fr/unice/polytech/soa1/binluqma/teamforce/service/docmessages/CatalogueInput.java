package fr.unice.polytech.soa1.binluqma.teamforce.service.docmessages;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by Hakim on 07/10/14.
 */
@XmlType
public class CatalogueInput{
    private String name;
    private List<RecommendedProductInfo> products;

    public CatalogueInput() {}

    @XmlElement(name = "name", required = true)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @XmlElement(name = "products", required = false)
    public List<RecommendedProductInfo> getProducts() { return products; }
    public void setProducts(List<RecommendedProductInfo> products) { this.products = products; }
}
