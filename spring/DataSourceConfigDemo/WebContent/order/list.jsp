<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="cn.jbit.demo.entity.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SSH框架-演示</title>
<style type="text/css">
table {
	border-left: 1px solid #222222;
	border-top: 1px solid #222222;
}

table+table {
	margin-top: 5px;
}

table th,td {
	padding: 2px;
	margin: 0px;
	border-bottom: 1px solid #222222;
	border-right: 1px solid #222222;
}

input {
	padding-left: 2px;
	height: 22px;
	line-height: 24px;
	border: 1px solid #000000;
}

textarea {
	border: 1px solid #000000;
}
</style>
</head>
<body>
	<h1>订单列表</h1>


	<%
		List<GoodsOrder> list = (List<GoodsOrder>) request
				.getAttribute("listOrder");
		//out.println(list.size());
	%>
	<table style="width: 100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td>编号</td>
			<td>订单号</td>
			<td>真实姓名</td>
			<td>E-mail</td>
			<td>手机</td>
			<td>地址</td>
			<td>总金额</td>
			<td>备注</td>
			<td>提交时间</td>
		</tr>
		<c:if test="${not empty listOrder}">
			<c:forEach items="${listOrder }" var="order" varStatus="vs">
				<tr>
					<td>${vs.count }&nbsp;</td>
					<td>${order.code }&nbsp;</td>
					<td>${order.trueName }&nbsp;</td>
					<td>${order.email }&nbsp;</td>
					<td>${order.phone }&nbsp;</td>
					<td>${order.address }&nbsp;</td>
					<td>${order.totalMoney }&nbsp;</td>
					<td>${order.remark }&nbsp;</td>
					<td>${order.submitTime } &nbsp;</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty listOrder}">
			<td colspan="9">无订单数据</td>
		</c:if>
	</table>

</body>
</html>