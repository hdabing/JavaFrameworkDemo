<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/default.css">
<title>提交订单</title>
</head>
<body>
	<center>
	<img alt="青鸟（国际）通讯器材销售系统" src="<%=request.getContextPath()%>/images/esale_logo.gif">
	
	<form name="frmSubmitGoodsOrder" action="<%=request.getContextPath()%>/submitGoodsORder.action" method="post">
	
		<table style="width: 780px; " border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td style="width: 100px; text-align: right;">订单编号</td>
				<td>
					<%
						//生成随机编号
						Date currDate = new Date();
						SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmssS");
						String code= sf.format(currDate);
					%>
					<input type="text" name="goodsOrder.code" value="<%=code %>" />
				</td>
			</tr>
			
			<tr>
				<td style=" text-align: right;">客户姓名</td>
				<td>
					
					<input type="text" name="goodsOrder.trueName" value="" />
				</td>
			</tr>
			
			<tr>
				<td style=" text-align: right;">客户E-mail</td>
				<td>
					
					<input type="text" name="goodsOrder.email" value="" />
				</td>
			</tr>
			
			<tr>
				<td style=" text-align: right;">客户电话</td>
				<td>
					
					<input type="text" name="goodsOrder.phone" value="" />
				</td>
			</tr>
			
			<tr>
				<td style=" text-align: right;">客户地址</td>
				<td>
					
					<input type="text" name="goodsOrder.address" value="" />
				</td>
			</tr>
			
			<tr>
				<td style=" text-align: right;">备注：</td>
				<td>
					
					<input type="text" name="goodsOrder.remark" value="" />
				</td>
			</tr>
			<tr>
				<td style=" text-align: right;"></td>
				<td>
					<button type="submit" style="width:100px; height: 30px;" >提交</button>
				</td>
			</tr>
			<tr>
				<td style=" text-align: right;"></td>
				<td>
					<div style="color: red; font-size: 14px;font-weight: bold;">${message }</div>
				</td>
			</tr>
		</table>
		
	</form>
	<br/>
	</center>
	<div class="page-footer">北大青鸟 大学城校区 孟祥超&copy;2016</div>
</body>
</html>