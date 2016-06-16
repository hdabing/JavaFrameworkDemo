<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ include file="module/verify_login.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <form class="dialog-panel-content" action="<%=request.getContextPath()%>/admin/removeVoteSubject.action" method="post">
 	
 	<div class="row vote-subject-title">${voteSubject.vsTitle }</div>
 	<div class="row vote-option-list">
 		<c:forEach items="${voteOptions }" var="voteOption" varStatus="vs">
 			<div  class="row vote-option">${vs.count }.${voteOption.voOption }</div>
 		</c:forEach>
 	</div>
 	<div class="row message">你确认删除这个投票吗？
 		<input type="hidden" name="vsid" value="${voteSubject.vsId }"/>
 	</div>
 </form>
 	
 <link rel="stylesheet" style="text/css" href="<%=request.getContextPath()%>/css/admin/to_remove_vote_subject/to_remove_vote_subject.css"/>