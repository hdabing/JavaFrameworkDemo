<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>调试主页</title>
</head>
<body>

	<a href="<%=request.getContextPath()%>/login.action">hello</a>
	
	<a href="<%=request.getContextPath()%>/to_submit_goods_order.jsp" target="_blank">提交订单</a>
	<a href="<%=request.getContextPath()%>/queryGoodsOrder.action" target="_blank">订单查询</a>
</body>
</html>