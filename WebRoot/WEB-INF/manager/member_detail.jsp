<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../CSS/style.css" rel="stylesheet">
</head>

<body >  
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
        <td valign="top" background="../images/manage_center_memberdetail.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="98%" align="right">&nbsp;</td>
            <td width="2%">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table>
      <table width="92%" height="192"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td valign="top">
             <table width="100%" height="14"  border="0" cellpadding="0" cellspacing="0">
               <tr>
                 <td height="13" align="center">&nbsp;</td>
               </tr>
             </table>
             <table width="96%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tableBorder_B_dashed" >
                 <tr>              
	              <td height="28" class="font2">基本信息</td>
	              <td height="28" align="right">&nbsp;</td>
	            </tr>
                <tr>              
	              <td width="18%" height="30" align="center">用 户 名：</td>
	              <td width="82%" class="word_grey">${member.memberName }</td>
	            </tr>
	            <tr>
	              <td height="28" align="center">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
	              <td height="28">${member.memberPassword }</td>
	            </tr> 
	            <tr>
	              <td height="28" align="center">E-mail：</td>
	              <td height="28">${member.memberEmail }</td>
	            </tr> 
	            <tr>
	              <td height="28" align="center">消费金额：</td>
	              <td height="28">${member.memberAmount }</td>
	            </tr> 
	            <tr>
	              <td height="28" align="center">会员等级：</td>
	              <td height="28">${member.memberGrade }</td>
	            </tr> 
	            <tr>
	              <td height="28" align="center">用户状态：</td>
	              <td height="28">${member.memberStatus }</td>
	            </tr> 
	            <tr>
	              <td height="28" align="center">创建时间：</td>
	              <td height="28">${member.updateDate }</td>
	            </tr> 
	        </table>	
	        <table width="96%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tableBorder_B_dashed" >
	            <tr>              
	              <td height="28" class="font2">收货地址</td>
	              <td height="28" align="right">&nbsp;</td>
	            </tr>
	            <tr>
	              <td height="28"  width="18%" align="center">姓&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
	              <td height="28">${memberAddressBook.memberTrueName }</td>
	            </tr>  
	            <tr>
	              <td height="28" align="center">地&nbsp;&nbsp;&nbsp;&nbsp;址：</td>
	              <td class="word_grey">${memberAddressBook.memberAddress }</td>
	            </tr>               
	            <tr>
	              <td height="28" align="center">地&nbsp;&nbsp;&nbsp;&nbsp;区：</td>
	              <td>${areaList.provinceName}省${areaList.cityName}市${areaList.areaName}地区</td>
	            </tr>            
	            <tr>
	              <td height="28" align="center">邮&nbsp;&nbsp;&nbsp;&nbsp;编：</td>
	              <td class="word_grey">${memberAddressBook.memberPostcode }</td>
	            </tr>
	            <tr>
	              <td height="28" align="center">联系电话：</td>
	              <td>${memberAddressBook.memberTelephone }</td>
	            </tr>             
            </table> 
            <table width="96%"  border="0" align="center" cellpadding="0" cellspacing="0" >
               <tr>
                  <td height="38" colspan="2" align="center"><input name="Submit3" type="button" class="btn_grey" value="返回" onClick="JScript:history.back()">                    </td>
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

 



