<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="module/verify_login.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/admin/login/login.css"/>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/module/easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/module/easyui/themes/icon.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/module/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/module/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/admin/index.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/admin/index/index.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/admin/admin.css"/>
<title>管理员平台主页</title>

</head>
<body class="easyui-layout">
	<div class="page-header" data-options="region:'north',split:false" >
		<img alt="" src="<%=request.getContextPath() %>/images/module/logo.gif">
	</div>
	<!-- 左边菜单 -->
	<div class="left-menu" data-options="region:'west',split:false" >
		<div class="menu-tree" url= "<%=request.getContextPath() %>/admin/showUserMenuTree.action" 
		contextPath="<%=request.getContextPath() %>"></div>
	</div>
	<!-- 中间内容 -->
	<div class="page-content" data-options="region:'center',split:false" >
		<div class="page-panel">
			<jsp:include page="welcome.jsp" flush="true"></jsp:include>
		</div>
	</div>
	<!-- 底部 -->
	<div class="page-footer" data-options="region:'south',split:false" >
		北大青鸟mxc版权所有 &copy;2016-05-30
	</div>
</body>
</html>