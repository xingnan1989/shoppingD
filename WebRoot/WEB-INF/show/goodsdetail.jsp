<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<title>商品详细页面</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" type="text/javascript" src="JS/goods.js"></script>
<script language="javascript" type="text/javascript" src="JS/individuality.js"></script>
	</head>
	<script language="javascript" type="text/javascript" src="JS/order.js"></script>
	<script language="javascript" type="text/javascript" src="JS/ordervalidate.js"></script>
	<script language="javascript" type="text/javascript" src="JS/comment.js"></script>
	<body>
		<table width="790" border="0" cellspacing="0" cellpadding="0"
			align="center">
			<tr>
				<td class="tableBorder">
					<!--导航条-->
					<%@ include file="navigation.jsp"%>
					<!--导航条结束-->
					<table width="790" height="236" border="0" align="center"
						cellpadding="0" cellspacing="0">
						<tr>
							<td width="182" height="182" valign="top">
								<!--左侧框架-->

								<%@ include file="left.jsp"%>
								<!--左侧框架结束-->
							</td>
							<td valign="top">
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td height="33" background="images/shop_12.gif"></td>
										<td width="505" height="33" align="right" valign="middle"
											background="images/shop_12.gif">
											<table width="100%" height="24" border="0" cellpadding="0"
												cellspacing="0">
												<tr>
													<td height="8"></td>
												</tr>
												<tr>
													<td align="right" class="word_green">
													<marquee direction="left" scrollamount="1" scrolldelay="1" onMouseOver="this.stop();" onMouseOut="this.start();">
														购买商品请先<a href="" style="color: #FF0000;">登录 </a><a href="register.jsp" class="word_green">[新用户注册]</a>
													</marquee>
													</td>
												</tr>
											</table>
										</td>
										<td width="10" background="images/shop_12.gif">
											&nbsp;
										</td>
									</tr>
									<tr>
										<td width="93" height="50" background="images/shop_15.gif">
											&nbsp;
										</td>
										<td colspan="2" background="images/shop_16.gif">
											<!--搜索框-->
											<%@ include file="search.jsp"%>
											<!--搜索框结束-->
										</td>
									</tr>
								</table>
								<!-- 添加 -->
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="189" valign="top">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td height="80" background="images/center01.gif">
														&nbsp;
													</td>
												</tr>
												<tr valign="top">
													<td height="134" align="center">
														<table width="96%" height="79" border="0" cellpadding="0"
															cellspacing="0" class="noborder">
															<tr>
																<td colspan="2" class="font">
																	${goodsdetail.goodsName }
																</td>
															</tr>
															<tr>
																<td width="37%" height="95" rowspan="4" align="center">
																	<img src="${goodsdetail.goodsPicture }" width="150"
																		height="100">
																</td>
																<td width="63%" style="text-decoration: line-through;">
																	市场价：￥${goodsdetail.goodsNormalPrice }
																</td>
															</tr>
															<tr>
																<td style="color: #FF0000">
																	商城价：￥${goodsdetail.goodsMemberPrice }(
																	<fmt:formatNumber pattern="#.#"
																		value="${goodsdetail.goodsRebate*10}"></fmt:formatNumber>
																	折)
																</td>
															</tr>
															<tr>
																<td>
																	
																	<c:if test="${memberID ne null}">
																		<input type="button" class="btn_grey" value="购买" onclick="goods(${id })">
																		&nbsp;&nbsp;
																		<input type="button" class="btn_grey" value="收藏" onclick="individuality(${id})" >
																	</c:if>
																	<c:if test="${memberID eq null}">
																		<input type="button" class="btn_grey" value="购买" onclick="alert('请先登录后再购买')">
											                      		<input type="button" class="btn_grey" value="收藏" onclick="alert('请先登录后再收藏')">
																	</c:if>
																</td>
															</tr>
															<c:if test="${goodsdetail.goodsNumber == 0 }">
																<tr>
																	<td height="27">
																		现在暂时无货
																	</td>
																</tr>
															</c:if>
															<c:if test="${goodsdetail.goodsNumber != 0 }">
																<tr>
																	<td height="27">
																		现在有货
																	</td>
																</tr>
															</c:if>
														</table>
														<table width="96%" border="0" cellpadding="0"
															cellspacing="0" class="noborder">
															<tr>
																<td colspan="2">
																	<hr align="center" size="1">
																</td>
															</tr>
															<tr>
																<td colspan="2" class="font1">
																	内容简介
																</td>
															</tr>
															<tr>
																<td colspan="2">
																	&nbsp;&nbsp;${goodsdetail.goodsIntroduce }
																</td>
															</tr>
															<tr>
																<td colspan="2">
																	<hr align="center" size="1">
																</td>
															</tr>
															<tr>
																<td class="font1" width="20%" colspan="2">
																	用户评论
																	<br/>
																	<br/>
																	<br/>
																</td>
															</tr>
															<c:if test="${falg == 0}">
															<tr>
																<td  width="20%" colspan="2">
																	&nbsp;暂无评论......
																	<br/>
																	<br/>
																	<br/>
																</td>
															</tr>
															</c:if>
															<c:if test="${falg != 0}">
															<c:forEach items="${commental}" var="commental">
															<tr>
																<td colspan="2">
																	会员：${commental.commentUserName }&nbsp;&nbsp;&nbsp;&nbsp;
																	时间：
																	<fmt:parseDate value="${commental.commentData}" pattern="yyyy-MM-dd HH:mm:ss" var="updateDate"/>
																	<fmt:formatDate value="${updateDate}" pattern="yyyy年MM月dd日 HH:mm" type="both" timeStyle="full"/>
																	<br/>
																	<br/>
																	<br/>
																</td>
															</tr>
															<tr>
																<td colspan="2">
																	评论:${commental.commentContent }<br/>
																	-------------------------------------------------------------------------
																	------------------------------------------------------------------------
																</td>
															</tr>
															</c:forEach>
															
															
															<tr align="center">
																<td colspan="2">
																
																<br/>
																<br/>
																<br/>
																总共有：&nbsp;${page.totalRecord }&nbsp;条记录&nbsp;&nbsp;
																当前页数：[${page.currentPage }/${page.totalPage }]&nbsp;
																<a href="CommentSelect?page=1&goodsID=${goodsdetail.goodsID}">第一页 </a>
																<c:if test="${page.currentPage > 1}">
																<a href="CommentSelect?page=${page.currentPage - 1 }&goodsID=${goodsdetail.goodsID}">上一页</a>
																</c:if> 
																<c:if test="${page.currentPage < page.totalPage}">
																<a href="CommentSelect?page=${page.currentPage + 1 }&goodsID=${goodsdetail.goodsID}">下一页
																											
																</c:if> 
																<a href="CommentSelect?page=${page.totalPage}&goodsID=${goodsdetail.goodsID}">最后一页&nbsp;</a>
																
																<br/>
																<br/>
																</td>
															</tr>
															</c:if>
															<tr>
																<td>
																	<form method="post" action="CommentSubmit?goodsID=${goodsdetail.goodsID}" name="form_comment" onsubmit="return commentSubmit()">
																	<table>
																	<tr>
																	<td colspan="2">
																	留言内容:<br/>
																	<textarea name="commentContent" cols="50" rows="5" class="textarea" id="commentContent"></textarea>
																	</td>
																	</tr>
																	<tr >
																	<td colspan="2">
																	<br/>
																	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																	<input type="submit" value="提交" >			
																	&nbsp;&nbsp;&nbsp;&nbsp;
																	<input type="reset" value="重置">
																	</td>
																	</tr>
																	</table>
																	</form>
																</td>
															</tr>
														</table>
													</td>
												</tr>
												<tr>
													<td height="38" align="right"
														background="images/center02.gif"></td>
												</tr>
											</table>
											<!-- 添加 -->
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<table width="790" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td>

								<!--版权信息-->
								<%@ include file="copyright.jsp"%>
								<!--版权信息结束-->
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
