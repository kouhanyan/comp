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
		var name=$("#name").val();
		var screenNo=$("#screenNo").val();
		var file=$("#file").val();
		if(name==''){	
			$("#nameInfo").text("图标名称不能为空");
			return;
		}
		if(!reg.test(screenNo)){	
			$("#noInfo").text("屏幕号必须为整数");
			return;
		}
		if(file=='' || (file.indexOf(".png")<0 && file.indexOf(".ico")<0 && file.indexOf(".icns")<0 && file.indexOf(".jpg")<0)){	
			$("#fileInfo").text("请上传png或ico或icns任何一种格式的图标文件");
			return;
		}
		$("#formId").submit();
	}
</script>
<title>系统桌面添加</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/comp/sysDesktop/add"
		method="post" id="formId" enctype="multipart/form-data">
		<div class="main">
			<div class="path">
				<div class="path_left"></div>
				<div class="path_module">当前位置：系统管理 → 系统桌面管理→ 系统桌面添加</div>
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
								<th align="right" width="150">图标名称：</th>
								<td align="left"><input name="name" type="text"
									value="" id="name" /><span
									style="color: red" id="nameInfo">*</span></td>
							</tr>
							<tr>
								<th align="right">屏幕号：</th>
								<td align="left"><input name="screenNo" type="text"
									value="" id="screenNo" /><span
									style="color: red" id="noInfo">*</span></td>
							</tr>

							<tr>
								<th align="right">选择图标：</th>
								<td align="left"><input id="file" type="file" name="file"  style="width:150px;"/>
									<span style="color: red" id="fileInfo">*</span></td>
							</tr>


							<tr>
								<th>&nbsp;</th>
								<td><input name=""
									class="input_btn" type="button" value="保存"
									onclick="judgeSubmit()" /> <input name="" class="input_btn"
									type="button" value="重置" onclick="formReset()"/> <input name="" class="input_btn"
									type="button" value="返回"
									onclick="doReturn('${pageContext.request.contextPath}/comp/sysDesktop/list')" /></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>