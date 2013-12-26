package com.fendou.placard.dao;

import java.util.ArrayList;

import com.fendou.order.po.OrderDetailArrayOrder;
import com.fendou.pagination.po.Pagination;
import com.fendou.placard.po.Placard;

public interface PlacardDao {
	public ArrayList<Placard> selectPlacard();//获得所有公告信息
	public void insertPlacard(Placard p);//管理员插入公告信息
	public void deletePlacard(long placardID);//删除公告
	public void updatePlacard(Placard placard);//修改公告
	public Placard selectPlacardToID(long placardID);//根据ID号获得
	public ArrayList<Placard> selectPlacardShow();//所有显示公告信息
	public int selectPlacardCount();//返回公告个数
	public ArrayList<Placard> selectPlacardPagination(Pagination page);//当前页面上的公告数
}
