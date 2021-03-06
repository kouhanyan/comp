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
<link href="${pageContext.request.contextPath}/css/jquery.treeview.css"
	rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js"
	language="javascript"></script>
<script src="${pageContext.request.contextPath}/js/common_list.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common_list_pager.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery.cookie.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery.treeview.js"
	type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript">
	function judgeSubmit() {
		var name = $("#name").val();
		var schoolId = $("#schoolId").val();
		if (name == '') {
			$("#nameInfo").text("角色名称不能为空");
			return;
		}
		if (schoolId == 0) {
			$("#schoolInfo").text("所属学校不能为空");
			return;
		}
		$("#formId").submit();
	}
	
	function checkAll() {
		$("[name^='list']").each(function() {
			if (!$(this).attr("checked")) {
				$(this).attr("checked", 'true');// 全选
			} else {
				$(this).removeAttr("checked");// 全不选
			}
		});
	}
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#navigation").treeview({
			persist : "location",
			collapsed : false
		});

		$("#navigation2").treeview({
			persist : "location",
			collapsed : false
		});

	});
</script>
<title>高级操作权限取消</title>
</head>
<body>

	<form
		action="${pageContext.request.contextPath}/comp/sysRole/cancelRoleOperate"
		method="post" id="formId">
		<input type="hidden" name="id" value="${sysRole.id}">
		<div class="main">
			<div class="path">
				<div class="path_left"></div>
				<div class="path_module">当前位置：系统管理 → 系统角色管理→ 高级操作权限取消</div>
				<div></div>
				<div class="path_right">
					<a href="javascript:history.go(1);" class="btn_next">向前</a> <a
						href="javascript:history.go(-1);" class="btn_back">返回</a>
				</div>
			</div>
			<jsp:include page="/includes/operate.info.jsp" />
			<div class="main_content">
				<div class="row_half edit">
					<div class="row_half_right">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<th align="right" width="150">角色名称：</th>
								<td align="left">${sysRole.name}</td>
							</tr>
							<tr>
								<th align="right">所属学校：</th>
								<td align="left">${school.schoolName}</td>
							</tr>

							<tr>
								<th align="right">角色描述：</th>
								<td colspan="3" align="left">${sysRole.roleDesc}</td>
							</tr>

							<tr>
								<th align="right">高级操作权限取消：</th>
								<td valign="top" style="background: #FFF">
									<ul id="navigation" class="treeview">
										<c:forEach items="${sysRoleResources}" var="i">
											<li class="collapsable">
												<div class="hitarea collapsable-hitarea"></div>${i.sysResource.name}
												<ul>
													<c:forEach items="${sysOperates}" var="j" varStatus="status">
														<c:if test="${j.resourceName==i.sysResource.name}">
															<li class="collapsable">
																<div class="hitarea collapsable-hitarea"></div> <input
																type="checkbox" name="list[${status.index}].operateId" value="${j.id}" />${j.name}
															</li>
														</c:if>
													</c:forEach>
												</ul>
											</li>
										</c:forEach>
									</ul>
									<div class="btn">
										<input type="button" value="全/反选" onclick="checkAll()" />
									</div>
								</td>
							</tr>

							<tr>
								<th>&nbsp;</th>
								<td><input name="" class="input_btn" type="button"
									value="保存" onclick="judgeSubmit()" /> <input name=""
									class="input_btn" type="button" value="重置"
									onclick="formReset()" /> <input name="" class="input_btn"
									type="button" value="返回"
									onclick="doReturn('${pageContext.request.contextPath}/comp/sysRole/list')" /></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>