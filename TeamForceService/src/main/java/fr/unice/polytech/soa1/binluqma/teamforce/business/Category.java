package fr.unice.polytech.soa1.binluqma.teamforce.business;

import java.util.List;

/**
 * Created by Hakim on 18/10/14.
 */
public class Category {
    public List<Product> products;

    public Category() { }

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }
}
