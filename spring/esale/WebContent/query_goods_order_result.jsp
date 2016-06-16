<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/default.css">
<title>订单列表</title>
</head>
<body>
<center>
	<img alt="青鸟（国际）通讯器材销售系统" src="<%=request.getContextPath()%>/images/esale_logo.gif" width="1024">
	<form method="get" name="frmQueryGoodsOrder" action="<%=request.getContextPath()%>/queryGoodsOrder.action">
		
		<table style="width:1024px;" border="0" cellpadding="0" cellspacing="0">
			
			<tr>
				<td>
					订单编号:<input name="code" type="text" value="${code }"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
				<td>
					客户姓名:<input name="trueName" type="text" value="${trueName }"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
				<td>
					客户电话:<input name="phone" type="text" value="${phone }"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
				<td align="center">
					<button type="submit">查询</button>
				</td>
			</tr>
			
		</table>
	</form>
		<br/>
		<table style="width:1024px;" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>记录编号</td>
				<td>订单编号</td>
				<td>客户姓名</td>
				<td>客户电话</td>
				<td>客户地址</td>
				<td>客户邮箱</td>
				<td>订单金额</td>
				<td>提交时间</td>
				<td>订单备注</td>
				<td>订单操作</td>
			</tr>
			<c:if test="${not empty goodsOrders }">
				<c:forEach items="${goodsOrders}" var="goodsOrder" varStatus="vs">
				<tr>
					<td>${vs.count }</td>
					<td>${goodsOrder.code }</td>
					<td>${goodsOrder.trueName}</td>
					<td>${goodsOrder.phone}</td>
					<td>${goodsOrder.address}</td>
					<td>${goodsOrder.email}</td>
					<td>￥${goodsOrder.totalMoney}</td>
					<td>
							<fmt:formatDate value="${goodsOrder.submitTime }" pattern="yyyy-MM-dd HH:mm"/>
					</td>
					
					<td>${goodsOrder.remark}</td>
					<td>
						<a href="<%=request.getContextPath()%>/toSubmitGoodsOrderDetail.action?orderId=${goodsOrder.id }">编辑订单</a>
					</td>
				</tr>
				</c:forEach>
			</c:if>
			
			<c:if test="${ empty goodsOrders }">
				<tr>
					<td colspan="10">列表数据为空</td>
				</tr>
			</c:if>
		</table>
		<br/>
		<table style="width:1024px;" border="0" cellpadding="0" cellspacing="0">
		
			<tr>
				<td>总记录：${totalRecord }；每页${pageSize }条；共 ${totalPage }页；当前${pageIndex } 页；</td>
				<td>
					<c:if test="${pageIndex gt 1 }">
						<a href="<%=request.getContextPath()%>/queryGoodsOrder.action?pageIndex=1&pageSize=${pageSize}${urlParam}">第一页</a>
						<a href="<%=request.getContextPath()%>/queryGoodsOrder.action?pageIndex=${pageIndex-1 }&pageSize=${pageSize}${urlParam}">上一页</a>
					</c:if>
					<c:if test="${pageIndex lt totalPage }">
						<a href="<%=request.getContextPath()%>/queryGoodsOrder.action?pageIndex=${pageIndex+1 }&pageSize=${pageSize}${urlParam}">下一页</a>
						<a href="<%=request.getContextPath()%>/queryGoodsOrder.action?pageIndex=${totalPage }&pageSize=${pageSize}${urlParam}">最后一页</a>
					</c:if>
				</td>
				<td>
					<form action="<%=request.getContextPath()%>/queryGoodsOrder.action?pageSize=${pageSize}${urlParam}" name="frmGoPage" method="post">
						输入页：<input type="text" name="pageIndex" value="${pageIndex }" style="width: 50px;text-align: center;"/>
						<button type="submit" style="width: 30px;height: 25px;">Go</button>
					</form>
				</td>
				<td>
					<form
					action="<%=request.getContextPath()%>/queryGoodsOrder.action?pageIndex=${pageIndex}${urlParam}" name="frmPageSize" method="post"
					>
					每页显示<select name="pageSize" onchange="submit()">
						
						<option value="5" <c:if test="${pageSize eq 5  }">selected</c:if> >5</option>
						<option value="10" <c:if test="${pageSize eq 10  }">selected</c:if> >10</option>
						<option value="15" <c:if test="${pageSize eq 15  }">selected</c:if> >15</option>
						<option value="20" <c:if test="${pageSize eq 20  }">selected</c:if> >20</option>
					</select>
					</form>
				</td>
			</tr>
			
		</table>
		

	</center>
	<div class="page-footer">北大青鸟 大学城校区 孟祥超&copy;2016</div>
</body>
</html>