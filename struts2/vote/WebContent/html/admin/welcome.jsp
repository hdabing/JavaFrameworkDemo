<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div class="welcome-info">
	<br/><br/><br/><br/>
	欢迎使用北大青鸟网上投票系统
	<%
		//消息
		String message = request.getParameter("message");
		if(message!=null&&!message.equals("")){	
		message= new String(message.getBytes("iso-8859-1"),"utf-8");
	%>
		<div class="message"><%=message %></div>
		<%
		}
		%>
	</div>
	
	