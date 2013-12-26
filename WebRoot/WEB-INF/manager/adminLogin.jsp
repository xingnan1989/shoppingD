<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
<head>
<title>后台管理!</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../CSS/style.css" rel="stylesheet">
</head>
<body>
      <table width="350" height="210"  border="0" align="center" cellpadding="0" cellspacing="0" background="../images/login_M.jpg" class="tableBorder">
        <tr>
          <td height="136" align="center"><br></td>
        </tr>	  
              
        <tr>
          <td height="87" align="center" valign="top">
          <form name="form1" method="post" action="UserLogin">
          <table width="62%" height="87"  border="0" cellpadding="0" cellspacing="0">              
			<tr>
              <td width="95%" align="center">&nbsp;用户名：
              <input name="userName" type="text" id="userName" size="20"></td>
              </tr>
            <tr>
              <td align="center">&nbsp;密&nbsp;&nbsp;&nbsp;&nbsp;码：
              <input name="userPassword" type="password" id="userPassword" size="20"
              onKeydown="if(event.keyCode==13) form1.submit()"></td>
              </tr>

            <tr>
              <td align="center"><input type="submit" class="btn_grey" value="确认" > 
              &nbsp;
                <input type="reset" class="btn_grey" value="重置">
              &nbsp;
              </td>
              </tr>           
          </table>
          </form>
          </td>
        </tr>
</table>
</body>
</html>

