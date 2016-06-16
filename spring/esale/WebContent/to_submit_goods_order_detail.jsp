<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/default.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/to_submit_goods_order_detail.js"></script>
<title>提交订单明细</title>
</head>
<body>
<center>
<img alt="青鸟（国际）通讯器材销售系统" src="<%=request.getContextPath()%>/images/esale_logo.gif">

	<table style="width: 780px;" border="0" cellpadding="0" cellspacing="0">
		
		<tr>
			<td style="width: 100px; text-align: right;">订单编号:</td>
			<td>${goodsOrder.code }</td>
		</tr>
		
		<tr>
			<td style=" text-align: right;">客户姓名:</td>
			<td>${goodsOrder.trueName }</td>
		</tr>
		
		<tr>
			<td style=" text-align: right;">客户电话:</td>
			<td>${goodsOrder.phone }</td>
		</tr>
		
		<tr>
			<td style=" text-align: right;">客户地址:</td>
			<td>${goodsOrder.address }</td>
		</tr>
		
		
		<tr>
			<td style=" text-align: right;">订单总计金额:</td>
			<td>￥${goodsOrder.totalMoney }</td>
		</tr>
		
		<tr>
			<td style=" text-align: right;">备注:</td>
			<td>${goodsOrder.remark }</td>
		</tr>
		
		<tr>
		
			
			<td style=" text-align: right;">订单提交时间:</td>
			<td> <fmt:formatDate value="${goodsOrder.submitTime }" pattern="yyyy-MM-dd HH:mm"/> </td>
		</tr>
	</table>
	
	<table style="width: 780px;" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<th width="220">商品</th>
			<th width="200">单价</th>
			<th width="100">数量</th>
			<th >操作</th>
		</tr>
		<c:if test="${not  empty goodsOrderDetails}">
			<c:forEach items="${goodsOrderDetails }" var = "detail" >
				<tr>
					<td>${detail.goods }&nbsp;</td>
					<td>￥${detail.price }</td>
					<td>${detail.num }</td>
					<td>
						<a onclick="return confirmRemove()" href="<%=request.getContextPath() %>/removeGoodsOrderDetail.action?id=${detail.id}">删除</a>
					</td>
				</tr>
			</c:forEach>
		</c:if>
		
		<c:if test="${empty goodsOrderDetails }">
			<tr>
				<td colspan="4">还没有添加订单明细 </td>
			</tr>
		</c:if>
		
		<form name="frmAddGoodsOrderDetail" action="<%=request.getContextPath() %>/addGoodsOrderDetail.action" method="post">
			<tr>
			
				<td>
					<select name="detail.goods" onchange="changeGoods($(this))">
						<option value="">-请选择一种商品-</option>
						<c:forEach items="${goodsList }" var="goods">
							<option value="${goods.title }" price="${goods.price }">${goods.title }</option>
						</c:forEach>
					</select>
				</td>
					
				<td>
					￥<input type="text" name="detail.price" value="" width="80" />
				</td>
			
				<td>
					<input type="text" name="detail.num" value="1" width="60"  />
				</td>
			
				<td>
					<input  type="hidden" name="detail.orderId" value="${orderId }"/>
					<button type="submit" style="width: 100px; height: 30px;">添加明细 </button>
				</td>
			</tr>
		 </form>
		 <!-- 删除订单 -->
		 <form name="frmRemoveGoodsOrder" action="<%=request.getContextPath() %>/removeGoodsOrder.action" method="post">
		 	<tr>
		 		<td colspan="4" style="text-align: right;">
		 			<input type="hidden" name ="id" value="${goodsOrder.id }">
		 			<button type="submit" value="">删除订单</button>
		 		</td>
		 	</tr>
		 </form>
		 <tr>
		 	<td colspan="4" style="color: red;">
		 	
		 		<%
		 			String message = request.getParameter("message");
		 		if(message!=null&&!message.equals("")){
		 			
		 			message= new String(message.getBytes("iso-8859-1"),"utf-8");
		 			
		 			out.print(message);
		 		}
		 		%>
		 	</td>
		 </tr>
	</table>
	</center>
	<div class="page-footer">北大青鸟 大学城校区 孟祥超&copy;2016</div>
</body>
</html>