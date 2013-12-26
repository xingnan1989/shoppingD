package com.fendou.placard.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.fendou.pagination.po.Pagination;
import com.fendou.placard.dao.PlacardDao;
import com.fendou.placard.po.Placard;
import com.fendou.system.db.Database;

public class PlacardDaoImpl implements PlacardDao{
	private Connection conn=null;
	private ResultSet r=null;
	private PreparedStatement ps=null;
	Database db=new Database();
	public ArrayList<Placard> selectPlacard(){
		String sql="select * from T_Placard order by PlacardID desc";
		ArrayList<Placard> pdal=new ArrayList();
		Placard pd=null;
		r=db.getexecuteR_Ps(sql);
		try {
			while(r.next()){
				pd=new Placard();
				pd.setPlacardID(r.getLong("PlacardID"));
				pd.setPlacardTitle(r.getString("PlacardTitle"));
				pd.setPlacardContent(r.getString("PlacardContent"));
				pd.setIssueDate(r.getString("IssueDate"));
				pd.setExpireDate(r.getString("ExpireDate"));
				pd.setCreater(r.getString("Creater"));
				pd.setCreateDate(r.getString("CreateDate"));
				pd.setUpdater(r.getString("Updater"));
				pd.setUpdateDate(r.getString("UpdateDate"));
				pdal.add(pd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return pdal;
	}
	
	public void insertPlacard(Placard p){
		String sql="insert into T_Placard values(null,?,?,?,?,?,now(),?,now())";
		ps=db.getexecutePs(sql);
		try {
			ps.setString(1, p.getPlacardTitle());
			ps.setString(2, p.getPlacardContent());
			ps.setString(3, p.getIssueDate());
			ps.setString(4, p.getExpireDate());
			ps.setString(5, p.getCreater());
			ps.setString(6, p.getUpdater());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecutePs(ps);
		}
		
	}
	
	public void deletePlacard(long placardID){
		String sql="delete from T_Placard where PlacardID="+placardID;
		ps=db.getexecutePs(sql);
		try {
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecutePs(ps);
		}
	}
	
	public void updatePlacard(Placard placard){
		String sql="update T_Placard set PlacardTitle='"+placard.getPlacardTitle()+"',PlacardContent='"+
		placard.getPlacardContent()+"',IssueDate='"+placard.getIssueDate()+"',ExpireDate='"+placard.getExpireDate()+
		"',Updater='"+placard.getUpdater()+"',UpdateDate=now() where PlacardID="+placard.getPlacardID();
		ps=db.getexecutePs(sql);
		try {
			int a=ps.executeUpdate();
			if(a>0){
				//System.out.println("有"+a+"条语句被修改！");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Placard selectPlacardToID(long placardID){
		String sql="select * from T_Placard where PlacardID="+placardID;
		r=db.getexecuteR_Ps(sql);
		Placard p=new Placard();
		try {
			while(r.next()){
				p.setPlacardID(r.getLong("PlacardID"));
				p.setPlacardTitle(r.getString("PlacardTitle"));
				p.setPlacardContent(r.getString("PlacardContent"));
				p.setIssueDate(r.getString("IssueDate"));
				p.setExpireDate(r.getString("ExpireDate"));
				p.setCreater(r.getString("Creater"));
				p.setCreateDate(r.getString("CreateDate"));
				p.setUpdater(r.getString("Updater"));
				p.setUpdateDate(r.getString("UpdateDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return p;
	}
	
	public ArrayList<Placard> selectPlacardShow(){
		SimpleDateFormat  dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String dateNowStr=dateFormat.format(new Date());
		String sql="select * from T_Placard where IssueDate <='"+dateNowStr+"' and ExpireDate>='"+dateNowStr+"'";
		r=db.getexecuteR_Ps(sql);
		ArrayList<Placard> pdal=new ArrayList();
		Placard pd=null;
		try {
			while(r.next()){
				pd=new Placard();
				pd.setPlacardID(r.getLong("PlacardID"));
				pd.setPlacardTitle(r.getString("PlacardTitle"));
				pd.setPlacardContent(r.getString("PlacardContent"));
				pd.setIssueDate(r.getString("IssueDate"));
				pd.setExpireDate(r.getString("ExpireDate"));
				pd.setCreater(r.getString("Creater"));
				pd.setCreateDate(r.getString("CreateDate"));
				pd.setUpdater(r.getString("Updater"));
				pd.setUpdateDate(r.getString("UpdateDate"));
				pdal.add(pd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pdal;
	}
	
	public int selectPlacardCount(){
		String sql="select count(*) from T_Placard";
		r=db.getexecuteR_Ps(sql);
		int count=0;
		try {
			while(r.next()){
				count=r.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return count;
	}
	
	public ArrayList<Placard> selectPlacardPagination(Pagination page){
//		String sql="select top "+page.getCurrentPageRecord()+"* from T_Placard where PlacardID not in"+
//					"(select top "+(page.getCurrentPage()-1)*page.getCurrentPageRecord()+" PlacardID from T_Placard order by PlacardID desc)order by PlacardID desc";
		String sql="select * from T_Placard order by PlacardID desc limit "+(page.getCurrentPage()-1)*page.getCurrentPageRecord()+","+page.getCurrentPageRecord()+" ";

		//System.out.println(sql);
		ArrayList<Placard> pal=new ArrayList();
		Placard pd=null;
		r=db.getexecuteR_Ps(sql);
		try {
			while(r.next()){
				pd=new Placard();
				pd.setPlacardID(r.getLong("PlacardID"));
				pd.setPlacardTitle(r.getString("PlacardTitle"));
				pd.setPlacardContent(r.getString("PlacardContent"));
				pd.setIssueDate(r.getString("IssueDate"));
				pd.setExpireDate(r.getString("ExpireDate"));
				pd.setCreater(r.getString("Creater"));
				pd.setCreateDate(r.getString("CreateDate"));
				pd.setUpdater(r.getString("Updater"));
				pd.setUpdateDate(r.getString("UpdateDate"));
				pal.add(pd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return pal;
	}
}
