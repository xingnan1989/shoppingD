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
			function invalidata() {
				if(confirm("您确定要使此商品失效！")) {
					return true;
				} else {
					return false;
				}
			}
			function repair(goodsID) {
				document.getElementById("showText").style.display="block";
				document.getElementById("asd").value=goodsID;
			}
			function sub() {
				var repair = "repair="+document.getElementById("repair").value+"&goodsID="+document.getElementById("asd").value+"&goodsNumberHidden="+document.getElementById("goodsNumberHidden").value;
				var repair1 = document.getElementById("repair").value;
				if(/^[0-9]*[1-9][0-9]*$/.test(repair1)||repair1==""||repair1==null) {
					createXMLHttpRequest();
					XmlHttpRequest.open("post","RepairAjax",true);
					XmlHttpRequest.onreadystatechange = handleResponse;
					XmlHttpRequest.setRequestHeader("content-type","application/x-www-form-urlencoded");
					XmlHttpRequest.send(repair);
					document.getElementById("showText").style.display="none";
				} else {
					alert("您输入的值不合法！");
				}		
			}
			function handleResponse() {
				if (XmlHttpRequest.readyState==4) {
	    			if (XmlHttpRequest.status==200) {   
	    				var str = XmlHttpRequest.responseText;
	    				var goodsID = document.getElementById("asd").value;
	    				if("succeed" == str.split("|")[0]) {
	    					var goodsNumber = str.split("|")[1]
	    					document.getElementById("showText").style.display="none";
	    					document.getElementById("goodsNumber"+goodsID).innerHTML=goodsNumber;
	    					window.location.reload();
	    				}
	    			}
	    		}
			}
			function psosendRequest(){
				var superTypeCode = "superTypeCodeAjax="+document.form1.supertype.options[document.form1.supertype.selectedIndex].value;
				createXMLHttpRequest();			
				XmlHttpRequest.open("post","SelectSubTypeAjax",true);
				XmlHttpRequest.onreadystatechange = poshandleResponse;
				XmlHttpRequest.setRequestHeader("content-type","application/x-www-form-urlencoded");				
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
	    						document.form1.typeID.options[0].text="小类";
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
								        <td valign="top" background="../images/manage_03.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0">
								          <tr>
								            <td width="70%">
									            <!--搜索框-->
												<form name="form1" method="post" action="Seach">
												<table width="100%" height="23"  border="0" cellpadding="0" cellspacing="0">
												<tr>
												  <td height="7"></td>
												</tr>
												<tr>
												  <td width="85%">&nbsp;&nbsp;&nbsp;&nbsp;商品类别：
													<select name="supertype" class="textarea" onchange="psosendRequest()">
													  <option value="0" selected>大类</option>
													  <c:forEach items="${alSuperType}" var="al">
													  <option value="${al.typeCode }" >${al.typeName }</option>
													  </c:forEach>
													</select>
													<select name="typeID" class="textarea">
													<option value="0" selected>小类</option>
													</select>
													<input name="key" type="text" class="txt_grey" size="15">              
								                    <input type="submit" class="btn_grey" value="搜索"></td>
												</tr>
												</table>
												</form>
												<!--搜索框结束-->
								            </td>
								            <td width="28%" align="right"><a href="SelectSuperTypeGoods?goods_add=2009">[ <img src="../images/list.gif" width="11" height="13">&nbsp;添加商品信息]</a></td>     
								            <td width="2%">&nbsp;</td>       
								          </tr>
								        </table></td>
								      </tr>
								    </table>
								<!-- 不同的部分顶部的图片 -->

								<!-- 不同的部分中间的部分 -->
									<table width="98%" height="192"  border="0" cellpadding="0" cellspacing="0">
								      <tr>
								        <td valign="top">
								          <table width="100%" height="14"  border="0" cellpadding="0" cellspacing="0">
								            <tr>
								              <td height="13" align="center">&nbsp;</td>
								            </tr>
								          </table>
								          <table width="100%" height="48"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#CCCCCC" bordercolorlight="#FFFFFF">
								            <tr bgcolor="#eeeeee">
								              <td width="5%" align="center">编号</td>
								              <td width="25%" height="24" align="center">商品名称</td>
								              <td width="13%" align="center">所属类型</td>                
								              <td width="13%" align="center">价格</td>                
								              <td width="12%" align="center">商品数量</td>
								              <td width="12%" align="center">订购数量</td>
								              <td width="5%" align="center">特价</td>
								              <td width="5%" align="center">补货</td>
								              <td width="5%" align="center">修改</td>
								              <td width="5%" align="center">状态</td>
								            </tr>
											<c:forEach var="al" items="${goodsAl}">
								            <tr style="padding:5px;">
								              <td align="center">${al.goodsID }</td>
								              <td height="20" align="center"><a href="CommentManagerSelect?goodsID=${al.goodsID }">${al.goodsName }</a></td>                
								              <td align="center">${al.typeName }</td>
								              <td align="center">${al.goodsMemberPrice }</td>                
								              <td align="center" ><div id="goodsNumber${al.goodsID }">${al.goodsNumber }</div></td>
								              <td align="center">${al.buyGoodsNumber }</td>
								              <c:if test="${al.isSale == 'y'}">
								              <td align="center">是</td>
								              </c:if>
								              <c:if test="${al.isSale == 'n'}">
								              <td align="center">否</td>
								              </c:if>
								              <td align="center"><a href="#" onclick="repair(${al.goodsID })"><img src="../images/add.gif" width="16" height="16" alt="补货"></a></td>
								              <td align="center"><a href="SelectGoodsOne?goodsID=${al.goodsID }&currentPage=${page.currentPage }"><img src="../images/modify.gif" width="15" height="15" alt="修改商品信息"></a></td>
								              <c:if test="${al.isValid == 'y'}">
								              <td align="center"><a href="Invalidate?goodsID=${al.goodsID }&state=n&currentPage=${page.currentPage }" onclick="return invalidata()"><img src="../images/thaw.gif" width="16" height="16" alt="使商品失效"></a></td>
								              </c:if>
								              <c:if test="${al.isValid == 'n'}">
								              <td align="center"><a href="Invalidate?goodsID=${al.goodsID }&state=y&currentPage=${page.currentPage }" ><img src="../images/freeze.gif" width="16" height="16" alt="使商品生效"></a></td>
								              </c:if>
								            </tr>
								            <tr><td><input type="hidden" id="goodsNumberHidden" value="${al.goodsNumber }"></td></tr>
								            </c:forEach>
								          </table>
								          
								         <table width="100%"  border="0" cellspacing="0" cellpadding="0">
									  <tr>
									   <td align="right">
									   <c:if test="${page.totalRecord != 0}">
										总共有：&nbsp;${page.totalRecord }&nbsp;条记录&nbsp;&nbsp;
										当前页数：[${page.currentPage }/${page.totalPage }]&nbsp;
										<a href="SelectGoods?pages=1">第一页 <c:if
												test="${page.currentPage > 1}">
												<a href="SelectGoods?pages=${page.currentPage - 1 }">上一页</a>
											</c:if> <c:if test="${page.currentPage < page.totalPage}">
												<a href="SelectGoods?pages=${page.currentPage + 1 }">下一页
												
											</c:if> <a href="SelectGoods?pages=${page.totalPage}">最后一页&nbsp;</a>
											</c:if>
											 <c:if test="${page.totalRecord == 0}">
											 <tr>
											 	<td><center>&nbsp;</center></td>
											 </tr>
											 <tr>
											 	<td><center>&nbsp;</center></td>
											 </tr>
											 <tr>
											 	<td><center>暂无商品！</center></td>
											 </tr>
											</c:if>
										</td>
									  </tr>
									</table>	
								  </td>
								      </tr>
								    </table>
									 <div id="showText" style="display:none">补货：<input type="text" name="repair" size="10"/>&nbsp;&nbsp;<input type="hidden" id="asd"><input type="button" value="保存" onclick="sub()"></div>
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

