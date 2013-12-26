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
        <td valign="top" background="../images/manage_center_orderdetail.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="98%" align="right">&nbsp;</td>
            <td width="2%">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table>
      <table width="95%" height="192"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td valign="top">
           <table width="100%" height="272"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td width="100%" height="220" align="center" valign="top">
				 <table width="97%" height="131"  border="0" cellpadding="0" cellspacing="0" class="tableBorder_LTR_dashed">
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
                      <td align="center">
                      <form action="OrderConsignment?orderID=${order2.orderID }" method="post">
                          <input type="submit" class="btn_grey" value="发货" >
                          <input type="button" class="btn_grey" value="返回" onClick="history.back(-1)">
                      </form>
                      </td>
                    </tr>
                  </table>
                </td>
              <td width="3%" valign="top">&nbsp;</td>
            </tr>
          </table>		 
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

 

 