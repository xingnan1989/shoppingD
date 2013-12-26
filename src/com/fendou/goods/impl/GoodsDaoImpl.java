package com.fendou.goods.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fendou.goods.dao.GoodsDao;
import com.fendou.goods.po.T_Goods;
import com.fendou.goods.po.T_GoodsType;
import com.fendou.pagination.po.Pagination;
import com.fendou.system.db.Database;

public class GoodsDaoImpl implements GoodsDao {
	private PreparedStatement ps;
	private ResultSet rs;
	Database db = new Database();
	ArrayList al;
	//娣诲姞澶х被
	public int insert(T_GoodsType type) {
		String sql = "insert into  T_GoodsType() values(null,'"+type.getTypeCode()+"','"+type.getTypeName()+"','"+type.getTypeDesc()+"','n',null,1,'"+type.getCreater()+"',now(),'"+type.getUpdater()+"',now())";
		ps = db.getexecutePs(sql);
		int count = 0;
		try {
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecutePs(ps);
		}
		return count;
	}
	//获得所有没有小类的商品大类个数
	public int getTotalRecord() {
		String sql = "select count(*) as num from T_GoodsType where isLeaf='n'";
		rs = db.getexecuteR_Ps(sql);
		int count = 0;
		try {
			while(rs.next()) {
				count = rs.getInt("num");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return count;
	}
	//获得当前大类的所有子类
	public int getTotalRecordSub(String parentID) {
		String sql = "select count(*) as num from T_GoodsType where isLeaf='y' and  ParentID='"+parentID+"'";
		rs = db.getexecuteR_Ps(sql);
		int count = 0;
		try {
			while(rs.next()) {
				count = rs.getInt("num");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return count;
	}
	//获得当前页的所有商品大类信息
	public ArrayList<T_GoodsType> select(Pagination page) {
//		String sql = "select top "+page.getCurrentPageRecord()+"  TypeName,TypeCode  from T_GoodsType where  isLeaf='n' and TypeID not in (select top "+(page.getCurrentPage()-1)*page.getCurrentPageRecord()+" TypeID from T_GoodsType where  isLeaf='n' order by TypeID desc)order by TypeID desc";		
		String sql = "select TypeName,TypeCode from T_GoodsType where  isLeaf='n' order by TypeID desc limit "+(page.getCurrentPage()-1)*page.getCurrentPageRecord()+","+page.getCurrentPageRecord()+" ";
		System.out.println(sql);
		rs = db.getexecuteR_Ps(sql);
		al = new ArrayList();
		try {
			while(rs.next()) {
				T_GoodsType type =new T_GoodsType();
				type.setTypeName(rs.getString("TypeName"));
				type.setTypeCode(rs.getString("TypeCode"));
				al.add(type);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return al;
	}
	//获得所有当前页的当前大类的所有商品子类信息
	public ArrayList<T_GoodsType> selectSub(Pagination page,String parentID) {
//		String sql = "select top "+page.getCurrentPageRecord()+"  TypeName,TypeCode  from T_GoodsType where  isLeaf='y' and  ParentID='"+parentID+"' and TypeID not in (select top "+(page.getCurrentPage()-1)*page.getCurrentPageRecord()+" TypeID from T_GoodsType order by TypeID desc)order by TypeID desc";
		String sql = "select TypeName,TypeCode  from T_GoodsType where  isLeaf='y' and  ParentID='"+parentID+"'  order by TypeID desc limit "+(page.getCurrentPage()-1)*page.getCurrentPageRecord()+","+page.getCurrentPageRecord()+" ";
		ResultSet rs = db.getexecuteR_Ps(sql);
		rs = db.getexecuteR_Ps(sql);
		al = new ArrayList();
		try {
			while(rs.next()) {
				T_GoodsType type =new T_GoodsType();
				type.setTypeName(rs.getString("TypeName"));
				type.setTypeCode(rs.getString("TypeCode"));
				type.setSuperTypeName(selectSuperName(parentID));
				al.add(type);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//db.closeexecuteR_Ps(rs);
		}
		return al;
	}
	//根据父类ID号获得父类的分类名称
	public String selectSuperName(String parentID) {
		String sql ="select TypeName from T_GoodsType where TypeCode='"+parentID+"'and isLeaf='n'";
		rs = db.getexecuteR_Ps(sql);
		String superTypeName = null;
		try {
			while(rs.next()) {
				superTypeName = rs.getString("TypeName");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return superTypeName;
	}
	//根据父类的ID号获得父类其他信息
	public String selectSubAjax(String parentID) {
		String sql ="select TypeName,TypeCode from T_GoodsType where ParentID='"+parentID+"'and isLeaf='y'";
		rs = db.getexecuteR_Ps(sql);
		String str = "";
		try {
			while(rs.next()) {
				str += rs.getString("TypeCode")+","+rs.getString("TypeName")+"|";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return str;
	}
	//添加大类信息
	public int insertSub(T_GoodsType type) {
		String sql = "insert into  T_GoodsType values(null,'"+type.getTypeCode()+"','"+type.getTypeName()+"','"+type.getTypeDesc()+"','y','"+type.getParentID()+"',0,'"+type.getCreater()+"',now(),'"+type.getUpdater()+"',now())";
		int count = 0;
		ps = db.getexecutePs(sql);
		try {
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecutePs(ps);
		}
		return count;
	}
	//删除大类信息
	public int deleteSub(T_GoodsType type) {
		String sql = "delete from T_GoodsType where isLeaf='y' and TypeCode='"+type.getTypeCode()+"'";
		String sql1 ="delete from T_Goods where T_Goods.TypeCode='"+type.getTypeCode()+"'";
		Connection conn = db.getConn();
		int count = 0;
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			ps = conn.prepareStatement(sql1);
			ps.executeUpdate();
			conn.commit();
			count = 1;
			//conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				count = 0;
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} 
		return count;
	}//
	//根据类别代码获得商品类型
	public T_GoodsType selectSubTypeOne(String typeCode) {
		String sql = "select TypeCode,TypeName,TypeDesc,Creater,CreateDate from T_GoodsType where TypeCode='"+typeCode+"'";
		rs = db.getexecuteR_Ps(sql);
		T_GoodsType type = null;
		try {
			while(rs.next()) {
				type = new T_GoodsType();
				type.setTypeCode(rs.getString("TypeCode"));
				type.setTypeName(rs.getString("TypeName"));
				type.setTypeDesc(rs.getString("TypeDesc"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return type;
	}
	//修改大类信息
	public int updateSubType(T_GoodsType type,String subTypeCode) {
		String sql = "update T_GoodsType set TypeCode='"+type.getTypeCode()+"',TypeName='"+type.getTypeName()+"',TypeDesc='"+type.getTypeDesc()+"',Updater='"+type.getUpdater()+"',UpdateDate=now() where TypeCode='"+subTypeCode+"' and isLeaf='y'";
		ps = db.getexecutePs(sql);
		int count = 0;
		try {
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecutePs(ps);
		}
		return count;
	}
	//根据大类代码修改大类信息
	public T_GoodsType selectSuperTypeOne(String superTypeCode) {
		String sql = "select TypeCode,TypeName,TypeDesc,Creater,CreateDate from T_GoodsType where TypeCode='"+superTypeCode+"'";
		rs = db.getexecuteR_Ps(sql);
		T_GoodsType type = null;
		try {
			while(rs.next()) {
				type = new T_GoodsType();
				type.setTypeCode(rs.getString("TypeCode"));
				type.setTypeName(rs.getString("TypeName"));
				type.setTypeDesc(rs.getString("TypeDesc"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return type;
	}
	//澶х被淇敼
	public int updateSuperType(T_GoodsType type,String superTypeCode) {
		//System.out.println(superTypeCode);
		String sql = "update T_GoodsType set TypeCode='"+type.getTypeCode()+"',TypeName='"+type.getTypeName()+"',TypeDesc='"+type.getTypeDesc()+"',Updater='"+type.getUpdater()+"',UpdateDate=now() where TypeCode='"+superTypeCode+"' and isLeaf='n'";
		ps = db.getexecutePs(sql);
		int count = 0;
		try {
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecutePs(ps);
		}
		return count;
	}
	//删除一个大类
	public int deleteSuperType(String superTypeCode) {
		String sql = "delete  from T_GoodsType where TypeCode='"+superTypeCode+"' or ParentID='"+superTypeCode+"'";
		String sql1 = "delete from  T_Goods where TypeCode in (select TypeCode  from T_GoodsType where ParentID='"+superTypeCode+"')";
		Connection conn = db.getConn();
		//int count = 0;
		//int temp = 0;
		int num = 0;
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql1);
			ps.executeUpdate();
			db.closePs(ps);
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			db.closePs(ps);
			//if(count > 0 && temp > 0) {
				conn.commit();
				num = 1;
			//} else {
				//conn.rollback();
			//} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				num = 0;
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} 
		return num;
		//return count;
	}
	//插入商品信息
	public int insertGoods(T_Goods goods) {
		String goodsIntroduce=goods.getGoodsIntroduce();
		if(goods.getGoodsIntroduce().equals("")){
			goodsIntroduce="请书写商品信息";
		}
		String sql = "insert into T_Goods values(null,'"+goods.getGoodsName()+"','"+goodsIntroduce+"',"+goods.getGoodsNormalPrice()+","+goods.getGoodsMemberPrice()+","+goods.getGoodsRebate()+",'"+goods.getTypeCode()+"',0,null,'"+goods.getIsSale()+"','y','"+goods.getGoodsPicture()+"','"+goods.getCreater()+"',now(),'"+goods.getUpdater()+"',now(),0,0) ";
//		System.out.println(sql);
		ps = db.getexecutePs(sql);
		int count = 0;
		try {
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecutePs(ps);
		}
		return count;
	}
	//显示当前页商品信息
	public ArrayList selectGoods(Pagination page) {
//		String sql = "select top "+page.getCurrentPageRecord()+" GoodsID,GoodsName,GoodsMemberPrice,TypeCode,GoodsNumber,BuyGoodsNumber,isSale,isValid from T_Goods where GoodsID not in(select top "+(page.getCurrentPage()-1)*page.getCurrentPageRecord()+" GoodsID from T_Goods order by GoodsID desc) order by GoodsID desc";
		String sql = "select  GoodsID,GoodsName,GoodsMemberPrice,TypeCode,GoodsNumber,BuyGoodsNumber,isSale,isValid from T_Goods order by GoodsID desc limit  "+(page.getCurrentPage()-1)*page.getCurrentPageRecord()+", "+page.getCurrentPageRecord()+"";
		ResultSet rs = db.getexecuteR_Ps(sql);
		al = new ArrayList();
		try {
			while(rs.next()) {
				T_Goods goods = new T_Goods();
				goods.setGoodsID(rs.getLong("GoodsID"));
				goods.setGoodsName(rs.getString("GoodsName"));
				goods.setGoodsMemberPrice(rs.getDouble("GoodsMemberPrice"));
				goods.setGoodsNumber(rs.getInt("GoodsNumber"));
				goods.setBuyGoodsNumber(rs.getInt("BuyGoodsNumber"));
				goods.setIsSale(rs.getString("isSale"));
				goods.setIsValid(rs.getString("isValid"));
				String typeCode = rs.getString("TypeCode");
				goods.setTypeName(getTypeName(typeCode));
				al.add(goods);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return al;
	}
	//显示类别名称
	public String getTypeName(String TypeCode) {
		String sql = "select TypeName from T_GoodsType where TypeCode='"+TypeCode+"' and isLeaf='y'";
		rs = db.getexecuteR_Ps(sql);
		String typeName = "";
		try {
			while(rs.next()) {
				typeName = rs.getString("TypeName");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return typeName;
	}
	//获得所有商品记录数
	public int getTotalGoodsRecord() {
		String sql = "select count(*) as num from T_Goods";
		rs = db.getexecuteR_Ps(sql);
		int num = 0;
		try {
			while(rs.next()) {
				num = rs.getInt("num");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return num;
	}
	//返回商品详细列表
	public T_Goods selectGoodsDetail(String goodsID) {
		String sql = "select GoodsID,GoodsName,GoodsIntroduce,GoodsNormalPrice,GoodsMemberPrice,GoodsRebate,isSale,GoodsPicture,TypeCode,GoodsNumber,Creater,CreateDate from T_Goods where GoodsID="+goodsID;
		ResultSet rs = db.getexecuteR_Ps(sql);
		T_Goods goods = new T_Goods();
		try {
			while(rs.next()) {
				goods.setGoodsID(rs.getLong("GoodsID"));
				goods.setGoodsName(rs.getString("GoodsName"));
				goods.setGoodsIntroduce(rs.getString("GoodsIntroduce"));
				goods.setGoodsNormalPrice(rs.getDouble("GoodsNormalPrice"));
				goods.setGoodsMemberPrice(rs.getDouble("GoodsMemberPrice"));
				goods.setGoodsRebate(rs.getFloat("GoodsRebate"));
				goods.setIsSale(rs.getString("isSale"));
				goods.setGoodsPicture(rs.getString("GoodsPicture"));
				String typeCode = rs.getString("TypeCode");
				goods.setTypeCode(typeCode);
				ArrayList al = getSuperCodeName(typeCode);
				goods.setSuperTypeCode(al.get(0).toString());
				goods.setSuperTypeName(al.get(1).toString());
				goods.setTypeName(getTypeName(typeCode));
				goods.setGoodsNumber(rs.getInt("GoodsNumber"));
				goods.setCreater(rs.getString("Creater"));
				goods.setCreateDate(rs.getString("CreateDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return goods;
	}
	//获得大类名称表
	public ArrayList getSuperCodeName(String typeCode) {
		String sql = "select TypeCode,TypeName from T_GoodsType where TypeCode in (select ParentID from T_GoodsType where TypeCode='"+typeCode+"')and isLeaf='n'";
		al = new ArrayList();
		rs = db.getexecuteR_Ps(sql);
		try {
			while(rs.next()) {
				al.add(rs.getString("TypeCode"));
				al.add(rs.getString("TypeName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return al;
	}
	//获得该商品的类别号
	public String  getTypeCode(String goodsID) {
		String sql = "select TypeCode from T_Goods where GoodsID="+goodsID;
		rs = db.getexecuteR_Ps(sql);
		String typeCode = "";
		try {
			while(rs.next()) {
				typeCode = rs.getString("TypeCode");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return typeCode;
	}
	//修改商品
	public int updateGoods(T_Goods goods) {
		String goodsIntroduce=goods.getGoodsIntroduce();
		//System.out.println("goodsIntroduce:"+goodsIntroduce);
		if(goods.getGoodsIntroduce().equals("")){
			goodsIntroduce="请输入商品信息描述";
		}
		//System.out.println("goodsIntroduce:(if鍚�"+goodsIntroduce);
		String sql = "update T_Goods set  GoodsName='"+goods.getGoodsName()+"',GoodsIntroduce='"+goodsIntroduce+"',GoodsNormalPrice="+goods.getGoodsNormalPrice()+",GoodsMemberPrice="+goods.getGoodsMemberPrice()+",GoodsRebate="+goods.getGoodsRebate()+",isSale='"+goods.getIsSale()+"',GoodsPicture='"+goods.getGoodsPicture()+"',TypeCode='"+goods.getTypeCode()+"',Updater='"+goods.getUpdater()+"',UpdateDate=now() where GoodsID="+goods.getGoodsID();
		ps = db.getexecutePs(sql);
		int count = 0;
		try {
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecutePs(ps);
		}
		return count;
	}
	//修改商品信息
	public int updateGoods1(T_Goods goods) {
		String goodsIntroduce=goods.getGoodsIntroduce();
		//System.out.println("goodsIntroduce:"+goodsIntroduce);
		if(goods.getGoodsIntroduce().equals("")){
			goodsIntroduce="请输入商品信息描述";
		}
		//System.out.println("goodsIntroduce:(if鍚�"+goodsIntroduce);
		String sql = "update T_Goods set  GoodsName='"+goods.getGoodsName()+"',GoodsIntroduce='"+goodsIntroduce+"',GoodsNormalPrice="+goods.getGoodsNormalPrice()+",GoodsMemberPrice="+goods.getGoodsMemberPrice()+",GoodsRebate="+goods.getGoodsRebate()+",isSale='"+goods.getIsSale()+"',TypeCode='"+goods.getTypeCode()+"',Updater='"+goods.getUpdater()+"',UpdateDate=now() where GoodsID="+goods.getGoodsID();
		ps = db.getexecutePs(sql);
		int count = 0;
		try {
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecutePs(ps);
		}
		return count;
	}
	//获得子类的代号列表
	public ArrayList getSubCodeName(String typeCode) {
		//System.out.println(typeCode);
		String sql = "select TypeCode,TypeName from T_GoodsType where ParentID in (select ParentID from T_GoodsType where TypeCode='"+typeCode+"') and isLeaf='y'";
		al = new ArrayList();
		rs = db.getexecuteR_Ps(sql);
		try {
			while(rs.next()) {
				T_Goods goods = new T_Goods();
				goods.setTypeCode(rs.getString("TypeCode"));
				goods.setTypeName(rs.getString("TypeName"));
				al.add(goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return al;
	}
	//修改商品状态
	public int goodsInvalidata(String goodsID,String state) {
		String sql="update T_Goods set isValid='"+state+"'where GoodsID="+goodsID;
		ps = db.getexecutePs(sql);
		int count = 0;
		try {
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecutePs(ps);
		}
		return count;
	}
	//鏌ヨ澶х被鍚嶇О鍜屽ぇ绫荤紪鍙�
	public ArrayList<T_GoodsType> select() {
		String sql = "select TypeName,TypeCode  from T_GoodsType where isLeaf='n'";
		rs = db.getexecuteR_Ps(sql);
		al = new ArrayList();
		try {
			while(rs.next()) {
				T_GoodsType type =new T_GoodsType();
				type.setTypeName(rs.getString("TypeName"));
				type.setTypeCode(rs.getString("TypeCode"));
				al.add(type);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return al;
	}
	//琛ヨ揣淇敼鏁版嵁搴�
	public int repairGoods(int updateGoodsNumber,String goodsId) {
		String sql="update T_Goods set GoodsNumber="+updateGoodsNumber+" where GoodsID="+goodsId;
		int count = 0;
		ps = db.getexecutePs(sql);
		try {
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecutePs(ps);
		}
		return count;
	}
	//琛ヨ揣鏌ヨ
	public String  repairGoods(String goodsId) {
		String sql="select GoodsNumber from T_Goods where GoodsID="+goodsId;
		rs = db.getexecuteR_Ps(sql);
		String goodsGrade = "";
		try {
			while(rs.next()) {
				goodsGrade = rs.getString("GoodsNumber");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return goodsGrade;
	}
	//查询商品信息
	public ArrayList seach(String key,String typeID,Pagination page) {
		String sql = "";
		if(key=="") {
//		sql = "select top "+page.getCurrentPageRecord()+" GoodsID,GoodsName,GoodsMemberPrice,TypeCode,GoodsNumber,BuyGoodsNumber,isSale,isValid from T_Goods where GoodsID not in (select top "+(page.getCurrentPage()-1)*page.getCurrentPageRecord()+" GoodsID from T_Goods where TypeCode='"+typeID+"' order by GoodsID desc) and TypeCode='"+typeID+"' order by GoodsID desc";
			sql = "select  GoodsID,GoodsName,GoodsMemberPrice,TypeCode,GoodsNumber,BuyGoodsNumber,isSale,isValid from T_Goods where TypeCode='"+typeID+"' order by GoodsID desc limit "+(page.getCurrentPage()-1)*page.getCurrentPageRecord()+" ,"+page.getCurrentPageRecord()+"";
		} else {
//			sql = "select top "+page.getCurrentPageRecord()+" GoodsID,GoodsName,GoodsMemberPrice,TypeCode,GoodsNumber,BuyGoodsNumber,isSale,isValid from T_Goods where GoodsID not in (select top "+(page.getCurrentPage()-1)*page.getCurrentPageRecord()+" GoodsID from T_Goods where TypeCode='"+typeID+"' and GoodsName like '%"+key+"%' or GoodsIntroduce like '%"+key+"%' order by GoodsID desc) and TypeCode='"+typeID+"' and GoodsName like '%"+key+"%' or GoodsIntroduce like '%"+key+"%' order by GoodsID desc";
			sql = "select  GoodsID,GoodsName,GoodsMemberPrice,TypeCode,GoodsNumber,BuyGoodsNumber,isSale,isValid from T_Goods where TypeCode='"+typeID+"' and GoodsName like '%"+key+"%' or GoodsIntroduce like '%"+key+"%' order by GoodsID desc limit "+(page.getCurrentPage()-1)*page.getCurrentPageRecord()+" ,"+page.getCurrentPageRecord()+"";
		}
		ResultSet rs = db.getexecuteR_Ps(sql);
		al = new ArrayList();
		try {
			while(rs.next()) {
				T_Goods goods = new T_Goods();
				goods.setGoodsID(rs.getLong("GoodsID"));
				goods.setGoodsName(rs.getString("GoodsName"));
				goods.setGoodsMemberPrice(rs.getDouble("GoodsMemberPrice"));
				goods.setGoodsNumber(rs.getInt("GoodsNumber"));
				goods.setBuyGoodsNumber(rs.getInt("BuyGoodsNumber"));
				goods.setIsSale(rs.getString("isSale"));
				goods.setIsValid(rs.getString("isValid"));
				String typeCode = rs.getString("TypeCode");
				goods.setTypeName(getTypeName(typeCode));
				al.add(goods);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return al;
	}
	//查询商品个数
	public int seachTotalRecord(String key,String typeID) {
		String sql = "";
		if(key=="") {
			sql = "select count(*) as num from T_Goods where TypeCode='"+typeID+"'";
		} else {
			 sql ="select count(*) as num from T_Goods where TypeCode='"+typeID+"' and GoodsName like '%"+key+"%' or GoodsIntroduce like '%"+key+"%'";
		}
		
		rs = db.getexecuteR_Ps(sql);
		int num = 0;
		try {
			while(rs.next()) {
				num = rs.getInt("num");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return num;
	}
	//获得特价商品
	public ArrayList indexTejiaGoods(int count) {
//		String sql ="select top  "+count+"  GoodsID,GoodsName,GoodsNormalPrice,GoodsMemberPrice,GoodsPicture  from T_Goods where isSale='y' and isValid='y' order by GoodsID desc";
		String sql ="select GoodsID,GoodsName,GoodsNormalPrice,GoodsMemberPrice,GoodsPicture  from T_Goods where isSale='y' and isValid='y' order by GoodsID desc limit 0,"+count+"";
		rs = db.getexecuteR_Ps(sql);
		al = new ArrayList();
		try {
			while(rs.next()) {
				T_Goods goods = new T_Goods();
				goods.setGoodsID(rs.getLong("GoodsID"));
				goods.setGoodsName(rs.getString("GoodsName"));
				goods.setGoodsNormalPrice(rs.getDouble("GoodsNormalPrice"));
				goods.setGoodsMemberPrice(rs.getDouble("GoodsMemberPrice"));
				goods.setGoodsPicture(rs.getString("GoodsPicture"));
				al.add(goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return al;
	} 
	//获得新品上市列表
	public ArrayList indexNewGoods(int count) {
//		String sql ="select top "+count+" GoodsID,GoodsName,GoodsMemberPrice,GoodsRebate,GoodsPicture  from T_Goods where  isValid='y' order by GoodsID desc";
		String sql ="select  GoodsID,GoodsName,GoodsMemberPrice,GoodsRebate,GoodsPicture  from T_Goods where  isValid='y' order by GoodsID desc limit 0,"+count+"";
		rs = db.getexecuteR_Ps(sql);
		al = new ArrayList();
		try {
			while(rs.next()) {
				T_Goods goods = new T_Goods();
				goods.setGoodsID(rs.getLong("GoodsID"));
				goods.setGoodsName(rs.getString("GoodsName"));
				goods.setGoodsMemberPrice(rs.getDouble("GoodsMemberPrice"));
				goods.setGoodsRebate(rs.getFloat("GoodsRebate"));
				goods.setGoodsPicture(rs.getString("GoodsPicture"));
				al.add(goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return al;
	}
	//判断大类是否存在
	public boolean superCodeAddAjax(String typeCode) {
		String sql = "select TypeCode from T_GoodsType where isLeaf='n' and TypeCode='"+typeCode+"'";
		rs = db.getexecuteR_Ps(sql);
		boolean flag = false;
		try {
			while(rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return flag;
	}
	//判断子类是否存在
	public boolean subCodeAddAjax(String typeCode) {
		String sql = "select TypeCode from T_GoodsType where isLeaf='y' and TypeCode='"+typeCode+"'";
		rs = db.getexecuteR_Ps(sql);
		boolean flag = false;
		try {
			while(rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return flag;
	}
	//修改大类
	public ArrayList superCodeUpdateAjax(String typeCode) {
		String sql = "select TypeCode from t_GoodsType where isLeaf='n' and TypeCode='"+typeCode+"'";
		rs = db.getexecuteR_Ps(sql);
		String code = "";
		boolean flag = false;
		al = new ArrayList();
		try {
			while(rs.next()) {
				code = rs.getString("TypeCode");
				flag = true;
			}
			al.add(flag);
			al.add(code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return al;
	}
	//获得已卖出去的商品列表
	public ArrayList saleGoods(Pagination page) {
//		String sql ="select top "+page.getCurrentPageRecord()+" GoodsID,GoodsName,GoodsNormalPrice,GoodsMemberPrice,GoodsRebate,GoodsPicture  from T_Goods where GoodsID not in (select top "+(page.getCurrentPage()-1)*page.getCurrentPageRecord()+" GoodsID from T_Goods where isSale='y' and isValid='y' order by GoodsID desc) and isSale='y' and isValid='y' order by GoodsID desc";
		String sql ="select GoodsID,GoodsName,GoodsNormalPrice,GoodsMemberPrice,GoodsRebate,GoodsPicture  from T_Goods where isSale='y' and isValid='y' order by GoodsID desc limit "+(page.getCurrentPage()-1)*page.getCurrentPageRecord()+" ,"+page.getCurrentPageRecord()+"";
		rs = db.getexecuteR_Ps(sql);
		al = new ArrayList();
		T_Goods goods =null;
		try {
			while(rs.next()) {
				goods= new T_Goods();
				goods.setGoodsID(rs.getLong("GoodsID"));
				goods.setGoodsName(rs.getString("GoodsName"));
				goods.setGoodsNormalPrice(rs.getDouble("GoodsNormalPrice"));
				goods.setGoodsMemberPrice(rs.getDouble("GoodsMemberPrice"));
				//System.out.println("GoodsRebate:"+rs.getFloat("GoodsRebate"));
				goods.setGoodsRebate(rs.getFloat("GoodsRebate"));
				goods.setGoodsPicture(rs.getString("GoodsPicture"));
				al.add(goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return al;
	} 
	//获得所有特价商品
	public int totalTejiaGoods() {
		String sql = "select count(*) as num from T_Goods where isSale='y' and isValid='y'";
		int num = 0;
		rs = db.getexecuteR_Ps(sql);
		try {
			while(rs.next()) {
				num = rs.getInt("num");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return num;
	}
	//当前页的新品上市列表
	public ArrayList newGoods(Pagination page) {
//		String sql ="select top "+page.getCurrentPageRecord()+" GoodsID,GoodsName,GoodsMemberPrice,GoodsRebate,GoodsNumber,GoodsPicture  from T_Goods where GoodsID not in (select top "+(page.getCurrentPage()-1)*page.getCurrentPageRecord()+" GoodsID from T_Goods where  isValid='y' and datediff(day,UpdateDate,now())<30 order by GoodsID desc) and isValid='y' and datediff(day,UpdateDate,now())<30 order by GoodsID desc";
		String sql ="select  GoodsID,GoodsName,GoodsMemberPrice,GoodsRebate,GoodsNumber,GoodsPicture  from T_Goods where isValid='y' and datediff(UpdateDate,now())<30 order by GoodsID desc limit  "+(page.getCurrentPage()-1)*page.getCurrentPageRecord()+" ,"+page.getCurrentPageRecord()+"";
		rs = db.getexecuteR_Ps(sql);
		al = new ArrayList();
		try {
			while(rs.next()) {
				T_Goods goods = new T_Goods();
				goods.setGoodsID(rs.getLong("GoodsID"));
				goods.setGoodsName(rs.getString("GoodsName"));
				goods.setGoodsMemberPrice(rs.getDouble("GoodsMemberPrice"));
				goods.setGoodsRebate(rs.getFloat("GoodsRebate"));
				goods.setGoodsNumber(rs.getInt("GoodsNumber"));
				goods.setGoodsPicture(rs.getString("GoodsPicture"));
				al.add(goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return al;
	}
	//获得新品上市个数
	public int totalNewGoods() {
		String sql = "select count(*) as num from T_Goods where datediff(UpdateDate,now())<30 and isValid='y'";
		rs = db.getexecuteR_Ps(sql);
		int num = 0;
		try {
			while(rs.next()) {
				num = rs.getInt("num");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return num;
	}
	//类别索引
	public ArrayList indexSeach() {
		String sql = "select TypeName,TypeCode  from T_GoodsType where  isLeaf='n'";		
		rs = db.getexecuteR_Ps(sql);
		al = new ArrayList();
		try {
			while(rs.next()) {
				T_GoodsType type =new T_GoodsType();
				type.setTypeName(rs.getString("TypeName"));
				type.setTypeCode(rs.getString("TypeCode"));
				al.add(type);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return al;
	}
	//返回搜索结果
	public ArrayList indexSeachResult(String key,Pagination page,String superTypeCode) {
		String sql = "";
		if(key=="") {
//			sql = "select top "+page.getCurrentPageRecord()+" GoodsID,GoodsName,GoodsMemberPrice,GoodsRebate,GoodsNumber,GoodsPicture from T_Goods where GoodsID not in (select top "+(page.getCurrentPage()-1)*page.getCurrentPageRecord()+" GoodsID from T_Goods where TypeCode in (select TypeCode from T_GoodsType where ParentID='"+superTypeCode+"') order by GoodsID desc) and  TypeCode in (select TypeCode from T_GoodsType where ParentID='"+superTypeCode+"') order by GoodsID desc";
			sql = "select GoodsID,GoodsName,GoodsMemberPrice,GoodsRebate,GoodsNumber,GoodsPicture from T_Goods where  TypeCode in (select TypeCode from T_GoodsType where ParentID='"+superTypeCode+"') order by GoodsID desc limit  "+(page.getCurrentPage()-1)*page.getCurrentPageRecord()+" ,"+page.getCurrentPageRecord()+"";
		} else {
//			sql = "select top "+page.getCurrentPageRecord()+" GoodsID,GoodsName,GoodsMemberPrice,GoodsRebate,GoodsNumber,GoodsPicture from T_Goods where GoodsID not in (select top "+(page.getCurrentPage()-1)*page.getCurrentPageRecord()+" GoodsID from T_Goods where TypeCode in (select TypeCode from T_GoodsType where ParentID='"+superTypeCode+"') and  GoodsName like '%"+key+"%' order by GoodsID desc) and  GoodsName like '%"+key+"%' and TypeCode in (select TypeCode from T_GoodsType where ParentID='"+superTypeCode+"') order by GoodsID desc";
			sql = "select GoodsID,GoodsName,GoodsMemberPrice,GoodsRebate,GoodsNumber,GoodsPicture from T_Goods where  GoodsName like '%"+key+"%' and TypeCode in (select TypeCode from T_GoodsType where ParentID='"+superTypeCode+"') order by GoodsID desc limit  "+(page.getCurrentPage()-1)*page.getCurrentPageRecord()+" ,"+page.getCurrentPageRecord()+"";
			
		}
		rs = db.getexecuteR_Ps(sql);
		al = new ArrayList();
		try {
			while(rs.next()) {
				T_Goods goods = new T_Goods();
				goods.setGoodsID(rs.getLong("GoodsID"));
				goods.setGoodsName(rs.getString("GoodsName"));
				goods.setGoodsMemberPrice(rs.getDouble("GoodsMemberPrice"));
				goods.setGoodsRebate(rs.getFloat("GoodsRebate"));
				goods.setGoodsNumber(rs.getInt("GoodsNumber"));
				goods.setGoodsPicture(rs.getString("GoodsPicture"));
				al.add(goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}
	//获得总的记录个数
	public int totalRecordIndexSeachResult(String key,String superTypeCode) {
		String sql = "";
		if(key=="") {
			sql = "select count(*) as num  from T_Goods where TypeCode in (select TypeCode from T_GoodsType where ParentID='"+superTypeCode+"')";
		} else {
			sql = "select count(*) as num  from T_Goods where TypeCode in (select TypeCode from T_GoodsType where ParentID='"+superTypeCode+"') and GoodsName like '%"+key+"%'";
		}
		rs = db.getexecuteR_Ps(sql);
		int num = 0;
		try {
			while(rs.next()) {
				num = rs.getInt("num");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	//根据类别代号获得类别名称
	public String getSuperName(String superTypeCode) {
		String sql = "select TypeName from T_GoodsType where TypeCode='"+superTypeCode+"'";
		rs = db.getexecuteR_Ps(sql);
		String typeName = "";
		try {
			while(rs.next()) {
				typeName = rs.getString("TypeName");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return typeName;
	}
	//返回所有商品类型
	public ArrayList selectGoodsType() {
		String sql = "select * from T_GoodsType";
		rs = db.getexecuteR_Ps(sql);
		al = new ArrayList();
		try {
			while(rs.next()) {
				T_GoodsType type = new T_GoodsType();
				type.setTypeCode(rs.getString("TypeCode"));
				type.setTypeName(rs.getString("TypeName"));
				type.setIsLeaf(rs.getString("isLeaf"));
				type.setParentID(rs.getString("ParentID"));
				al.add(type);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}
	//获得该子类下的所有商品
	public ArrayList selectGoods(String subTypeCode) {
		String sql = "select * from T_Goods where TypeCode='"+subTypeCode+"'";
		rs = db.getexecuteR_Ps(sql);
		al = new ArrayList();
		try {
			while(rs.next()) {
				T_Goods goods = new T_Goods();
				goods.setGoodsID(rs.getLong("GoodsID"));
				goods.setGoodsName(rs.getString("GoodsName"));
				goods.setGoodsMemberPrice(rs.getDouble("GoodsMemberPrice"));
				goods.setBuyGoodsNumber(rs.getInt("GoodsNumber"));
				al.add(goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}
	//根据类别代号获得类别名称
	public String subNameShow(String subTypeCode) {
		String sql = "select TypeName from T_GoodsType where TypeCode='"+subTypeCode+"' and isLeaf='y'";
		rs = db.getexecuteR_Ps(sql);
		String typeName = "";
		try {
			while(rs.next()) {
				typeName = rs.getString("TypeName");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return typeName;
	}
	//根据子类代号获得大类名称
	public String superNameShow(String subTypeCode) {
		String sql = "select TypeName from T_GoodsType where TypeCode=(select ParentID from T_GoodsType where TypeCode='"+subTypeCode+"')";
		rs = db.getexecuteR_Ps(sql);
		String typeName = "";
		try {
			while(rs.next()) {
				typeName = rs.getString("TypeName");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return typeName;
	}
	//获得没有子类的大类信息
	public ArrayList<T_GoodsType> selectSuperTypeGoods() {
		String sql = "select TypeName,TypeCode  from T_GoodsType where  isLeaf='n'";		
		rs = db.getexecuteR_Ps(sql);
		al = new ArrayList();
		try {
			while(rs.next()) {
				T_GoodsType type =new T_GoodsType();
				type.setTypeName(rs.getString("TypeName"));
				type.setTypeCode(rs.getString("TypeCode"));
				al.add(type);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeexecuteR_Ps(rs);
		}
		return al;
	}
}
