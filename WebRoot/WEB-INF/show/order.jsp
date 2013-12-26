<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*" %>
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
              <td height="80" background="images/center_order.gif">&nbsp;</td>
              </tr>
            <tr valign="top">
              <td height="134" align="center">
             	 
					<table width="94%"  border="0" cellpadding="3" cellspacing="3">
                    <tr align="center" >
                      <td width="15%" height="30" class="tableBorder_B_dashed">订单号</td>
                      <td width="25%" class="tableBorder_B_dashed">订单时间</td>
                      <td width="10%" class="tableBorder_B_dashed">收货人</td>
                      <td width="40%" class="tableBorder_B_dashed">订单商品</td>
                      <td width="10%" class="tableBorder_B_dashed">订单状态</td>
                    </tr>
                    <c:forEach items="${ooal}" var="ooal">

                    <tr align="center" >
                      <fmt:parseDate value="${ooal.order.greateDate}" pattern="yyyy-MM-dd HH:mm:ss" var="greateDate"/>
                      <fmt:formatDate value="${greateDate}" pattern="yyyyMMdd" type="both" timeStyle="full" var="ordernumber1"/>
                      <td class="tableBorder_B_dashed"><a href="OrderDetailShow?orderID=${ooal.order.orderID}">${ordernumber1}${ooal.order.orderID}</a></td>
                      <td class="tableBorder_B_dashed">
                      	<fmt:parseDate value="${ooal.order.updateDate}" pattern="yyyy-MM-dd HH:mm:ss" var="updateDate"/>
						<fmt:formatDate value="${updateDate}" pattern="yyyy年MM月dd日 HH:mm:ss" type="both" timeStyle="full"/>
                      </td>
                      <td class="tableBorder_B_dashed">${ooal.order.memberTureName }</td>
                      <td class="tableBorder_B_dashed">
                      		<c:forEach items="${ooal.odal}" var="odal">
                              ${odal.goodsName }<br>
                            </c:forEach>
                      </td>
                      <td class="tableBorder_B_dashed">新订单<br/>
                      <c:if test="${ooal.order.orderStatus=='N'}">
                      	<a href="OrderSend?orderID=${ooal.order.orderID }" onclick="ordersend(${ooal.order.orderID })">取消</a>
                      </c:if>
                       <c:if test="${ooal.order.orderStatus=='Y'}">
                      	已发送
                      </c:if>
                      </td>
                    </tr>	
                    </c:forEach>
                    <tr align="center">
                    	<td colspan="5">
		                  总共有：&nbsp;${page.totalRecord }&nbsp;条记录&nbsp;&nbsp;
						当前页数：[${page.currentPage }/${page.totalPage }]&nbsp;
						<a href="OrderOrderAndDetatlSelect?page=1">第一页 </a>
						<c:if test="${page.currentPage > 1}">
						<a href="OrderOrderAndDetatlSelect?page=${page.currentPage - 1 }">上一页</a>
						</c:if> 
						<c:if test="${page.currentPage < page.totalPage}">
						<a href="OrderOrderAndDetatlSelect?page=${page.currentPage + 1 }">下一页
						</c:if> 
						<a href="OrderOrderAndDetatlSelect?page=${page.totalPage}">最后一页&nbsp;</a>
						</td>
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

 
