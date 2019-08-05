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
<title>反馈详情</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/feedBack/edit"
		method="post" id="formId" enctype="multipart/form-data">
		<div class="main">
			<div class="path">
				<div class="path_left"></div>
				<div class="path_module">当前位置：系统管理→ 反馈管理→ 反馈详情</div>
				<div></div>
				<div class="path_right">
					<a href="javascript:history.go(1);" class="btn_next">向前</a> <a
						href="javascript:history.go(-1);" class="btn_back">返回</a>
				</div>
			</div>
			<jsp:include page="/includes/operate.info.jsp" />
			<div class="main_content">
				<div class="row_half edit">
					<div class="row_half_left">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<th align="right" style="width:auto">问题反馈：</th>
								<td align="left"><textarea name="problem" id="problem"
										cols="50" rows="3" onblur="textOnBlur()" style="overflow:scroll; overflow-x:hidden; width:600px; ">${feedBack.problem}</textarea><span
									style="color: red" id="problemInfo">*</span></td>
							</tr>

							<tr>
								<th align="right" style="width:auto">反馈截图：</th>
								<td align="left"><a target="_blank" href="${pageContext.request.contextPath}/comp/feedBack/image/${feedBack.id}">
										<img border="0" src="${pageContext.request.contextPath}/comp/feedBack/image/${feedBack.id}" width="80%" height="80%"/>
								</a></td>
							</tr>


						</table>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>