package com.fendou.member.po;

import java.util.Date;

public class MemberList {

    //用户ID
	private long memberID;
	
	//用户名
	private String memberName;
	
	//用户真实姓名
	private String memberTrueName;
	
	//用户密码
	private String memberPassword;
	
	//用户Email
	private String memberEmail;
	
	//用户年龄 
    private int memberGrade ;    
   
    //用户总金额
    private double memberAmount;
    
	//用户状态
	private String memberStatus;
	
	//用户创建时间
	private Date createDate ;
	
	//用户修改时间
	private Date updateDate ;

	public long getMemberID() {
		return memberID;
	}

	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberTrueName() {
		return memberTrueName;
	}

	public void setMemberTrueName(String memberTrueName) {
		this.memberTrueName = memberTrueName;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public int getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(int memberGrade) {
		this.memberGrade = memberGrade;
	}

	public double getMemberAmount() {
		return memberAmount;
	}

	public void setMemberAmount(double memberAmount) {
		this.memberAmount = memberAmount;
	}

	public String getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	

}
