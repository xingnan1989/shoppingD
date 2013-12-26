package com.fendou.statistic.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fendou.statistic.dao.StatisticDao;
import com.fendou.statistic.po.Goods;
import com.fendou.system.db.Database;

public class StatisticDaoImpl implements StatisticDao{
	private ResultSet r=null;
	private Connection conn=null;
	private PreparedStatement ps=null;
	Database db=new Database();
	public ArrayList<Goods> selectGoodsStatistic(){
		String sql="select * from T_Goods order by BuyGoodsNumber desc limit 0,10";
		r=db.getexecuteR_Ps(sql);
		ArrayList<Goods> gdal=new ArrayList();
		Goods goods=null;
		try {
			while(r.next()){
				goods=new Goods();		
				goods.setGoodsID(r.getLong("GoodsID"));
				goods.setGoodsName(r.getString("GoodsName"));
				//goods.setGoodsIntroduce(r.getString("GoodsIntroduce"));
				goods.setGoodsNormalPrice(r.getDouble("GoodsNormalPrice"));
				goods.setGoodsMemberPrice(r.getDouble("GoodsMemberPrice"));
				goods.setGoodsRebate(r.getFloat("GoodsRebate"));
				goods.setTypeCode(r.getString("TypeCode"));
				goods.setGoodsNumber(r.getInt("GoodsNumber"));
				goods.setGoodsGrade(r.getInt("GoodsGrade"));
				goods.setIsSale(r.getString("isSale"));
				goods.setIsValid(r.getString("isValid"));
				goods.setGoodsPicture(r.getString("GoodsPicture"));
				goods.setCreater(r.getString("Creater"));
				goods.setCreateDate(r.getString("CreateDate"));
				goods.setUpdater(r.getString("Updater"));
				goods.setUpdateDate(r.getString("UpdateDate"));
				goods.setBuyCount(r.getInt("BuyCount"));
				goods.setBuyGoodsNumber(r.getInt("BuyGoodsNumber"));
				gdal.add(goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return gdal;
	}
	
	public Goods selectGoodstoID(Long goodsID){
		Goods goods=null;
		String sql="select * from T_Goods where GoodsID="+goodsID;
		r=db.getexecuteR_Ps(sql);
		try {
			if(r.next()){
				goods=new Goods();		
				goods.setGoodsID(r.getLong("GoodsID"));
				goods.setGoodsName(r.getString("GoodsName"));
				goods.setGoodsIntroduce(r.getString("GoodsIntroduce"));
				goods.setGoodsNormalPrice(r.getDouble("GoodsNormalPrice"));
				goods.setGoodsMemberPrice(r.getDouble("GoodsMemberPrice"));
				goods.setGoodsRebate(r.getFloat("GoodsRebate"));
				goods.setTypeCode(r.getString("TypeCode"));
				goods.setGoodsNumber(r.getInt("GoodsNumber"));
				goods.setGoodsGrade(r.getInt("GoodsGrade"));
				goods.setIsSale(r.getString("isSale"));
				goods.setIsValid(r.getString("isValid"));
				goods.setGoodsPicture(r.getString("GoodsPicture"));
				goods.setCreater(r.getString("Creater"));
				goods.setCreateDate(r.getString("CreateDate"));
				goods.setUpdater(r.getString("Updater"));
				goods.setUpdateDate(r.getString("UpdateDate"));
				goods.setBuyCount(r.getInt("BuyCount"));
				goods.setBuyGoodsNumber(r.getInt("BuyGoodsNumber"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return goods;
	}
}
