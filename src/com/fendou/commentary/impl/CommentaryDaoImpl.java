package com.fendou.commentary.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fendou.commentary.dao.CommentaryDao;
import com.fendou.commentary.po.Comment;
import com.fendou.pagination.po.Pagination;
import com.fendou.system.db.Database;

public class CommentaryDaoImpl implements CommentaryDao{
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet r;
	Database db = new Database();
	public void insertComment(Comment comment){
		String sql="insert into T_Comment values(null,'"+comment.getCommentUserName()+"',"+comment.getCommentRank()+",'"+comment.getCommentContent()+"',now(),"+comment.getGoodsID()+")";
		//System.out.println(sql);
		ps=db.getexecutePs(sql);
		try {
			int a=ps.executeUpdate();
			if(a<=0){
				System.out.println("插入失败！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecutePs(ps);
		}
	}
	
	public ArrayList<Comment> selectComment(long goodsID){
		String sql="select * from T_Comment where GoodsID="+goodsID;
		//System.out.println("impl:"+goodsID);
		ArrayList<Comment> commental=new ArrayList();
		Comment comment=null;
		r=db.getexecuteR_Ps(sql);
		try {
			while(r.next()){
				comment=new Comment();
				comment.setCommentID(r.getLong("CommentID"));
				comment.setCommentUserName(r.getString("CommentUserName"));
				comment.setCommentRank(r.getInt("CommentRank"));
				comment.setCommentContent(r.getString("CommentContent"));
				comment.setCommentData(r.getString("CommentData"));
				commental.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeexecuteR_Ps(r);
		}
		return commental;
	}
	
	public ArrayList<Comment> selectCommentPagination(Pagination page,long goodsID){
		int totalPage=page.getTotalPage();//总的页面数
		int totalRecord=page.getTotalRecord();//总的记录个数
		int currentPage=page.getCurrentPage();//当前页面
		int currentPageRecord = page.getCurrentPageRecord();//当前页总的记录个数
//		String sql="select top "+currentPageRecord+"* from T_Comment where CommentID not in(select top "+(currentPage-1)*currentPageRecord+" CommentID from T_Comment where GoodsID="+goodsID+" order by CommentID desc) and GoodsID="+goodsID+"order by CommentID desc";
		String sql="select * from T_Comment order by CommentID desc limit "+(currentPage-1)*currentPageRecord+","+currentPageRecord+"";
		//System.out.println(sql);
		ArrayList<Comment> alPagination =new ArrayList();
		Comment comment=null;
		r=db.getexecuteR_Ps(sql);
		try {
			while(r.next()){
				comment=new Comment();
				comment.setCommentID(r.getLong("CommentID"));
				comment.setCommentUserName(r.getString("CommentUserName"));
				comment.setCommentRank(r.getInt("CommentRank"));
				comment.setCommentContent(r.getString("CommentContent"));
				comment.setCommentData(r.getString("CommentData"));
				alPagination.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return alPagination;
	}
}
