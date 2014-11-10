package fr.polytech.unice.soa1.misterDiscount.business;

import javax.xml.bind.annotation.XmlElement;

public class Receipt {
	private String status;
	private Order order;

	@XmlElement(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@XmlElement(name = "Order")
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
