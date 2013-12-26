package com.fendou.goods.dao;

import java.util.ArrayList;

import com.fendou.goods.po.T_Goods;
import com.fendou.goods.po.T_GoodsType;
import com.fendou.pagination.po.Pagination;

public interface GoodsDao {
	public int insert(T_GoodsType type);
	public int getTotalRecord();
	public ArrayList select(Pagination page);
	public int insertSub(T_GoodsType type);
	public int getTotalRecordSub(String parentID);
	public ArrayList selectSub(Pagination page,String parentID);
	public String selectSuperName(String typeCode);
	public int deleteSub(T_GoodsType type);
	public T_GoodsType selectSubTypeOne(String typeCode);
	public int updateSubType(T_GoodsType type,String subTypeCode);
	public T_GoodsType selectSuperTypeOne(String superTypeCode);
	public int updateSuperType(T_GoodsType type,String superTypeCode);
	public int deleteSuperType(String superTypeCode);
	public String selectSubAjax(String parentID);
	public int insertGoods(T_Goods goods);
	public int getTotalGoodsRecord();
	public ArrayList selectGoods(Pagination page);
	public T_Goods selectGoodsDetail(String goodsID);
	public int goodsInvalidata(String goodsID,String state);
	public ArrayList<T_GoodsType> select();
	public int repairGoods(int updateGoodsNumber,String goodsId);
	public String  repairGoods(String goodsId);
	public ArrayList getSubCodeName(String typeCode);
	public String  getTypeCode(String goodsID);
	public int updateGoods(T_Goods goods);
	public int updateGoods1(T_Goods goods);
	public ArrayList seach(String key,String typeID,Pagination page);
	public int seachTotalRecord(String key,String typeID) ;
	public ArrayList indexTejiaGoods(int count);
	public ArrayList indexNewGoods(int count);
	public boolean superCodeAddAjax(String typeCode);
	public boolean subCodeAddAjax(String typeCode);
	public ArrayList superCodeUpdateAjax(String typeCode);
	public ArrayList saleGoods(Pagination page);
	public int totalTejiaGoods();
	public ArrayList newGoods(Pagination page);
	public int totalNewGoods();
	public ArrayList indexSeach();
	public ArrayList indexSeachResult(String key,Pagination page,String superTypeCode);
	public int totalRecordIndexSeachResult(String key,String superTypeCode);
	public String getSuperName(String superTypeCode);
	public ArrayList selectGoodsType();
	public ArrayList selectGoods(String subTypeCode);
	public String subNameShow(String subTypeCode);
	public String superNameShow(String subTypeCode);
	public ArrayList<T_GoodsType> selectSuperTypeGoods();
}
