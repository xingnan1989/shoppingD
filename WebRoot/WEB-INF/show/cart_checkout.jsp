<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<html>
<head>
<title>奋斗电子商城</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="CSS/style.css" rel="stylesheet">
</head>
	<script language="javascript" type="text/javascript" src="JS/order.js"></script>
	<script language="javascript" type="text/javascript" src="JS/ordervalidate.js"></script>
<body>
	<table width="790" border="0" cellspacing="0" cellpadding="0"
			align="center">
			<tr>
				<td class="tableBorder">
					<!--导航条-->
					<%@ include file="navigation.jsp" %>
					<!--导航条结束-->
					<table width="790" height="236" border="0" align="center"
						cellpadding="0" cellspacing="0">
						<tr>
							<td width="182" height="182" valign="top">
								<!--左侧框架-->
								<%@ include file="left.jsp" %>
								<!--左侧框架结束-->
							</td>
							<td valign="top">
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td height="33" background="images/shop_12.gif"></td>
										<td width="505" height="33" align="right" valign="middle"
											background="images/shop_12.gif">
											<table width="100%" height="24" border="0" cellpadding="0"
												cellspacing="0">
												<tr>
													<td height="8"></td>
												</tr>
												<tr>
													<td align="right" class="word_green">
														
													</td>
												</tr>
											</table>
										</td>
										<td width="10" background="images/shop_12.gif">
											&nbsp;
										</td>
									</tr>
									<tr>
										<td width="93" height="50" background="images/shop_15.gif">
											&nbsp;
										</td>
										<td colspan="2" background="images/shop_16.gif">
											<!--搜索框-->
											<%@ include file="search.jsp" %>
											<!--搜索框结束-->
										</td>
									</tr>
								</table>
			
  <table width="100%"  border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="189" valign="top"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="80" background="images/center_checkout.gif">&nbsp;</td>
              </tr>
            <tr valign="top">
              <td height="134" align="center">
              	
                 <form method="post" action="OrderSubmit" name="form_checkout" onsubmit="return submitl()">
                    <table width="100%" height="339"  border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="7%" height="26">&nbsp; </td>
                        <td height="26" colspan="2" class="word_deepgrey">注意：请您不要恶意或非法提交订单以免造成不必要的麻烦！</td>
                        </tr>
                      <tr>
                        <td height="26" colspan="2" align="center">姓名：</td>
                        <td><div id="inputmemberTrueName">${mab.memberTrueName}</div><span id="namespan"></span></td>
                      </tr>
                       
                      <tr>
                        <td height="26" colspan="2" align="center">地址：</td>
                        <td>
                        	<div id="inputmemberAddress">${mab.memberAddress }</div>
                        	<span id="addressspan"></span>
                        </td>
                      </tr>
                      <tr>
                        <td height="26" colspan="2" align="center">邮编：</td>
                        <td><div id="inputmemberPostcode">${mab.memberPostcode }</div><span id="postcodespan"></span></td>
                      </tr>
                      <tr>
                        <td height="26" colspan="2" align="center">电话：</td>
                        <td><div id="inputmemberTelephone">${mab.memberTelephone }</div><span id="telephonespan"></span></td>
                      </tr>
                      <tr>
                        <td height="26" colspan="2" align="center">送货地址</td>
                        <td width="74%">
                        	<div id="button" class="line"><input type="button" value="修改" onclick="orderAddressUpdate()"></div><span id="address" class="line"></span>
                        </td>
                      </tr>
                      <tr>
                        <td height="26" colspan="2" align="center">区域地址：</td>
                        <td>
                        	省份:<select name="province" onchange="sendCityAjax()">
    							<option value="${provinceCode }" >${province}</option>
    							<c:forEach items="${p_al}" var="p">
    								<option value="${p.provinceCode }">${p.province}</option>
    							</c:forEach>
					    		</select>
					    	城市:<select name="city" onchange="sendAreaAjax()">
					    			<option value="${cityCode }">${city }</option>
					    		</select>
					    	
					    	地区:<select name="area">
					    			<option value="${areaCode }">${area }</option>
					    		</select>
					    	<span id="addressPCAspan"></span>
                        </td>
                       </tr>
                      <tr>
                        <td height="28" colspan="3"><hr align="center" width="92%" size="1"></td>
                      </tr>
                      <tr>
                        <td height="26" colspan="2" align="center">付款方式</td>
                        <td><div id="orderPayMode" class="line">${opm.payContent}</div>
                        	<div class="line3"><span id="payMode_v"></span></div>
                        	<div class="line2" id="button2"><input type="button" value="修改" onclick="orderPayModeUpdate()"></div>
                        </td>
                      </tr>
                      <tr>
                        <td height="26" colspan="2" align="center" valign="top">开具发票</td>
                        <td valign="top">
                        	<div id="need"><input type="checkbox" name="needinvoice"  class="noborder" onclick="nd1()"></div></br>
                        	<span id="ndtext"></span></br>
                        	<span id="needselect"></span>
                        </td>
                      </tr>
                      <tr>
                        <td height="28" colspan="3"><hr align="center" width="92%" size="1"></td>
                      </tr>
                      <tr>
                        <td height="26" colspan="2" align="center">送货方式</td>
                        <td><div id="orderCarryMode" class="line">${ocm.carryContent }</div>
                        	<div class="line3"><span id="carryMode_v"></span></div>
                        	<div class="line2" id="orderCarryModebutton"><input type="button" value="修改" onclick="OrderCarryMode()"></div>
                        </td>
                      </tr> 
                      <tr>
                        <td height="26" colspan="2" align="center">时间要求</td>
                        <td>(注:如对送货时间有特别要求请注明)<span id="orderCarryTime_v"></span></td>
                         
                      </tr> 
                      <c:forEach items="${octal}" var="octal">
                      <tr>
                        <td height="26" colspan="2" align="center"></td>
                        <td>
                        	<input type="radio" value="${octal.carryTimeID }" name="time1" class="noborder" onclick="orderCarryTimevalidate()">${octal.carryTimeContent }
                        </td>
                        
                      </tr> 
                      </c:forEach>
                      <tr>
                        <td height="101" colspan="2" align="center">备注：</td>
                        <td><textarea name="bz" cols="50" rows="5" class="textarea" id="bz"></textarea></td>
                      </tr>                       
                      <tr align="center">
                        <td colspan="3"><input type="submit" class="btn_grey" value="提交" >
                           &nbsp;
                           <input type="button" class="btn_grey" value="返回" onClick="history.back(1);"></td>
                        </tr>
                    </table>
</form>
			  </td>
            </tr>
            <tr>
              <td height="38" align="right" background="images/center02.gif"></td>
              </tr>
          </table></td>
          </tr>
      </table></td>
  </tr>
</table>
<table width="790"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>
      <!--版权信息-->
		<%@ include file="copyright.jsp" %>
	<!--版权信息结束-->
    </td>
  </tr>
</table>
</td>
</tr>
</table>
</body>
</html>

