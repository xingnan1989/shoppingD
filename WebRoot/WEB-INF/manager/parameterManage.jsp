<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>后台管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="../CSS/style.css" rel="stylesheet">
		<script src="../JS/check.jsp"></script>
		<script src="onclock.JS"></script>
		<script type="text/javascript">
		<!--
			function superTypeDel() {
				if(confirm("删除大类，小类与相关商品也将删除\n     您确定要删除？")) {
					return true;
				} else {
					return false;
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
						<%@ include file="top.jsp" %>
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
											<%@ include file="left.jsp" %>
											<!-- 操作菜单结束 -->
										</td>
									</tr>
								</table>
							</td>
							<td align="center" valign="top">
								<!-- 不同的部分顶部的图片 -->
									<table width="100%" height="120"  border="0" cellpadding="0" cellspacing="0"> 
						              <tr> 
						                <td valign="top" background="../images/manage_center_superList.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0"> 
						                    <tr> 
						                      <td width="98%" align="right"><a href="superType_add.jsp">[ <img src="../images/list.gif" width="11" height="13">&nbsp;添加大分类信息]</a></td> 
						                      <td width="2%">&nbsp;</td> 
						                    </tr> 
						                </table></td> 
						              </tr> 
						            </table>
								<!-- 不同的部分顶部的图片 -->

								<!-- 不同的部分中间的部分 -->
									 <form action="superType_Del_deal.jsp" method="post" name="frm"> 
						              <table width="92%" height="192"  border="0" cellpadding="0" cellspacing="0"> 
						                <tr align="right"> 
						                  <td valign="top"> 
						                    <table width="96%" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#CCCCCC" bordercolorlight="#FFFFFF"> 
						                      <tr bgcolor="#eeeeee" style="padding:5px;"> 
						                        <td width="10%" height="20" align="center">编号</td> 
						                        <td width="45%" align="center">大分类信息名称</td>
						                        <td width="20%" align="center">子类管理</td>
						                        <td width="10%" align="center">修改</td> 
						                        <td width="10%" align="center">删除</td> 
						                      </tr>      
						                       <c:forEach var="al" items="${alSuperType}">             
						                      <tr style="padding:5px;"> 
						                        <td height="20" align="center">${al.typeCode }</td> 
						                        <td align="center">${al.typeName }</td> 
						                        <td align="center"><a href="SelectSubType?superTypeCode=${al.typeCode }"><img src="../images/modify.gif" width="15" height="15" alt="子类管理"></a></td>
						                        <td align="center"><a href="SelectSuperTypeOne?superTypeCode=${al.typeCode }"><img src="../images/modify.gif" width="15" height="15" alt="修改"></a></td>
						                        <td align="center"><a href="DeleteSuperType?superTypeCode=${al.typeCode }" onclick="return superTypeDel()"><img src="../images/del.gif" width="16" height="16" alt="删除"></a></td>
						                      </tr> 
											</c:forEach>                 
						                    </table> 
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												一共有${page.totalRecord }条记录&nbsp;&nbsp;
												当前页数：[${page.currentPage }/${page.totalPage }]&nbsp;
												<a href="SelectSuperType?page=1">首页</a>&nbsp;&nbsp;
												<c:if test="${page.currentPage > 1}">&nbsp;&nbsp;
												<a href="SelectSuperType?page=${page.currentPage - 1}">上一页</a>&nbsp;&nbsp;
												</c:if>
												<c:if test="${page.currentPage < page.totalPage }">
												<a href="SelectSuperType?page=${page.currentPage + 1}">下一页</a>&nbsp;&nbsp;
												</c:if>
												<a href="SelectSuperType?page=${page.totalPage }">最后一页</a>
						                  </td> 
						                </tr> 
						              </table> 
						            </form> 
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
								<%@ include file="bottom.jsp" %>
								<!--版权信息结束  -->
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>

