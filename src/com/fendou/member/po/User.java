/*后台管理人员表
 * 此表用于存放后台管理员信息*/
package com.fendou.member.po;

import java.util.Date;

public class User {
	private long userID;
	private String userName;
	private String userTrueName;
	private String userPassword;
	private String isValid;
	private Date createDate;
	private Date updateDate;
	private String userType;
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserTrueName() {
		return userTrueName;
	}
	public void setUserTrueName(String userTrueName) {
		this.userTrueName = userTrueName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getIsValid() {
		return isValid;
	}
	public void setIsValid(String isValid) {
		this.isValid = isValid;
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
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}

	

}
