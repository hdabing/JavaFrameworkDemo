<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="module/verify_login.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/user/user.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/user/index/index.css">

<title>用户平台主页</title>
</head>
<body>
	<div class="page-head">
		<img  alt="logo" src="<%=request.getContextPath() %>/images/module/logo.gif"/>
	</div>
	<div class="page-middle">
		<div class="page-menu">
			<jsp:include page="module/left_menu.jsp" flush="true"></jsp:include>
		</div >
		<div class="page-content">
			<br/><br/><br/><br/><br/>
		</div>
	</div>
	<div class="page-footer">
		北大青鸟mxc版权所有 &copy;2016-05-31
	</div>
</body>
</html>