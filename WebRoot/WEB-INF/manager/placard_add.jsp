<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<title>后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../CSS/style.css" rel="stylesheet">
</head>
<script language="javascript" type="text/javascript" src="../JS/calendar.js">
</script>
<body> 
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
        <td valign="top" background="../images/manage_center_placardadd.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0">
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
   			  <form action="PlacardInsert" method="post" name="form1">
			    <table width="100%"  border="0" align="center" cellpadding="-2" cellspacing="-2" bordercolordark="#FFFFFF">
                  <tr>
                    <td height="30">公告标题：</td>
					<td><input name="title" type="text" id="title" size="60"></td>
                  </tr> 
				  <tr>
                    <td width="14%" >&nbsp;公告内容：</td>
                    <td width="86%">
                        <textarea name="content" cols="60" rows="15" class="textarea"></textarea></td>
                  </tr> 
                  <tr>
                    <td height="30">发布时间：</td>
					<td>
						<input  name="inputBirthday" id="inputBirthday" style="WIDTH: 180px" onclick="fPopCalendar(this,this,this.value);return false;" readOnly maxLength="15" value="">
						<span id="brith"></span>
					</td>
                  </tr> 
                  <tr>
                    <td height="30">失效时间：</td>
					<td>
						<input  name="expireDate" id="expireDate" style="WIDTH: 180px" onclick="fPopCalendar(this,this,this.value);return false;" readOnly maxLength="15" value="">
						<span id="brith"></span>
                    </td>
                  </tr>                   
                  <tr>
                    <td height="25" colspan="2" align="center">
                        <input name="Button" type="submit" class="btn_grey" value="保存" >
                        &nbsp;                        
                        <input name="Submit2" type="reset" class="btn_grey" value="重置">
                        &nbsp;
                        <input name="Submit3" type="button" class="btn_grey" value="返回" onClick="window.location.href='PlacardSelect'">
                    </td>
                  </tr>
                </table>
			  </form>
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
	<!--版权信息结束  -->  </td>
  </tr>
</table>
</td>
</tr>
</table>
</body>
</html>

 