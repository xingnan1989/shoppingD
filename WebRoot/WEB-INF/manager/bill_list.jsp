<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
	<head>
		<title>后台管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="../CSS/style.css" rel="stylesheet">
		<script src="../JS/check.jsp"></script>
		<script src="onclock.JS"></script>
		<script language="javascript" type="text/javascript">
		<!--
			function billDel() {
				if(!confirm("您确定要删除此广告？")) {
					return false;
				} else {
					return true;
				}
			}
		//-->
		</script>
	</head>
	<body>
		<table width="777" height="192" border="0" align="center"
			cellpadding="0" cellspacing="0" class="tableBorder">
			<tr>
				<td>
					<!-- LOGO -->
						<%@ include file="top.jsp"%>
					<!-- LOGO结束-->
					<table width="777" height="288" border="0" align="center"
						cellpadding="0" cellspacing="0">
						<tr>
							<td width="182" valign="top">
								<table width="100%" height="431" border="0" cellpadding="0"
									cellspacing="0">
									<tr>
										<td valign="top" background="../images/manage_02.gif">
											<!-- 操作菜单 -->
											<%@ include file="left.jsp"%>
											<!-- 操作菜单结束 -->
										</td>
									</tr>
								</table>
							</td>
							<td align="center" valign="top">
								<!-- 不同的部分顶部的图片 -->
								<table width="100%" height="120" border="0" cellpadding="0"
									cellspacing="0">
									<tr>
										<td valign="top" background="../images/bill_list.gif">
											<table width="100%" height="36" border="0" cellpadding="0"
												cellspacing="0">
												<tr>
													<td width="98%" align="right">
														<a href="bill_add.jsp">[ <img src="../images/list.gif"
																width="11" height="13">&nbsp;添加广告</a>
													</td>
													<td width="2%">
														&nbsp;
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
								<!-- 不同的部分顶部的图片 -->

								<!-- 不同的部分中间的部分 -->
								<table width="98%" height="192" border="0" cellpadding="0"
									cellspacing="0">
									<tr>
										<td valign="top">
											<table width="100%" height="48" border="1" cellpadding="0"
												cellspacing="0" bordercolor="#FFFFFF"
												bordercolordark="#CCCCCC" bordercolorlight="#FFFFFF">
												<tr bgcolor="#eeeeee">
													<td width="10%" align="center">
														编号
													</td>
													<td width="20%" align="center">
														状态
													</td>
													<td width="20%" align="center">
														广告排序
													</td>
													<td width="5%" align="center">
														修改
													</td>
													<td width="5%" align="center">
														删除
													</td>
												</tr>
												<c:forEach var="al" items="${al}">
													<tr style="padding: 5px;">
														<td height="20" align="center">
															${al.billId }
														</td>
														<td align="center">
															<c:choose>
																<c:when test="${al.billStatus  == 'y'}">
					                        	有效
					                        	</c:when>
																<c:when test="${al.billStatus == 'n'}">
					                        	无效
					                        	</c:when>
															</c:choose>
														</td>
														<td align="center">
															<!--  此广告排在第&nbsp;${al.billOrder}&nbsp;位&nbsp;&nbsp;-->
															<a href="OrderBill?billOrder=${al.billOrder}&billId=${al.billId }">上移</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<a href="OrderBillBack?billOrder=${al.billOrder}&billId=${al.billId }">下移</a>
														</td>
														<td align="center">
															<a href="SelectBillOne?billId=${al.billId }"><img
																	src="../images/modify.gif" width="15" height="15">
															</a>
														</td>
														<td align="center">
															<a href="DeleteBill?billId=${al.billId }"
																onclick="return billDel()"><img
																	src="../images/del.gif" width="16" height="16">
															</a>
														</td>
													</tr>
												</c:forEach>
											</table>
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td align="right">
														总共有：&nbsp;${page.totalRecord }&nbsp;条记录&nbsp;&nbsp;
														当前页数：[${page.currentPage }/${page.totalPage }]&nbsp;
														<a href="SelectBill?pages=1">第一页 <c:if
																test="${page.currentPage > 1}">
																<a href="SelectBill?pages=${page.currentPage - 1 }">上一页</a>
															</c:if> <c:if test="${page.currentPage < page.totalPage}">
																<a href="SelectBill?pages=${page.currentPage + 1 }">下一页
																
															</c:if> <a href="SelectBill?pages=${page.totalPage}">最后一页&nbsp;</a>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
								<!-- 不同的部分中间的部分 -->
								<table width="100%" height="46" border="0" cellpadding="0"
									cellspacing="0">
									<tr>
										<td background="../images/manage_06.gif">
											&nbsp;
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<table width="777" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td height="54" align="center">
								<!--版权信息  -->
								<%@ include file="bottom.jsp"%>
								<!--版权信息结束  -->
								<br>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>

