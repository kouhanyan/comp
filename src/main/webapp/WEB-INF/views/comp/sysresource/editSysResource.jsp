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
	function judgeSubmit() {
		var reg = /^[1-9]\d*$/;
		var name = $("#name").val();
		var url = $("#url").val();
		var level=$("#level").val();
		if (name=='') {
			$("#nameInfo").text("系统资源名称不能为空");
			return;
		}
		if (url=='') {
			$("#urlInfo").text("链接地址不能为空");
			return;
		}
		if(!reg.test(level)){	
			$("#urlInfo").text("资源等级必须为大于0的整数");
			return;
		}
		$("#formId").submit();
	}
	
	function findByLevel() {
		var level = $("#level").val();
		$.post('${pageContext.request.contextPath}/comp/sysResource/findByLevel', {
			'resourceLevel' : level
		}, function(data) {
				var content = '<option value="0">--请选择--</option>';
				for ( var i = 0; i < data.length; i++) {
					content += '<option value="'+data[i].id+'">' + data[i].name
							+ '</option>';
				}
				$("#parentId").empty();
				$("#parentId").append(content);
		}, 'json');
	}
</script>
<title>系统资源修改</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/comp/sysResource/edit"
		method="post" id="formId" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${sysResource.id}">
		<div class="main">
			<div class="path">
				<div class="path_left"></div>
				<div class="path_module">当前位置：系统管理 → 系统资源管理→ 系统资源修改</div>
				<div ></div>
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
								<th align="right" width="150">系统资源名称：</th>
								<td align="left"><input name="name" type="text"
									value="${sysResource.name}" id="name" /><span
									style="color: red" id="nameInfo">*</span></td>
							</tr>
							<tr>
								<th align="right">系统资源链接地址：</th>
								<td align="left"><input name="url" type="text"
									value="${sysResource.url}" id="url" /><span
									style="color: red" id="urlInfo">*</span></td>
							</tr>
							
							<tr>
								<th align="right">系统资源等级：</th>
								<td align="left"><input name="resourceLevel" type="text"
									value="${sysResource.resourceLevel}" id="level" onblur="findByLevel()"/><span
									style="color: red" id="levelInfo">*</span></td>
							</tr>
							
							<tr>
								<th align="right">上级系统资源：</th>
								<td align="left"><select name="parentId"
									id="parentId">
										<option value="0">--请选择--</option>
										<c:forEach items="${sysResources}" var="i">
											<option value="${i.id}"
												<c:if test="${sysResource.parentId==i.id}">selected="selected"</c:if>>${i.name}</option>
										</c:forEach>
								</select></td>
							</tr>
											
							<tr>
								<th align="right">排序：</th>
								<td colspan="3" align="left"><input name="sort" type="text"
									value="${sysResource.sort}" id="sort" /></td>
							</tr>

                             <tr>
								<th align="right">图标上传：</th>
								<td align="left"><input id="file" type="file" name="file" /></td>
							</tr>

							<tr>
								<th>&nbsp;</th>
								<td><input name=""
									class="input_btn" type="button" value="保存"
									onclick="judgeSubmit()" /> <input name="" class="input_btn"
									type="button" value="重置" onclick="formReset()"/> <input name="" class="input_btn"
									type="button" value="返回"
									onclick="doReturn('${pageContext.request.contextPath}/comp/sysResource/list')" /></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>