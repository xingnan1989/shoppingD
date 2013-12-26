<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<html>
  <head>  
    <title>My JSP 'mai.jsp' starting page</title>
  </head>
  
  <body>
  	<%
  		long i=2;
  		session.setAttribute("memberID",i);
  		session.setAttribute("memberName","q464610036");
  		session.setAttribute("memberTrueName","寒若冰");
  	 %>
    商品1<a href="OrderShopcar?goodsID=1">购买</a><br>
    商品2<a href="OrderShopcar?goodsID=2">购买</a><br>
    商品3<a href="OrderShopcar?goodsID=3">购买</a>
    <img src="images/T_contact.gif" width="42" height="28">
      
  </body>
</html>
