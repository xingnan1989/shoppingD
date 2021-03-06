<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.fendou.order.po.*"%>
<html>
	<head>
		<title>奋斗电子商城</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link href="CSS/style.css" rel="stylesheet">
	</head>
	<script language="javascript" type="text/javascript" src="JS/order.js"></script>
	<script language="javascript" type="text/javascript" src="JS/ordervalidate.js"></script>
	<body>
		<%
			Boolean falg=false;
			String goodss=request.getParameter("goodss");
			falg=Boolean.parseBoolean(request.getParameter("falg"));
			
			if(falg==true){
				out.println("<script>alert('对不起,"+goodss+"商品数量不足,请修改购买数量')</script>");
			}
		 %>
		<c:set value="${memberName}" var="username" />
		<table width="790" border="0" cellspacing="0" cellpadding="0"
			align="center">
			<tr>
				<td class="tableBorder">
					<!--导航条-->
					<%@ include file="navigation.jsp" %>
					
					<!--导航条结束-->
					<table width="790" height="236" border="0" align="center"
						cellpadding="0" cellspacing="0">
						<tr>
							<td width="182" height="182" valign="top">
								<!--左侧框架-->
								
								<%@ include file="left.jsp" %>
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
											<%@ include file="search.jsp" %>
											
											<!--搜索框结束-->
										</td>
									</tr>
								</table>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="189" valign="top">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td height="80" background="images/center_cart.gif">
														&nbsp;
													</td>
												</tr>
												<tr valign="top">
													<td height="134" align="center">
														<table width="100%" height="126" border="0"
															cellpadding="0" cellspacing="0">

															<tr>
																<td valign="top">
																	<table width="100%" border="0" cellspacing="0"
																		cellpadding="0">
																		<tr>
																			<td>
																				
																				<form method="post" action="OrderShopcarCheckout" name="modifygoods" >
																					<table width="92%" height="48" border="0"
																						align="center" cellpadding="0" cellspacing="0" onmouseover="">
																						
																						 <c:if test="${countgoodsNormalPrice == 0.0 or countgoodsNormalPrice == null}">
																							<tr align="center" valign="middle">
																								<td  align="center">
																									<font color="red">您还没有添加任何商品</font>
																								</td>
																							</tr>
																						</c:if>
																						<c:if test="${countgoodsNormalPrice != 0.0 and countgoodsNormalPrice != null}">
																						<tr align="center" valign="middle">
																							<td height="27" class="tableBorder_B1">
																								编号
																							</td>
																							<td class="tableBorder_B1">
																								商品名称
																							</td>
																							<td class="tableBorder_B1">
																								市场价
																							</td>
																							<td class="tableBorder_B1">
																								商城价
																							</td>
																							<td class="tableBorder_B1">
																								折扣
																							</td>
																							<td class="tableBorder_B1">
																								数量
																							</td>
																							<td class="tableBorder_B1">
																								退回
																							</td>
																						</tr>
																						<%
																							int i=0;
																						%>
																						<c:forEach items="${car2}" var="car" varStatus="status">
																						
																						<%
																							i++;
																							request.setAttribute("i",i);
																						 %>
																						<tr align="center" valign="middle">
																							<td height="27">
																								${status.index+1}
																							</td>
																							<td>
																								<a href="Goods_detail?goodsID=${car.goods.goodsID}">${car.goods.goodsName}</a>
																							</td>
																							<td style="text-decoration: line-through;">
																								${car.goods.goodsNormalPrice }
																							</td>
																							<td style="color: #FF0000">
																								${car.goods.goodsMemberPrice }
																							</td>
																							<td>
																								${car.goods.goodsRebate}
																							</td>
																							<td>
																								<input size="5" type="text" class="txt_grey"
																									value="${car.num}" name="goodnum${status.index}" id="${status.index}" onblur="shopcarSubmit(goodnum${status.index}.value,${status.index})">
																								<input type="button" class="btn_grey"
																									value="更新" onclick="shopcarUpdate(${car.goods.goodsID},goodnum${status.index}.value,${status.index})">
																							</td>
																							<td>
																								<a href="OrderShopcarDelete?goodsID=${car.goods.goodsID}"><img src="images/del.gif"
																										width="16" height="16">
																								</a>
																							</td>
																						</tr>
																						
																						</c:forEach>
																						
																						<tr align="center" valign="middle">
																							<td colspan="2" align="center">
																							共有&nbsp;<font color="red"><b>${i }</b></font>&nbsp;种商品&nbsp;&nbsp;&nbsp;
																								总价
																							</td>
																							<td style="text-decoration: line-through;">
																								<div id="countgoodsNormalPrice">${countgoodsNormalPrice }</div>
																								
																							</td>
																							<td style="color: #FF0000">
																								<div id="countgoodsMemberPrice">${countgoodsMemberPrice }</div>
																							</td>
																							<td colspan="3">
																									
																							</td>
																						</tr>
																						<tr align="center" valign="middle">
																						<td colspan="7">
																							<br/><br/><br/>
																							总共有：&nbsp;${page.totalRecord }&nbsp;条记录&nbsp;&nbsp;
																							当前页数：[${page.currentPage }/${page.totalPage }]&nbsp;
																							<a href="OrderShopcarPagination?page=1">第一页 </a>
																							<c:if test="${page.currentPage > 1}">
																							<a href="OrderShopcarPagination?page=${page.currentPage - 1 }">上一页</a>
																							</c:if> 
																							<c:if test="${page.currentPage < page.totalPage}">
																							<a href="OrderShopcarPagination?page=${page.currentPage + 1 }">下一页
																											
																							</c:if> 
																							<a href="OrderShopcarPagination?page=${page.totalPage}">最后一页&nbsp;</a>
																							</td>
																						</tr>
																						</c:if>
																					</table>
																				
																				<table width="100%" height="52" border="0"
																					align="center" cellpadding="0" cellspacing="0">
																					<tr align="center" valign="middle">
																						<td height="21" colspan="2">
																							<div class="line5">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																							</div>
																							<div class="line5"><a href="NewGoods">继续购物</a> |</div>
																							<c:if test="${countgoodsMemberPrice != 0.0 and countgoodsMemberPrice != null}">
																								<div id="shopcarsubmit" class="line5"><a href="OrderShopcarCheckout" >去收银台结账</a>|</div>  
																							</c:if>
																							<c:if test="${countgoodsMemberPrice == 0.0 or countgoodsMemberPrice == null}">
																								<div class="line5"><a href="#" onclick="alert('您还没有购买任何商品')">去收银台结账</a> | </div>
																							</c:if>
																							<div class="line5"><a href="OrderShopcarDrop">清空购物车</a> |</div>
																						</td>
																					</tr>
																				</table>
																				</form>
																			</td>
																		</tr>
																	</table>
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
								
								<%@ include file="copyright.jsp" %>
								<!--版权信息结束-->
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>