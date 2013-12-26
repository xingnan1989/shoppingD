/*
 *用户信息
 **/
package com.fendou.member.po;

import java.util.Date;

public class Member {

	private long memberID;
	private String memberName;
	private String memberPassword;
	private String memberEmail;
	private int memberGrade;
	private double memberAmount;
	private String memberStatus;
	private Date createDate;
	private Date updateDate;
	private String memberTrueName;
	
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
	public String getMemberTrueName() {
		return memberTrueName;
	}
	public void setMemberTrueName(String memberTrueName) {
		this.memberTrueName = memberTrueName;
	}

	
}
