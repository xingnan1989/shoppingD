package com.fendou.commentary.dao;

import java.util.ArrayList;

import com.fendou.commentary.po.Comment;
import com.fendou.pagination.po.Pagination;

public interface CommentaryDao {
	public void insertComment(Comment comment);//插入一条留言内容
	public ArrayList<Comment> selectComment(long goodsID);//获得该商品的所有留言内容
	//将所有留言内容分页处理
	public ArrayList<Comment> selectCommentPagination(Pagination page,long goodsID);
}
