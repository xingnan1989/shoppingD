<%@ page language="java" pageEncoding="UTF-8" import="net.fckeditor.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>后台管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="../CSS/style.css" rel="stylesheet">
		<script src="../JS/check.jsp"></script>
		<script src="onclock.JS"></script>
		<script>
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
			var supertype = document.getElementById("supertype").value;
	   		if(supertype==0) {
				return false;
			} else {
				var superTypeCode = "superTypeCodeAjax="+document.form1.supertype.options[document.form1.supertype.selectedIndex].value;
				createXMLHttpRequest();			
				XmlHttpRequest.open("post","SelectSubTypeAjax",true);
				XmlHttpRequest.onreadystatechange = poshandleResponse;
				XmlHttpRequest.setRequestHeader("content-type","application/x-www-form-urlencoded");				
				XmlHttpRequest.send(superTypeCode);
				document.getElementById("supertypeSpan").innerHTML = "";
				return true;
			}
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
	   	function checkGoodsName() {
	   		var goodsName = document.getElementById("goodsName").value;
	   		if(goodsName=="") {
	   			return false;
	   		} else {
	   			document.getElementById("goodsNameSpan").innerHTML = "";
	   			return true;
	   		}
	   	}
	   	function checkmarkprice() {
	   		var markprice = document.getElementById("markprice").value;
	   		var rule = /^[1-9]d*.d*|0.d*[1-9]d*$/;
	   		if(!rule.test(markprice)) {
	   			return false;
	   		} else  {
	   			document.getElementById("markpriceSpan").innerHTML = "";
	   			return true;
	   		}
	   	}
   	 	function checkmemberprice() {
	   		var memberprice = document.getElementById("memberprice").value;
	   		var rule = /^[1-9]d*.d*|0.d*[1-9]d*$/;
	   		if(!rule.test(memberprice)) {
	   			return false;
	   		} else  {
	   			document.getElementById("memberpriceSpan").innerHTML = "";
	   			return true;
	   		}
	   	}
	   	function checkprice() {
	   		var price = document.getElementById("price").value;
   			if(price=="") {
   				return false;
   			} 
	   		else  {
	   			document.getElementById("priceSpan").innerHTML = "";
	   			return true;
	   		}
	   	}
	   	function checkPic() {
				var pricute = document.getElementById("pricute").value;
				if(pricute=="") {
					return false;
				} else {
					document.getElementById("pricuteSpan").innerHTML="";
					return true;
				}
			}
			function succeed() {
				if(checkGoodsName()&&checkmarkprice()&&checkmemberprice()&&checkprice()&&checkPic()&&psosendRequest()) {
					return true;
				} else {
					if(psosendRequest()==false) {
						document.getElementById("supertypeSpan").innerHTML = "<font color='red'><small>大类不能为空！</small></font>";
					} else if(checkGoodsName()==false) {
				   			document.getElementById("goodsNameSpan").innerHTML = "<font color='red'><small>商品名称不能为空！</small></font>";
				   	} else if(checkmarkprice()==false) {
						var markprice = document.getElementById("markprice").value;
	   					var rule = /^[1-9]d*.d*|0.d*[1-9]d*$/;
						if(markprice=="") {
			   				document.getElementById("markpriceSpan").innerHTML = "<font color='red'><small>市场价格不能为空！</small></font>";
			   			} else {
			   				document.getElementById("markpriceSpan").innerHTML = "<font color='red'><small>市场价格输入有误！</small></font>";
			   			}
			   		} else if(checkmemberprice()==false) {
			   			var memberprice = document.getElementById("memberprice").value;
				   		var rule = /^[1-9]d*.d*|0.d*[1-9]d*$/;
			   			if(memberprice=="") {
			   				document.getElementById("memberpriceSpan").innerHTML = "<font color='red'><small>商城价格不能为空！</small></font>";
			   			} else {
			   				document.getElementById("memberpriceSpan").innerHTML = "<font color='red'><small>商城价格输入有误！</small></font>";
			   				}
				   		}else if(checkprice()==false) {
				   			document.getElementById("priceSpan").innerHTML = "<font color='red'><small>折扣率不能为空号！</small></font>";
				   		} else if(checkPic()==false) {
				   			document.getElementById("pricuteSpan").innerHTML = "<font color='red'><small>图片不能为空！</small></font>";
				   		} 
				   		return false;
			   		}
				}
		</script>
	</head>
		<%
		FCKeditor fckEditor = new FCKeditor(request, "introduce");
		fckEditor.setHeight("400");
		fckEditor.setWidth("480");
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
								        <td valign="top" background="../images/manage_center_goodsadd.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0">
								          <tr>
								            <td width="98%" align="right"></td>
								            <td width="2%">&nbsp;</td>
								          </tr>
								        </table></td>
								      </tr>
								    </table>
								<!-- 不同的部分顶部的图片 -->

								<!-- 不同的部分中间的部分 -->
								 <form action="GoodsAdd" method="post" name="form1" enctype="multipart/form-data">
									<table width="100%"  border="0" align="center" cellpadding="-2" cellspacing="-2" bordercolordark="#FFFFFF">
					                  <tr>
					                    <td height="30">&nbsp;所属大类：</td>
					                    <td width="31%">&nbsp;
										  <select name="supertype" class="textarea" id="supertype" onchange="psosendRequest()">
										  <option value="0">请选择</option>	
										  <c:forEach var="al" items="${alSuperType}">					  
										  <option value="${al.typeCode }">${al.typeName }</option>
										  </c:forEach>				  
					                      </select><span id="supertypeSpan"></span>	
					                      </td>
					                    <td width="13%"> &nbsp;所属小类：</td>
					                    <td width="42%">&nbsp;
					                      <select name="typeID" class="textarea" id="typeID">					  
										   <option value="0">请选择</option>			 
					                      </select><span id="typeIDSpan"></span>	
					                    </td>
					                  </tr>
					                  <tr>
					                    <td width="14%" height="30">&nbsp;商品名称：</td>
					                    <td colspan="3">&nbsp;
					                      <input name="goodsName" type="text" class="Sytle_text" id="bookID2" size="50" onblur="checkGoodsName()">&nbsp;&nbsp;<span id="goodsNameSpan"></span></td>
					                    </tr>
					                  <tr>
					                    <td height="30">&nbsp;市场价格：</td>
					                    <td>&nbsp;
					                          <input name="markprice" type="text" class="Sytle_text" id="markprice" onblur="checkmarkprice()">(元)<div id="markpriceSpan"></div>
					                    </td>
					                    <td>&nbsp;商城价格：</td>
					                    <td>&nbsp;
					                          <input name="memberprice" type="text" class="Sytle_text" id="memberprice" onblur="checkmemberprice()">(元)<span id="memberpriceSpan"></span>
					                    </td>
					                  </tr>
					                  <tr>                    
					                    <td height="30">&nbsp;折 扣 率：</td>
					                    <td>&nbsp;
					                         <input name="rebate" type="text" class="Sytle_text" id="price" size="10" readonly onblur="checkprice()">
					                          <input name="but" type="button" class="Sytle_text" id="but" value="计算折扣率" onclick="rebateCount()"><div id="priceSpan"></div>
					                    </td>
					                    <td>&nbsp;是否特价：</td>
					                    <td><input name="sale" type="radio" class="noborder" value="y" checked>是<input name="sale" type="radio" class="noborder" value="n">否
					                    </td>
					                  </tr>                 
					                  <tr>
					                    <td height="30">&nbsp;商品图片：</td>
					                    <td colspan="3"><span class="style5">&nbsp; </span>
					                       <input type="file" name="pricute" size=50 id="pricute" onblur="checkPic()"><span id="pricuteSpan"></span>
					                    </td>
					                  </tr>
					                  <tr>
					                    <td height="103">&nbsp;商品简介：</td>
					                    <td colspan="3"><span class="style5">&nbsp; </span>
					                        <!--  <textarea name="introduce" cols="60" rows="5" class="textarea" id="introduce"></textarea>-->
					                        <%
												fckEditor.setValue("");
												out.println(fckEditor);
											%>	
										</td>
					                  </tr>
					                  <tr>
					                    <td height="38" colspan="4" align="center">
					                        <input name="Button" type="submit" class="btn_grey" value="保存" onclick="return succeed()">
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

