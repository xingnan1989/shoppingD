<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>后台管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="../CSS/style.css" rel="stylesheet">
		<script src="../JS/check.jsp"></script>
		<script src="onclock.JS"></script>
		<script type="text/javascript">
		<!--
			function subDel() {
				if(confirm("相关的商品也将会删除\n您确定要删除此类?")) {
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
						                <td valign="top" background="../images/manage_center_subList.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0"> 
						                    <tr> 
						                      <td width="98%" align="right"><a href="PassParameter1?superTypeCode=${superTypeCode }">[ <img src="../images/list.gif" width="11" height="13">&nbsp;添加小分类信息]</a></td> 
						                      <td width="2%">&nbsp;</td> 
						                    </tr> 
						                </table></td> 
						              </tr> 
						            </table>       
								<!-- 不同的部分顶部的图片 -->

								<!-- 不同的部分中间的部分 -->
									 <form action="" method="post" name="frm"> 
							              <table width="92%" height="192"  border="0" cellpadding="0" cellspacing="0"> 
							                <tr align="right"> 
							                  <td valign="top"> <table width="100%" height="14"  border="0" cellpadding="0" cellspacing="0"> </table> 
							                    <table width="100%" height="48"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#CCCCCC" bordercolorlight="#FFFFFF"> 
							                      <tr bgcolor="#eeeeee"> 
							                        <td width="10%" height="20" align="center">编号</td> 
							                        <td width="30%" align="center">大分类信息名称</td> 
							                        <td width="30%" align="center">小分类信息名称</td>
							                        <td width="10%" align="center">修改</td> 
							                        <td width="10%" align="center">删除</td> 
							                      </tr>   
							                      <c:forEach var="al" items="${al}">                    
							                      <tr style="padding:5px;"> 
							                        <td  align="center">${al.typeCode }</td> 
							                        <td height="20" align="center">${al.superTypeName }</td>
							                        <td height="20" align="center">${al.typeName }</td>
							                        <td align="center"><a href="SelectSubTypeOne?typeCode=${al.typeCode }&superTypeCode=${superTypeCode }"><img src="../images/modify.gif" width="15" height="15"></a></td>
							                        <td align="center"><a href="DeleteSub?typeCode=${al.typeCode }&superTypeCode=${superTypeCode }" onclick="return subDel()"><img src="../images/del.gif" width="16" height="16"></a></td>
							                      </tr>  
							                     </c:forEach>                 
							                    </table> 
							                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												一共有${page.totalRecord }条记录&nbsp;&nbsp;
												当前页数：[${page.currentPage }/${page.totalPage }]&nbsp;
												<a href="SelectSubType?page=1">首页</a>&nbsp;&nbsp;
												<c:if test="${page.currentPage > 1}">&nbsp;&nbsp;
												<a href="SelectSubType?page=${page.currentPage - 1}">上一页</a>&nbsp;&nbsp;
												</c:if>
												<c:if test="${page.currentPage < page.totalPage }">
												<a href="SelectSubType?page=${page.currentPage + 1}">下一页</a>&nbsp;&nbsp;
												</c:if>
												<a href="SelectSubType?page=${page.totalPage }">最后一页</a>
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

