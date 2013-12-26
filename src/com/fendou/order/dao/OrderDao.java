package com.fendou.order.dao;
import java.util.ArrayList;

import com.fendou.order.po.*;
import com.fendou.pagination.po.Pagination;
public interface OrderDao {
	public Goods selectGoods_goodsId(String str);//根据商品GoodsID获得商品信息
	//public Goods selectGoods_to_number();
	public void updateGoodsNumber(int num,String goodsID);//修改商品数量
	public MemberAddressBook selectMemberAddressBook(long memberID);//根据用户ID获得用户的地址详情
	public void updateMemberAddressBook(MemberAddressBook mab);//修改由session保存的地址信息
	public ArrayList<OrderPayMode> selectOrderPayMode();//订单支付方式列表
	public OrderPayMode selectOrderPayMode_id(String payID);//根据支付的ID获得支付方式
	
	public ArrayList<Province> selectProvince();//省份列表
	//由ID到列表
	public ArrayList<City> selectCity(int provinceID);//根据省份ID获得城市列表
	public ArrayList<Area> selectArea(int cityID);//根据城市ID获得地区列表
	//由编号到ID
	public int selectProvinceIDtoCode(String provinceCode);//由省份编号获得省份ID
	public int selectCityIDtoCode(String cityCode);//由城市编号获得城市ID
	public int selectAreaIDtoCode(String areaCode);//由地区编号获得地区ID
	//由编号到name
	public String selectProvinceCode(String provinceCode);//由省份ID号获得省份名称
	public String selectCityCode(String cityCode);//由城市ID号获得城市名称
	public String selectAreaCode(String areaCode);//由地区ID号获得地区名称
	
	public ArrayList<OrderCarryMode> selectOrderCarryMode();//获得所有送货方式列表
	public OrderCarryMode selectOrderCarryMode_id(String carryID);//根据送货方式ID获得送货名称

	public ArrayList<OrderCarryTime> selectOrderCarryTime();//获得所有送货时间列表
	public OrderCarryTime selectOrderCarryTimeToID(int carryTimeID);//根据送货时间ID获得送货时间
	
	public void insertOrder(Order o,OrderInvoice oi,ArrayList car);//添加订单
	public int selectOrderLastID();//获得最后一个订单
	
	public ArrayList<Order> selectOrder(long memberID);//查找该用户的所有订单
	public Order selectOrder2(long orderID);//根据订单ID号查找订单-管理员
	public ArrayList<Order> selectOrder();//所有订单列表
	
	public ArrayList<OrderDetail> selectOrderDetail(long orderID);//根据订单ID号查找该订单详情
	public ArrayList<OrderDetail> selectOrderDetail();//查找所有订单
	
	public void updateBuyGoodsNumber(String goodsID,int buyGoodsNumber);//修改购买商品的数量
	public void deleteOrder(Long orderID,String orderInvoice);//根据订单ID号和发票删除订单
	
	public void updateOrderStatus(Long orderID);//修改订单状态
	public ArrayList<Order> selectDate(String date);//根据日期获得订单列表
}
