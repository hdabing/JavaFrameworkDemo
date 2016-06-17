<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String currentSn=(String) session.getAttribute("currentSn");

	if(currentSn==null){
		
		request.setAttribute("message", "请先登录");
		request.getRequestDispatcher("/html/login.jsp").forward(request, response);
	}

%>