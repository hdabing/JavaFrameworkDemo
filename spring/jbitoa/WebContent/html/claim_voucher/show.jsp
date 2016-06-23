<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="../module/verfiy_login.jsp" %>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示报销单</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/page/page.css" />
	<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/page.js"></script>
	<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/module/easyui/jquery-1.8.3.js"></script>
</head>
<body>
<div class="page">
		<div class="title">
			<div class="tab">
				<div class="left"></div>
				<div class="text">欢迎主页</div>
				<div class="right"></div>
				<div class="clear"></div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="content">
			<div class="content1">
				<c:if test="${not empty claimVoucher }">
					
					<!-- 报销单信息 -->
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
					
						<tr>
							<td style="width:100px;text-align: right;">报销人：</td>
							<td>${employee.name }</td>
							
							<td style="width:100px;text-align: right;">填报时间：</td>
							<td>
								<fmt:formatDate value="${claimVoucher.createTime }" pattern="yyyy-MM-dd HH:mm"/>
							</td>
						</tr>
					
					
						<tr>
							<td style="width:100px;text-align: right;">总金额：</td>
							<td>${claimVoucher.totalAccount }</td>
							
							<td style="width:100px;text-align: right;">状态：</td>
							<td>${claimVoucher.status }</td>
						</tr>
					
					
						<tr>
							<td style="width:100px;text-align: right;">事由：</td>
							<td colspan="3">${claimVoucher.event }</td>
							
						</tr>
					
					</table>
					
					<!-- 报销单明细 -->
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
					
						<tr class="title">
							<td style="width: 120px;">项目</td>
							<td style="width: 100px;">金额(￥)</td>
							<td >费用说明</td>
						</tr>
						
						<c:forEach items="${details }" var="detail">
							<tr class="row">
								<td>${detail.item }</td>
								<td>${detail.account }</td>
								<td>${detail.desc }</td>
							</tr>
						</c:forEach>
						<c:if test="${empty details  }">
							<tr>
								<td colspan="3">没有明细记录</td>
							</tr>
						</c:if>
					</table>
					
					<!-- 报销单审核列表 -->
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
					
						<tr class="title">
							<td style="width: 120px;">审核人</td>
							<td style="width: 150px;">审核时间</td>
							<td style="width: 100px;">审核结果</td>
							<td >内容</td>
						</tr>
					
					<c:forEach items="${checkResults }" var="checkResult">
						<tr>
							<td>${checkEmployeeMap[checkResult].name }</td>
							<td>
								<fmt:formatDate value="${checkResult.checkTime }" pattern="yyyy-MM-dd HH:mm"/>
							</td>
							<td>${checkResult.result }</td>
							<td>${checkResult.comment }</td>
						</tr>
					</c:forEach>
					
					<c:if test="${empty checkResults  }">
							<tr>
								<td colspan="4">没有审核记录</td>
							</tr>
						</c:if>
						
					</table>
				</c:if>
				
				<%
					String message = request.getParameter("message");
					if (message != null && !message.equals("")) {
						message = new String(message.getBytes("iso-8859-1"), "utf-8");
						
					}
					
				%>
				<!-- 消息 -->
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td style="font-size: 14px;color: red;font-weight: bold;">
							<%=message %>
						</td>
					</tr>
				</table>
				
				
			</div>
		</div>
		<div class="footer">
			<div class="left"></div>
			<div class="right"></div>
			<div class="clear"></div>
		</div>
	</div>
</body>
</html>