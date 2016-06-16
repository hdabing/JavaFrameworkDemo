<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>调试主页</title>
</head>
<body>
<h3>管理平台</h3>
	<h3>
		<a href="<%=request.getContextPath() %>/html/admin/login.jsp" target="_blank">登录</a>&nbsp;&nbsp;&nbsp;
		<a href="<%=request.getContextPath() %>/admin/logout.action" target="_blank">注销</a>&nbsp;&nbsp;&nbsp;
		<a href="<%=request.getContextPath() %>/admin/index.action" target="_blank">主页</a>&nbsp;&nbsp;&nbsp;
	</h3>
<h3>客户平台</h3>
	<h3>
		<a href="<%=request.getContextPath() %>/html/user/login.jsp" target="_blank">登录</a>&nbsp;&nbsp;&nbsp;
		<a href="<%=request.getContextPath() %>/user/logout.action" target="_blank">注销</a>&nbsp;&nbsp;&nbsp;
		<a href="<%=request.getContextPath() %>/user/index.action" target="_blank">主页</a>&nbsp;&nbsp;&nbsp;
	</h3>

</body>
</html>