<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <input type="hidden" name="url" value="<%=request.getContextPath() %>/admin/logout.action"/>
   
<script type="text/javascript">
	alert($("input[name=url]").val());
	//改变窗体的url
	window.location.href=$("input[name=url]").val();
</script>