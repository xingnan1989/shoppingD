<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <table width="100%"  border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td><img src="images/shop_20.gif" width="201" height="80"></td>
            </tr>
            <tr>
              <td height="90" valign="top"><table width="100%" height="40"  border="0" cellpadding="0" cellspacing="0">
                <!--DWLayoutTable-->
            <tr>
			  <td width="29" height="90" valign="top"><!--DWLayoutEmptyCell-->&nbsp;</td>
              <td width="172" valign="top">
			
			    <script language='JavaScript'>
			<c:forEach items="${goodsType}" var="al">
				<c:if test="${al.isLeaf == 'n'}">
					addtree('<B>${al.typeName }</B>');
				</c:if>
				<c:forEach items="${goodsType}" var="al2">
				<c:if test="${al2.parentID==al.typeCode }">
					addtree('-${al2.typeName}','GoodsListShow?subTypeCode=${al2.typeCode}','_self');
				</c:if>
				</c:forEach>
			</c:forEach>
			createtree();
			    </script>			  </td>
            </table></td>
            </tr>
            <tr>
              <td height="30" valign="bottom"><img src="images/shop_31.gif" width="201" height="30"></td>
            </tr>
          </table>
            <table width="100%" height="119"  border="0" cellpadding="0" cellspacing="0">
            <c:forEach   var="al" items="${alAd}">
              <tr>
                <td height="70" align="center"><a href="#"><img src="${al.billPicPath}" width="150" height="60"></a></td>
              </tr>
            </c:forEach>
            </table>