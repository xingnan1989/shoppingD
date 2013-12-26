/*
 * 本.java属于错误信息
 */
package com.fendou.commentary.po;

import java.util.Date;

public class Commemt {
	private long commentID;//留言ID
	private long commentUserID;//留言者ID
	private String commentUserName;//留言者姓名
	private int commentRank;//留言等级
	private String CommentContent;//留言内容
	private Date commentData;//留言日期
	public long getCommentID() {
		return commentID;
	}
	public void setCommentID(long commentID) {
		this.commentID = commentID;
	}
	public long getCommentUserID() {
		return commentUserID;
	}
	public void setCommentUserID(long commentUserID) {
		this.commentUserID = commentUserID;
	}
	public String getCommentUserName() {
		return commentUserName;
	}
	public void setCommentUserName(String commentUserName) {
		this.commentUserName = commentUserName;
	}
	public int getCommentRank() {
		return commentRank;
	}
	public void setCommentRank(int commentRank) {
		this.commentRank = commentRank;
	}
	public String getCommentContent() {
		return CommentContent;
	}
	public void setCommentContent(String commentContent) {
		CommentContent = commentContent;
	}
	public Date getCommentData() {
		return commentData;
	}
	public void setCommentData(Date commentData) {
		this.commentData = commentData;
	}
	
}
