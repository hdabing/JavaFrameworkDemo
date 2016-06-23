<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
        <%@ include file="../module/verfiy_login.jsp" %>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/page/page.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/module/easyui/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/claim_voucher/to_submit.js"></script>
<title>去提交报销单</title>
</head>
<body>
<div class="page">
		<div class="title">
			<div class="tab">
				<div class="left"></div>
				<div class="text">提交报销单</div>
				<div class="right"></div>
				<div class="clear"></div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="content">
			<div class="content1">
				<form action="<%=request.getContextPath() %>/claim_voucher/submit.action" method="post" name="frmSubmitClaimVoucher" onsubmit="return checkfrmSubmitClaimVoucher($(this));">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					
						<tr>
							<td style="width: 100px;text-align: right;">填报人：</td>
							<td  >${employee.name }<input type="hidden" name="claimVoucher.createSn" value="${employee.sn }"/></td>
							<td style="width: 100px;text-align: right;">填报时间：</td>
							<td>
								<%
									pageContext.setAttribute("currentDate", new Date());
								%>
								<fmt:formatDate value="${currentDate}" pattern="yyyy-MM-dd HH:mm"/>
							</td>
							
						
						</tr>
						
						<tr>
							<td  style="text-align: right;">总金额：</td>
							<td>￥<input type="text" name="claimVoucher.totalAccount" value="0.00" readonly="readonly"/></td>
							<td style="text-align: right;"> 状态：</td>
							<td><input type="text" name="claimVoucher.status" value="新建" readonly="readonly"/></td>
						</tr>
						
						<tr>
							<td style="text-align: right;">事由：</td>
							<td colspan="3">
								<textarea rows="5" cols="45" name="claimVoucher.event"></textarea>
							</td>
						</tr>
					</table>
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					
						<tr class="title">
							<td>项目</td>
							<td>金额(￥)</td>
							<td>费用说明</td>
							<td>操作</td>
						</tr>
						
						<tr class="row template" style="display: none;">
							<td><input name="item" type="text" value="" readonly="readonly"/></td>
							<td><input type="text" name="account" value="" readonly="readonly"/></td>
							<td><input type="text" name="desc" value="" readonly="readonly"/></td>
							<td><button type="button" class="delete" onclick="removeClaimVoucherItem($(this))"></button></td>
						</tr>
						
						
						<tr class="row unconfirm" >
							<td>
								<select name="item">
									<option value="-1">--请选择一项--</option>
									<c:forEach items="${claimVouchItemList}" var="dictionary">
										<option value="${dictionary.item }">${dictionary.item }</option>
									</c:forEach>
								</select>
							</td>
							<td><input type="text" name="account" value="0.00"/></td>
							<td><input type="text" name="desc" value=""/></td>
							<td><button type="button" class="save" onclick="addCliamVoucherItem($(this))"></button></td>
						</tr>
						
						
					</table>
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
						<tr>
							<td style="text-align: right;">
								
								<input type="submit" class="button" value="提交单据"/>
							</td>
						</tr>
					</table>
				</form>
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