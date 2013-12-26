<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
		<title>后台管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="../CSS/style.css" rel="stylesheet">
		<script src="../JS/check.jsp"></script>
		<script src="onclock.JS"></script>
	</head>
	<body>
		<table width="777" height="192" border="0" align="center"
			cellpadding="0" cellspacing="0" class="tableBorder">
			<tr>
				<td>
					<!-- LOGO -->
						<%@ include file="top.jsp" %>
					<!-- LOGO结束-->
					<table width="777" height="288" border="0" align="center"
						cellpadding="0" cellspacing="0">
						<tr>
							<td width="182" valign="top">
								<table width="100%" height="431" border="0" cellpadding="0"
									cellspacing="0">
									<tr>
										<td valign="top" background="../images/manage_02.gif">
											<!-- 操作菜单 -->
											<%@ include file="left.jsp" %>
											<!-- 操作菜单结束 -->
										</td>
									</tr>
								</table>
							</td>
							<td align="center" valign="top">
								<!-- 不同的部分顶部的图片 -->
									<table width="100%" height="120"  border="0" cellpadding="0" cellspacing="0">
								      <tr>
								        <td valign="top" background="../images/manage_center_goodsdetail.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0">
								          <tr>
								            <td width="98%" align="right"></td>
								            <td width="2%">&nbsp;</td>
								          </tr>
								        </table></td>
								      </tr>
								    </table>
								<!-- 不同的部分顶部的图片 -->

								<!-- 不同的部分中间的部分 -->
									<table width="92%" height="192"  border="0" cellpadding="0" cellspacing="0">
								        <tr>
								          <td valign="top">
								                   <table width="98%"  border="0" cellpadding="0" cellspacing="0" class="noborder">
								                   <tr>
								                      <td colspan="2" class="font">${goods.goodsName }</td>
								                    </tr>
								                    <tr>
								                      <td width="37%" rowspan="5" align="center"><img src="../${goods.goodsPicture }" width="150" height="100"></td>
								                      <td width="63%">商品类型：[${goods.typeName }] </td>
								                    </tr>
								                    <tr>
								                      <td>市场价：￥${goods.goodsNormalPrice }(元)</td>
								                    </tr> 
								                    <tr>
								                      <td>商城价：￥${goods.goodsMemberPrice }(元) </td>
								                    </tr>
								                    <tr>
								                      <td>折扣率： <fmt:formatNumber value="${goods.goodsRebate }" pattern="#0.##%"></fmt:formatNumber></td>
								                    </tr> 
								                    <tr>
								                     <c:if test="${goods.isSale == 'y' }">
								                      <td>特价商品 </td>
								                     </c:if>
								                     <c:if test="${goods.isSale == 'n' }">
								                      <td>非特价商品 </td>
								                     </c:if>
								                    </tr> 
								                    <tr>
								                       <td colspan="2"><hr align="center" size="1"></td>
								                    </tr>
								                    <tr>
								                      <td colspan="2" class="font1">内容简介</td>                      
								                    </tr>
								                    <tr>
								                      <td colspan="2">&nbsp;&nbsp;${goods.goodsIntroduce }</td>
								                    </tr> 
								                    <tr>
								                       <td colspan="2"><hr align="center" size="1"></td>
								                    </tr>
								                    <tr>
								                      <td colspan="2">&nbsp;&nbsp;创建人：${goods.creater }  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;创建时间：${goods.createDate }</td>
								                    </tr>                   
								                   
								                    <tr>
																<td class="font1" width="20%" colspan="2">
																	用户评论
																	<br/>
																	<br/>
																	<br/>
																</td>
													</tr>
															<c:if test="${falg == 0}">
															<tr>
																<td  width="20%" colspan="2">
																	&nbsp;暂无评论......
																	<br/>
																	<br/>
																	<br/>
																</td>
															</tr>
															</c:if>
															<c:if test="${falg != 0}">
															<c:forEach items="${commental}" var="commental">
															<tr>
																<td colspan="2">
																	会员：${commental.commentUserName }&nbsp;&nbsp;&nbsp;&nbsp;
																	时间：
																	<fmt:parseDate value="${commental.commentData}" pattern="yyyy-MM-dd HH:mm:ss" var="updateDate"/>
																	<fmt:formatDate value="${updateDate}" pattern="yyyy年MM月dd日 HH:mm" type="both" timeStyle="full"/>
																	<br/>
																	<br/>
																	<br/>
																</td>
															</tr>
															<tr>
																<td colspan="2">
																	评论:${commental.commentContent }<br/>
																	-------------------------------------------------------------------------
																	------------------------------------------------------
																</td>
															</tr>
															</c:forEach>
															
															
															<tr align="center">
																<td colspan="2">
																
																<br/>
																<br/>
																<br/>
																总共有：&nbsp;${page.totalRecord }&nbsp;条记录&nbsp;&nbsp;
																当前页数：[${page.currentPage }/${page.totalPage }]&nbsp;
																<a href="CommentManagerSelect?page=1&goodsID=${goods.goodsID}">第一页 </a>
																<c:if test="${page.currentPage > 1}">
																<a href="CommentManagerSelect?page=${page.currentPage - 1 }&goodsID=${goods.goodsID}">上一页</a>
																</c:if> 
																<c:if test="${page.currentPage < page.totalPage}">
																<a href="CommentManagerSelect?page=${page.currentPage + 1 }&goodsID=${goods.goodsID}">下一页
																											
																</c:if> 
																<a href="CommentManagerSelect?page=${page.totalPage}&goodsID=${goods.goodsID}">最后一页&nbsp;</a>
																
																<br/>
																<br/>
																</td>
															</tr>
															</c:if>
															 <tr>
								                      <td colspan="2" align="center">
								                         <input name="Submit" type="submit" class="btn_grey" onClick="JScript:history.back(-1)" value="返回">
								   			          </td>
								                    </tr>
								                  </table>
								          </td>
								        </tr>
								      </table>
								<!-- 不同的部分中间的部分 -->
								<table width="100%" height="46" border="0" cellpadding="0"
									cellspacing="0">
									<tr>
										<td background="../images/manage_06.gif">
											&nbsp;
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<table width="777" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td height="54" align="center"><!--版权信息  -->
								<%@ include file="bottom.jsp" %>
								<!--版权信息结束  -->
							<br></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>

