package com.fendou.goods.po;

import java.io.Serializable;

public class T_Goods implements Serializable{
	private long goodsID;//商品ID
	private String goodsName;//商品名称
	private String goodsIntroduce;//商品描述
	private double goodsNormalPrice;//市场价格
	private double goodsMemberPrice;//商城价格
	private float goodsRebate;//折扣率
	private String typeCode;//小类编号
	private String typeName;//小类名称
	private String superTypeCode;//大类编号
	private String superTypeName;//大类名称
	private int goodsNumber;//商品数量
	private int goodsGrade;//商品等级
	private String isSale;//是否特价
	private String isValid;//是否有效
	private String goodsPicture;//商品图片
	private String creater;//创建者
	private String createDate;//创建时间
	private String updater;//修改者
	private String updateDate;//修改时间
	private int buyCount;//购买次数
	private int buyGoodsNumber;//商品被购买数量
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
		return buyGoodsNumber;
	}
	public void setBuyGoodsNumber(int buyGoodsNumber) {
		this.buyGoodsNumber = buyGoodsNumber;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getSuperTypeCode() {
		return superTypeCode;
	}
	public void setSuperTypeCode(String superTypeCode) {
		this.superTypeCode = superTypeCode;
	}
	public String getSuperTypeName() {
		return superTypeName;
	}
	public void setSuperTypeName(String superTypeName) {
		this.superTypeName = superTypeName;
	}
	
	
	

}
