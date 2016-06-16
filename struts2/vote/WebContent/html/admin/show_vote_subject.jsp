<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="module/verify_login.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <div class="dialog-panel-content">
 	<div class="row vote-subject-title">${voteSubject.vsTitle }</div>
 	<div class="row vote-option-list">
 		<c:forEach items="${voteOptions }" var="voteOption" varStatus="vs">
 			<div  class="row vote-option">${vs.count }.${voteOption.voOption }</div>
 		</c:forEach>
 	</div>
 	<%
 		//消息
 		String message = request.getParameter("message");
 	if(message!=null&&!message.equals("")){
 		message= new String(message.getBytes("iso-8859-1"),"utf-8");
 	
 	%>
 		<div class="row message"><%=message %></div>
 	<%
 	}
 	%>
 </div>
 <link rel="stylesheet" style="text/css" href="<%=request.getContextPath()%>/css/admin/show_vote_subject/show_vote_subject.css">