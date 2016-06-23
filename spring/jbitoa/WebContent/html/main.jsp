<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="module/verfiy_login.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main/main.css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/module/easyui/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/main.js"></script>
<title>主页面</title>
</head>
<body>
	<div class="main">
		<div class="top">
		
			<div class="head">
				<div class="logo">
					<img alt="mxc版权所有" src="<%=request.getContextPath()%>/images/module/logo.gif" height="86">
				</div>
			</div>
			
			<div class="loginInfo">
				<span class="usertype">[登录角色：${position.nameCn }]</span>	
				<span >${employee.name } 你好，欢迎使用青鸟办公自动化系统！</span>	
				<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="<%=request.getContextPath()%>/logout.action">注销</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="<%=request.getContextPath()%>/html/welcome.jsp" target="contentFrame">返回主页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</span>	
				<span></span>	
			</div>
		</div>
		<div class="mid">
		
			<div class="left">
				<iframe id="leftFrame" name="leftFrame" src="<%=request.getContextPath()%>/left.action"></iframe>
			</div>
			<div class="right">
			
				<%
						String message = request.getParameter("message");
						if(message!=null&&!message.equals("")){
							message= new String(message.getBytes("iso-8859-1"),"utf-8");
							//out.print(message);
						}else{
							message="空的";
						}
					%>
			
				<iframe id="contentFrame" name="contentFrame" src="<%=request.getContextPath()%>/html/welcome.jsp?message=<%=message%>"></iframe>
			
				
			</div>
			<div class="clear"></div>
			
		</div>
		
		
		<div class="bottom">
			北大青鸟 大学城校区 &copy;mxc  版权所有;
		</div>
	</div>
 

	
</body>
</html>