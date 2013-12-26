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
			function checkOrder() {
				var rule = /^[0-9]*[1-9][0-9]*$/;
				var order = document.getElementById("billOrder").value;
				if(rule.test(order)) {
					document.getElementById("billOrderspan").innerHTML="";
					return true;
				} else {
					return false;
				}
			}
			function succeed() {
				if(checkOrder()) {
					return true;
				} else {
					if(checkOrder()==false) {
						document.getElementById("billOrderspan").innerHTML="<font color='red'>请输入正整数！</font>";
					} 
					return false;
				}
			}
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
							        <td valign="top" background="../images/bill_modify.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0">
							          <tr>
							            <td width="98%" align="right">&nbsp;</td>
							            <td width="2%">&nbsp;</td>
							          </tr>
							        </table></td>
							      </tr>
							    </table>
								<!-- 不同的部分顶部的图片 -->

								<!-- 不同的部分中间的部分 -->
								<table width="92%" height="192"  border="0" cellpadding="0" cellspacing="0">
							        <tr>
							          <td valign="top">
							   			  <form action="UpdataBill" method="post" name="form1" enctype="multipart/form-data">
										    <table width="100%"  border="0" align="center" cellpadding="-2" cellspacing="-2" bordercolordark="#FFFFFF">
										    <tr>图片上传：<input type="file" name="billFile" onpaste="return false" oncontextmenu="window.event.returnvalue=false;" oncopy="return false;" oncut="return false;"　/></tr>
							                  <tr>
							                  	<td>&nbsp;</td>
                                             	<td>&nbsp;</td>
							          			<td width="" align="right" rowspan="9" colspan="9">
							          				<img src="../${bill.billPicPath}" width="260" height="200"/>      				
                                                </td>            
							                  </tr>					       
							                  <tr>
							                    <td height="30">&nbsp;&nbsp;广告排序：</td>
												<td>
												<input type="text" name="billOrder" value="${bill.billOrder }" align="bottom" onblur="checkOrder()"/><span id="billOrderspan"></span>
							                    </td>
							                  </tr>
							                  <tr>
							                    <td height="30">&nbsp;&nbsp;广告状态：</td>
							                    <c:if test="${bill.billStatus == 'y'}">
												<td>
												有效<input type="radio" name="billStatus" value="y" checked/>&nbsp;&nbsp;&nbsp;
												无效<input type="radio" name="billStatus" value="n"/>
							                    </td>
							                    </c:if>
							                    <c:if test="${bill.billStatus == 'n'}">
												<td>
												有效<input type="radio" name="billStatus" value="y" />&nbsp;&nbsp;&nbsp;
												无效<input type="radio" name="billStatus" value="n" checked/>
							                    </td>
							                    </c:if>
							                  </tr>						           
							                  <tr><td> &nbsp;</td></tr> 
							                  <tr><td> &nbsp;</td></tr>                         
							                  <tr>
							                    <td height="25" colspan="2" align="left">
							                        <input name="Button" type="submit" class="btn_grey" value="保存" onclick="return succeed()">
							                        &nbsp;                        
							                        <input name="Submit2" type="reset" class="btn_grey" value="重置">
							                        &nbsp;
							                        <input name="Submit3" type="button" class="btn_grey" value="返回" onclick="JScript:history.back()">
							                    </td>
							                    <td><input type="hidden" name="hidd" value="${bill.billId }"></td>
							                  </tr>
							                </table>
										  </form>
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
							<td height="54" align="center"><!--版权信息  -->
								<%@ include file="bottom.jsp" %>
								<!--版权信息结束  -->
							<br></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>

