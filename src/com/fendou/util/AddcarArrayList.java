package com.fendou.util;

import java.util.ArrayList;

import com.fendou.order.po.Goods;
import com.fendou.order.po.ShopCarAdd;

public class AddcarArrayList {
	private ArrayList car;

	public ArrayList getCar() {
		return car;
	}

	public void setCar(ArrayList car) {
		this.car = car;
	}
	public ArrayList addcar(Goods goods,int num){
		if(car==null){
			car=new ArrayList();
			ShopCarAdd sca=new ShopCarAdd(goods,num);
			car.add(sca);
		}else{
			boolean falg=false;
			for(int i=0;i<car.size();i++){
				ShopCarAdd sca=(ShopCarAdd)car.get(i);
				if(sca.getGoods().getGoodsID()==goods.getGoodsID()){
					sca.setNum(sca.getNum()+num);
					falg=true;
					break;
				}
			}
			if(falg==false){
				ShopCarAdd sca=new ShopCarAdd(goods,num);
				car.add(sca);
			}
		}
		return car;
	}


}
