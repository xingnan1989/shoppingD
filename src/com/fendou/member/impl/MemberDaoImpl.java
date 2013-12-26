package com.fendou.member.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fendou.member.po.*;

import com.fendou.member.dao.MemberDao;
import com.fendou.member.po.MemberAddressBook;
import com.fendou.system.db.Database;
import com.fendou.util.FPageBean;

public class MemberDaoImpl implements MemberDao {

	private Database db = null;
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	/* 添加用户信息*/
	public boolean addMember(Member member, MemberAddressBook memberAddressBook) {
		boolean flag = false;
		db = new Database();
		int num1 = 0, num2 = 0;

		conn = db.getConn();
		String sql = "insert into T_Member (MemberName,MemberPassword,MemberEmail,MemberStatus,CreateDate,UpdateDate)"
				+ "values (?,?,?,?,?,?)";
		//System.out.println("qqqqqqqqqqq");
		try {
			conn.setAutoCommit(false);
			ps = db.getPs(sql, conn);
			ps.setString(1, member.getMemberName());
			ps.setString(2, member.getMemberPassword());
			ps.setString(3, member.getMemberEmail());
			ps.setInt(4, 1);
			ps.setTimestamp(5, new Timestamp(new Date().getTime()));
			ps.setTimestamp(6, new Timestamp(new Date().getTime()));
			//ps.setString(7, member.getMemberTrueName());

			//  通过用户名查找用户基本信息，并获得MemberID
			long memberID = 0;
			num1 = ps.executeUpdate();
			ps.close();
			String sql1 = "select * from T_Member where MemberName='"
					+ member.getMemberName() + "'";

			ps = db.getPs(sql1, conn);
			rs = ps.executeQuery();
			//System.out.println("qqqqqqqqqqq");

			if (rs.next()) {
				memberID = rs.getLong("MemberID");
				//System.out.println(memberID);
				ps.close();
			}

			//通过T_MemberAddressBook查找用户其他信息
			String sql2 = "insert into  T_MemberAddressBook (MemberID,MemberTrueName,MemberAddress,"
					+ "ProvinceCode,CityCode,AreaCode,MemberPostcode,MemberTelephone,CreateDate,UpdateDate"
					+ ") values(?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql2);
			ps.setLong(1, memberID);
			ps.setString(2, memberAddressBook.getMemberTrueName());
			ps.setString(3, memberAddressBook.getMemberAddress());
			ps.setString(4, memberAddressBook.getProvinceCode());
			ps.setString(5, memberAddressBook.getCityCode());
			ps.setString(6, memberAddressBook.getAreaCode());
			ps.setString(7, memberAddressBook.getMemberPostcode());
			ps.setString(8, memberAddressBook.getMemberTelephone());
			ps.setTimestamp(9, new Timestamp(new Date().getTime()));
			ps.setTimestamp(10, new Timestamp(new Date().getTime()));
			num2 = ps.executeUpdate();

			if (num1 > 0 && num2 > 0) {
				conn.commit();
				conn.setAutoCommit(true);
				flag = true;
				//System.out.println("T_MemberAddressBook中的用户地址信息");
			} else {
				flag = false;
				System.out.println("没有该T_Member信息");
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeConn(conn);
			db.closePs(ps);
		}
		return flag;
	}

	/**
	 * 用户名验证
	 */
	public boolean validUsername(String memberName) {
		db = new Database();
		boolean flag = false;
		String sql = "select * from T_Member where MemberName='" + memberName
				+ "'";
		rs = db.getexecuteR_Ps(sql);
		try {
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;

	}

	/**
	 * 管理员登陆
	 */
	public Member userLogin(String memberName, String memberPassword) {
		Member member = null;
		db = new Database();
		String sql = "select * from T_Member where MemberName='" + memberName
				+ "' and MemberPassword='" + memberPassword + "'";
		try {
			rs = db.getexecuteR_Ps(sql);
			if (rs.next()) {
				member = new Member();
				member.setMemberID(rs.getLong("MemberID"));
				member.setMemberName(rs.getString("MemberName"));
				member.setMemberPassword(rs.getString("MemberPassword"));
				member.setMemberEmail(rs.getString("MemberEmail"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			db.closeexecuteR_Ps(rs);
		}
		return member;

	}

	/**
	 * 通过ID号依次查找用户信息
	 */
	public Member queryMember(long memberID) {
		Member member = null;
		db = new Database();
		String sql = "select * from T_Member where MemberID='" + memberID + "'";
		try {
			rs = db.getexecuteR_Ps(sql);
			if (rs.next()) {
				member = new Member();
				member.setMemberID(rs.getLong("MemberID"));
				member.setMemberName(rs.getString("MemberName"));
				member.setMemberPassword(rs.getString("MemberPassword"));
				member.setMemberEmail(rs.getString("MemberEmail"));
				member.setMemberGrade(rs.getInt("MemberGrade"));
				member.setMemberStatus(rs.getString("MemberStatus"));
				member.setCreateDate(rs.getTimestamp("CreateDate"));
				member.setUpdateDate(rs.getTimestamp("UpdateDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return member;
	}

	/**
	 * 查询用户地址信息ַ
	 */
	public MemberAddressBook queryMemberAddress(long memberID) {
		MemberAddressBook memberAddressBook = new MemberAddressBook();
		db = new Database();
		String sql = "select * from T_MemberAddressBook where MemberID='"
				+ memberID + "'";
		try {
			rs = db.getexecuteR_Ps(sql);
			if (rs.next()) {

				memberAddressBook.setId(rs.getLong("ID"));
				memberAddressBook.setMemberID(rs.getLong("MemberID"));
				memberAddressBook.setMemberTrueName(rs
						.getString("MemberTrueName"));
				memberAddressBook.setMemberAddress(rs
						.getString("MemberAddress"));
				memberAddressBook.setProvinceCode(rs.getString("ProvinceCode"));
				memberAddressBook.setCityCode(rs.getString("CityCode"));
				memberAddressBook.setAreaCode(rs.getString("AreaCode"));
				memberAddressBook.setMemberPostcode(rs
						.getString("MemberPostcode"));
				memberAddressBook.setMemberTelephone(rs
						.getString("MemberTelephone"));
				memberAddressBook.setCreateDate(rs.getTimestamp("CreateDate"));
				memberAddressBook.setUpdateDate(rs.getTimestamp("UpdateDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return memberAddressBook;
	}

	/**
	 * 通过用户名查询ID号
	 */
	public long queryMemberID(String memberName) {
		long memberID = 0;
		db = new Database();
		String sql = "select * from T_Member where MemberName='" + memberName
				+ "'";
		rs = db.getexecuteR_Ps(sql);
		try {
			if (rs.next()) {
				memberID = rs.getLong("MemberID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return memberID;
	}

	/**
	 * 验证用户名密码
	 */
	public boolean validMemberPassword(String memberName, String memberPassword) {
		db = new Database();
		boolean flag = false;
		String sql = "select * from T_Member where MemberName='" + memberName
				+ "' and MemberPassword='" + memberPassword + "'";
		rs = db.getexecuteR_Ps(sql);
		try {
			if (rs.next()) {
				flag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return flag;
	}

	/**
	 * 修改密码
	 */
	public boolean modifyMemberPassword(String memberName, String memberPassword) {
		boolean flag = false;
		db = new Database();
		conn = db.getConn();
		String sql = "update T_Member set MemberPassword='" + memberPassword
				+ "'where MemberName='" + memberName + "'";
		ps = db.getPs(sql, conn);
		try {
			ps.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return flag;
	}

	/**
	 * 修改用户地址信息
	 */
	public boolean modifyMemberAddress(MemberAddressBook memberAddressBook,
			long memberID) {
		boolean flag = false;
		db = new Database();
		conn = db.getConn();
		String sql = "update T_MemberAddressBook set MemberTrueName=?,MemberAddress=?,ProvinceCode=?,"
				+ "CityCode=?,AreaCode=?,MemberPostcode=?,MemberTelephone=?,UpdateDate=? where MemberID=?";
		ps = db.getPs(sql, conn);
		
		try {
			ps.setString(1, memberAddressBook.getMemberTrueName());
			ps.setString(2, memberAddressBook.getMemberAddress());
			/*ps.setString(3, memberAddressBook.getProvinceCode());
			ps.setString(4, memberAddressBook.getCityCode());
			ps.setString(5, memberAddressBook.getAreaCode());*/
			ps.setString(3, memberAddressBook.getProvinceCode());
			ps.setString(4, memberAddressBook.getCityCode());
			ps.setString(5, memberAddressBook.getAreaCode());
			ps.setString(6, memberAddressBook.getMemberPostcode());
			ps.setString(7, memberAddressBook.getMemberTelephone());
			ps.setTimestamp(8, new Timestamp(new Date().getTime()));
			ps.setLong(9, memberID);
			ps.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return flag;
	}

	/**
	 * ͨ��memberName��查询memberID
	 */
	public long selectMemberID(String memberName) {
		long memberID = 0;
		db = new Database();
		String sql = "select * from T_Member where MemberName='" + memberName
				+ "'";
		rs = db.getexecuteR_Ps(sql);
		try {
			if (rs.next()) {
				memberID = rs.getLong("MemberID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return memberID;
	}

	/**
	 * 记录用户个数
	 */
	public int getMemberTotleCount() {
		int totalCount = 0;
		db = new Database();
		String sql = "select count(*) as size from T_Member";
		rs = db.getexecuteR_Ps(sql);
		try {
			if (rs.next()) {
				totalCount = rs.getInt("size");
			}
		}catch (SQLException e) {
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return totalCount;
	}

	/**
	 * 查询所有用户信息并分页处理
	 */
	public List<MemberList> selectMemberList(FPageBean page) {
		db = new Database();
		ResultSet rs1 = null;
		List<MemberList> list=new ArrayList<MemberList>(); 
		MemberList memberList=null;
		
		String sql = "select  * from T_Member order by MemberID limit "+(page.getPageSize()-1)* page.getPageNumber()+","+page.getPageNumber()+" ";
	//	System.out.print("112");
		rs = db.getexecuteR_Ps(sql);
		try {
			while(rs.next()){
				memberList=new MemberList();
				memberList.setMemberID(rs.getLong("MemberID"));
				memberList.setMemberName(rs.getString("MemberName"));
				memberList.setMemberPassword(rs.getString("MemberPassword"));
				memberList.setMemberEmail(rs.getString("MemberEmail"));
				memberList.setMemberGrade(rs.getInt("MemberGrade"));
				memberList.setMemberAmount(rs.getDouble("MemberAmount"));
				memberList.setMemberStatus(rs.getString("MemberStatus"));
				memberList.setCreateDate(rs.getDate("CreateDate"));
				memberList.setUpdateDate(rs.getDate("UpdateDate"));
				long memberID=rs.getLong("MemberID");
			    String sql1="select MemberTrueName from T_MemberAddressBook where MemberID='"+memberID+"'";
			    rs1 = db.getexecuteR_Ps(sql1);
			    if(rs1.next()){
			    	memberList.setMemberTrueName(rs1.getString("MemberTrueName"));
			    }
			    list.add(memberList);		    
			}
		}catch(SQLException e){
		}finally{
		}
		return list;
	}
	
	/**
	 * 冻结用户
	 */
	public Member lockMember(long memberID)  {
		Member member = new Member();
		db = new Database();
		try {
			conn = db.getConn();
			String sql="update T_Member set MemberStatus=? where MemberID=?";
			String sql1 = "select * from T_Member where MemberID='"+memberID+"'";
			ps=db.getPs(sql, conn);
			ps.setString(1, "0");
			ps.setLong(2, memberID);
			if(ps.executeUpdate()>0){
				member.setMemberStatus("0");
				rs = db.getexecuteR_Ps(sql1);
				if(rs.next()) {
					member.setMemberName(rs.getString("MemberName"));
				}
			}
		}catch (SQLException e){
		}finally{
		}
		return member;
		
	}

	/**
	 * 解冻用户
	 */
	public Member unlockMember(long memberID)  {
		Member member = new Member();
		db = new Database();
		try {
			conn = db.getConn();
			String sql="update T_Member set MemberStatus=? where MemberID=?";
			String sql1 = "select * from T_Member where MemberID='"+memberID+"'";
			ps=db.getPs(sql, conn);
			ps.setString(1, "1");
			ps.setLong(2, memberID);
			if(ps.executeUpdate()>0){
				member.setMemberStatus("1");
				rs = db.getexecuteR_Ps(sql1);
				if(rs.next()) {
					member.setMemberName(rs.getString("MemberName"));
				}
			}
		}catch (SQLException e){
		}finally{
		}
		return member;
		
	}

	/**
	 * 通过用户名查找用户所有信息
	 * */
	public MemberList SelectMemberByName(String memberName) {
		db = new Database();
		MemberList memberList = null;
		String sql = "select * from T_Member where MemberName like '%"+memberName+"%'";
		try {
			rs = db.getexecuteR_Ps(sql);
			ResultSet rs1=null;
			while(rs.next()){
				memberList=new MemberList();
				//�õ���ԱID
				long memberID=rs.getLong("MemberID");
				memberList.setMemberID(rs.getLong("MemberID"));
				memberList.setMemberName(rs.getString("MemberName"));
				memberList.setMemberPassword(rs.getString("MemberPassword"));
				memberList.setMemberEmail(rs.getString("MemberEmail"));
				memberList.setMemberGrade(rs.getInt("MemberGrade"));
				memberList.setMemberAmount(rs.getDouble("MemberAmount"));
				memberList.setMemberStatus(rs.getString("MemberStatus"));
				memberList.setCreateDate(rs.getTimestamp("CreateDate"));
				memberList.setUpdateDate(rs.getTimestamp("UpdateDate"));
				
			    String sql1="select MemberTrueName from T_MemberAddressBook where MemberID='"+memberID+"'";
			    rs1 = db.getexecuteR_Ps(sql1);
			    if(rs1.next()){
			    	memberList.setMemberTrueName(rs1.getString("MemberTrueName"));
			    }	    
			}
		} catch (SQLException e) {
		}
		return memberList;
	}

	/**
	 * 获得管理员登陆名和密码
	 * */
	public User adminLogin(String userName, String userPassword) {
		User user =null;
		db = new Database();
		String sql = "select * from T_User where UserName='"+userName+"' and UserPassword='"+userPassword+"'";
		rs = db.getexecuteR_Ps(sql);
		
		//System.out.println(rs);
		try {
			
			//System.out.println("r:"+rs.first());
			if(rs.next()) {
				user=new User();
				user.setUserID(rs.getLong("UserID"));
				user.setUserName(userName);
				user.setUserTrueName(rs.getString("UserTrueName"));
				user.setUserPassword(userPassword);
				user.setIsValid(rs.getString("isValid"));
				user.setCreateDate(rs.getDate("CreateDate"));
				user.setUpdateDate(rs.getDate("UpdateDate"));
			}
			//System.out.println("user:"+user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public ArrayList<Member> selectMember(){
		db = new Database();
		String sql="select * from T_Member";
		rs=db.getexecuteR_Ps(sql);
		ArrayList<Member> mal=new ArrayList();
		Member member=null;
		try {
			while(rs.next()){
				member=new Member();
				member.setMemberName(rs.getString("MemberName"));
				mal.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(rs);
		}
		return mal;
	}
}
