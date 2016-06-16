<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="module/verify_login.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!-- bianji投票页面 -->
 <form class="page-panel-content" js="<%=request.getContextPath()%>/js/admin/to_edit_vote_subject.js"
 	action="<%=request.getContextPath() %>/admin/editSaveVoteSubject.action" method="post"
 >
	<input type="hidden" name="voteSubject.vsId" value="${voteSubject.vsId}"/>
	<div class="row">
		<span class="label">标题：</span>
		<span class="editable">
			<input type="text" name ="voteSubject.vsTitle" value="${voteSubject.vsTitle}"/>
		</span>
		<span class="clear"></span>
	</div>	
	
	<div class="row">
		<span class="label">类型：</span>
		<span class="editable">
			<input type="radio" name ="voteSubject.vsType" value="1" <c:if test="${voteSubject.vsType eq 1 }"> checked</c:if> />单选&nbsp;&nbsp;&nbsp;
			<input type="radio" name ="voteSubject.vsType" value="2" <c:if test="${voteSubject.vsType eq 2 }"> checked</c:if> />多选
		</span>
		<span class="clear"></span>
	</div>	
	
	<div class="row vote-option-list">
		<div class="row">
			<span class="label">投票选项：</span>
		</div>
		<div class="row data-list">
			
			<c:forEach items="${voteOptions}" var ="option">
				<div class="row">
					<input type="hidden" value="${option.voId}" name="voId"/>
				<input type="text" name="voOption" value="${option.voOption}"/>
				<button type="button" onclick="removeVoteOptionRow($(this))">删除</button>
			</div>
			</c:forEach>
			
		</div>
		<div class="row template" style="display:none">
			<div class="row">
				<input type="hidden" name="voId" value="-1"/>
				<input type="text" name="voOption" />
				<button type="button" onclick="removeVoteOptionRow($(this))">删除</button>
			</div>
		</div>
		<div class="row unconfirm">
			<div class="row">
				<input type="text" name="voOption"/>
				<button type="button" onclick="addVoteOptionRow($(this))">添加</button>
			</div>
		</div>
		<span class="clear"></span>
	</div>
 </form>
 
 <link style="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/admin/to_edit_vote_subject/to_edit_vote_subject.css"/>