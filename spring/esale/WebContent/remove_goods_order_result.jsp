<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/default.css">
<title>删除订单的结果</title>
</head>
<body>
<center>
	<img alt="青鸟（国际）通讯器材销售系统" src="<%=request.getContextPath()%>/images/esale_logo.gif">
	<table style="width: 780px; margin-top: 10px;border: none;">
		<tr>
			<td style="color: blue;">
				<%
					String message = request.getParameter("message");
					if(message!=null&&!message.equals("")){
						message = new String(message.getBytes("iso-8859-1"),"utf-8");
						out.print(message);
					}
				%>
				<a href="<%=request.getContextPath()%>/queryGoodsOrder.action">返回订单列表</a>
			</td>
		</tr>
	</table>
	<br/>
	</center>
	<div class="page-footer">北大青鸟 大学城校区 孟祥超&copy;2016</div>
</body>
</html>