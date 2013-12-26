package com.fendou.placard.po;

import java.io.Serializable;

public class Placard implements Serializable{
	private long placardID;//	����ID	bigint
	private String placardTitle;//	��������	Varchar(100)
	private String placardContent;//	��������	Varchar(4000)
	private String issueDate;//	����ʱ��	datetime
	private String expireDate;//	ʧЧʱ��	datetime
	private String creater;//	������	String
	private String createDate;//	����ʱ��	datetime
	private String updater;//	�޸���	String
	private String updateDate;//	�޸�ʱ��	datetime
	public long getPlacardID() {
		return placardID;
	}
	public void setPlacardID(long placardID) {
		this.placardID = placardID;
	}
	public String getPlacardTitle() {
		return placardTitle;
	}
	public void setPlacardTitle(String placardTitle) {
		this.placardTitle = placardTitle;
	}
	public String getPlacardContent() {
		return placardContent;
	}
	public void setPlacardContent(String placardContent) {
		this.placardContent = placardContent;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	

}
