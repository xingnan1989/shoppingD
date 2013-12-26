package com.fendou.individuality.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fendou.individuality.dao.IndividualityDao;
import com.fendou.individuality.po.Favorits;
import com.fendou.order.po.Goods;
import com.fendou.system.db.Database;
public class IndividualityImpl implements IndividualityDao{
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet r=null;
	Database db=new Database();
	public Goods selectGoods(long goodsID){
		String sql="select * from T_Goods where GoodsID="+goodsID;
		r=db.getexecuteR_Ps(sql);
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
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		
		return goods;
	}
	
	public void insertFavorits(long goodsID,long memberID){
		String sql="insert into T_Favorits values(null,"+memberID+","+goodsID+",now())";
		ps=db.getexecutePs(sql);
		try {
			int a=ps.executeUpdate();
			if(a<=0){
				System.out.println("插入失败！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecutePs(ps);
		}
	}
	
	public ArrayList<Favorits> selectFavoritsToMemberID(long memberID){
		String sql="select GoodsID from T_Favorits where MemberID="+memberID;
		r=db.getexecuteR_Ps(sql);
		ArrayList<Favorits> fal=new ArrayList();
		Favorits f=null;
		try {
			while(r.next()){
				f=new Favorits();
				f.setGoodsID(r.getLong("GoodsID"));
				fal.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecutePs(ps);
		}
		return fal;
	}
	
	public ArrayList<Favorits> selectFavorits(long memberID){
		String sql="select * from T_Favorits where MemberID="+memberID;
		r=db.getexecuteR_Ps(sql);
		ArrayList<Favorits> fal=new ArrayList();
		Favorits f=null;
		try {
			while(r.next()){
				f=new Favorits();
				f.setID(r.getLong("ID"));
				f.setGoodsID(r.getLong("GoodsID"));
				f.setMemberID(r.getLong("MemberID"));
				f.setAddtime(r.getString("Addtime"));
				fal.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecutePs(ps);
		}
		return fal;
	}
	
	public void deleteFavorits(long goodsID){
		String sql="delete from T_Favorits where GoodsID="+goodsID;
		ps=db.getexecutePs(sql);
		try {
			int a=ps.executeUpdate();
			if(a<=0){
				System.out.println("删除失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecutePs(ps);
		}
	}
}
