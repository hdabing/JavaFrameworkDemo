<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="module/verfiy_login.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link  type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/left/left.css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/module/easyui/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/left.js"></script>
<title>左边菜单</title>
</head>
<body>
	<div class="menu">
		<div class="top">
			<div class="left"></div>
			<div class="right"></div>
		</div>
		<div class="content">
			
			<div class="content1">
				<h4>菜单</h4>
				<a href="<%=request.getContextPath()%>/html/welcome.jsp" target="contentFrame">主页</a><br>
				<a href="<%=request.getContextPath()%>/claim_voucher/toSubmit.action" target="contentFrame">提交报销单</a><br>
				<a href="<%=request.getContextPath()%>/claim_voucher/queryMy.action" target="contentFrame">我的报销单</a><br>
				<a href="<%=request.getContextPath()%>/logout.action">注销</a><br>
			</div>
		
			
		</div>
		<div class="bottom"></div>
	</div>

	
</body>
</html>