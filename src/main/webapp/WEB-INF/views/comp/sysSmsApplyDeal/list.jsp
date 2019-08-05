<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/css/css.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/frame.css"
	rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js"
	language="javascript"></script>
<script src="${pageContext.request.contextPath}/js/common_list.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/js/calendar/WdatePicker.js"
	language="javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>短信申请处理</title>

</head>
<body>
	<form action="${pageContext.request.contextPath}/comp/sysSmsApplyDeal/query"
		method="post" id="formId">
		<jsp:include page="/includes/writeHidden.jsp" flush="true" />
		<div class="main">
			<div class="path">
				<div class="path_left"></div>
				<div class="path_module">当前位置：系统管理→ 短信申请处理</div>
				<div class="path_right">
					<a href="javascript:history.go(1);" class="btn_next">向前</a> <a
						href="javascript:history.go(-1);" class="btn_back">返回</a>
				</div>
			</div>
			<div class="main_content">
				<jsp:include page="/includes/operate.info.jsp" />
				<div class="search">
					<div class="search_condition">
						<span><font>学校名称：</font> <input name="schoolName"
							type="text" id="schoolName"
							value="${smsApplyQueryForm.schoolName}" /></span> 
							
						<span><font>处理类型：</font> <select name="smsApplyStateEnum" id="smsApplyStateEnum">
							<option value="">---请选择---</option>
							<c:forEach items="${states }" var="i">
								<option value="${i.key }"<c:if test="${i.key == smsApplyQueryForm.smsApplyStateEnum.name }"></c:if>>${i.value }</option>
							</c:forEach>
						</select></span>
						
						<span><font>申请日期从：</font>
							<input name="applyStartDate" type="text" id="applyStartDate"
							value="<fmt:formatDate pattern='yyyy-MM-dd' value='${smsApplyQueryForm.applyStartDate}' />"
							onclick="WdatePicker({skin:'blueFresh',dateFmt:'yyyy-MM-dd',el:'applyStartDate'})" /></span>
						

						<span><font>至：</font> <input name="applyEndDate"
							type="text" id="applyEndDate"
							value="<fmt:formatDate pattern='yyyy-MM-dd' value='${smsApplyQueryForm.applyEndDate}' />"
							onclick="WdatePicker({skin:'blueFresh',dateFmt:'yyyy-MM-dd',el:'applyEndDate'})" /></span>
						<span
							class="search_button"
							onclick="doFormSubmit('formId','${pageContext.request.contextPath}/comp/sysSmsApplyDeal/query')">
							<input name="" type="button" value="查询" class="btn_orange" />
					</div>
				</div>
				<div class="list_table_title">
					<h3>短信申请列表</h3>
					<ul>
						<li><span class="btn_left"></span><a
							href="javascript:modfiy('${pageContext.request.contextPath}/comp/sysSmsApplyDeal/audit/#id#')"
							class="btn btn_new">审核</a><span class="btn_right"></span></li>
					</ul>
				</div>
				<div class="list" id="list1">
					<table id="myTable01" class="list_table" width="100%" border="0"
						cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<th width="3%">选择</th>
								<th width="8%">学校名称</th>
								<th width="10%">套餐</th>
								<th width="10%">所需金额</th>
								<th width="10%">申请条数</th>
								<th width="10%">申请日期</th>
								<th width="10%">处理日期</th>
								<th width="10%">处理状态</th>
								<th width="8%">联系人</th>
								<th width="10%">联系电话</th>
								<th width="10%">联系邮箱</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${page.content}" var="i">
								<input name="ids" type="hidden" value="${i.id}" />
								<tr>
									<td align="right"><input name="checks" type="checkbox"
										class="input_none" id="checks" /></td>
									<td>${i.schoolName}&nbsp;</td>
									<td>${i.project}&nbsp;</td>
									<td>${i.amount}&nbsp;</td>
									<td>${i.applyNum}&nbsp;</td>
									<td><fmt:formatDate pattern='yyyy-MM-dd'
											value='${i.applyDate}' />&nbsp;</td>
									<td><fmt:formatDate pattern='yyyy-MM-dd'
											value='${i.dealDate}' />&nbsp;</td>
									<td>${i.applyStateStr }&nbsp;</td>
									<td>${i.contactName }&nbsp;</td>
									<td>${i.contactPhone }&nbsp;</td>
									<td>${i.contactEmail }&nbsp;</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<jsp:include page="/includes/pager.inc.jsp" flush="true" />
			</div>
		</div>
	</form>
</body>
</html>