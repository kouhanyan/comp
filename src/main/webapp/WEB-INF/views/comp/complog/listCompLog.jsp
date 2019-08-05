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
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common_list.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/calendar/WdatePicker.js"
	type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>系统日志列表</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/comp/compLog/list"
		method="post" id="formId">
		<jsp:include page="/includes/writeHidden.jsp" flush="true" />
		<div class="main">
			<div class="path">
				<div class="path_left"></div>
				<div class="path_module">当前位置：系统管理 → 系统日志→ 系统日志列表</div>
				<div class="path_right">
					<a href="javascript:history.go(1);" class="btn_next">向前</a> <a
						href="javascript:history.go(-1);" class="btn_back">返回</a>
				</div>
			</div>
			<div class="main_content">
				<jsp:include page="/includes/operate.info.jsp" />
				<div class="search">
					<div class="search_condition">
						 <span><font>开始时间：</font> <input name="startDate"
							type="text" id="startDate"
							value="<fmt:formatDate pattern='yyyy-MM-dd' value='${compLogQueryForm.startDate}' />"
							onclick="WdatePicker({skin:'blueFresh',dateFmt:'yyyy-MM-dd',el:'startDate'})" /></span>

						<span><font>结束时间：</font> <input name="endDate" type="text"
							id="endDate"
							value="<fmt:formatDate pattern='yyyy-MM-dd' value='${compLogQueryForm.endDate}' />"
							onclick="WdatePicker({skin:'blueFresh',dateFmt:'yyyy-MM-dd',el:'endDate'})" /></span>

						<span class="search_button"
							onclick="doFormSubmit('formId','${pageContext.request.contextPath}/comp/compLog/query')">
							<input name="" type="button" value="查询" class="btn_orange" />
						</span>
					</div>
				</div>
				
				<div class="list" id="list1">
					<table id="myTable01" class="list_table" width="100%" border="0"
						cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<th width="16%">IP地址</th>
								<th width="16%">登录用户</th>
								<th width="16%">创建日期</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${page.content}" var="i">
									<td>${i.ip}&nbsp;</td>
									<td>${i.userName}&nbsp;</td>
									<td>${i.createDate}&nbsp;</td>
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