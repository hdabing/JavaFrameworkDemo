<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ include file="module/verify_login.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
    
    <div class="title">共找到${totalRecord }条记录，当前显示第${pageIndex }页，列表数据如下：</div>
    
    <table class="data-list"  border="1"  cellpadding="0" cellsacing="0" >
    	<tr class="title">
    		<th class="cell index">编&nbsp;&nbsp;号</th>
    		<th class="cell vs-title">标&nbsp;&nbsp;题</th>
    		<th class="cell vs-type">类&nbsp;&nbsp;型</th>
    		<th class="cell total-vs-option">选项数量</th>
    		<th class="cell total-vs-user">投票人数</th>
    		<th class="cell operating">操&nbsp;&nbsp;作</th>
    		
    	</tr>
    	<c:forEach items ="${currentPageList }" var ="voteSubject"  varStatus="vs">
	    	<tr class="data-row">
	    		<td class="cell index">${vs.count }</td>
	    		<td class="cell vs-title">${voteSubject.vsTitle }</td>
	    		<td class="cell vs-type"> <c:if test="${voteSubject.vsType eq 1 }">单选</c:if><c:if test="${voteSubject.vsType eq 2 }">多选</c:if></td>
	    		<td class="cell total-vs-option">${totalVoteOptionMap[voteSubject] }</td>
	    		<td class="cell total-vs-user">${totalVoteUserMap[voteSubject] }</td>
	    		<td class="cell operating">
	    			<a class="submig-vote" href="<%=request.getContextPath()%>/user/toPullVoteSubject.action?vsId=${voteSubject.vsId}" onclick="return pullSubject($(this))">投票</a> &nbsp;&nbsp;&nbsp;&nbsp;
	    			<a class="show-vote-subject" href="<%=request.getContextPath()%>/user/toPullVoteSubject.action?vsId=${voteSubject.vsId}" onclick="return showSubject($(this))">显示</a>
	    		</td>
	    	</tr>
    	</c:forEach>
    </table>
    
    
    <table class="pagination"  border="0" cellpadding="0" cellsacing="0">
    	<tr>
    		<td class="total-info">
    			共找到${totalRecord }条记录，每页显示${pageSize }条，共${totalPage }页，当前显示第${pageIndex }页
    			
    		</td>
    		<td class="navigation">
    			<c:if test="${pageIndex>1 }">
    			<a href="<%=request.getContextPath()%>/user/quert_vote_subject.action" query-param="pageIndex=1&pageSize=${pageSize }${urlParam}" onclick="return clickPage($(this))">第一页</a>
    			<a href="<%=request.getContextPath()%>/user/quert_vote_subject.action" query-param="pageIndex=${pageIndex - 1  }&pageSize=${pageSize}${urlParam}" onclick="return clickPage($(this))">上一页</a>
    			</c:if>
    			<c:if test="${pageIndex < totalPage }">
    			<a href="<%=request.getContextPath()%>/user/quert_vote_subject.action" query-param="pageIndex=${pageIndex + 1  }&pageSize=${pageSize}${urlParam}" onclick="return clickPage($(this))">下一页</a>
    			<a href="<%=request.getContextPath()%>/user/quert_vote_subject.action" query-param="pageIndex=${totalPage }&pageSize=${pageSize}${urlParam}" onclick="return clickPage($(this))">最后一页</a>
    			</c:if>
    		</td>
    		<td class="go-page">
    			
    			去第<input type="text" name="pageIndex" value="${pageIndex }"/>
    		
    			<button  type="button" url="<%=request.getContextPath()%>/user/quert_vote_subject.action" query-param="pageSize=${pageSize}${urlParam}" onclick="goPage($(this))">Go</button>
    		
    		</td>
    		<td class="change-page-size" >
    			每页显示
    				<select name="pageSize" onchange="changePageSize($(this))"   url="<%=request.getContextPath()%>/user/quert_vote_subject.action" query-param="pageIndex=1${urlParam}">
    				
    					<option value="2"  <c:if test="${pageSize eq 2}" >selected</c:if> >2</option>
    					<option value="5"  <c:if test="${pageSize eq 5}" >selected</c:if>>5</option>
    					<option value="10"  <c:if test="${pageSize eq 10}" >selected</c:if>>10</option>
    					<option value="15"  <c:if test="${pageSize eq 15}" >selected</c:if>>15</option>
    					<option value="20"  <c:if test="${pageSize eq 20}" >selected</c:if> >20</option>
    				</select>
    			条
    		</td>
    	</tr>
    </table>