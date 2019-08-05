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
<script src="${pageContext.request.contextPath}/js/calendar/WdatePicker.js"
	language="javascript"></script>
<script src="${pageContext.request.contextPath}/js/common_list.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common_list_pager.js"
	type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript">
	function judgeSubmit() {
		var reg = /^[1-9]\d*$/;
		var schoolId=$("#schoolId").val();
		if(schoolId==0){	
			$("#schoolInfo").text("授权学校不能为空");
			return;
		}
		var applicant=$("#applicant").val();
		
		if(applicant==''){	
			$("#appInfo").text("申请人不能为空");
			return;
		}
		var appCount=$("#appCount").val();
		if(!reg.test(appCount)){	
			$("#countInfo").text("申请册数必须为整数");
			return;
		}
		var appDate=$("#appDate").val();
		if(appDate==''){	
			$("#dateInfo").text("申请时间不能为空");
			return;
		}
		$("#formId").submit();
	}
</script>
<title>编目授权添加</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/comp/biblioAuthorize/add"
		method="post" id="formId">
		<div class="main">
			<div class="path">
				<div class="path_left"></div>
				<div class="path_module">当前位置：系统管理 → 编目授权管理→ 编目授权添加 </div>
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
								<th align="right" width="150">授权学校：</th>
								<td align="left"><select name="schoolId"
									id="schoolId">
										<option value="0">--请选择--</option>
										<c:forEach items="${schools}" var="i">
											<option value="${i.id}"
												<c:if test="${biblioAuthorize.schoolId==i.id}">selected="selected"</c:if>>${i.schoolName}</option>
										</c:forEach>
								</select><span
									style="color: red" id="schoolInfo">*</span></td>
							</tr>
							
							<tr>
								<th align="right">申请人：</th>
								<td align="left"><input name="applicant" type="text"
									value="" id="applicant" /><span
									style="color: red" id="appInfo">*</span></td>
							</tr>
							
							<tr>
								<th align="right">申请册数：</th>
								<td align="left"><input name="appCount" type="text"
									value="" id="appCount" /><span
									style="color: red" id="countInfo">*</span></td>
							</tr>
							
							<tr>
								<th align="right">申请时间：</th>
								<td align="left"><input name="appDate" type="text" id="appDate"
									value="<fmt:formatDate pattern='yyyy-MM-dd' value='${biblioAuthorize.appDate}' />"
								onclick="WdatePicker({skin:'blueFresh',dateFmt:'yyyy-MM-dd',el:'appDate'})" /><span
									style="color: red" id="dateInfo">*</span></td>
							</tr>
							
							<tr>
								<th align="right">是否有效：</th>
								<td align="left"><select name="isValid"
									id="isValid">
										<c:forEach items="${sysDics}" var="i">
											<option value="${i.dicKey}"
												<c:if test="${biblioAuthorize.isValid==i.dicKey}">selected="selected"</c:if>>${i.dicValue}</option>
										</c:forEach>
								</select><span
									style="color: red">*</span></td>
							</tr>
							
							
							<tr>
								<th>&nbsp;</th>
								<td><input name=""
									class="input_btn" type="button" value="保存"
									onclick="judgeSubmit()" /> <input name="" class="input_btn"
									type="button" value="重置" onclick="formReset()"/> <input name="" class="input_btn"
									type="button" value="返回"
									onclick="doReturn('${pageContext.request.contextPath}/comp/biblioAuthorize/list')" /></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>