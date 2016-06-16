<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/user/user.css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/module/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/admin/login.js"></script>
<link rel="stylesheet"  style="text/css" href="<%=request.getContextPath() %>/css/user/login/login.css">
<title>用户登录</title>
</head>
<body>
	<div class="page-head">
		<img alt="" src="<%=request.getContextPath() %>/images/module/logo.gif">
	</div>
	<div class="page-middle">
		<div class="column c1">
			<img alt="" src="<%=request.getContextPath() %>/images/user/login/voteBanner.jpg">
		</div>
		<div class="column c2"></div>
		<form class="column c3" action="<%=request.getContextPath() %>/user/login.action" name="loginForm" method="post">
			用户名：<input name="vuUserName" value="ordinary"/><br/>
			密&nbsp;&nbsp;码：<input name="vuPassword" type="password" value="ordinary"/><br/>
			验证码：<input name="verifyCode" value="" />&nbsp;&nbsp;
			<img alt="验证码" src="<%=request.getContextPath() %>/showVerifyCode.action?location=user" onclick=" chageVerifyCode($(this))"/>
			<a href="#" onclick="return chageVerifyCode($(this))">看不清，换一张</a>
			<br/>
			<input type="submit" value="登录"/>
			<h3 style="color:blue">${message }</h3>
		</form>
		<div class="column c4">
			<img alt="" src="<%=request.getContextPath() %>/images/module/banner_corner.jpg">
		</div>
	</div>
	<div class="page-footer">
		北大青鸟mxc版权所有 &copy;2016-05-30
	</div>
</body>
</html>