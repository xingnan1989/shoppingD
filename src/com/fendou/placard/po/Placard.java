package com.fendou.placard.po;

import java.io.Serializable;

public class Placard implements Serializable{
	private long placardID;//	公告ID	bigint
	private String placardTitle;//	公告主题	Varchar(100)
	private String placardContent;//	公告内容	Varchar(4000)
	private String issueDate;//	发布时间	datetime
	private String expireDate;//	失效时间	datetime
	private String creater;//	创建人	String
	private String createDate;//	创建时间	datetime
	private String updater;//	修改人	String
	private String updateDate;//	修改时间	datetime
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
