<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>奋斗电子商城</title>
		<link href="CSS/style.css" rel="stylesheet">
		
	</head>
		<script language="javascript" type="text/javascript" src="JS/menutree.js"></script>
		<script language="javascript" type="text/javascript" src="JS/modifyAddressCheck.js"></script>
		<script language="javascript" type="text/javascript" src="JS/addressAjax.js"></script>
	<body >
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
								<!--搜索框-->
								<%@ include file="search.jsp"%>
								<!--搜索框结束-->

								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="189" valign="top">
											<!-- 中间块-->
											<c:choose>
												<c:when test="${empty memberName}">
													<table width="300" height="200" align="center">
														<tr align="center">
															<td class="tipcolor">
																对不起，请您先登录再进行此操作!
															</td>
														</tr>
													</table>
												</c:when>
												<c:otherwise>
													<table width="100%" border="0" cellspacing="0"
														cellpadding="0">
														<tr>
															<td height="80" background="images/center_member.jpg">
																&nbsp;
															</td>
														</tr>
														<tr>
															<td height="189" align="center">
																<form action="ModifyPwd" method="post" name="modifypwd">
																	<table width="80%" border="0" cellspacing="-2"
																		cellpadding="-2" class="tableBorder_B_dashed">
																		<tr>
																			<td height="28" class="font2">
																				修改密码
																			</td>
																			<td height="28" align="right">
																				<input type="submit" value="修改">
																			</td>
																		</tr>
																		<tr>
																			<td width="18%" height="30" align="center">
																				用 户 名：
																			</td>
																			<td width="82%" class="word_grey">
																				${memberName}
																			</td>
																		</tr>
																		<tr>
																			<td height="28" align="center">
																				E-mail：
																			</td>
																			<td height="28">
																				${memberEmail}
																			</td>
																		</tr>
																		<tr>
																			<td height="28" align="center">
																				原始密码：
																			</td>
																			<td height="28">
																				<input name="oldpwd" type="password" size="20"
																					maxlength="20">
																				<span class="word_orange">*</span>
																			</td>
																		</tr>
																		<tr>
																			<td height="28" align="center">
																				修改密码：
																			</td>
																			<td height="28">
																				<input name="newpwd" type="password" size="20"
																					maxlength="20"
																					onKeydown="if(event.keyCode==13) modifypwd.submit()">
																				<span class="word_orange">*</span>
																			</td>
																		</tr>
																	</table>
																</form>
																<form action="ModifyAddress" method="post"
																	name="ModifyAddress" onSubmit="return modifyCheck()">
																	<table width="80%" border="0" cellspacing="-2"
																		cellpadding="-2" class="tableBorder_B_dashed">
																		<tr>
																			<td height="28" class="font2">
																				修改地址簿
																			</td>
																			<td height="28" align="right">
																				<input type="submit" value="修改">
																			</td>
																		</tr>
																		<tr>
																			<td height="28" align="center">
																				姓&nbsp;&nbsp;&nbsp;&nbsp;名：
																			</td>
																			<td height="28">
																				<input name="memberTrueName" type="text"
																					maxlength="10" onBlur="checktruename()"
																					value="${memberAddressBook.memberTrueName }"
																					onKeydown="if(event.keyCode==13) ModifyAddress.submit()">
																				<span class="word_orange">*</span><span
																					id="truenametip" class="tipcolor"></span>
																			</td>
																		</tr>
																		<tr>
																	<td height="28" align="center">
																		地&nbsp;&nbsp;&nbsp;&nbsp;区：
																	</td>
																	<td>
																		 
												                        	省份:<select name="province" onchange="sendCityAjax1()">
												    							<option value="${provinceCode }" >${province}</option>
												    							<c:forEach items="${p_al2}" var="p">
												    								<option value="${p.provinceCode }">${p.province}</option>
												    							</c:forEach>
																	    		</select>
																	    	城市:<select name="city" onchange="sendAreaAjax1()">
																	    			<option value="${cityCode }">${city }</option>
																	    		</select>
																	    	
																	    	地区:<select name="area">
																	    			<option value="${areaCode }">${area }</option>
																	    		</select>
												                        
																		
																	</td>
																</tr>
																		<tr>
																			<td height="28" align="center">
																				地&nbsp;&nbsp;&nbsp;&nbsp;址：
																			</td>
																			<td class="word_grey">
																				<input name="memberAddress" type="text" size="50"
																					onBlur="checkaddress()"
																					value="${memberAddressBook.memberAddress}"
																					onKeydown="if(event.keyCode==13) ModifyAddress.submit()">
																				<span class="word_orange">*</span>
																				<span id="addresstip" class="tipcolor"></span>
																			</td>
																		</tr>
																		<tr>
																			<td height="28" align="center">
																				邮&nbsp;&nbsp;&nbsp;&nbsp;编：
																			</td>
																			<td class="word_grey">
																				<input name="memberPostcode" type="text" size="20"
																					onBlur="checkpostcode()"
																					value="${memberAddressBook.memberPostcode }"
																					onKeydown="if(event.keyCode==13) ModifyAddress.submit()">
																				<span class="word_orange">*</span><span
																					id="postcodetip" class="tipcolor"></span>
																			</td>
																		</tr>
																		<tr>
																			<td height="28" align="center">
																				联系电话：
																			</td>
																			<td>
																				<input name="memberTelephone" type="text"
																					onBlur="checktelephone()"
																					value="${memberAddressBook.memberTelephone }"
																					onKeydown="if(event.keyCode==13) ModifyAddress.submit()">
																				<span class="word_orange">*</span>
																				<span id="telephonetip" class="tipcolor"></span>
																			</td>
																		</tr>
																	</table>
																</form>
																<table width="80%" border="0" cellspacing="-2"
																	cellpadding="-2" class="tableBorder_B_dashed">
																	<tr>
																		<td height="28" class="font2">
																			查看收藏夹
																		</td>
																		<td height="28" align="right">
																			<input type="button" value="查看"
																				onClick="window.location.href='FavoritsSelectManager'">
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
												</c:otherwise>
											</c:choose>
											<!-- 中间块结束-->
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

