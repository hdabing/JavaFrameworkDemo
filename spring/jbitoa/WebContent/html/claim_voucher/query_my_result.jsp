<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ include file="../module/verfiy_login.jsp" %>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/module/easyui/jquery-1.8.3.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/page/page.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/page.js"></script>
<title>我的报销单</title>
</head>
<body>
<div class="page">
		<div class="title">
			<div class="tab">
				<div class="left"></div>
				<div class="text">我的报销单</div>
				<div class="right"></div>
				<div class="clear"></div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="content">
			<div class="content1">
				
				<form action="<%=request.getContextPath()%>/claim_voucher/queryMy.action" name="frmQueryMy" method="get">
					
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td class="title">查询</td>
							<td class="content">
								单号：<input type="text" name="id" value="${id }" style="width: 100px;"/>
								事件：<input type="text" name="event" value="${event }" style="width: 220px;"/>
								状态：<select name="status" style="width: 150px;">
										<option value="-1">-请选择一项-</option>
										
										<option value="新建" <c:if test="${status eq '新建' }">selected</c:if> >新建</option>
										<option value="打回" <c:if test="${status eq '打回' }">selected</c:if> >打回</option>
										<option value="审核通过" <c:if test="${status eq '审核通过' }">selected</c:if> >审核通过</option>
										<option value="完毕" <c:if test="${status eq '完毕' }">selected</c:if> >完毕</option>
										<option value="取消" <c:if test="${status eq '取消' }">selected</c:if> >取消</option>
									</select>
									
								创建时间：<input type="text" name="createTime1" value="<fmt:formatDate value="${createTime1 }" pattern="yyyy-MM-dd"/>" />
								至<input type="text" name="createTime2" value="<fmt:formatDate value="${createTime2 }" pattern="yyyy-MM-dd"/>" />
								<button type="submit" class="button">查询</button>
							</td>
						</tr>
					</table>
					
					
				</form>
				<br/>
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr class="title">
						<td style="width: 60px;">编号</td>
						<td style="width: 150px;" >提交时间</td>
						<td style="width: 120px;">提交人</td>
						<td style="width: 100px;">总金额(￥)</td>
						<td style="width: 90px;">状态</td>
						<td >操作</td>
					</tr>
					
					<c:forEach items="${claimVouchers }" varStatus="vs" var="claimVoucher">
						<tr>
							<td align="center">${vs.count }</td>
							<td><fmt:formatDate value="${claimVoucher.createTime }" pattern="yyyy-MM-dd"/> </td>
							<td>${ claimVoucherCreateEmployeeMap[claimVoucher].name }</td>
							<td>${claimVoucher.totalAccount  }</td>
							<td>${claimVoucher.status}</td>
							<td>
								<c:if test="${claimVoucher.status eq '新建' or claimVoucher.status eq '打回'  }">
									<a href="<%=request.getContextPath()%>/claim_voucher/toEdit.action?id=${claimVoucher.id}" class="edit"></a>&nbsp;&nbsp;&nbsp;
									<a href="<%=request.getContextPath()%>/claim_voucher/toRemove.action?id=${claimVoucher.id}" class="delete"></a>
								</c:if>
							</td>
						</tr>
					</c:forEach>
					
					<c:if test="${empty  claimVouchers}">
						<tr>
							<td colspan="6">
								没有查询到数据
							</td>
						</tr>
					</c:if>
				</table>
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td style="width:350px;">
							共查询到${totalRecord }条记录，
							每页显示${pageSize }条，
							共${totalPage }页，当前是第${pageIndex }页
						</td>
						<td >
							<c:if test="${pageIndex gt 1 }">
								<a href="<%=request.getContextPath() %>/claim_voucher/queryMy.action?pageIndex=1&pageSize=${pageSize}${urlParam}">第一页</a>
								<a href="<%=request.getContextPath() %>/claim_voucher/queryMy.action?pageIndex=${pageIndex - 1 }&pageSize=${pageSize}${urlParam}">上一页</a>
							</c:if>
							<c:if test="${pageIndex lt totalPage }">
								
								<a href="<%=request.getContextPath() %>/claim_voucher/queryMy.action?pageIndex=${pageIndex + 1 }&pageSize=${pageSize}${urlParam}">下一页</a>
								<a href="<%=request.getContextPath() %>/claim_voucher/queryMy.action?pageIndex=${totalPage }&pageSize=${pageSize}${urlParam}">最后一页</a>
							</c:if>
						</td>
						<td style="width: 150px;">
							<form action="<%=request.getContextPath() %>/claim_voucher/queryMy.action?pageSize=${pageSize}${urlParam}" method="post" name="frmgoPageIndex">
								去第<input name="pageIndex" type="text" value="${pageIndex }" style="width: 40px;"/>页
								<button type="submit">Go</button>
							</form>
						</td>
						<td style="width: 110px;">
						
							<form  action="<%=request.getContextPath() %>/claim_voucher/queryMy.action?pageIndex=1${urlParam}" method="post" name="frmgoPageSize">
							每页显示 <select name="pageSize" onchange="submit();">
										
										<option value="2" <c:if test="${pageSize eq 2 }">selected</c:if>>2</option>
										<option value="5" <c:if test="${pageSize eq 5 }">selected</c:if>>5</option>
										<option value="10" <c:if test="${pageSize eq 10 }">selected</c:if>>10</option>
										<option value="15" <c:if test="${pageSize eq 15 }">selected</c:if>>15</option>
										<option value="20" <c:if test="${pageSize eq 20 }">selected</c:if>>20</option>
									</select>
							</form>
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