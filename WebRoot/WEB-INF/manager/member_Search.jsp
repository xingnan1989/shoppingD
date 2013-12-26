<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
        <td valign="top" background="../images/manage_center_memberlist.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="98%" align="right">
            <!--搜索框-->
				<form name="search" method="post" action="MemberSearch">
				<table width="100%" height="23"  border="0" cellpadding="0" cellspacing="0">
				<tr>
				  <td height="7"></td>
				</tr>
				<tr>
				  <td width="85%">&nbsp;&nbsp;&nbsp;&nbsp;会员编号：
					<input name="mid" type="text" class="txt_grey" size="10">
					会员名：
					<input name="mname" type="text" class="txt_grey" size="10">              
                    <input type="submit" class="btn_grey" value="搜索"></td>
				</tr>
				</table>
				</form>
				<!--搜索框结束-->
						</td>
            <td width="2%">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table>
      <table width="98%" height="192"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td valign="top">
          <table width="100%" height="14"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="13" align="center">&nbsp;</td>
            </tr>
          </table>
          <c:choose>
          	<c:when test="${empty member}">
          		<table width="300" height="75" align="center">
              	<tr align="center">
                	<td>${memberTip}</td>
              	</tr>
              </table>
          	</c:when>
          	<c:otherwise>
            <table width="100%" height="48"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#CCCCCC" bordercolorlight="#FFFFFF">
              <tr>
                <td width="5%" align="center">编号</td>
                <td width="10%" height="27" align="center">用户名</td>
                <td width="15%" align="center">真实姓名</td>
                <td width="30%" align="center">Email</td>
                <td width="10%" align="center">销费额</td>
                <td width="10%" align="center">会员等级</td>
                <td width="15%" align="center">创建时间</td>
                <td width="5%" align="center">冻结</td>
              </tr>
              <tr style="padding:5px;">
                <td align="center">1</td>
                <td height="24" align="center"><a href="QueryMemberDetail?memberid=${member.memberID}">${member.memberName}</a></td>
                <td align="center">${member.memberTrueName}</td>
                <td align="center">${member.memberEmail}</td>
                <td align="center">${member.memberAmount}</td>
                <td align="center">${member.memberGrade}</td>
                <td align="center">${member.createDate}</td>
                <td align="center">
                <c:if test="${member.memberStatus eq 1}">
                <a href="SearchLockMember?memberid=${member.memberID}">
                <img src="../images/freeze.gif" alt="冻结" width="13" height="15"></a> 
                </c:if> 
                <c:if test="${member.memberStatus eq 0}">
                <a href="SearchUnlockMember?memberid=${member.memberID}">
                <img src="../images/thaw.gif" alt="解结" width="13" height="15"></a> 
                </c:if>               
				</td>
              </tr>
            </table>
			</c:otherwise>
          </c:choose>	
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
</tr>
</table>
</body>
</html>

 



