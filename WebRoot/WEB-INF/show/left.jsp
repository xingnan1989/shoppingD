<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<html>
  <head> 
    <title>My JSP 'left.jsp' starting page</title>
    <link href="CSS/style.css" rel="stylesheet">
  </head>
  <script language="javascript" type="text/javascript" src="JS/order.js"></script>
  <body>
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td height="83" align="center">
											<img src="images/shop_11.gif" width="182" height="83">
										</td>
									</tr>
									<tr>
										<td height="98" align="center" background="images/shop_17.gif">
											<form name="login" method="post" action="MemberLogin">
												<table width="100%" border="0" cellpadding="0"
													cellspacing="0">
													<tr>
														<td width="10%">
															&nbsp;
														</td>
														<td width="90%" valign="top" background="Images/index_09.gif">
															
															<c:if test="${memberName eq null}">
																<table width="100%" border="0" cellpadding="0"
																	cellspacing="0">
																	<tr>
																		<td width="94%" height="24">
																			会员名
																			<input name="memberName" type="text" class="txt_grey"
																				id="memberName" size="16">
																		</td>
																		<td width="6%">
																			&nbsp;
																		</td>
																	</tr>
																	<tr>
																		<td height="24">
																			密&nbsp;&nbsp;&nbsp;&nbsp;码
																			<input name="memberPassword" type="password" class="txt_grey"
																				id="memberPassword" size="16"
																				onKeydown="if(event.keyCode==13) login.submit();">
																		</td>
																		<td>
																			&nbsp;
																		</td>
																	</tr>
																	<tr>
																		<td height="31">
																			<input type="button" class="btn_grey" value="注册"
																				onClick="window.location.href='Register'">
																			&nbsp;
																			<input type="submit" class="btn_grey" value="登录">
																			<input type="reset" class="btn_grey" value="重置">
																		</td>
																		<td>
																			&nbsp;
																		</td>
																	</tr>
																</table>
															</c:if>
															<!-- 登录后的效果-->
															<c:if test="${memberName ne null}">
																<table width="100%" border="0" cellpadding="0"
																	cellspacing="0">
																	<tr>
																		<td width="94%" height="31" align="center"
																			class="word_white">
																			${memberName }您好!
																			<br>
																			您现在可以购物了!
																		</td>
																		<td width="6%">
																			&nbsp;
																		</td>
																	</tr>
																	<tr>
																		<td height="24" align="center">
																			<input type="button" class="btn_grey" value="修改资料"
																				onClick="window.location.href='ShowMemberInfo';">
																		</td>
																		<td>
																			&nbsp;
																		</td>
																	</tr>
																	
																	<tr>
																		<td height="24" align="center">
																			<input type="button" class="btn_grey" value="退出登录"
																				onClick="window.location.href='MemberLoginOut';">
																		</td>
																		<td>
																			&nbsp;
																		</td>
																	</tr>
																</table>
															</c:if>
														</td>
													</tr>
												</table>
											</form>
										</td>
									</tr>
								</table>
								<table width="100%" height="155" border="0" cellpadding="0"
									cellspacing="0">
									<tr>
										<td>
											<img src="images/shop_22.gif" width="182" height="58">
										</td>
									</tr>
									<tr>
										<td height="97" align="center" valign="top"
											class="tableBorder_l">
											<table width="88%" border="0" cellspacing="0" cellpadding="0">
											<c:forEach items="${pdal}" var="pdal">
												<tr>
													<td height="24" class="tableBorder_T_dashed">
														<a href="PlacardShow?placardID=${pdal.placardID }">${pdal.placardTitle}</a>
													</td>
												</tr>
											</c:forEach>
											</table>
										</td>
									</tr>
								</table>
								<table width="100%" height="151" border="0" cellpadding="0"
									cellspacing="0">
									<tr>
										<td height="40" background="images/shop_33.gif">
											&nbsp;
										</td>
									</tr>
									<tr>
										<td align="center" valign="top" class="tableBorder_lb">
											<table width="88%" border="0" cellspacing="0" cellpadding="0">
												<c:forEach items="${goodsal}"  var="goodsal" varStatus="status">
												<tr>
													<td height="20" class="tableBorder_B_dashed">
														<a href="CommentSelect?goodsID=${goodsal.goodsID }">
															<c:if test="${status.index+1 <=3}" >
																<b><font color="red" size="2">NO${status.index+1}:</font></b>&nbsp;&nbsp;
																${goodsal.goodsName}&nbsp;&nbsp;&nbsp;&nbsp;
																<b><font color="red">HOT</font></b>
															</c:if>
															<c:if test="${status.index+1 >3}" >
																<b><font  color="blue">NO${status.index+1}:</font></b>&nbsp;&nbsp;
																${goodsal.goodsName}&nbsp;&nbsp;&nbsp;&nbsp;
																
															</c:if>
														</a>
													</td>
												</tr>
												</c:forEach>

											</table>
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td>
														&nbsp;
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
  </body>
</html>
