package com.fendou.bill.dao;

import java.util.ArrayList;

import com.fendou.bill.po.T_Bill;
import com.fendou.goods.po.T_GoodsType;
import com.fendou.pagination.po.Pagination;



public interface BillDao {
	public int insert(T_Bill bill);
	public ArrayList select(Pagination page);
	public int delete(T_Bill bill);
	public T_Bill selectOne(T_Bill bill);
	public int getTotalRecord();
	public int update(T_Bill bill);
	public int updateThree(T_Bill bill);
	public ArrayList selectAdIndex(int count);
	public ArrayList selectBillOrder();
	public int updateBillOrder(int order);
	public int updateBillOrder1(int billId);
	public int updateBillOrderBack(int order);
	public int updateBillOrderBack1(int billId);
}
