package com.fendou.commentary.po;

import java.util.Date;

public class Comment {
	private long commentID;//留言ID
	private String commentUserName;//留言者ID
	private int commentRank;//留言等级
	private String commentContent;//留言内容
	private String commentData;//留言时间
	private long goodsID;
	public long getCommentID() {
		return commentID;
	}
	public void setCommentID(long commentID) {
		this.commentID = commentID;
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
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getCommentData() {
		return commentData;
	}
	public void setCommentData(String commentData) {
		this.commentData = commentData;
	}
	public long getGoodsID() {
		return goodsID;
	}
	public void setGoodsID(long goodsID) {
		this.goodsID = goodsID;
	}
	
}
