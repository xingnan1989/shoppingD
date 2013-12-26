package com.fendou.order.po;

import java.io.Serializable;

public class OrderInvoice implements Serializable{
	private long invoiceID;//	发票ID	bigint
	private long orderID;//订单ID	bigint
	private String invoiceTitle;//发票标题Varchar(100)
	private String invoiceContent;//	发票内容	Varchar(150)
	private double invoiceAmount;//	金额	money
	public long getInvoiceID() {
		return invoiceID;
	}
	public void setInvoiceID(long invoiceID) {
		this.invoiceID = invoiceID;
	}
	public long getOrderID() {
		return orderID;
	}
	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}
	public String getInvoiceTitle() {
		return invoiceTitle;
	}
	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}
	public String getInvoiceContent() {
		return invoiceContent;
	}
	public void setInvoiceContent(String invoiceContent) {
		this.invoiceContent = invoiceContent;
	}
	public double getInvoiceAmount() {
		return invoiceAmount;
	}
	public void setInvoiceAmount(double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}
	
	
}
