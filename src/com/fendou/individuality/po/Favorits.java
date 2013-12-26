package com.fendou.individuality.po;

public class Favorits {
	private long iD;//收藏ID号	bigint
	private long memberID;//	用户ID号	bigint
	private long goodsID;//	商品ID	bigint
	private String addtime;//收藏时间	datetime
	public long getID() {
		return iD;
	}
	public void setID(long id) {
		iD = id;
	}
	public long getMemberID() {
		return memberID;
	}
	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}
	public long getGoodsID() {
		return goodsID;
	}
	public void setGoodsID(long goodsID) {
		this.goodsID = goodsID;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	
}
