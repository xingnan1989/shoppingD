<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<html>
  <head> 
    <title>My JSP 'navigation.jsp' starting page</title>
    <link href="CSS/style.css" rel="stylesheet">
        <link rel="alternate stylesheet" href="CSS/red.css" type="text/css" title="red" media="screen, projection"/> 
  <link rel="stylesheet" href="CSS/green.css" type="text/css" title="green" media="screen, projection"/> 
  <link rel="alternate stylesheet" href="CSS/yellow.css" type="text/css" title="yellow" media="screen, projection"/>
  <script language="javascript" src="JS/changebg.js"></script>
  </head>
  <script language="javascript" type="text/javascript" src="JS/order.js"></script>
  <body>
    <table width="790" height="115" border="0" align="center"
						cellpadding="0" cellspacing="0">
						<tr>
							<td valign="top">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td bgcolor="#CCCCCC" height="6px"></td>
									</tr>
								</table>
								<table width="100%" height="109" border="0" cellpadding="0"
									cellspacing="0">
									<tr>
										<td width="25%">
											<img src="images/shop_02.gif" width="275" height="109">
										</td>
										<td width="75%">
											<table width="100%" height="109" border="0" cellpadding="0"
												cellspacing="0">
												<tr>
													<td height="52" align="right" valign="top">
														<table width="100%" height="31" border="0" cellpadding="0"
															cellspacing="0">
															<tr align="center">
																<td width="281">
																	&nbsp;
																</td>
																<td width="7" valign="top">
																	<img src="images/T_contact.gif" width="42" height="28">
																</td>
																<td width="72">
																	<a href="mailto:519523266@qq.com">联系我们</a>
																</td>
																<input type="button" onclick="setActiveStyleSheet('red')"; return false value="风格一" > 
																<input type="button" onclick="setActiveStyleSheet('green')"; return false  value="风格二" > 
																<input type="button" onclick="setActiveStyleSheet('yellow')"; return false  value="风格三" >
																<input type="button" onclick="setActiveStyleSheet('none')"; return false  value="还 原" > 
																<td width="10" valign="top">
																	<img src="images/T_favorite.gif" width="42" height="28">
																</td>
																<td width="68">
																	<a
																		href="javascript:window.external.AddFavorite('www.fendoujiaoyu.com','奋斗教育')">收藏本站</a>
																</td>
																<td width="10" valign="top">
																	<img src="images/T_home.gif" width="42" height="28">
																</td>
																<td width="70">
																	<a href="#"
																		onclick="this.style.behavior='url(#default#homepage)';this.sethomepage('http://www.fendou.com')">设为首页</a>
																</td>
															</tr>
														</table>
													</td>
												</tr>
												<tr>
													<td height="57" valign="top"
														background="images/shop_07.gif">
														<table width="100%" height="53" border="0" cellpadding="0"
															cellspacing="0">
															<tr align="center">
																<td width="9%">
																	<a href="index">首页<br> Index</a>
																</td>
																<td width="2%">
																	<img src="images/shop_09.gif" width="3" height="57">
																</td>
																<td width="15%">
																	<a href="NewGoods">新品上架<br> NewGoods</a>
																</td>
																<td width="1%">
																	<img src="images/shop_09.gif" width="3" height="57">
																</td>
																<td width="14%">
																	<a href="Sale">特价商品<br> At a sale</a>
																</td>
																<td width="1%">
																	<img src="images/shop_09.gif" width="3" height="57">
																</td>
																<td width="14%">
																<c:if test="${memberID ne null}">
																	<a href="ShowMemberInfo">会员资料修改<br> Member</a>
																</c:if>
																<c:if test="${memberID eq null}">
																	<a href="#" onclick="alert('您还没有登录')">会员资料修改<br> Member</a>
																</c:if>
																</td>
																<td width="1%">
																	<img src="images/shop_09.gif" width="3" height="57">
																</td>
																<td width="10%">
																<c:if test="${memberID ne null}">
																	<a href="OrderShopcarPagination">购物车<br> Cart</a>
																</c:if>
																<c:if test="${memberID eq null}">
																	<a href="#" onclick="alert('您还没有登录')">购物车<br> Member</a>
																</c:if>
																</td>
																<td width="1%">
																	<img src="images/shop_09.gif" width="3" height="57">
																</td>
																<td width="15%">
																<c:if test="${memberID ne null}">
																	<a href="OrderOrderAndDetatlSelect">查看订单<br> Order</a>
																</c:if>
																<c:if test="${memberID eq null}">
																	<a href="#" onclick="alert('您还没有登录')">查看订单<br> Member</a>
																</c:if>
																</td>
																<td width="1%">
																	<img src="images/shop_09.gif" width="3" height="57">
																</td>
																<td width="11%">
																	<a href="sellsort.jsp">销售排行<br> SellSort</a>
																</td>
																<td width="2%">
																	&nbsp;
																</td>
															</tr>
														</table>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
  </body>
</html>
