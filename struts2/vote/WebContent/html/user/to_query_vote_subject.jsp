<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="module/verify_login.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/user/module/themes/base/jquery.ui.all.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/user/user.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/user/to_query_vote_subject/to_query_vote_subject.css">

<script type="text/javascript" src="<%=request.getContextPath()%>/js/module/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/module/jquery-ui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/user/to_query_vote_subject.js"></script>
<title>投票列表</title>
</head>
<body>
	<div class="page-head">
		<img  alt="logo" src="<%=request.getContextPath() %>/images/module/logo.gif"/>
	</div>
	<div class="page-middle">
		<div class="page-menu">
			<jsp:include page="module/left_menu.jsp" flush="true"></jsp:include>
		</div >
		<div class="page-content">
		
			<div class="query-form-panel">
				<div class="title">查询</div>
				<div class="content">
					<div class="unit">
						<span class="label">标题：</span>
						<span class="editable">
							<input type="text" name="vsTitle" value=""/>
						</span>
					</div>
					<div class="unit">
						<span class="action-button">
							<button type="button" url="<%=request.getContextPath()%>/user/quert_vote_subject.action" 
								onclick="queryVoteSubject($(this))">查询</button>
						</span>
					</div>
					<div class="clear"></div>
				</div>
				
			</div>
		
		<div class="query-result-panel">
			<br/><br/><br/><br/><br/>
		</div>
		
			
		</div>
	</div>
	<div class="page-footer">
		北大青鸟mxc版权所有 &copy;2016-05-31
	</div>
</body>
</html>