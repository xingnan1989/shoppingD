package com.fendou.order.po;

import java.io.Serializable;

public class GoodsNumber implements Serializable{
	private String goodsID;
	private int goodsNumber;
	private int buyGoodsNumber;
	public String getGoodsID() {
		return goodsID;
	}
	public void setGoodsID(String goodsID) {
		this.goodsID = goodsID;
	}
	public int getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	public int getBuyGoodsNumber() {
		return buyGoodsNumber;
	}
	public void setBuyGoodsNumber(int buyGoodsNumber) {
		this.buyGoodsNumber = buyGoodsNumber;
	}

	
}
