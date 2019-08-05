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
<script src="${pageContext.request.contextPath}/js/calendar/WdatePicker.js"
	language="javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>编目授权列表</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/comp/biblioAuthorize/list"
		method="post" id="formId">
		<jsp:include page="/includes/writeHidden.jsp" flush="true" />
		<div class="main">
			<div class="path">
				<div class="path_left"></div>
				<div class="path_module">当前位置：系统管理 → 编目授权管理→ 编目授权列表</div>
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
							type="text" value="${biblioAuthorizeQueryForm.schoolName}" /> </span> <span><font>申请人：</font>
							<input name="applicant" type="text"
							value="${biblioAuthorizeQueryForm.applicant}" /> </span> <span><font>申请日期：</font>
							<input name="appDate" type="text" id="appDate"
									value="<fmt:formatDate pattern='yyyy-MM-dd' value='${biblioAuthorizeQueryForm.appDate}' />"
								onclick="WdatePicker({skin:'blueFresh',dateFmt:'yyyy-MM-dd',el:'appDate'})" />
						</span> <span><font>是否有效：</font> <select name="isValid">
								<option value="0">--请选择--</option>
								<c:forEach items="${sysDics}" var="i">
									<option value="${i.dicKey}"
										<c:if test="${biblioAuthorizeQueryForm.isValid==i.dicKey}">selected="selected"</c:if>>${i.dicValue}</option>
								</c:forEach>
						</select> </span> <span class="search_button"
							onclick="doFormSubmit('formId','${pageContext.request.contextPath}/comp/biblioAuthorize/query')">
							<input name="" type="button" value="查询" class="btn_orange" />
						</span>
					</div>
				</div>
				<div class="list_table_title">
					<h3>编目授权列表</h3>
					<ul>
						<li><span class="btn_left"></span><a
							href="${pageContext.request.contextPath}/comp/biblioAuthorize/addForward"
							class="btn btn_new">新增</a><span class="btn_right"></span></li>
						<li><font></font></li>
						<li><span class="btn_left"></span><a
							href="javascript:modfiy('${pageContext.request.contextPath}/comp/biblioAuthorize/findOne/#id#')"
							class="btn btn_edit">修改</a><span class="btn_right"></span></li>
						<li><font></font></li>
						<li><span class="btn_left"></span><a
							href="javascript:remove('${pageContext.request.contextPath}/comp/biblioAuthorize/delete/#id#')"
							class="btn btn_delete">删除</a><span class="btn_right"></span></li>
						<li><font></font></li>
					</ul>
				</div>
				<div class="list" id="list1">
					<table id="myTable01" class="list_table" width="100%" border="0"
						cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<th width="3%">选择</th>
								<th width="16%">学校名称</th>
								<th width="16%">申请人</th>
								<th width="16%">申请时间</th>
								<th width="16%">申请册数</th>
								<th width="16%">当前册数</th>
								<th width="16%">是否有效</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${page.content}" var="i">
								<input name="ids" type="hidden" value="${i.id}" />
								<tr>
									<td align="right"><input name="checks"
										type="checkbox" class="input_none" id="checks" /></td>
									<td>${i.schoolName}&nbsp;</td>
									<td>${i.applicant}&nbsp;</td>
									<td>&nbsp;<fmt:formatDate pattern='yyyy-MM-dd'
											value='${i.appDate}' />&nbsp;</td>
									<td>${i.appCount}&nbsp;</td>
									<td>${i.curCount}&nbsp;</td>
									<td><c:forEach items="${sysDics}" var="k">
											<c:if test="${i.isValid==k.dicKey}">${k.dicValue}</c:if>
										</c:forEach>&nbsp;</td>
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