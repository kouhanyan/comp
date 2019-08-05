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
<title>系统公告列表</title>
<script type="text/javascript">
function setDisplay(uri){
	var idAndNum = checkOne();
	var id = idAndNum[1];
	$("#workingId").val(id);
	$("#formId").attr("action", uri);
	$("#formId").submit();
}
</script>
</head>
<body>
	<form
		action="${pageContext.request.contextPath}/comp/sysAnnouncement/list"
		method="post" id="formId">
		<input name="workingId" type="hidden" id="workingId"/>
		<jsp:include page="/includes/writeHidden.jsp" flush="true" />
		<div class="main">
			<div class="path">
				<div class="path_left"></div>
				<div class="path_module">当前位置：系统管理 → 系统公告管理→ 系统公告列表</div>
				<div class="path_right">
					<a href="javascript:history.go(1);" class="btn_next">向前</a> <a
						href="javascript:history.go(-1);" class="btn_back">返回</a>
				</div>
			</div>
			<div class="main_content">
				<jsp:include page="/includes/operate.info.jsp" />

				<div class="list_table_title">
					<h3>系统公告列表</h3>
					<ul>
						<li><span class="btn_left"></span><a
							href="${pageContext.request.contextPath}/comp/sysAnnouncement/addForward"
							class="btn btn_new">新增</a><span class="btn_right"></span></li>
						<li><font></font></li>
						<li><span class="btn_left"></span><a
							href="javascript:modfiy('${pageContext.request.contextPath}/comp/sysAnnouncement/findOne/#id#')"
							class="btn btn_edit">修改</a><span class="btn_right"></span></li>
						<li><font></font></li>
						<li><span class="btn_left"></span><a
							href="javascript:remove('${pageContext.request.contextPath}/comp/sysAnnouncement/delete/#id#')"
							class="btn btn_delete">删除</a><span class="btn_right"></span></li>
						<li><font></font></li>
						<li><span class="btn_left"></span><a
							href="javascript:setDisplay('${pageContext.request.contextPath}/comp/sysAnnouncement/setDisplay')"
							class="btn btn_confirm">设置为当前版本</a><span class="btn_right"></span></li>
						<li><font></font></li>
					</ul>
				</div>
				<div class="list" id="list1">
					<table id="myTable01" class="list_table" width="100%" border="0"
						cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<th width="3%">选择</th>
								<th width="16%">发送者</th>
								<th width="16%">主题</th>
								<th width="16%">是否显示在页面</th>
								<th width="16%">发送日期</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${page.content}" var="i">
								<input name="ids" type="hidden" value="${i.id}" />
								<tr>
									<td align="right"><input name="checks" type="checkbox"
										class="input_none" id="checks" /></td>
									<td>${i.sender}&nbsp;</td>
									<td>${i.title}&nbsp;</td>
										<td><c:choose>
											<c:when test="${i.isDisplay == false}">
												<a class="btn btn_delete"></a>
											</c:when>
											<c:otherwise>
												<a class="btn btn_confirm"></a>
											</c:otherwise>
										</c:choose></td>
									<td>&nbsp;<fmt:formatDate pattern='yyyy-MM-dd'
											value='${i.sendDate}' />&nbsp;
									</td>
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