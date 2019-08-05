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
<script type="text/javascript">
	function judgeSubmit() {
		var reg = /^[1-9]\d*$/;
		var dicType = $("#dicType").val();
		var dicKey = $("#dicKey").val();
		if (!reg.test(dicType)) {
			$("#typeInfo").text("数据类型必须为大于0的整数!");
			return;
		}
		if (!reg.test(dicKey)) {
			$("#keyInfo").text("数据键值必须为大于0的整数!");
			return;
		}
		$("#formId").submit();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>数据字典修改</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/comp/sysDic/edit"
		method="post" id="formId">
		<input type="hidden" name="id" value="${sysDic.id}">
		<div class="main">
			<div class="path">
				<div class="path_left"></div>
				<div class="path_module">当前位置：系统管理 → 数据字典管理→ 数据字典修改</div>
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
								<th align="right" width="150">数据类型：</th>
								<td align="left"><input name="dicType" type="text"
									value="${sysDic.dicType}" id="dicType" /><span
									style="color: red" id="typeInfo">*</span></td>
							</tr>
							<tr>
								<th align="right">数据键值：</th>
								<td align="left"><input name="dicKey" type="text"
									value="${sysDic.dicKey}" id="dicKey" /><span
									style="color: red" id="keyInfo">*</span></td>
							</tr>
							<tr>
								<th align="right">数据内容：</th>
								<td align="left"><input name="dicValue" type="text"
									value="${sysDic.dicValue}" /></td>
							</tr>
							
							<tr>
								<th align="right">排序：</th>
								<td align="left"><input name="sort" type="text"
									value="${sysDic.sort}" /></td>
							</tr>
							
							<tr>
								<th align="right">数据类型描述：</th>
								<td colspan="3" align="left"><textarea name="dicTypeDesc"
										id="textarea" cols="50" rows="3">${sysDic.dicTypeDesc}</textarea></td>
							</tr>
							<tr>
								<th>&nbsp;</th>
								<td><input name=""
									class="input_btn" type="button" value="保存"
									onclick="judgeSubmit()" /> <input name="" class="input_btn"
									type="button" value="重置" onclick="formReset()"/> <input name="" class="input_btn"
									type="button" value="返回"
									onclick="doReturn('${pageContext.request.contextPath}/comp/sysDic/list')" /></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>