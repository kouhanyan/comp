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
<title>添加版次</title>

<script type="text/javascript">
	function judgeSubmit() {
		if ($("#edition").val() == '') {
			$("#editionInfo").text("版次不能为空*");
			return;
		}
		if ($("#directory").val() == '') {
			$("#directoryInfo").text("目次不能为空*");
			return;
		}
		
		$("#formId").submit();
	}
</script>

</head>
<body>
	<form action="${pageContext.request.contextPath}/comp/sysVersion/add"
		method="post" id="formId">
		<div class="main">
			<div class="path">
				<div class="path_left"></div>
				<div class="path_module">当前位置：系统管理 → 版次管理 →版次添加</div>
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
								<th align="right" width="150">版次：</th>
								<td align="left"><input name="edition" type="text"
									value="" id="edition"/><span style="color: red" id="editionInfo">*</span></td>
							</tr>
							<tr>
								<th align="right">目次：</th>
								<td align="left"><input name="directory" type="text"
									value="" id="directory">
									<span style="color: red" id="directoryInfo">*</span></td>
							</tr>

							<tr>
								<th align="right">特点：</th>
								<td align="left"><textarea name="characteristic"></textarea></td>
							</tr>
							<tr>
								<th align="right">版本说明：</th>
								<td align="left"><textarea name="releaseNotes"></textarea></td>
							</tr>

							<tr>
								<th>&nbsp;</th>
								<td><input name=""
									class="input_btn" type="button" value="保存"
									onclick="judgeSubmit()" /> <input name="" class="input_btn"
									type="button" value="重置" onclick="formReset()"/> <input name="" class="input_btn"
									type="button" value="返回"
									onclick="doReturn('${pageContext.request.contextPath}/comp/sysVersion/list')" /></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>