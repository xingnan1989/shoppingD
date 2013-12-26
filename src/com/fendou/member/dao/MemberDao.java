package com.fendou.member.dao;

import java.util.ArrayList;
import java.util.List;

import com.fendou.member.po.Member;
import com.fendou.member.po.MemberAddressBook;
import com.fendou.member.po.MemberList;
import com.fendou.member.po.User;
import com.fendou.util.FPageBean;

public interface MemberDao {
	/*添加用户信息*/
	public boolean addMember(Member member,MemberAddressBook memberAddressBook);
	/*验证用户名*/
	public boolean validUsername(String memberName);
	/*管理员登陆*/
	public Member userLogin(String memberName,String memeberPassword);
	/*通过ID号依次查找用户信息*/
	public Member queryMember(long memberID);
	/*查询用户地址信息*/
	public MemberAddressBook queryMemberAddress(long memberID);
	/*ͨ���通过用户名查询ID号*/
	public long queryMemberID(String memberName);
	/*验证用户名密码*/
	public boolean validMemberPassword(String memberName,String memberPassword);
	/*修改密码*/
	public boolean modifyMemberPassword(String memberName,String memberPassword);
	/*修改用户地址信息*/
	public boolean modifyMemberAddress(MemberAddressBook memberAddressBook,long memberID);
	/*ͨ��memberName��查询memberID*/
	public long selectMemberID(String memberName);
	/*记录用户个数*/
	public int getMemberTotleCount();
	/*查询所有用户信息并分页处理*/
	public List<MemberList> selectMemberList(FPageBean fpage);
	/*冻结用户*/
	public Member lockMember(long memberID);
	/*解冻用户*/
	public Member unlockMember(long memberID);
	/*通过用户名查找用户所有信息*/
	public MemberList SelectMemberByName(String memberName);
	/*获得管理员登陆名和密码*/
	public User adminLogin(String userName,String userPassword);
	//查询所有用户信息
	public ArrayList<Member> selectMember();
}
