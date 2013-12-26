<%@ page language="java" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>后台管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="../CSS/style.css" rel="stylesheet">
		<script src="../JS/check.jsp"></script>
		<script src="onclock.JS"></script>
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
								        <td valign="top" background="../images/subType_modify.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0">
								          <tr>
								            <td width="98%" align="right">&nbsp;</td>
								            <td width="2%">&nbsp;</td>
								          </tr>
								        </table></td>
								      </tr>
								    </table>
								<!-- 不同的部分顶部的图片 -->

								<!-- 不同的部分中间的部分 -->
									<form action="UpdateSubType?superTypeCode=${superTypeCode }&subTypeCode=${type.typeCode }" method="post" name="form1">
									    <table width="100%"  border="0" align="center" cellpadding="-2" cellspacing="-2" bordercolordark="#FFFFFF">
						                  <tr>
						                    <td height="30">小分类名称：</td>
											<td><input name="typename" type="text" id="typename" size="40" value="${type.typeName }"></td>
						                  </tr> 
						                  <tr>
						                    <td height="30">类型编号：</td>
											<td><input name="typeCode" type="text" id="typename" size="60" value="${type.typeCode }"></td>
						                  </tr> 
										  <tr>
						                    <td width="16%" >描&nbsp;&nbsp;&nbsp;&nbsp;述</td>
						                    <td width="84%" ><textarea cols="50" rows="5" name="description" >${type.typeDesc }</textarea></td>
						                  </tr>
						                  <tr align="center">
						                    <td height="30" colspan="3">
						                        <input type="submit" class="btn_grey" value="保存" >
						                        &nbsp;                        
						                        <input type="reset" class="btn_grey" value="重置">
						                        &nbsp;
						                        <input type="button" class="btn_grey" value="返回" onClick="JScript:history.back()">                    </td>
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

