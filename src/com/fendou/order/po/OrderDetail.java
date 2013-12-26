package com.fendou.order.po;

import java.io.Serializable;

public class OrderDetail implements Serializable{
	private long iD;//	详细订单ID	bigint
	private long orderID;//	订单ID	bigint
	private long goodsID;//商品ID	bigint
	private String goodsName;//	商品名称	Varchar(200)
	private double goodsPrice;//	商品价格	money
	private int goodsCount;//	商品数量	int
	public long getID() {
		return iD;
	}
	public void setID(long id) {
		iD = id;
	}
	public long getOrderID() {
		return orderID;
	}
	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}
	public long getGoodsID() {
		return goodsID;
	}
	public void setGoodsID(long goodsID) {
		this.goodsID = goodsID;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public int getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}
	

}
