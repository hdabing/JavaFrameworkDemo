<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Integer userId =(Integer) session.getAttribute("userId");
	if(userId==null){
		request.setAttribute("message", "请先登录");
		request.getRequestDispatcher("/html/user/login.jsp").forward(request, response);
		return;
	}
%>