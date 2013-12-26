package com.fendou.statistic.dao;

import java.util.ArrayList;

import com.fendou.statistic.po.Goods;

public interface StatisticDao {
	public ArrayList<Goods> selectGoodsStatistic();//已经购买的商品列表
	public Goods selectGoodstoID(Long goodsID);

}
