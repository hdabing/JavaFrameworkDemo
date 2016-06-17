<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SSH框架-演示</title>
</head>
<body>
	<h1>提交订单</h1>

	<form action="<%=request.getContextPath()%>/order/submit.do"
		method="post">
		订单编号：<input name="goodsOrder.code"
			value="<%SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			out.print(sdf.format(new Date(System.currentTimeMillis())));%>" /><br />
		客户姓名：<input type="text" name="goodsOrder.trueName" value="张昊" /><br />
		客户Email：<input type="text" name="goodsOrder.email"
			value="zhanghao@163.com" /><br /> 客户电话：<input type="text"
			name="goodsOrder.phone" value="12376354234" /><br /> 客户地址：<input
			type="text" name="goodsOrder.address" value="北京 海淀" /><br /> 订单总金额：<input
			type="text" name="goodsOrder.totalMoney" value="12345" /><br /> 备注：<input
			type="text" name="goodsOrder.remark" value="有可能忙而没有接到电话。" /><br />

		<button type="submit">提交</button>

	</form>
	<div style="color: red; font-size: 14px; font-weight: bold;">${msg
		}</div>


</body>
</html>