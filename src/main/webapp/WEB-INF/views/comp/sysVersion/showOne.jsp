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
<script type="text/javascript">
	
</script>
</head>
<body>
	<form action="#" method="post" id="formId">
		<div class="main">
			<div class="path">
				<div class="path_left"></div>
				<div class="path_module">当前位置：系统管理 → 版次管理→ 版本</div>
				<div></div>
				<div class="path_right">
					<a href="javascript:history.go(1);" class="btn_next">向前</a> <a
						href="javascript:history.go(-1);" class="btn_back">返回</a>
				</div>
			</div>
			<div class="main_content">
				<div class="edit">
					<div class="edit_table_title">${sysVersion.info}版本查看</div>
					<table class="edit_table" width="100%" border="0" cellspacing="0"
						cellpadding="5">
						<tr>
							<th width="8%" align="right">版次：</th>
							<td>${sysVersion.edition }</td>

						</tr>
						<tr>
							<th width="8%" align="right">目次：</th>
							<td>${sysVersion.directory }</td>
						</tr>
						<tr>
							<th width="8%" align="right">创建时间：</th>
							<td>${sysVersion.createDateStr }</td>
						</tr>
						<tr>
							<th width="8%" align="right">修改时间：</th>
							<td>${sysVersion.modifyDateStr }</td>
						</tr>
						<tr>
							<th width="8%" align="right">是否为当前版本：</th>
							<td><c:choose>
									<c:when test="${sysVersion.isCurrentVersion == false  }">
									否
									</c:when>
									<c:otherwise>
									是
									</c:otherwise>
								</c:choose></td>
						</tr>
						<tr>
							<th width="8%" align="right">介绍：</th>
							<td>${sysVersion.releaseNotes }</td>

						</tr>
						<tr>
							<th width="8%" align="right">特点：</th>
							<td>${sysVersion.characteristic }</td>

						</tr>
					</table>
				</div>
			</div>
		</div>
	</form>
</body>
</html>