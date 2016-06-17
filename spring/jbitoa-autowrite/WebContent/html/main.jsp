<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="module/verfiy_login.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
</head>
<body>
	<h3 style="color:blue;">
		<%
			String message = request.getParameter("message");
			if(message!=null&&!message.equals("")){
				message= new String(message.getBytes("iso-8859-1"),"utf-8");
				out.print(message);
			}
		%>
	</h3>
	
	<a href="<%=request.getContextPath()%>/to_submit_claim_voucher.jsp">添加报销单</a>
</body>
</html>