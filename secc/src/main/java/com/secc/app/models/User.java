package com.secc.app.models;

public class User {
	private int id;
	private String name;
	private long phone;
	private String deliveryAddress;
	private String upi;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getUpi() {
		return upi;
	}
	public void setUpi(String upi) {
		this.upi = upi;
	}

}
