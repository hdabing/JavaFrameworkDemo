<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="page-panel-content">
	<div class="title">投票管理->投票列表</div>
	<!-- 查询表单 -->
	<div class="query-form-panel query-vote">
		<div class="title">查询</div>
		<div class="content">
			<div class="unit">
				<span class="label">标题</span>
				<span class="editable">
					<input type="text" name="vsTitle" value=""/>
				</span>
			</div>
			<div class="unit">
				<span class="action">
					<button class="queryBtn" onclick="queryParam()"></button>
				</span>
				
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div class="operator" style="display:none;">
		<div class="operating">
		<a href="<%=request.getContextPath()%>/admin/showVoteSubject.action?id=#id" onclick=" return showVoteSubject($(this))">显示</a> ||
			<a href="<%=request.getContextPath()%>/admin/toEditVoteSubject.action?id=#id" onclick="return toEditVoteSubject($(this))">编辑</a> ||
			<a href="<%=request.getContextPath()%>/admin/toRemoveVoteSubject.action?id=#id" onclick="return removeVoteSubject($(this))">删除</a>
		</div>
	</div>
	<div class="row" >
		<a href="<%=request.getContextPath()%>/admin/toAddVoteSubject.action" onclick="return toAddVoteSubject($(this))">添加投票</a>
	</div>
	<div class="query-result-panel easyui-grid" title="投票列表" 
		style="height:340px" url="<%=request.getContextPath() %>/admin/queryVote.action">
		
	</div>
	
</div>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/admin/index/to_query_vote/to_query_vote.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/admin/to_query_vote.js"></script>
