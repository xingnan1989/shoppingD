<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../CSS/style.css" rel="stylesheet">
<script src="../JS/check.jsp"></script>
<script src="onclock.JS"></script>
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
                <td valign="top" background="../images/manage_center_placardlist.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0"> 
                    <tr> 
                      <td width="98%" align="right"><a href="placard_add.jsp">[ <img src="../images/list.gif" width="11" height="13">&nbsp;添加公告信息]</a></td> 
                      <td width="2%">&nbsp;</td> 
                    </tr> 
                  </table></td> 
              </tr> 
            </table> 
            
              <table width="98%" height="192"  border="0" cellpadding="0" cellspacing="0"> 
                <tr> 
                  <td valign="top">                   
                    <table width="100%" height="48"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#CCCCCC" bordercolorlight="#FFFFFF"> 
                      <tr bgcolor="#eeeeee"> 
                        <td width="10%" align="center">编号</td> 
                        <td width="40%" height="24" align="center">公告标题</td> 
                        <td width="20%" align="center">发布时间</td> 
                        <td width="20%" align="center">失效时间</td> 
                        <td width="5%" align="center">修改</td>
                        <td width="5%" align="center">删除</td>
                      </tr>
                      <%
                      	int i=1;
                       %>
                      <c:forEach items="${pdal}" var="pdal">                     
                      <tr style="padding:5px;"> 
                      <%
                      	request.setAttribute("i",i);
                      	i++;
                       %>
                        <td height="20" align="center">${i}</td> 
                        <td align="center">${pdal.placardTitle }</td> 
                        <fmt:parseDate value="${pdal.issueDate }" pattern="yyyy-MM-dd HH:mm:ss" var="greateDate"/>
                      	<fmt:formatDate value="${greateDate}" pattern="yyyy-MM-dd" type="both" timeStyle="full" var="issueDate"/>
                        <td align="center">${issueDate}</td>
                        <fmt:parseDate value="${pdal.expireDate}" pattern="yyyy-MM-dd HH:mm:ss" var="greateDate2"/>
                      	<fmt:formatDate value="${greateDate2}" pattern="yyyy-MM-dd" type="both" timeStyle="full" var="expireDate"/>
                        <td align="center">${expireDate}</td> 
                        <td align="center"><a href="PlacardSelectplacardID?placardID=${pdal.placardID }"><img src="../images/modify.gif" width="15" height="15"></a></td>
                        <td align="center"><a href="PlacardDelete?placardID=${pdal.placardID }"><img src="../images/del.gif" width="16" height="16"></a></td>
                      </tr>  
                      </c:forEach>                    
                    </table>                   
                    <table width="100%"  border="0" cellspacing="0" cellpadding="0">
					  <tr>
					    <td align="right">
					     总共有：&nbsp;${page.totalRecord }&nbsp;条记录&nbsp;&nbsp;
						当前页数：[${page.currentPage }/${page.totalPage }]&nbsp;
						<a href="PlacardSelect?page=1">第一页 </a>
						<c:if test="${page.currentPage > 1}">
						<a href="PlacardSelect?page=${page.currentPage - 1 }">上一页</a>
						</c:if> 
						<c:if test="${page.currentPage < page.totalPage}">
						<a href="PlacardSelect?page=${page.currentPage + 1 }">下一页
						</c:if> 
						<a href="PlacardSelect?page=${page.totalPage}">最后一页&nbsp;</a>
						</td>
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
		      <table width="100%" height="78"  border="0" align="center" cellpadding="-2" cellspacing="-2">
		      <tr>
		        <td height="13" colspan="5"></td>
		        </tr>
		      <tr>
		        <td width="124" height="13">&nbsp;</td>
		        <td height="13" colspan="3" align="center">奋斗子商城客户服务热线：0791-3881060，3881061 传真：0791-3881063</td>
		        <td width="141">&nbsp;</td>
		      </tr>
		      <tr>
		        <td height="15" colspan="2">&nbsp;</td>
		        <td width="464" valign="bottom" align="center"> CopyRight &copy; 2009 www.fendoujiaoyu.com 奋斗教育</td>
		        <td colspan="2">&nbsp;</td>
		      </tr>
		      <tr>
		        <td colspan="2">&nbsp;</td>
		        <td align="center">本站请使用IE6.0或以上版本 1024*768为最佳显示效果</td>
		        <td colspan="2">&nbsp;</td>
		      </tr>
		      <tr bgcolor="#cccccc">
		        <td height="8" colspan="2"></td>
		        <td height="8" align="center"></td>
		        <td height="8" colspan="2"></td>
		      </tr>
		    </table>
		      <!--版权信息结束  -->  
          </td> 
        </tr> 
      </table></td> 
  </tr> 
</table> 
</body>
</html>

 
