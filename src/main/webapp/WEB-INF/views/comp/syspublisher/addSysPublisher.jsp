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
		var code = $("#code").val();
		var name = $("#name").val();
		if (code=='') {
			$("#codeInfo").text("代码不能为空");
			return;
		}
		if (name=='') {
			$("#nameInfo").text("名称不能为空");
			return;
		}
		$("#formId").submit();
	}
</script>
<title>出版社添加</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/comp/sysPublisher/add"
		method="post" id="formId">
		<div class="main">
			<div class="path">
				<div class="path_left"></div>
				<div class="path_module">当前位置：系统管理 → 出版社管理→ 出版社添加 </div>
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
								<th align="right" width="150">出版社代码：</th>
								<td align="left"><input name="code" type="text"
									value="" id="code" /><span
									style="color: red" id="codeInfo">*</span></td>
							</tr>
							<tr>
								<th align="right">出版社名称：</th>
								<td align="left"><input name="name" type="text"
									value="" id="name" /><span
									style="color: red" id="nameInfo">*</span></td>
							</tr>
							<tr>
								<th align="right">所属城市代码：</th>
								<td align="left"><input name="cityCode" type="text"
									value="" id="cityCode"/></td>
							</tr>
							<tr>
								<th align="right">所属城市名称：</th>
								<td colspan="3" align="left"><input name="cityName" type="text"
									value="" id="cityName"/></td>
							</tr>

							<tr>
								<th>&nbsp;</th>
								<td><input name=""
									class="input_btn" type="button" value="保存"
									onclick="judgeSubmit()" /> <input name="" class="input_btn"
									type="button" value="重置" onclick="formReset()"/> <input name="" class="input_btn"
									type="button" value="返回"
									onclick="doReturn('${pageContext.request.contextPath}/comp/sysPublisher/list')" /></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>