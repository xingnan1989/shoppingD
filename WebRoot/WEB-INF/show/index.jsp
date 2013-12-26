<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>奋斗电子商城</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="CSS/style.css" rel="stylesheet">
<script language='JavaScript' src='JS/menutree.js'></script>
<script language="javascript" type="text/javascript" src="JS/order.js"></script>
<script language="javascript" type="text/javascript" src="JS/ordervalidate.js"></script>
<script language="javascript" type="text/javascript" src="JS/individuality.js"></script>
</head>
<body>
<table width="790"  border="0" cellspacing="0" cellpadding="0" align="center">
 <tr>
 <td class="tableBorder">
<!--导航条-->
<%@ include file="navigation.jsp" %>
<!--导航条结束-->
<table width="790" height="236"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="182" height="182" valign="top">
	
	<!--左侧框架-->
	<%@ include file="left.jsp" %>
	<!--左侧框架结束-->
	</td>
    <td valign="top"><table width="100%"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="33" background="images/shop_12.gif"></td>
        <td width="505" height="33" align="right" valign="middle" background="images/shop_12.gif">
        <table width="100%" height="24"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td height="8"></td>
          </tr>
          <tr>
            <td align="right" class="word_green">
			<marquee direction="left" scrollamount="1" scrolldelay="1" onMouseOver="this.stop();" onMouseOut="this.start();">
			购买商品请先<a href="" style="color: #FF0000;">登录 </a>
			<a href="register.jsp" class="word_green">[新用户注册]</a>
			<!-- Mary欢迎您!(如果您不是Mary，<a href="" style="color: #FF0000;">请点击这里退出登录</a>) -->
			</marquee></td>
          </tr>
        </table></td>
        <td width="10" background="images/shop_12.gif">&nbsp;</td>
      </tr>
      <tr>
        <td width="93" height="50" background="images/shop_15.gif">&nbsp;</td>
        <td colspan="2" background="images/shop_16.gif" valign="top">
			<!--搜索框-->
			<%@ include file="search.jsp" %>
			<!--搜索框结束-->
		</td>
      </tr>
    </table>
      <table width="100%"  border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="69%" height="189" valign="top"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="98%" height="80" background="images/shop_18.gif">&nbsp;</td>
              <td width="2%"><img src="images/shop_19.gif" width="10" height="80"></td>
            </tr>
            <tr align="center" valign="top">
              <td height="134" colspan="2"><table width="100%" height="162"  border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="49%" height="162" valign="top">
				  <table width="100%"  border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td height="95" align="center"><img src="${goodsTejia1.goodsPicture }" width="150" height="88"></td>
                    </tr>
                    <tr>
                      <td height="22" align="center" class="font2"><a href="Goods_detail?goodsID=${goodsTejia1.goodsID }">${goodsTejia1.goodsName }</a></td>
                    </tr>
                    <tr>
                      <td height="20" align="center" style="text-decoration:line-through;">市场价：￥${goodsTejia1.goodsNormalPrice } </td>
                    </tr>
                    <tr>
                      <td height="20" align="center" style="color:#FF0000">商城价：￥${goodsTejia1.goodsMemberPrice }</td>
                    </tr>
                    <tr>
                      <td height="22" align="center">
                     	<c:if test="${memberID ne null}">
							<input type="button" class="btn_grey" value="购买" onclick="goods(${goodsTejia1.goodsID })">
                      		&nbsp;<input type="button" class="btn_grey" value="收藏" onclick="individuality(${goodsTejia1.goodsID })">
						</c:if>
						<c:if test="${memberID eq null}">
							<input type="button" class="btn_grey" value="购买" onclick="alert('请先登录后再购买')">
                      		&nbsp;<input type="button" class="btn_grey" value="收藏" onclick="alert('请先登录后再收藏')">
						</c:if>
                      
                      </td>
                    </tr>
                  </table>
				  </td>
                  <td width="2%" align="center" valign="top"><table width="3" height="160"  border="0" cellpadding="0" cellspacing="0" background="images/point.gif">
                    <tr>
                      <td></td>
                    </tr>
                  </table></td>
                  <td width="49%" valign="top">
				    <table width="100%"  border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td height="95" align="center"><img src="${goodsTejia2.goodsPicture }" width="150" height="88"></td>
                      </tr>
                      <tr>
                         <td height="22" align="center" class="font2"><a href="Goods_detail?goodsID=${goodsTejia2.goodsID }">${goodsTejia2.goodsName }</a></td>
                      </tr>
                      <tr>
                        <td height="20" align="center" style="text-decoration:line-through;">市场价：￥${goodsTejia2.goodsNormalPrice } </td>
                      </tr>
                      <tr>
                        <td height="20" align="center" style="color:#FF0000">商城价：￥${goodsTejia2.goodsMemberPrice }</td>
                      </tr>
                      <tr>
                        <td height="22" align="center">
                           <c:if test="${memberID ne null}">
							<input type="button" class="btn_grey" value="购买" onclick="goods(${goodsTejia2.goodsID })">
                      		&nbsp;<input type="button" class="btn_grey" value="收藏" onclick="individuality(${goodsTejia2.goodsID })">
						</c:if>
						<c:if test="${memberID eq null}">
							<input type="button" class="btn_grey" value="购买" onclick="alert('请先登录后再购买')">
                      		&nbsp;<input type="button" class="btn_grey" value="收藏" onclick="alert('请先登录后再收藏')">
						</c:if>
                        </td>
                      </tr>
                    </table>
				    </td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td height="42" align="right" background="images/shop_24.gif"><a href="Sale"><img src="images/MORE.GIF" width="50" height="20" border="0"></a>
                <br><br>
              </td>
              <td height="42" background="images/shop_25.gif">&nbsp;</td>
            </tr>
          </table>
            <table width="100%" height="76"  border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="361" background="images/shop_28.gif">&nbsp;</td>
                <td width="46" height="35" background="images/shop_29.gif">&nbsp;</td>
              </tr>
              <tr>
                <td colspan="2">
                <!-- 新品上架 -->
				<c:forEach var="alNewGoods" items="${alNewGoods}">
				<table width="100%" height="79"  border="0" cellpadding="0" cellspacing="0" class="tableBorder_B_dashed">
                  <tr>
                    <td width="33%" height="95" rowspan="2" align="center"><img src="${alNewGoods.goodsPicture }" width="99" height="61"></td>
                    <td width="67%" class="font2"><a href="Goods_detail?goodsID=${alNewGoods.goodsID }">${alNewGoods.goodsName }</a></td>
                  </tr>                  
                  <tr>
                    <td>￥${alNewGoods.goodsMemberPrice }(<fmt:formatNumber pattern="#.#" value="${alNewGoods.goodsRebate*10}"></fmt:formatNumber>折) 
                     	<c:if test="${memberID ne null}">
							<input type="button" class="btn_grey" onClick="goods(${alNewGoods.goodsID })" value="购买">
                      		&nbsp;<input type="button" class="btn_grey" value="收藏" onclick="individuality(${alNewGoods.goodsID})">
						</c:if>
						<c:if test="${memberID eq null}">
							<input type="button" class="btn_grey" onclick="alert('请先登录后再购买')" value="购买">
                      		&nbsp;<input type="button" class="btn_grey" value="收藏" onclick="alert('请先登录后再收藏')">
						</c:if>
					</td>
                  </tr>
                </table>               
                </c:forEach>
				<table width="100%" height="30"  border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="98%" align="right"><a href="NewGoods"><img src="images/MORE.GIF" width="50" height="20" border="0"></a></td>
                    <td width="2%">&nbsp;</td>
                  </tr>
                </table>
                </td>
              </tr>
            </table></td>
          <td width="31%" valign="top">
		  
		 <!--右侧框架-->
		 <%@ include file="right.jsp" %>
		 <!--右侧框架结束-->
		  </td>
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


 