<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="module/verfiy_login.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加报销单</title>
</head>
<body>
	<h3>添加报销单</h3>
	<form action="<%=request.getContextPath()%>/submitClaimVoucher.action" name="frmSubmitClaimVoucher" method="post"> 
		事&nbsp;&nbsp;&nbsp;&nbsp;件:<input type="text" name="claimVoucher123.event" value="吃饭" /><br/>
		总计金额:<input type="text" name="claimVoucher123.totalAccount" value="100000" /><br/>
		<input type="submit" value="提交报销单"/>
	</form>
</body>
</html>