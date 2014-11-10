package fr.polytech.unice.soa1.misterDiscount.business;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="itemQuantity")
public class ItemQuantity {
	private String productId;
	private int quantity;
	
	@XmlElement(name = "productId")
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	@XmlElement(name = "quantity")
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
