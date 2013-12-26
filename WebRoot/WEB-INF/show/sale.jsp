<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script language="javascript" type="text/javascript" src="JS/individuality.js"></script>
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
        <td width="505" height="33" align="right" valign="middle" background="images/shop_12.gif"><table width="100%" height="24"  border="0" cellpadding="0" cellspacing="0">
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
              <td height="80" background="images/center_sale.gif">&nbsp;</td>
              </tr>
            <tr valign="top">
              <td height="134" align="center">
			  <c:forEach items="${alSaleGoods}" var="al">
                  <table width="98%" height="79"  border="0" cellpadding="0" cellspacing="0" class="noborder">
                    <tr>
                      <td width="37%" height="95" rowspan="4" align="center"><img src="${al.goodsPicture }" width="150" height="100"></td>
                      <td width="63%" height="27" class="font2"><a href="Goods_detail?goodsID=${al.goodsID }">${al.goodsName }</a></td>
                    </tr>
                    <tr>
                      <td height="27" style="text-decoration:line-through;">市场价：￥${al.goodsNormalPrice } </td>
                    </tr>
                    <tr>
                      <td height="27" style="color:#FF0000">商城价：￥${al.goodsMemberPrice }(<fmt:formatNumber pattern="#.#" value="${al.goodsRebate*10}"></fmt:formatNumber>折) </td>
                    </tr>                   
                    <tr>
                      <td>
						<c:if test="${memberID ne null}">
							<input type="button" class="btn_grey" value="购买" onclick="goods(${al.goodsID })">&nbsp;&nbsp;
						 	<input type="button" class="btn_grey" value="收藏" onclick="individuality(${al.goodsID })">
						</c:if>
						<c:if test="${memberID eq null}">
							<input type="button" class="btn_grey" value="购买" onclick="alert('请先登录后再购买')">
							<input type="button" class="btn_grey" value="收藏" onclick="alert('请先登录后再收藏')">
						</c:if>
					  </td>
                    </tr>
                  </table>
				  <hr align="center" width="92%" size="1">
				  </c:forEach>
				  总共有：&nbsp;${page.totalRecord }&nbsp;条记录&nbsp;&nbsp;
				当前页数：[${page.currentPage }/${page.totalPage }]&nbsp;
				<a href="Sale?pages=1">第一页 <c:if
						test="${page.currentPage > 1}">
						<a href="Sale?pages=${page.currentPage - 1 }">上一页</a>
					</c:if> <c:if test="${page.currentPage < page.totalPage}">
						<a href="Sale?pages=${page.currentPage + 1 }">下一页
						
					</c:if> <a href="Sale?pages=${page.totalPage}">最后一页&nbsp;</a>
                 </td>
            </tr>
            <tr>
              <td height="38" align="right" background="images/center02.gif">
              </td>
              </tr>
          </table>
          
          </td>
          </tr>
      </table>
     </td>
  </tr>
</table>
<table width="790"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>
    <!--版权信息-->
	<%@ include file="copyright.jsp"%>
	<!--版权信息结束-->
    </td>
  </tr>
</table>
</td>
</tr>
</table>
</body>
</html>
 