package com.fendou.order.po;

import java.io.Serializable;
import java.util.ArrayList;

public class OrderDetailArrayOrder implements Serializable{
	ArrayList<OrderDetail> odal=null;
	Order order=null;
	public ArrayList<OrderDetail> getOdal() {
		return odal;
	}
	public void setOdal(ArrayList<OrderDetail> odal) {
		this.odal = odal;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}

	
	
}
