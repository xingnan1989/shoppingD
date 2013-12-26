package com.fendou.order.po;

import java.io.Serializable;


public class ShopCarAdd implements Serializable{
	private Goods goods;
	private int num;
	public ShopCarAdd(){
		
	}
	public ShopCarAdd(Goods goods,int num){
		this.goods=goods;
		this.num=num;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	
}
