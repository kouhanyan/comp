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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>反馈信息列表</title>
<style type="text/css">
table {
	table-layout: fixed;
}

td {
	white-space: nowrap;
	overflow: hidden;
}
</style>
<script type="text/javascript">
	function dealOrCancel(url, warnInfo, successInfo, state) {
		var idAndNum = checkOne();
		var tdVal = $("#myTable01 tbody tr:eq(" + idAndNum[0] + ")").children(
				"td").eq(5).text().trim();
		if (tdVal == state) {
			showMsg(warnInfo, "warn");
			return;
		}
		$.post(url, {
			"id" : idAndNum[1]
		}, function(data) {
			if (data == 'success') {
				$("#myTable01 tbody tr:eq(" + idAndNum[0] + ")").children("td")
						.eq(5).text(state);
				showMsg(successInfo, "success");
			}
		}, "text");
	}
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/comp/feedBack/list"
		method="post" id="formId">
		<jsp:include page="/includes/writeHidden.jsp" flush="true" />
		<div class="main">
			<div class="path">
				<div class="path_left"></div>
				<div class="path_module">当前位置：系统管理→ 反馈管理→ 反馈信息列表</div>
				<div class="path_right">
					<a href="javascript:history.go(1);" class="btn_next">向前</a> <a
						href="javascript:history.go(-1);" class="btn_back">返回</a>
				</div>
			</div>
			<div class="main_content">
				<jsp:include page="/includes/operate.info.jsp" />
				<div class="search">
					<div class="search_condition">
						<span><font>操作者：</font> <input name="sysUserName"
							type="text" value="${feedBackQueryForm.sysUserName}" /> </span> <span><font>学校名称：</font>
							<input name="schoolName" type="text"
							value="${feedBackQueryForm.schoolName}" /> </span> <span><font>处理状态：</font>
							<select name="isDeal">
								<option value="0">--请选择--</option>
								<c:forEach items="${sysDics}" var="i">
									<option value="${i.dicKey}"
										<c:if test="${feedBackQueryForm.isDeal==i.dicKey}">selected="selected"</c:if>>${i.dicValue}</option>
								</c:forEach>
						</select> </span> <span class="search_button"
							onclick="doFormSubmit('formId','${pageContext.request.contextPath}/comp/feedBack/query')">
							<input name="" type="button" value="查询" class="btn_orange" />
						</span>
					</div>
				</div>
				<div class="list_table_title">
					<h3>反馈信息列表</h3>
					<ul>
						<li><span class="btn_left"></span><a
							href="javascript:dealOrCancel('${pageContext.request.contextPath}/comp/feedBack/dealOrCancel','该记录已处理','处理成功','已处理')"
							class="btn btn_new">处理</a><span class="btn_right"></span></li>
						<li><font></font></li>

						<li><span class="btn_left"></span><a
							href="javascript:dealOrCancel('${pageContext.request.contextPath}/comp/feedBack/dealOrCancel','该记录已撤销','撤销成功','未处理')"
							class="btn btn_new">撤销</a><span class="btn_right"></span></li>
						<li><font></font></li>
						<li><span class="btn_left"></span><a
							href="javascript:modfiy('${pageContext.request.contextPath}/comp/feedBack/download/#id#')"
							class="btn btn_new">下载</a><span class="btn_right"></span></li>
						<li><font></font></li>
						<li><span class="btn_left"></span><a
							href="javascript:remove('${pageContext.request.contextPath}/comp/feedBack/delete/#id#')"
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
								<th width="5%">操作者</th>
								<th width="56%">问题</th>
								<th width="10%">所属学校</th>
								<th width="10%">创建日期</th>
								<th width="5%">处理状态</th>
								<th width="10">详细</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${page.content}" var="i">
								<input name="ids" type="hidden" value="${i.id}" />
								<tr>
									<td align="right"><input name="checks" type="checkbox"
										class="input_none" id="checks" /></td>
									<td>${i.sysUserName}&nbsp;</td>
									<td style="overflow: hidden; text-overflow: ellipsis;"><NOBR>${i.problem}&nbsp;</NOBR></td>
									<td>${i.schoolName}&nbsp;</td>
									<td>&nbsp;<fmt:formatDate pattern='yyyy-MM-dd'
											value='${i.createDate}' />&nbsp;
									</td>
									<td><c:forEach items="${sysDics}" var="j">
											<c:if test="${i.isDeal==j.dicKey}">${j.dicValue}</c:if>
										</c:forEach>&nbsp;</td>
									<td><a class="btn btn_edit" href="${pageContext.request.contextPath}/comp/feedBack/detail/${i.id}">详细</a></td>
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