<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ include file="module/verfiy_login.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/module/easyui/jquery-1.8.3.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/page/page.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/page.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="page">
		<div class="title">
			<div class="tab">
				<div class="left"></div>
				<div class="text">欢迎主页</div>
				<div class="right"></div>
				<div class="clear"></div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="content">
			<div class="content1">
				<h1>欢迎使用北大青鸟办公自动化系统</h1>
				<h3 style="color: blue">
					<%
						String message = request.getParameter("message");
						if (message != null && !message.equals("")) {
							message = new String(message.getBytes("iso-8859-1"), "utf-8");
							out.println(message);
						}
					%>
				</h3>
			</div>
		</div>
		<div class="footer">
			<div class="left"></div>
			<div class="right"></div>
			<div class="clear"></div>
		</div>
	</div>

</body>
</html>