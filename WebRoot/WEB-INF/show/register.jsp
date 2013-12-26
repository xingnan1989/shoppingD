<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
	<head>
		<title>奋斗电子商城</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link href="CSS/style.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="JS/registerCheck.js"></script>
		<script type="text/javascript" src="JS/registeraddress.js"></script>
	</head>
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
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td height="80" background="images/center_register.jpg">
														&nbsp;
													</td>
												</tr>
												<tr>
													<td height="189" align="center">
														<form action="MemberRegister" method="post" name="reg"
															onSubmit="return regcheck()">
															<table border="0" cellspacing="-2" cellpadding="-2">
																<tr>
																	<td width="95" height="42" align="center">
																		用 户 名：
																	</td>
																	<td width="450" valign="bottom" class="word_grey">
																		<input name="memberName" id="memberName" type="text"
																			maxlength="16"
																			onBlur="validusername(memberName.value)">
																		<span class="word_orange">*</span><span
																			class="tipcolor" id="nametip"></span>
																		<br />
																		<span class="word_lightgray">用户名长度3-16个字符,由字母、数字、下划线组成</span>
																	</td>
																</tr>
																<tr>
																	<td height="42" align="center">
																		密&nbsp;&nbsp;&nbsp;&nbsp;码：
																	</td>
																	<td height="28" valign="bottom">
																		<input name="memberPassword" type="password" size="20"
																			maxlength="16" onBlur="checkpwd()">
																		<span class="word_orange">*</span><span id="pwdtip"
																			class="tipcolor"></span>
																		<br />
																		<span class="word_lightgray">密码长度为6-16个字符</span>
																	</td>
																</tr>
																<tr>
																	<td height="42" align="center">
																		确认密码：
																	</td>
																	<td height="28">
																		<input name="memberPassword2" type="password"
																			size="20" maxlength="16" onBlur="checkcfpwd()">
																		<span class="word_orange">*</span><span
																			class="tipcolor" id="cfpwdtip"></span>
																	</td>
																</tr>
																<tr>
																	<td height="42" align="center">
																		E-mail：
																	</td>
																	<td height="28" valign="bottom">
																		<input name="memberEmail" type="text" size="30"
																			onBlur="checkemail()">
																		<span class="word_orange">*</span><span id="emailtip"
																			class="tipcolor"></span>
																		<br />
																		<span class="word_lightgray">如:jackyyung@163.com</span>
																	</td>
																</tr>
																<tr>
																	<td height="28" align="center">
																		验 证 码：
																	</td>
																	<td height="28">
																		<input name="validateCode" id="validateCode"
																			type="text" size="20">
																		<span class="word_orange"><a href="#"
																			onClick="reload()">看不清?换一个</a>
																		</span>
																		<img id="valid" src="VerifyCode">
																		<span id="randtip" class="tipcolor"></span>
																	</td>
																</tr>
																<tr>
																	<td height="28" colspan="2">
																		<hr align="center" size="1">
																	</td>
																</tr>

																<tr>
																	<td height="28" align="center">
																		姓&nbsp;&nbsp;&nbsp;&nbsp;名：
																	</td>
																	<td height="28">
																		<input name="memberTrueName" type="text"
																			maxlength="10" onBlur="checktruename()">
																		<span class="word_orange">*</span><span
																			id="truenametip" class="tipcolor">
																	</td>
																</tr>
<tr>
																	<td height="28" align="center">
																		地&nbsp;&nbsp;&nbsp;&nbsp;区：
																	</td>
																	<td>
																		省份:<select name="province" onchange="sendCityAjax2()">
												    							<option value="0" >请选择</option>
												    							<c:forEach items="${p_al2}" var="p">
												    								<option value="${p.provinceCode }">${p.province}</option>
												    							</c:forEach>
																	    		</select>
																	    	城市:<select name="city" onchange="sendAreaAjax2()">
																	    			<option value="0">请选择</option>
																	    		</select>
																	    	
																	    	地区:<select name="area">
																	    			<option value="0">请选择</option>
																	   			</select>
																		<span class="word_orange" id="add">*</span>
																	</td>
																</tr>
																
																
																<tr>
																	<td height="28" align="center">
																		地&nbsp;&nbsp;&nbsp;&nbsp;址：
																	</td>
																	<td class="word_grey">
																		<input name="memberAddress" type="text" size="50"
																			onBlur="checkaddress()">
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
																			onBlur="checkpostcode()">
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
																			onBlur="checktelephone()">
																		<span class="word_orange">*</span>
																		<span id="telephonetip" class="tipcolor"></span>
																	</td>
																</tr>
																<tr>

																	<td height="34">
																		&nbsp;
																	</td>
																	<td class="word_grey">
																		<input type="submit" class="btn_grey" value="确定保存">
																		<input type="reset" class="btn_grey" value="重新填写">
																		<input type="button" class="btn_grey" value="返回"
																			onClick="window.location.href='index'">
																	</td>
																</tr>
															</table>
														</form>
													</td>
												</tr>
												<tr>
													<td height="38" align="right"
														background="images/center02.gif"></td>
												</tr>
											</table>

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

