package com.fendou.order.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fendou.order.dao.OrderDao;
import com.fendou.order.po.Area;
import com.fendou.order.po.City;
import com.fendou.order.po.Goods;
import com.fendou.order.po.MemberAddressBook;
import com.fendou.order.po.Order;
import com.fendou.order.po.OrderCarryMode;
import com.fendou.order.po.OrderCarryTime;
import com.fendou.order.po.OrderDetail;
import com.fendou.order.po.OrderDetailArrayOrder;
import com.fendou.order.po.OrderInvoice;
import com.fendou.order.po.OrderPayMode;
import com.fendou.order.po.Province;
import com.fendou.order.po.ShopCarAdd;
import com.fendou.pagination.po.Pagination;
import com.fendou.system.db.Database;

public class OrderDaoImpl implements OrderDao{
	Database db=new Database();
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet r,r1,r2;

	public Goods selectGoods_goodsId(String goodsID){
		Goods goods=null;
		String sql="select * from T_Goods where GoodsID="+goodsID;
		r=db.getexecuteR_Ps(sql);
		try {
			if(r.next()){
				goods=new Goods();		
				goods.setGoodsID(r.getLong("GoodsID"));
				goods.setGoodsName(r.getString("GoodsName"));
				//goods.setGoodsIntroduce(r.getString("GoodsIntroduce"));
				goods.setGoodsNormalPrice(r.getDouble("GoodsNormalPrice"));
				goods.setGoodsMemberPrice(r.getDouble("GoodsMemberPrice"));
				goods.setGoodsRebate(r.getFloat("GoodsRebate"));
				goods.setTypeCode(r.getString("TypeCode"));
				goods.setGoodsNumber(r.getInt("GoodsNumber"));
				goods.setGoodsGrade(r.getInt("GoodsGrade"));
				goods.setIsSale(r.getString("isSale"));
				goods.setIsValid(r.getString("isValid"));
				goods.setGoodsPicture(r.getString("GoodsPicture"));
				goods.setCreater(r.getString("Creater"));
				goods.setCreateDate(r.getString("CreateDate"));
				goods.setUpdater(r.getString("Updater"));
				goods.setUpdateDate(r.getString("UpdateDate"));
				goods.setBuyCount(r.getInt("BuyCount"));
				goods.setBuyGoodsNumber(r.getInt("BuyGoodsNumber"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return goods;
	}
	public void updateGoodsNumber(int num,String goodsID){
		String sql="update T_Goods set GoodsNumber='"+num+"'where GoodsID='"+goodsID+"'";
		ps=db.getexecutePs(sql);
		try {
			int a=ps.executeUpdate();
			System.out.println(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			db.closeexecutePs(ps);
		}
		
	}
		
	public void updateBuyGoodsNumber(String goodsID,int buyGoodsNumber){
		String sql="update T_Goods set BuyGoodsNumber='"+buyGoodsNumber+"'where GoodsID='"+goodsID+"'";
		ps=db.getexecutePs(sql);
		try {
			int a=ps.executeUpdate();
			//System.out.println(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			db.closeexecutePs(ps);
		}
	}	
		
	public MemberAddressBook selectMemberAddressBook(long memberID){
		String sql="select * from T_MemberAddressBook where MemberID='"+memberID+"'";	
		r=db.getexecuteR_Ps(sql);
		MemberAddressBook mab=null;
		try {
			while(r.next()){
				mab=new MemberAddressBook();
				mab.setID(r.getInt("ID"));
				mab.setMemberID(r.getInt("MemberID"));
				mab.setMemberTrueName(r.getString("MemberTrueName"));
				mab.setMemberAddress(r.getString("MemberAddress"));
				mab.setProvinceCode(r.getString("ProvinceCode" ));
				mab.setCityCode(r.getString("CityCode"));
				mab.setAreaCode(r.getString("AreaCode"));
				mab.setMemberPostcode(r.getString("MemberPostcode"));
				mab.setMemberTelephone(r.getString("MemberTelephone"));
				mab.setGreateDate(r.getString("CreateDate"));
				//System.out.println(r.getString("CreateDate"));
				mab.setUpdateDate(r.getString("UpdateDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return mab;
	}
	
	public void updateMemberAddressBook(MemberAddressBook dao){
		Long memberID=dao.getMemberID();
		String memberTrueName=dao.getMemberTrueName();
		String memberAddress=dao.getMemberAddress();
		String memberPostcode=dao.getMemberPostcode();
		String memberTelephone=dao.getMemberTelephone();
		String sql="update T_MemberAddressBook set" +
				" MemberTrueName='"+memberTrueName+"', MemberAddress='"+memberAddress+
				"', MemberPostcode='"+memberPostcode+"', MemberTelephone='"+memberTelephone+
				"' where MemberID="+memberID;
		ps=db.getexecutePs(sql);
		try {
			int n=ps.executeUpdate();
			if(n<0){
				System.out.println("修改失败!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecutePs(ps);
		}
		//System.out.println(sql);
	}
	
	public ArrayList<OrderPayMode> selectOrderPayMode(){
		String sql="select * from T_OrderPayMode";
		r=db.getexecuteR_Ps(sql);
		ArrayList al_opm=new ArrayList();
		OrderPayMode opm=null;
		try {
			while(r.next()){
				opm=new OrderPayMode();
				opm.setPayID(r.getInt("PayID"));
				opm.setPayContent(r.getString("PayContent"));
				opm.setPayDesc(r.getString("PayDesc"));
				al_opm.add(opm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return al_opm;
	}
	
	public OrderPayMode selectOrderPayMode_id(String payID){
		String sql="select * from T_OrderPayMode where PayID="+payID;
		r=db.getexecuteR_Ps(sql);
		OrderPayMode opm=null;
		try {
			while(r.next()){
				opm=new OrderPayMode();
				opm.setPayID(r.getInt("PayID"));
				opm.setPayContent(r.getString("PayContent"));
				opm.setPayDesc(r.getString("PayDesc"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return opm;
	}
	
	public ArrayList<Province> selectProvince(){
		String sql="select * from T_Province";
		r=db.getexecuteR_Ps(sql);
		ArrayList<Province> p_al=new ArrayList();
		try {
			while(r.next()){
				Province p=new Province();
				p.setProvinceCode(r.getString("ProvinceCode"));
				p.setProvince(r.getString("Province"));
				p_al.add(p);
			}
		} catch (SQLException e) {
			System.out.println("sql异常");
			
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return p_al;
	}
	//根据省份ID号获得城市ID号
	public ArrayList<City> selectCity(int provinceID){
		String sql="select * from T_City where provinceID="+provinceID;
		r=db.getexecuteR_Ps(sql);
		ArrayList<City> cal=new ArrayList();
		try {
			while(r.next()){
				City c=new City();
				c.setCityCode(r.getString("CityCode"));
				c.setCity(r.getString("City"));
				cal.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return cal;
	}
	
	public ArrayList<Area> selectArea(int cityID){
		String sql="select * from T_Area where CityID="+cityID;
		//System.out.println(sql);
		r=db.getexecuteR_Ps(sql);
		ArrayList<Area> aal=new ArrayList();
		try {
			while(r.next()){
				Area a=new Area();
				a.setAreaCode(r.getString("AreaCode"));
				a.setArea(r.getString("Area"));
				aal.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return aal;
	}
	//根据省份名称获得省份ID
	public int selectProvinceIDtoCode(String provinceCode){
		String sql="select * from T_Province where ProvinceCode="+provinceCode;
		//System.out.print(sql);
		r=db.getexecuteR_Ps(sql);
		int provinceID=0;
		try {
			while(r.next()){
				provinceID = r.getInt("ProvinceID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return provinceID;
		
	}
	public int selectCityIDtoCode(String cityCode){
		String sql="select * from T_City where CityCode="+cityCode;
		System.out.print(sql);
		r=db.getexecuteR_Ps(sql);
		int cityID=0;
		try {
			while(r.next()){
				cityID = r.getInt("CityID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return cityID;
		
	}
	public int selectAreaIDtoCode(String areaCode){
		String sql="select * from T_Area where AreaCode="+areaCode;
		System.out.print(sql);
		r=db.getexecuteR_Ps(sql);
		int areaID=0;
		try {
			while(r.next()){
				areaID = r.getInt("AreaID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return areaID;
		
	}
	
	//根据省份编号获得省份名称ַ
	public String selectProvinceCode(String provinceCode){
		String sql="select * from T_Province where ProvinceCode="+provinceCode;
		//System.out.println(sql);
		r=db.getexecuteR_Ps(sql);
		String province=null;
		try {
			while(r.next()){
				province=r.getString("Province");
			}			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return province;
	}
	public String selectCityCode(String cityCode){
		String sql="select * from T_City where CityCode="+cityCode;
		//System.out.print(sql);
		r=db.getexecuteR_Ps(sql);
		String province=null;
		try {
			while(r.next()){
				province=r.getString("City");
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return province;
	}
	public String selectAreaCode(String areaCode){
		String sql="select * from T_Area where AreaCode="+areaCode;
		//System.out.print(sql);
		r=db.getexecuteR_Ps(sql);
		String province=null;
		try {
			while(r.next()){
				province=r.getString("Area");
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return province;
	}
/*	public int selectProvinceIDtoCode(String provinceCode){
		String sql="select * from T_Province where ProvinceCode="+provinceCode;
		//System.out.print(sql);
		r=db.getexecuteR_Ps(sql);
		int provinceID=0;
		try {
			while(r.next()){
				provinceID = r.getInt("ProvinceID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return provinceID;
		
	}
	public int selectCityIDtoCode(String cityCode){
		String sql="select * from T_City where CityCode="+cityCode;
		System.out.print(sql);
		r=db.getexecuteR_Ps(sql);
		int cityID=0;
		try {
			while(r.next()){
				cityID = r.getInt("CityID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return cityID;
		
	}
	public int selectAreaIDtoCode(String areaCode){
		String sql="select * from T_Area where AreaCode="+areaCode;
		System.out.print(sql);
		r=db.getexecuteR_Ps(sql);
		int areaID=0;
		try {
			while(r.next()){
				areaID = r.getInt("AreaID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return areaID;
		
	}
	
	//Code���ַ
	public String selectProvinceCode(String provinceCode){
		String sql="select * from T_Province where ProvinceCode="+provinceCode;
		//System.out.println(sql);
		r=db.getexecuteR_Ps(sql);
		String province=null;
		try {
			while(r.next()){
				province=r.getString("Province");
			}			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return province;
	}
	public String selectCityCode(String cityCode){
		String sql="select * from T_City where CityCode="+cityCode;
		//System.out.print(sql);
		r=db.getexecuteR_Ps(sql);
		String province=null;
		try {
			while(r.next()){
				province=r.getString("City");
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return province;
	}
	public String selectAreaCode(String areaCode){
		String sql="select * from T_Area where AreaCode="+areaCode;
		//System.out.print(sql);
		r=db.getexecuteR_Ps(sql);
		String province=null;
		try {
			while(r.next()){
				province=r.getString("Area");
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return province;
	}*/
	
	public ArrayList<OrderCarryMode> selectOrderCarryMode(){
		String sql="select * from T_OrderCarryMode";
		r=db.getexecuteR_Ps(sql);
		ArrayList alocm=new ArrayList();
		OrderCarryMode ocm=null;
		try {
			while(r.next()){
				ocm=new OrderCarryMode();
				ocm.setCarryID(r.getInt("CarryID"));
				ocm.setCarryContent(r.getString("CarryContent"));
				ocm.setCarryDay(r.getInt("CarryDay"));
				ocm.setCarryDesc(r.getString("CarryDesc"));
				alocm.add(ocm);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return alocm;
	}
	
	public OrderCarryMode selectOrderCarryMode_id(String carryID){
		String sql="select * from T_OrderCarryMode where CarryID="+carryID;
		r=db.getexecuteR_Ps(sql);
		OrderCarryMode ocm=null;
		try {
			while(r.next()){
				ocm=new OrderCarryMode();
				ocm.setCarryID(r.getInt("CarryID"));
				ocm.setCarryContent(r.getString("CarryContent"));
				ocm.setCarryDay(r.getInt("CarryDay"));
				ocm.setCarryDesc(r.getString("CarryDesc"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return ocm;
	}
	
	public ArrayList<OrderCarryTime> selectOrderCarryTime(){
		String sql="select * from T_OrderCarryTime";
		ArrayList<OrderCarryTime> octal=new ArrayList();
		OrderCarryTime oct=null;
		r=db.getexecuteR_Ps(sql);
		try {
			while(r.next()){
				oct=new OrderCarryTime();
				oct.setCarryTimeID(r.getInt("CarryTimeID"));
				oct.setCarryTimeContent(r.getString("CarryTimeContent"));
				octal.add(oct);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return octal;
	}
	
	public OrderCarryTime selectOrderCarryTimeToID(int carryTimeID){
		String sql="select * from T_OrderCarryTime where CarryTimeID="+carryTimeID;
		r=db.getexecuteR_Ps(sql);
		OrderCarryTime oct=null;
		try {
			while(r.next()){
				oct=new OrderCarryTime();
				oct.setCarryTimeID(r.getInt("CarryTimeID"));
				oct.setCarryTimeContent(r.getString("CarryTimeContent"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oct;
	}
	
	public void insertOrder(Order o,OrderInvoice oi,ArrayList car){
		
		int orderID=0;
		int num1=0;
		int num2=0;
		ArrayList<Integer> num3=new ArrayList();
		try {
			//1.插入订单表
			String sqlB="insert into T_Order values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,now(),now())";
			conn=db.getConn();
			conn.setAutoCommit(false);//设置事物手动提交
			ps=db.getPs(sqlB, conn);
			ps.setLong(1, o.getMemberID());
			ps.setString(2,o.getMemberTureName());
			ps.setString(3, o.getMemberAddress());
			ps.setString(4, o.getMemberProvince());
			ps.setString(5, o.getMemberCity());
			ps.setString(6, o.getMemberArea());
			ps.setString(7, o.getMemberPostcode());
			ps.setString(8, o.getMemberTelephone());
			ps.setDouble(9, o.getOrderAmount());
			ps.setString(10, o.getOrderPay());
			ps.setString(11, o.getOrderInvoice());
			ps.setString(12, o.getOrderCarry());
			ps.setInt(13, o.getOrderCarryTime());
			ps.setString(14, o.getOrderRemark());
			ps.setString(15, o.getOrderStatus());
			num1=ps.executeUpdate();
			db.closePs(ps);
			//conn.commit();
			
			//2.查询订单ID
			String sqlA="select * from T_Order where OrderID=(select max(OrderID) from T_Order )";
			//System.out.println("conn2:"+conn);
			ps=db.getPs(sqlA, conn);
			r=db.getR(ps);
			while(r.next()){
				orderID=r.getInt("OrderID");
			}
			db.closeR(r);
			db.closePs(ps);
			//System.out.println(orderID);

			//3.插入订单明细表
			Goods goods=null;
			ShopCarAdd sca=null;
			for(int i=0;i<car.size();i++){
				//System.out.println(i);
				sca=(ShopCarAdd)car.get(i);
				goods=sca.getGoods();
				String sqlD="insert into T_OrderDetail values(null,?,?,?,?,?)";
				ps=db.getPs(sqlD, conn);
				ps.setLong(1, orderID);
				ps.setLong(2,goods.getGoodsID());
				ps.setString(3, goods.getGoodsName());
				ps.setDouble(4, goods.getGoodsMemberPrice());
				ps.setInt(5,sca.getNum());
//				System.out.println("1:"+orderID);
//				System.out.println("2:"+goods.getGoodsID());
//				System.out.println("3:"+goods.getGoodsName());
//				System.out.println("4:"+goods.getGoodsMemberPrice());
//				System.out.println("5:"+sca.getNum());
				num3.add(ps.executeUpdate());
				db.closePs(ps);
			}

			//4.插入发票表
			
				if(o.getOrderInvoice().equals("Y")){
					String sqlC="insert into T_OrderInvoice values(null,?,?,?,?)";
					//System.out.println("conn3:"+conn);
					ps=db.getPs(sqlC, conn);
					ps.setInt(1, orderID);
					ps.setString(2,oi.getInvoiceTitle() );
					ps.setString(3, oi.getInvoiceContent());
					ps.setDouble(4,o.getOrderAmount());
					num2=ps.executeUpdate();
					db.closePs(ps);
					for(int i=0;i<car.size();i++){
						if(num1>0 && num2>0 && num3.get(i)>0){
							conn.commit();
							//System.out.println("插入发票");
						}else{
							conn.rollback();
							System.out.println("订单表，订单明细表，发票表插入失败！");
						}
					}
				}else{
					for(int i=0;i<car.size();i++){
						if(num1>0 && num3.get(i)>0){
							conn.commit();
							//System.out.println("插入订单表");
						}else{
							conn.rollback();
							System.out.println("订单表，订单明细表插入失败！");
						}
					}
				}	
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeConn(conn);
		}
		
		
	}
	
	public int selectOrderLastID(){
	//	String sql1="select max(OrderID) from T_Order";
		String sql="select * from T_Order where OrderID=(select max(OrderID)  from T_Order)";
		r=db.getexecuteR_Ps(sql);
		int OrderID=0;
		try {
			while(r.next()){
				OrderID=r.getInt("OrderID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return OrderID;
	}
	
	public ArrayList<Order> selectOrder(long memberID){
		String sql="select * from T_Order where MemberID='"+memberID+"' order by OrderID desc";
		r=db.getexecuteR_Ps(sql);
	//	System.out.print(sql);
		ArrayList<Order> al=new ArrayList();
		Order o=null;
		try {
			while(r.next()){
				o=new Order();
				o.setOrderID(r.getLong("OrderID"));
				o.setMemberID(r.getLong("MemberID"));
				o.setMemberTureName(r.getString("MemberTrueName"));
				o.setMemberAddress(r.getString("MemberAddress"));
				o.setMemberProvince(r.getString("MemberProvince"));
				o.setMemberCity(r.getString("MemberCity"));
				o.setMemberArea(r.getString("MemberArea"));
				o.setMemberPostcode(r.getString("MemberPostcode"));
				o.setMemberTelephone(r.getString("MemberTelephone"));
				o.setOrderAmount(r.getDouble("OrderAmount"));
				o.setOrderPay(r.getString("OrderPay"));
				o.setOrderInvoice(r.getString("OrderInvoice"));
				o.setOrderCarry(r.getString("OrderCarry"));
				o.setOrderCarryTime(r.getInt("OrderCarryTime"));
				o.setOrderRemark(r.getString("OrderRemark"));
				o.setOrderStatus(r.getString("OrderStatus"));
				o.setGreateDate(r.getString("CreateDate"));
				o.setUpdateDate(r.getString("UpdateDate"));
				
				
				al.add(o);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return al;
	}
	
	public Order selectOrder2(long orderID){
		String sql="select * from T_Order where OrderID="+orderID;
		r=db.getexecuteR_Ps(sql);
		Order o=null;
		try {
			while(r.next()){
				o=new Order();
				o.setOrderID(r.getLong("OrderID"));
				o.setMemberID(r.getLong("MemberID"));
				o.setMemberTureName(r.getString("MemberTrueName"));
				o.setMemberAddress(r.getString("MemberAddress"));
				o.setMemberProvince(r.getString("MemberProvince"));
				o.setMemberCity(r.getString("MemberCity"));
				o.setMemberArea(r.getString("MemberArea"));
				o.setMemberPostcode(r.getString("MemberPostcode") );
				o.setMemberTelephone(r.getString("MemberTelephone"));
				o.setOrderAmount(r.getDouble("OrderAmount"));
				o.setOrderPay(r.getString("OrderPay"));
				o.setOrderInvoice(r.getString("OrderInvoice"));
				o.setOrderCarry(r.getString("OrderCarry") );
				o.setOrderCarryTime(r.getInt("OrderCarryTime"));
				o.setOrderRemark(r.getString("OrderRemark"));
				o.setOrderStatus(r.getString("OrderStatus") );
				o.setGreateDate(r.getString("CreateDate"));
				o.setUpdateDate(r.getString("UpdateDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
	
	public ArrayList<Order> selectOrder(){
		String sql="select * from T_Order order by OrderID desc";
		r=db.getexecuteR_Ps(sql);
		ArrayList<Order> al=new ArrayList();
		Order o=null;
		try {
			while(r.next()){
				o=new Order();
				o.setOrderID(r.getLong("OrderID"));
				o.setMemberID(r.getLong("MemberID"));
				o.setMemberTureName(r.getString("MemberTrueName"));
				o.setMemberAddress(r.getString("MemberAddress"));
				o.setMemberProvince(r.getString("MemberProvince"));
				o.setMemberCity(r.getString("MemberCity"));
				o.setMemberArea(r.getString("MemberArea"));
				o.setMemberPostcode(r.getString("MemberPostcode"));
				o.setMemberTelephone(r.getString("MemberTelephone"));
				o.setOrderAmount(r.getDouble("OrderAmount"));
				o.setOrderPay(r.getString("OrderPay"));
				o.setOrderInvoice(r.getString("OrderInvoice"));
				o.setOrderCarry(r.getString("OrderCarry"));
				o.setOrderCarryTime(r.getInt("OrderCarryTime"));
				o.setOrderRemark(r.getString("OrderRemark"));
				o.setOrderStatus(r.getString("OrderStatus"));
				o.setGreateDate(r.getString("CreateDate"));
				o.setUpdateDate(r.getString("UpdateDate"));
				al.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return al;
	}
	
	public ArrayList<OrderDetail> selectOrderDetail(long orderID){
		//System.out.println("orderID:"+orderID);
		String sql="select * from T_OrderDetail where OrderID="+orderID;
		r=db.getexecuteR_Ps(sql);
		ArrayList<OrderDetail> odal=new ArrayList();
		OrderDetail od=null;
		try {
			while(r.next()){
				od=new OrderDetail();
				od.setID(r.getLong("ID"));
				od.setOrderID(r.getLong("OrderID"));
				od.setGoodsID(r.getLong("GoodsID"));
				od.setGoodsName(r.getString("GoodsName"));
				od.setGoodsPrice(r.getDouble("GoodsPrice"));
				od.setGoodsCount(r.getInt("GoodsCount"));
				odal.add(od);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return odal;
	}
	
	public ArrayList<OrderDetail> selectOrderDetail(){
		String sql="select * from T_OrderDetail";
		r=db.getexecuteR_Ps(sql);
		ArrayList<OrderDetail> odal=new ArrayList();
		OrderDetail od=null;
		try {
			while(r.next()){
				od=new OrderDetail();
				od.setID(r.getLong("ID"));
				//System.out.println(r.getInt("ID"));
				od.setOrderID(r.getLong("OrderID"));
				od.setGoodsID(r.getLong("GoodsID"));
				od.setGoodsName(r.getString("GoodsName"));
				od.setGoodsPrice(r.getDouble("GoodsPrice"));
				od.setGoodsCount(r.getInt("GoodsCount"));
				odal.add(od);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return odal;
	}
	
	public void deleteOrder(Long  orderID,String orderInvoice){
		int a=0;
		int b=0;
		int c=0;
		try {
			//1.根据orderID删除订单明细
			String sqlB="delete from T_OrderDetail where OrderID="+orderID;
			conn=db.getConn();
			conn.setAutoCommit(false);
			ps=db.getPs(sqlB, conn);
			b=ps.executeUpdate();
			db.closePs(ps);
			//System.out.println("b="+b);
			
			//2.根据orderID删除发票表
			if(orderInvoice.equals("Y")){
				String sqlC="delete from T_OrderInvoice where OrderID="+orderID;
				ps=db.getPs(sqlC, conn);
				c=ps.executeUpdate();
				db.closePs(ps);
				//System.out.println("c="+c);
			}
				
				///3.删除商品表中指定ID信息
				String sqlA="delete from T_Order where OrderID="+orderID;
				//System.out.println(sqlA);
				//System.out.println("orderInvoice="+orderInvoice);
				ps=db.getPs(sqlA, conn);
				a=ps.executeUpdate();
				db.closePs(ps);
				//System.out.println("a="+a);
				
				
			if(orderInvoice.equals("Y")){	
				if(a>0 && b>0 && c>0){
					conn.commit();
					//System.out.println("删除成功");
				}else{
					conn.rollback();
					System.out.println("删除失败");
				}
			}else{
				if(a>0 && b>0 ){
					conn.commit();
					//System.out.println("删除成功");
				}else{
					conn.rollback();
					System.out.println("删除失败");
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			db.closeConn(conn);
		}
	}
	
	public void updateOrderStatus(Long orderID){//订单状态
		String sql="update T_Order set OrderStatus='Y' where OrderID= "+orderID;
		ps=db.getexecutePs(sql);
		try {
			int a=ps.executeUpdate();
			if(a>0){
				//System.out.println("修改记录");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			db.closeexecutePs(ps);
		}
	}
	
	
	public ArrayList<Order> selectDate(String date){
		String sql=null;
		ArrayList<Order> oal1=new ArrayList();;
		Order o=null;
		//sql="select * from T_Order";
		sql="select * from T_Order where createDate like '%"+date+"%'";
		//System.out.println("date:"+date);
		//System.out.println("sql:"+sql);
		r=db.getexecuteR_Ps(sql);
		try {
			while(r.next()){
				o=new Order();
				o.setOrderID(r.getLong("OrderID"));
				o.setMemberID(r.getLong("MemberID"));
				o.setMemberTureName(r.getString("MemberTrueName"));
				o.setMemberAddress(r.getString("MemberAddress"));
				o.setMemberProvince(r.getString("MemberProvince"));
				o.setMemberCity(r.getString("MemberCity"));
				o.setMemberArea(r.getString("MemberArea"));
				o.setMemberPostcode(r.getString("MemberPostcode"));
				o.setMemberTelephone(r.getString("MemberTelephone"));
				o.setOrderAmount(r.getDouble("OrderAmount"));
				o.setOrderPay(r.getString("OrderPay"));
				o.setOrderInvoice(r.getString("OrderInvoice"));
				o.setOrderCarry(r.getString("OrderCarry"));
				o.setOrderCarryTime(r.getInt("OrderCarryTime"));
				o.setOrderRemark(r.getString("OrderRemark"));
				o.setOrderStatus(r.getString("OrderStatus"));
				o.setGreateDate(r.getString("CreateDate"));
				o.setUpdateDate(r.getString("UpdateDate"));
				oal1.add(o);
				System.out.println("orderID:"+r.getLong("OrderID"));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return oal1;
		}
		
	}
}
