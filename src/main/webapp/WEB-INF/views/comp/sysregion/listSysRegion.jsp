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
<script src="${pageContext.request.contextPath}/js/common_list_pager.js"
	type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>行政区划列表</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/comp/sysRegion/list"
		method="post" id="formId">
		<jsp:include page="/includes/writeHidden.jsp" flush="true" />
		<div class="main">
			<div class="path">
				<div class="path_left"></div>
				<div class="path_module">当前位置：系统管理 → 行政区划管理→ 行政区划列表</div>
				<div ></div>
				<div class="path_right">
					<a href="javascript:history.go(1);" class="btn_next">向前</a> <a
						href="javascript:history.go(-1);" class="btn_back">返回</a>
				</div>
			</div>
			<div class="main_content">
				<jsp:include page="/includes/operate.info.jsp" />
				<div class="search">
					<div class="search_condition">
						<span><font>行政区划代码：</font> <input name="code" type="text" value="${sysRegionQueryForm.code}"/>
						</span> <span><font>行政区划名称：</font> <input name="name" type="text" value="${sysRegionQueryForm.name}"/>
						</span> <span><font>上级行政区划：</font> <input name="parentName"
							type="text" value="${sysRegionQueryForm.parentName}"/> </span> <span class="search_button"
							onclick="doFormSubmit('formId','${pageContext.request.contextPath}/comp/sysRegion/query')">
							<input name="" type="button" value="查询" class="btn_orange" />
						</span>
					</div>
				</div>
				<div class="list_table_title">
					<h3>行政区划列表</h3>
					<ul>
						<li><span class="btn_left"></span><a
							href="${pageContext.request.contextPath}/comp/sysRegion/addForward"
							class="btn btn_new">新增</a><span class="btn_right"></span></li>
						<li><font></font></li>
						<li><span class="btn_left"></span><a
							href="javascript:modfiy('${pageContext.request.contextPath}/comp/sysRegion/findOne/#id#')"
							class="btn btn_edit">修改</a><span class="btn_right"></span></li>
						<li><font></font></li>
						<li><span class="btn_left"></span><a
							href="javascript:remove('${pageContext.request.contextPath}/comp/sysRegion/delete/#id#')"
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
								<th width="16%">行政区划代码</th>
								<th width="16%">行政区划名称</th>
								<th width="16%">上级行政区划</th>
								<th width="16%">层次</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${page.content}" var="i">
								<input name="ids" type="hidden" value="${i.id}" />
								<tr>
									<td align="right"><input name="checks"
										type="checkbox" class="input_none" id="checks" /></td>
									<td>${i.code}&nbsp;</td>
									<td>${i.name}&nbsp;</td>
									<td><c:forEach items="${parents}" var="j">
											<c:if test="${i.parentId==j.id}">${j.name}</c:if>
										</c:forEach>&nbsp;</td>
									<td>${i.regionLevel}&nbsp;</td>
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