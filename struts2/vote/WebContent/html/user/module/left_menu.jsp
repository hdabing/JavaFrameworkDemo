<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <ul>
 	<li><a href="<%=request.getContextPath() %>/user/index.action" >主页</a></li>
 	<li><a href="<%=request.getContextPath() %>/html/user/to_query_vote_subject.jsp" >投票</a></li>
 	<li><a href="<%=request.getContextPath() %>/user/logout.action" >注销</a></li>
 	<li><a href="#" target="_blank">我的信息</a></li>
 </ul>