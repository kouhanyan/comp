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
<script
	src="${pageContext.request.contextPath}/js/calendar/WdatePicker.js"
	language="javascript"></script>
<script type="text/javascript">
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>数据恢复</title>
<script type="text/javascript">
	$(function() {
		var message = "${message}";
		if(message != ''){
			$("#message").show();
			var	timename=setTimeout("hidenTr()",10000);
		}else{
			hidenTr();
		}
	});
	function hidenTr(){
		$("#message").hide();
		
	}
	function judgeSubmit() {
		$("#formId").submit();
		$("#message").show();
		$("#message").children().html("数据导入中...");
	}
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/comp/dataManage/deal"
		method="post" id="formId" enctype="multipart/form-data">
		<div class="main">
			<div class="path">
				<div class="path_left"></div>
				<div class="path_module">当前位置：系统管理→ 数据恢复</div>
				<div class="path_right">
					<a href="javascript:history.go(1);" class="btn_next">向前</a> <a
						href="javascript:history.go(-1);" class="btn_back">返回</a>
				</div>
			</div>

			<div class="main_content">
				<div class="edit">
					<div class="edit_table_title">数据恢复文件接收</div>
					<table class="edit_table" width="100%" border="0" cellspacing="0"
						cellpadding="5">
						<tr>
							<td align="center"><input name="file" type="file" id="file" /></td>
						</tr>
						<tr id="message" style="color: red;">
							<td align="left">${message}</td>
						</tr>
						<tr>
							<td align="center">
								<div class="edit_table_btn">
									<input name="" type="button" class="btn_ok"
										onclick="judgeSubmit()" />
								</div>
							</td>

						</tr>
					</table>
				</div>
			</div>
		</div>
	</form>
</body>
</html>