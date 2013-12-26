<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<title>奋斗电子商城</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link href="CSS/style.css" rel="stylesheet">
		<script language='JavaScript' src='JS/menutree.js'></script>
		<script language="javascript" type="text/javascript" src="JS/order.js"></script>
		<script language="javascript" type="text/javascript"
			src="JS/ordervalidate.js"></script>
		<script language="javascript" type="text/javascript"
			src="JS/individuality.js"></script>
	</head>
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
														<marquee direction="left" scrollamount="1" scrolldelay="1"
															onMouseOver="this.stop();" onMouseOut="this.start();">
															购买商品请先<a href="" style="color: #FF0000;">登录 </a>
														<a href="register.jsp" class="word_green">[新用户注册]</a>
															<!-- Mary欢迎您!(如果您不是Mary，<a href="" style="color: #FF0000;">请点击这里退出登录</a>) -->
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
										<td colspan="2" background="images/shop_16.gif" valign="top">
											<!--搜索框-->
											<%@ include file="search.jsp"%>
											<!--搜索框结束-->
										</td>
									</tr>
								</table>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="69%" height="189" valign="top">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="98%" height="80"
														background="images/center_type.gif">
														&nbsp;
													</td>
													<td width="2%">
														<img src="images/shop_19.gif" width="10" height="80">
													</td>
												</tr>
												<tr align="center" valign="top">
													<td height="134" align="center">
														<table width="90%" height="23" border="0" cellpadding="0"
															cellspacing="0" class="tableBorder_B_dashed">
															<tr>
																<td height="23">
																	当前选择的类别：[ ${superName } ]->[ ${subName } ]
																</td>
															</tr>
														</table>
														<c:forEach items="${goodsListShow}" var="al" varStatus="start">
														<table width="90%" height="23" border="0" cellpadding="0"
															cellspacing="0" class="noborder">
															<tr>
																<td width="5%" align="center">
																	${start.count }.
																</td>
																<td width="45%">
																	<a href="Goods_detail?goodsID=${al.goodsID }">${al.goodsName }</a>
																</td>
																<td height="20">
																	￥${al.goodsMemberPrice }
																</td>
																<td width="30%" align="center">
																<c:if test="${al.goodsNumber!=0}">
																	<input type="button" class="btn_grey"
																		onClick="window.location.href='cart_add.html'"
																		value="购买">${al.goodsID }
																</c:if>
																<c:if test="${al.goodsNumber==0}">
																	暂无商品
																</c:if>
																</td>
															</tr>
														</table>
													</c:forEach>
													</td>
												</tr>
												<tr>
													<td height="42" align="right"
														background="images/shop_24.gif">
														<a href="sale.jsp"><br> <br> </a>
													</td>
													<td height="42" background="images/shop_25.gif">
														&nbsp;
													</td>
												</tr>
											</table>
										</td>
										<td width="31%" valign="top">

											<!--右侧框架-->
											<%@ include file="right.jsp"%>
											<!--右侧框架结束-->
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


