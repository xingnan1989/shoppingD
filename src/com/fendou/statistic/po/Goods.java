package com.fendou.statistic.po;

import java.io.Serializable;

public class Goods implements Serializable{

	private long goodsID;
	private String goodsName;
	private String goodsIntroduce;
	private double goodsNormalPrice;
	private double goodsMemberPrice;
	private float goodsRebate;
	private String typeCode;
	private int goodsNumber;
	private int goodsGrade;
	private String isSale;
	private String isValid;
	private String goodsPicture;
	private String creater;
	private String createDate;
	private String updater;
	private String updateDate;
	private int buyCount;
	private int BuyGoodsNumber;
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
	public String getGoodsIntroduce() {
		return goodsIntroduce;
	}
	public void setGoodsIntroduce(String goodsIntroduce) {
		this.goodsIntroduce = goodsIntroduce;
	}
	public double getGoodsNormalPrice() {
		return goodsNormalPrice;
	}
	public void setGoodsNormalPrice(double goodsNormalPrice) {
		this.goodsNormalPrice = goodsNormalPrice;
	}
	public double getGoodsMemberPrice() {
		return goodsMemberPrice;
	}
	public void setGoodsMemberPrice(double goodsMemberPrice) {
		this.goodsMemberPrice = goodsMemberPrice;
	}
	public float getGoodsRebate() {
		return goodsRebate;
	}
	public void setGoodsRebate(float goodsRebate) {
		this.goodsRebate = goodsRebate;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public int getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	public int getGoodsGrade() {
		return goodsGrade;
	}
	public void setGoodsGrade(int goodsGrade) {
		this.goodsGrade = goodsGrade;
	}
	public String getIsSale() {
		return isSale;
	}
	public void setIsSale(String isSale) {
		this.isSale = isSale;
	}
	public String getIsValid() {
		return isValid;
	}
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	public String getGoodsPicture() {
		return goodsPicture;
	}
	public void setGoodsPicture(String goodsPicture) {
		this.goodsPicture = goodsPicture;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public int getBuyCount() {
		return buyCount;
	}
	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}
	public int getBuyGoodsNumber() {
		return BuyGoodsNumber;
	}
	public void setBuyGoodsNumber(int buyGoodsNumber) {
		BuyGoodsNumber = buyGoodsNumber;
	}
	
	
}
