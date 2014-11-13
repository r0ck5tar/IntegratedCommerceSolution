package fr.polytech.unice.soa1.misterDiscount.business;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="receipt")
public class Receipt {
	private String status;
	private SimpleOrder order;
	private String trackingNumber;
	private Date date;
	
	public Receipt(){}
	
	public Receipt(String status, SimpleOrder order, String trackingNumber, Date date){
		this.status = status;
		this.order = order;
		this.setTrackingNumber(trackingNumber);
		this.setDate(date);
	}

	@XmlElement(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@XmlElement(name = "order")
	public SimpleOrder getOrder() {
		return order;
	}

	public void setOrder(SimpleOrder order) {
		this.order = order;
	}

	@XmlElement(name = "trackingNumber")
	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	@XmlElement(name = "date")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
