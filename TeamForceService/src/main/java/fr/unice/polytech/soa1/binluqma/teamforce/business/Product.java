package fr.unice.polytech.soa1.binluqma.teamforce.business;


/**
 * Created by Hakim on 06/10/14.
 */
public class Product {
    private String id;
    private float price;

    public Product() {}

    public Product(String id, float price) {
        this.id = id;
        this.price = price;
    }

    public String getId() { return id; }
    public void setId() { this.id = id; }

    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }
}
