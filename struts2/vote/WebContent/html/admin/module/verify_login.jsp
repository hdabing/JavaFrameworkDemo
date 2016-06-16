<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Integer adminId =(Integer) session.getAttribute("adminId");
	if(adminId==null){
		request.setAttribute("message", "请先登录");
		request.getRequestDispatcher("/html/admin/login.jsp").forward(request, response);
		return;
	}
%>