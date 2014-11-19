package fr.polytech.unice.soa1.misterDiscount.business;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlType(name="simple_order")
public class SimpleOrder {
	/**
	 * 
	 */
	private String customerId;
	private List<ItemQuantity> itemquantity;
	
	public SimpleOrder() { }
	
	@XmlElement(name = "customerId")
	public String getCustormerId() {
		return customerId;
	}
	public void setCustormerId(String custormerId) {
		this.customerId = custormerId;
	}
	
	@XmlElement(name = "listItemQuantity")
	public List<ItemQuantity> getItemquantity() {
		return itemquantity;
	}
	public void setItemquantity(List<ItemQuantity> itemquantity) {
		this.itemquantity = itemquantity;
	} 
	
	

}
