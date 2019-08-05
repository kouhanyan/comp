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
<title>Z3950列表</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/comp/z3950/list"
		method="post" id="formId">
		<jsp:include page="/includes/writeHidden.jsp" flush="true" />
		<div class="main">
			<div class="path">
				<div class="path_left"></div>
				<div class="path_module">当前位置：系统管理 → Z3950管理→ Z3950列表</div>
				<div class="path_right">
					<a href="javascript:history.go(1);" class="btn_next">向前</a> <a
						href="javascript:history.go(-1);" class="btn_back">返回</a>
				</div>
			</div>
			<div class="main_content">
				<jsp:include page="/includes/operate.info.jsp" />
				<div class="search">
					<div class="search_condition">
						<span><font>名称：</font> <input name="name" type="text" value="${z3950QueryForm.name}"/> </span>
						<span><font>服务器地址：</font> <input name="server" type="text" value="${z3950QueryForm.server}"/>
						</span> <span><font>数据库：</font> <input name="database" type="text" value="${z3950QueryForm.database}"/>
						</span> <span class="search_button"
							onclick="doFormSubmit('formId','${pageContext.request.contextPath}/comp/z3950/query')">
							<input name="" type="button" value="查询" class="btn_orange" />
						</span>
					</div>
				</div>
				<div class="list_table_title">
					<h3>Z3950列表</h3>
					<ul>
						<li><span class="btn_left"></span><a
							href="${pageContext.request.contextPath}/comp/z3950/addForward"
							class="btn btn_new">新增</a><span class="btn_right"></span></li>
						<li><font></font></li>
						<li><span class="btn_left"></span><a
							href="javascript:modfiy('${pageContext.request.contextPath}/comp/z3950/findOne/#id#')"
							class="btn btn_edit">修改</a><span class="btn_right"></span></li>
						<li><font></font></li>
						<li><span class="btn_left"></span><a
							href="javascript:remove('${pageContext.request.contextPath}/comp/z3950/delete/#id#')"
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
								<th width="14%">名称</th>
								<th width="14%">国家</th>
								<th>服务器地址</th>
								<th width="14%">端口</th>
								<th width="14%">数据库</th>
								<th width="14%">用户名</th>
								<th width="14%">认证类型</th>
								<th width="14%">操作用户</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${page.content}" var="i">
								<input name="ids" type="hidden" value="${i.id}" />
								<tr>
									<td align="right"><input name="checks"
										type="checkbox" class="input_none" id="checks" /></td>
									<td>${i.name}&nbsp;</td>
									<td>${i.country}&nbsp;</td>
									<td>${i.server}&nbsp;</td>
									<td>${i.port}&nbsp;</td>
									<td>${i.database}&nbsp;</td>
									<td>${i.userName}&nbsp;</td>
									<td>${i.authType}&nbsp;</td>
									<td>${i.sysUser.userName}&nbsp;</td>
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