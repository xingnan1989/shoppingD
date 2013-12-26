<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../CSS/style.css" rel="stylesheet">
</head>

<body  >  
<table width="777" height="192"  border="0" align="center" cellpadding="0" cellspacing="0" class="tableBorder">
<tr>
  <td>
<!-- LOGO -->
	<%@ include file="top.jsp" %>
<!-- LOGO结束-->
<table width="777" height="288"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="182" valign="top"><table width="100%" height="431"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top" background="../images/manage_02.gif">
         <!-- 操作菜单 -->
          <%@ include file="left.jsp" %>
         <!-- 操作菜单结束 --> 
        </td>
      </tr>
    </table></td>
    <td align="center" valign="top"><table width="100%" height="120"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top" background="../images/manage_center_orderlist.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="98%" align="right">
              <!--搜索框-->
				<%@ include file="fild.jsp" %>
				<!--搜索框结束-->
            </td>
            <td width="2%">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table>
      <table width="95%" height="192"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td valign="top" align="right">
            <table width="100%" height="48"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#CCCCCC" bordercolorlight="#FFFFFF">
              <tr align="center">
                <td width="10%">编号</td>
                <td width="15%" height="30">订单号</td>
                <td width="10%">订单金额</td>                                
                <td width="30%">订单商品</td>                
                <td width="25%">订单时间</td>
                <td width="10%">订单状态</td>
              </tr>
			  <%int i=1; 
              
              %>
              <c:forEach items="${ooal2}" var="ooal2">
              <%
              request.setAttribute("i",i);
              i++; 
              %>
			  <tr align="center">
			    <td>${i }</td>
			    <fmt:parseDate value="${ooal2.order.greateDate}" pattern="yyyy-MM-dd HH:mm:ss" var="greateDate"/>
                <fmt:formatDate value="${greateDate}" pattern="yyyyMMdd" type="both" timeStyle="full" var="ordernumber1"/>
                <td height="20"><a href="OrderDetailShow2?orderID=${ooal2.order.orderID }">${ordernumber1 }${ooal2.order.orderID }</a></td> 
                <td>￥${ooal2.order.orderAmount }</td>
                <td>
                <c:forEach items="${ooal2.odal}" var="odal">
                 ${odal.goodsName }（${odal.goodsCount }）<br>      
                </c:forEach>
                </td>          
                <td>${ooal2.order.updateDate }</td>
                <td>
                <c:if test="${ooal2.order.orderStatus eq 'Y'}" >
                	<c:out value="已发送"/>
                </c:if>
                <c:if test="${ooal2.order.orderStatus eq 'N'}" >
                	<c:out value="未发送"/>
                </c:if>
                </td>
              </tr>
              </c:forEach>
            </table>
          		 总共有：&nbsp;${page.totalRecord }&nbsp;条记录&nbsp;&nbsp;
				当前页数：[${page.currentPage }/${page.totalPage }]&nbsp;
				<a href="OrderManager?page=1">第一页 </a>
				<c:if test="${page.currentPage > 1}">
				<a href="OrderManager?page=${page.currentPage - 1 }">上一页</a>
				</c:if> 
				<c:if test="${page.currentPage < page.totalPage}">
				<a href="OrderManager?page=${page.currentPage + 1 }">下一页
				</c:if> 
				<a href="OrderManager?page=${page.totalPage}">最后一页&nbsp;</a>
            
		  </td>
        </tr>
      </table>
      <table width="100%" height="46"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td background="../images/manage_06.gif">&nbsp;</td>
        </tr>
      </table></td>
  </tr>
</table>
<table width="777"  border="0" align="center" cellpadding="0" cellspacing="0">
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

 

 