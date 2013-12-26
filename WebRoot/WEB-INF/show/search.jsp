<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<html>
  <head> 
    <link href="CSS/style.css" rel="stylesheet">
  </head>
  <script language="javascript" type="text/javascript" src="JS/order.js"></script>
  <body>
    <form name="OrderOrderAndDetatlSelect" method="post" action="SeachIndex">
		<table width="100%" height="23" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td colspan="2" height="7"></td>
			</tr>
			<tr>
				<td width="85%">
					请输入查询条件：
					<select name="superTypeCode" class="textarea">
						<option value="0" selected>
								全部分类
						</option>
						<c:forEach items="${superTypeal}" var="al">
							<option value="${al.typeCode }" >
								${al.typeName }
							</option>
						</c:forEach>
					</select>
					<input name="key" type="text" class="txt_grey" size="33">
				</td>
				<td width="15%">
					<input type="submit" class="btn_grey" value="搜索">
				</td>
			</tr>
		</table>
	</form>
  </body>
</html>
