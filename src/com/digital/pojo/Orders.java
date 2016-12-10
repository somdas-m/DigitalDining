package com.digital.pojo;

import java.util.Date;
import java.util.List;

public class Orders {
	private String tableNo;
	private List<Item> orders;
	private boolean paymentStatus;
	private Date orderedTime;
	private float amount;
	
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getTableNo() {
		return tableNo;
	}
	public void setTableNo(String tableNo) {
		this.tableNo = tableNo;
	}
	public List<Item> getOrders() {
		return orders;
	}
	public void setOrders(List<Item> orders) {
		this.orders = orders;
	}
	public boolean isPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Date getOrderedTime() {
		return orderedTime;
	}
	public void setOrderedTime(Date orderedTime) {
		this.orderedTime = orderedTime;
	}
	

}
