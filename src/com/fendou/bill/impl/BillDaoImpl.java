package com.fendou.bill.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.fendou.bill.dao.BillDao;
import com.fendou.bill.po.T_Bill;
import com.fendou.goods.po.T_GoodsType;
import com.fendou.pagination.po.Pagination;
import com.fendou.system.db.Database;


public class BillDaoImpl implements BillDao {
	private PreparedStatement ps;
	private ResultSet rs;
	ArrayList al;
	Database db = new Database();
	public int insert(T_Bill bill) {
		int count = 0;
		String sql="insert into T_Bill values(null,'"+bill.getBillPicPath()+"',now(),'"+bill.getBillOrder()+"','"+bill.getBillStatus()+"','"+bill.getBillCreateUser()+"')";
		ps = db.getexecutePs(sql);
		try {
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeexecutePs(ps);
		}
		return count;
	}
	public ArrayList select(Pagination page) {
		al = new ArrayList();
		String sql = "select * from T_Bill order by BillId desc limit "+(page.getCurrentPage()-1)*page.getCurrentPageRecord()+","+page.getCurrentPageRecord()+"";
		rs = db.getexecuteR_Ps(sql);
		try {
			while(rs.next()) {
				T_Bill bill = new T_Bill();
				bill.setBillId(rs.getInt("BillId"));
				bill.setBillAddTime(rs.getString("BillAddTime"));
				bill.setBillStatus(rs.getString("BillStatus"));
				bill.setBillPicPath(rs.getString("BillPicPath"));
				bill.setBillOrder(rs.getInt("BillOrder"));
				bill.setBillCreateUser(rs.getString("BillCreateUser"));
				al.add(bill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return al;
	}
	public int getTotalRecord() {
		String sql = "select count(*) as num from T_Bill";
		rs = db.getexecuteR_Ps(sql);
		int totalRecord = 0;
		try {
			rs.next();
			totalRecord = rs.getInt("num");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return totalRecord;
	}
	public int delete(T_Bill bill) {
		int count = 0;
		String sql = "delete from T_Bill where BillId='"+bill.getBillId()+"'";
		ps = db.getexecutePs(sql);
		try {
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeexecutePs(ps);
		}
		return count;
	}
	public T_Bill selectOne(T_Bill bill) {
		String sql = "select * from T_Bill where BillId='"+bill.getBillId()+"'";
		rs = db.getexecuteR_Ps(sql);
		try {
			while(rs.next()) {
				bill.setBillId(rs.getInt("BillId"));
				bill.setBillAddTime(rs.getString("BillAddTime"));
				bill.setBillStatus(rs.getString("BillStatus"));
				bill.setBillPicPath(rs.getString("BillPicPath"));
				bill.setBillOrder(rs.getInt("BillOrder"));
				bill.setBillCreateUser(rs.getString("BillCreateUser"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return bill;
	}
	public int update(T_Bill bill) {
		String sql = "update T_Bill set BillPicPath='"+bill.getBillPicPath()+"',BillAddTime=now(),BillOrder='"+bill.getBillOrder()+"',BillStatus='"+bill.getBillStatus()+"',BillCreateUser='"+bill.getBillCreateUser()+"' where BillId='"+bill.getBillId()+"'";
		int count = 0;
		ps = db.getexecutePs(sql);
		try {
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecutePs(ps);
		}
		return count;
	}
	public int updateThree(T_Bill bill) {
		String sql = "update T_Bill set BillAddTime=now(),BillOrder='"+bill.getBillOrder()+"',BillStatus='"+bill.getBillStatus()+"',BillCreateUser='"+bill.getBillCreateUser()+"' where BillId='"+bill.getBillId()+"'";
		int count = 0;
		ps = db.getexecutePs(sql);
		try {
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecutePs(ps);
		}
		return count;
	}
	//获得所有显示在前台的广告
	public ArrayList selectAdIndex(int count) {
		String sql = "select BillPicPath from T_Bill where BillStatus='y' order by BillOrder asc limit 0,"+count+"";
		rs = db.getexecuteR_Ps(sql);
		al = new ArrayList();
		try {
			while(rs.next()) {
				T_Bill bill = new T_Bill();
				bill.setBillPicPath(rs.getString("BillPicPath"));
				al.add(bill);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}
	//获得所有广告信息
	public ArrayList<T_Bill> selectBillOrder() {
		String sql = "select * from T_Bill";
		rs = db.getexecuteR_Ps(sql);
		al = new ArrayList();
		try {
			while(rs.next()) {
				T_Bill bill=new T_Bill();
				bill.setBillId(rs.getInt("billId"));
				bill.setBillOrder(rs.getInt("BillOrder"));
				al.add(bill);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}
	//修改广告信息的排序，向下移动
	public int updateBillOrder(int billId ) {
		String sql = "update T_Bill set BillOrder=BillOrder+1 where BillId="+billId+"";
		ps = db.getexecutePs(sql);
		int count = 0;
		try {
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	//修改前台广告显示的排序情况，向上移动一位
	public int updateBillOrder1(int billId) {
		String sql = "update T_Bill set BillOrder=BillOrder-1 where BillId="+billId+"";
		ps = db.getexecutePs(sql);
		int count = 0;
		try {
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	//取消向下移动
	public int updateBillOrderBack(int billId) {
		String sql = "update T_Bill set BillOrder=BillOrder-1 where BillId="+billId ;
		ps = db.getexecutePs(sql);
		int count = 0;
		try {
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	//取消向上移动
	public int updateBillOrderBack1(int billId) {
		String sql = "update T_Bill set BillOrder=BillOrder+1 where BillId="+billId;
		ps = db.getexecutePs(sql);
		int count = 0;
		try {
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}
