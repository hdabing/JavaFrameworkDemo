<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/login/login.css" />
<title>登录</title>
</head>
<body>
<div class="logo">
	<img alt="" src="<%=request.getContextPath() %>/images/login/logo.gif">
</div>

	<form name="frmLogin"  action="<%=request.getContextPath()%>/login.action" method="post">
		
		<input type="text" name="sn" value="0001"/>
		<input type="password" name="password" value="1234"/>
		<input type="text" name="verifyCode" value=""/>
		<img alt="点击换一个" src="<%=request.getContextPath()%>/showVerifyCode.action" style="position: static;float: left;width: 60px;height: 24px;margin-top: 6px;margin-left: 10px">
		<button type="submit" class="submit" ></button>
		
		<c:if test="${not empty message }">
			<div class="message">${message}</div>
		</c:if>
	</form>
</body>
</html>