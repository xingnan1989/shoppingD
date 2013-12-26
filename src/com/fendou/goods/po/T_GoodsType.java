package com.fendou.goods.po;

import java.io.Serializable;
import java.util.Date;

public class T_GoodsType implements Serializable{
	private String typeID;//类型ID
	private String typeCode;//类型编号
	private int typeLevel;//类型级别
	private String typeName;//类型名称
	private String typeDesc;//类型描述
	private String isLeaf;//是否子节点
	private String parentID;//父节点ID
	private String creater;//创建人
	private Date createDate;//创建时间
	private String updater;//修改人
	private Date updateDate;//修改时间
	private String superTypeName;//大类的名称
	public String getTypeID() {
		return typeID;
	}
	public void setTypeID(String typeID) {
		this.typeID = typeID;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeDesc() {
		return typeDesc;
	}
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}
	public String getIsLeaf() {
		return isLeaf;
	}
	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}
	public String getParentID() {
		return parentID;
	}
	public void setParentID(String parentID) {
		this.parentID = parentID;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public int getTypeLevel() {
		return typeLevel;
	}
	public void setTypeLevel(int typeLevel) {
		this.typeLevel = typeLevel;
	}
	public String getSuperTypeName() {
		return superTypeName;
	}
	public void setSuperTypeName(String superTypeName) {
		this.superTypeName = superTypeName;
	}
}
