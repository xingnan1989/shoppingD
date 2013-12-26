/*
 * 会员收藏列表
 */
package com.fendou.individuality.dao;

import java.util.ArrayList;

import com.fendou.individuality.po.Favorits;
import com.fendou.order.po.Goods;

public interface IndividualityDao {
	public Goods selectGoods(long goodsID);//根据商品ID号获得该商品对象
	public void insertFavorits(long goodsID,long memberID);//将该商品插入我的收藏里
	public ArrayList<Favorits> selectFavoritsToMemberID(long memberID);//根据会员ID号查找所有收藏商品ID列表
	public ArrayList<Favorits> selectFavorits(long memberID);//根据会员ID号所有收藏商品列表
	public void deleteFavorits(long goodsID);//删除收藏
}
