<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="module/verify_login.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  <div class="dialog-panel-content"> -->
 <form action="<%=request.getContextPath()%>/user/submitVoteOptions.action" name="frmSubmitVoteOptions" method="post">
 	<input type="hidden" name="vsId" value="${votesubject.vsId }"/>
 	<div class="row vote-subject-title">
 		<div style="line-height: 50px;height: 50px;font-size: 18px;font-weight: bold;">标题：</div>
 	${votesubject.vsTitle }</div>
 	<div class="row vote-option-list">
 		<div style="line-height: 50px;height: 50px;font-size: 18px;font-weight: bold;">投票项：</div>
 		<c:forEach items="${voteOptions }" var="voteOption" varStatus="vs">
 			<div  class="row vote-option">
 				<c:if test="${votesubject.vsType eq 1 }"><input type="radio" value="${voteOption.voId }" name="options"/></c:if>
 				<c:if test="${votesubject.vsType eq 2 }"><input type="checkbox" value="${voteOption.voId }" name="options"/></c:if>
 			${voteOption.voOption }</div>
 		</c:forEach>
 		
 	</div>
 	
 </form>
<!--  </div> -->
 
 