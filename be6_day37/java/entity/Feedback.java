package entity;

import java.sql.Date;

public class Feedback {
	Date date;
	Long customerId;
	String productName;
	String feedback;
	
	public Feedback(Date date, Long customerId, String productName, String feedback) {
		super();
		this.date = date;
		this.customerId = customerId;
		this.productName = productName;
		this.feedback = feedback;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	
	
	
}