package com.pojo;

public class orderlist {
	
	private String orderid;
	
	private String cost;
	
	private String statusid;
	
	private String name;

	private String paywayid;
	
	private String paystyle;
	
	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;		
	}
	
	public String getStatusid() {
		return statusid;
	}

	public void setStatusid(String statusid) {
		this.statusid= statusid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name= name;
	}
	
	public String getPaywayid() {
		return paywayid;
	}

	public void setPaywayid(String paywayid) {
		this.paywayid= paywayid;
	}
	
	
	
	public String getPaystyle() {
		return paystyle;
	}

	public void setPaystyle(String paystyle) {
		this.paystyle= paystyle;
	}
}
