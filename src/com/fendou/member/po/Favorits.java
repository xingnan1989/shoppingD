/*��Ʒ�ղر�
 * ����û��Ժ�Ҫ�������Ʒ��Ϣ*/
package com.fendou.member.po;

import java.util.Date;

public class Favorits {
	private long id;
	private long memberID;
	private long goodsID;
	private Date addtime;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	

}
