<%@ page language="java" pageEncoding="UTF-8" import="net.fckeditor.*,com.fendou.goods.po.T_Goods"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>后台管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="../CSS/style.css" rel="stylesheet">
		<script src="../JS/check.jsp"></script>
		<script src="onclock.JS"></script>
		<script type="text/javascript">
			var XmlHttpRequest = false;
			function createXMLHttpRequest() {
    		if (window.XMLHttpRequest) {
    			XmlHttpRequest = new XMLHttpRequest();
    		} else {
    			try {
	    				if (window.ActiveXObject) {
	    					XmlHttpRequest = new ActiveXObject("Msxml.XMLHTTP");
	    				}
	    			} catch (e) {	
		    				try {
		    					XmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
		    				} catch (e) {
	    				}
	    			}
	    		}
	    	}
			function psosendRequest(){
				var superTypeCode = "superTypeCodeAjax="+document.form1.supertype.options[document.form1.supertype.selectedIndex].value;
				createXMLHttpRequest();			
				XmlHttpRequest.open("post","SelectSubTypeAjax",true);
				XmlHttpRequest.onreadystatechange = poshandleResponse;
				XmlHttpRequest.setRequestHeader ("content-type","application/x-www-form-urlencoded");				
				XmlHttpRequest.send(superTypeCode);
			}
			function poshandleResponse() {
	    		if (XmlHttpRequest.readyState==4) {
	    			if (XmlHttpRequest.status==200) {   	
	    					var sub = XmlHttpRequest.responseText;
	    					var subType = sub.split("|");
	    					var subCode = new Array();
	    					var subTypeName = new Array();
	    					for(i=0;i<subType.length-1;i++){
	    						subCode[i] = subType[i].split(",")[0];
	    						subTypeName[i] = subType[i].split(",")[1];
	    					}
	    					if(document.form1.supertype.selectedIndex==0) {
	    						document.form1.typeID.length=1;
	    						document.form1.typeID.options[0].value="0";
	    						document.form1.typeID.options[0].text="请选择";
	    					} else {
	    						document.form1.typeID.length=subType.length-1;
	    						for(i=0;i<subType.length-1;i++) {
	    							document.form1.typeID.options[i].value=subCode[i];
	    							document.form1.typeID.options[i].text=subTypeName[i];
	    						}
	    					}
		    			}
		    		}
		    	}
		    	function rebateCount() {
		    		var price = "markprice="+document.getElementById("markprice").value+"&memberprice="+document.getElementById("memberprice").value;
		    		createXMLHttpRequest();
		    		XmlHttpRequest.open("post","RebateAjax",true);
		    		XmlHttpRequest.onreadystatechange = rebatehandle;
		    		XmlHttpRequest.setRequestHeader ("content-type","application/x-www-form-urlencoded");
		    		XmlHttpRequest.send(price);
		    	}
		    	function rebatehandle() {
		    		if (XmlHttpRequest.readyState==4) {
	    			if (XmlHttpRequest.status==200) {  
	    					document.getElementById("rebate").value = XmlHttpRequest.responseText;
	    				}
	    			}
		    	}
		</script>
	</head>
	<%
		FCKeditor fckEditor = new FCKeditor(request, "introduce");
		fckEditor.setHeight("300");
		%>
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
								      <td valign="top" background="../images/manage_center_goodsmodi.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0">
								        <tr>
								          <td width="98%" align="right"></td>
								          <td width="2%">&nbsp;</td>
								        </tr>
								      </table></td>
								    </tr>
								  </table>
								<!-- 不同的部分顶部的图片 -->

								<!-- 不同的部分中间的部分 -->
									 <form action="UpdateGoods?goodsID=${goodsID }&currentPage=${currentPage}" method="post" name="form1" enctype="multipart/form-data">
									    <table width="100%"  border="0" align="center" cellpadding="-2" cellspacing="-2" bordercolordark="#FFFFFF">
						                  <tr>
						                    <td height="30">&nbsp;所属大类：</td>
						                    <td width="31%">&nbsp;
											  <select name="supertype" class="textarea" id="supertype" onChange="psosendRequest()"> 				  
											   <option value="${goods.superTypeCode }" selected>${goods.superTypeName }</option>
											  <c:forEach var="al" items="${alSuperType}">
												  <c:if test="${al.typeCode != goods.superTypeCode }">
												  	<option value="${al.typeCode }" >${al.typeName }</option>	
												  </c:if>
											  </c:forEach>				  
						                      </select></td>
						                    <td width="13%"> &nbsp;所属小类：</td>
						                    <td width="42%">&nbsp;
						                      <select name="typeID" class="textarea" id="typeID">	
						                       <option value="${goods.typeCode }" selected>${goods.typeName }</option>	
						                      <c:forEach items="${alSubType}" var="al">		
						                     	 <c:if test="${goods.typeCode != al.typeCode}">  
											    	<option value="${al.typeCode }">${al.typeName }</option>	
											    </c:if>	
											   </c:forEach>				 
						                      </select>
						                    </td>
						                  </tr>
						                  <tr>
						                    <td width="14%" height="30">&nbsp;商品名称：</td>
						                    <td colspan="3">&nbsp;
						                      <input name="goodsName" type="text" value="${goods.goodsName }" class="Sytle_text" id="bookID2" size="50">&nbsp;&nbsp;                    </td>
						                    </tr>
						                  <tr>
						                    <td height="30">&nbsp;市场价格：</td>
						                    <td>&nbsp;
						                          <input name="markprice" type="text" value="${goods.goodsNormalPrice }" class="Sytle_text" id="price">(元)
						                    </td>
						                    <td>&nbsp;商城价格：</td>
						                    <td>&nbsp;
						                          <input name="memberprice" type="text" value="${goods.goodsMemberPrice }" class="Sytle_text" id="price">(元)
						                    </td>
						                  </tr>
						                  <tr>                    
						                    <td height="30">&nbsp;折 扣 率：</td>
						                    <td>&nbsp;
						                         <input name="rebate" type="text" value="${goods.goodsRebate }" class="Sytle_text" id="price" size="10" readonly>
						                          <input name="but" type="button" class="Sytle_text" id="but" value="计算折扣率" onclick="rebateCount()">
						                    </td>
						                    <td>&nbsp;是否特价：</td>
						                    <td>
						                    <c:if test="${goods.isSale == 'y' }">
						                    <input name="sale" type="radio" class="noborder" value="y" checked>是
						                    <input name="sale" type="radio" class="noborder" value="n">否
						                    </c:if>
						                    <c:if test="${goods.isSale == 'n' }">
						                    <input name="sale" type="radio" class="noborder" value="y" >是
						                    <input name="sale" type="radio" class="noborder" value="n" checked>否
						                    </c:if>
						                    </td>
						                  </tr> 
						                  <tr>
						                    <td height="30">&nbsp;商品图片：</td>
						                    <td colspan="3"><span class="style5">&nbsp; </span>
						                       <input type="file" name="pricute" size=50 onpaste="return false" oncontextmenu="window.event.returnvalue=false;" oncopy="return false;" oncut="return false;"　>
						                    </td>
						                  </tr>
						                  <tr>
						                    <td height="103">&nbsp;商品简介：</td>
						                    <td colspan="3"><span class="style5">&nbsp; </span>
						                       <%
												T_Goods goods= (T_Goods)request.getAttribute("goods");
												fckEditor.setValue(goods.getGoodsIntroduce());
												out.println(fckEditor);
											   %>
						                  </tr>
						                  <tr>
						                    <td height="38" colspan="4" align="center">
						                        <input name="Button" type="submit" class="btn_grey" value="保存" ">
						&nbsp;                        
						<input name="Submit2" type="reset" class="btn_grey" value="重置">
						                        &nbsp;
						                        <input name="Submit3" type="button" class="btn_grey" value="返回" onClick="JScript:history.back(-1)">
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

