package com.fendou.system.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//import sun.jdbc.odbc.ee.DataSource;
//import javax.sql.DataSource;

public class Database {
	private Connection conn=null;
	private PreparedStatement ps;
	private ResultSet r;
	public Connection getConn(){
		try {
			Context ct=new InitialContext();
			DataSource ds=(DataSource)ct.lookup("java:comp/env/jdbc/mysql");
			conn = ds.getConnection();
			if(conn!=null){
//				System.out.println("23232");
			}else{System.out.println("ssss");}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeConn(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
/**********************************************************************************/	
	public PreparedStatement getPs(String sql,Connection conn){
		try {
			ps=conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}
	
	public void closePs(PreparedStatement ps){
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
/**********************************************************************************/
	public PreparedStatement getPs(String sql,Connection conn,Object...objs) {
		try {
			ps = conn.prepareStatement(sql);
			for(int i=0;i<objs.length;i++) {
				ps.setObject(i+1,objs[i]);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return ps;
	}
	
	
/**********************************************************************************/
	public ResultSet getR(PreparedStatement ps){
		try {
			r=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	
	public void closeR(ResultSet r){
		if(r != null){
			try {
				r.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
/**********************************************************************************/
	//返回结果集
	public ResultSet getexecuteR_Ps(String sql){
		conn=getConn();
		ps=getPs(sql,conn);
		r=getR(ps);
		return r;
	}
	
	public void closeexecuteR_Ps(ResultSet r){
		if(r != null){
			closeR(r);
			closePs(ps);
			closeConn(conn);
		}
	}

/**********************************************************************************/
	//数据库预处理
	public PreparedStatement getexecutePs(String sql){
		conn=getConn();
		ps = getPs(sql,conn);
		return ps;
	}
	public void closeexecutePs(PreparedStatement ps){
		if(ps != null){
			closePs(ps);
			closeConn(conn);
		}
	}

}




