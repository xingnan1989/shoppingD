<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
              <td height="80" background="images/center_orderdetail.gif">&nbsp;</td>
              </tr>
            <tr valign="top">
              <td height="134" align="center">
                <table width="100%" height="272"  border="0" cellpadding="0" cellspacing="0">
                  <tr>
                   <td width="97%" height="220" align="center" valign="top">
					  <table width="90%" height="131"  border="0" cellpadding="0" cellspacing="0" class="tableBorder_LTR_dashed">
                        <tr>
                          <td width="16%" style="padding:5px;" align="center">订单时间：</td>
                          <td>${order2.updateDate}</td>
                        </tr>
                        <tr>
                          <td width="16%" style="padding:5px;" align="center">订 单 号：</td>
                           <fmt:parseDate value="${order2.greateDate}" pattern="yyyy-MM-dd HH:mm:ss" var="greateDate"/>
                      	   <fmt:formatDate value="${greateDate}" pattern="yyyyMMdd" type="both" timeStyle="full" var="ordernumber1"/>
                          <td>${ordernumber1 }${order2.orderID }</td>
                        </tr>
                        <tr>
                          <td width="16%" style="padding:5px;" align="center">订单总计：</td>
                          <td>${order2.orderAmount }</td>
                        </tr>
                        <tr>
                          <td colspan="2"><hr align="center" width="92%" size="1"></td>
                        </tr>
                        <tr>
                          <td style="padding:5px;" align="center">付款方式：</td>
                          <td>- ${order2.orderPay }</td>
                        </tr>
                        <tr>
                          <td style="padding:5px;" align="center">发票信息：</td>
                          <td>- ${order2.orderInvoice }</td>
                        </tr>
                        <tr>
                          <td colspan="2"><hr align="center" width="92%" size="1"></td>
                        </tr>
                        <tr>
                          <td style="padding:5px;" align="center">配送地址：</td>
                          <td>-姓名： ${order2.memberTureName }</td>
                        </tr>
                        <tr>
                          <td style="padding:5px;" align="center"></td>
                          <td>-详细地址： ${order2.memberAddress }</td>
                        </tr>
                        <tr>
                          <td style="padding:5px;" align="center"></td>
                          <td>-所在地区： ${order2.memberProvince }  ${order2.memberCity }  ${order2.memberArea }</td>
                        </tr>
                        <tr>
                          <td style="padding:5px;" align="center"></td>
                          <td>- 邮编：${order2.memberPostcode }</td>
                        </tr>
                        <tr>
                          <td style="padding:5px;" align="center"></td>
                          <td>- 电话：${order2.memberTelephone }</td>
                        </tr>
                        <tr>
                          <td style="padding:5px;" align="center">收货方式：</td>
                          <td>- ${order2.orderCarry }</td>
                        </tr>
                        <tr>
                          <td style="padding:5px;" align="center">备&nbsp;&nbsp;&nbsp;&nbsp;注：</td>
                          <td>- ${oct2.carryTimeContent }</td>
                        </tr>
                       
                      </table>
					  <table width="90%"  border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#CCCCCC" class="tableBorder_dashed">
                        <tr align="center" bgcolor="#eeeeee">
                          <td width="50%" height="24">商品名称</td>                          
                          <td width="20%">数量</td>
                          <td width="30%">单价</td>
                        </tr>
                        <c:forEach items="${odarray}" var="odarray">						
                        <tr align="center">
                          <td height="24">${odarray.goodsName }</td>                                                   
                          <td>${odarray.goodsCount }</td>
                          <td>￥${odarray.goodsPrice }(元)</td> 
                        </tr>
                        </c:forEach>
						<tr align="center">
                          <td colspan="2" align="right">总计：</td>
                          <td>￥${order2.orderAmount}(元)</td> 
                        </tr>
                        
                      </table>
					  <table width="100%" height="49"  border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td align="center"><input type="submit" class="btn_grey" value="返回" onClick="history.back(-1)"></td>
                        </tr>
                      </table></td>
              <td width="3%" valign="top">&nbsp;</td>
            </tr>
          </table>
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