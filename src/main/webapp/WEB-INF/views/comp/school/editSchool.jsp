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
<title>学校修改</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/comp/school/edit"
		method="post" id="formId">
		<input type="hidden" name="id" value="${school.id}">
		<div class="main">
			<div class="path">
				<div class="path_left"></div>
				<div class="path_module">当前位置：系统管理 → 学校管理 → 学校修改</div>
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
								<th align="right" width="150">学校代码：</th>
								<td align="left"><input name="schoolCode" type="text"
									value="${school.schoolCode}" /><cite class="red"><form:errors
											path="school.schoolCode" /></cite><span style="color: red">*</span></td>
							</tr>

							<tr>
								<th align="right">学校简称：</th>
								<td align="left"><input name="simpleName" type="text"
									value="${school.simpleName}" /></td>
							</tr>

							<tr>
								<th align="right">学校名称：</th>
								<td align="left"><input name="schoolName" type="text"
									value="${school.schoolName}" /><cite class="red"><form:errors
											path="school.schoolName" /></cite><span style="color: red">*</span></td>
							</tr>

							<tr>
								<th align="right">所属行政区划：</th>
								<td align="left"><select name="sysRegion.id">
										<option value="0">--请选择--</option>
										<c:forEach items="${sysRegions}" var="i">
											<option value="${i.id}"
												<c:if test='${school.sysRegion.id==i.id}'>selected="selected"</c:if>>${i.name}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<th align="right">类别：</th>
								<td colspan="3" align="left"><select name="type">
										<c:forEach items="${sysDics}" var="i">
											<option value="${i.dicKey}"
												<c:if test='${school.type==i.dicKey}'>selected="selected"</c:if>>${i.dicValue}</option>
										</c:forEach>
								</select><cite class="red"><form:errors path="school.type" /></cite><span
									style="color: red">*</span></td>
							</tr>

                            <tr>
								<th align="right">是否停用：</th>
								<td colspan="3" align="left"><select name="isStop">
										<c:forEach items="${isStops}" var="i">
											<option value="${i.dicKey}"
												<c:if test='${school.isStop==i.dicKey}'>selected="selected"</c:if>>${i.dicValue}</option>
										</c:forEach>
								</select><span
									style="color: red">*</span></td>
							</tr>

							<tr>
								<th>&nbsp;</th>
								<td><input name=""
									class="input_btn" type="button" value="保存"
									onclick="doFormSubmit('formId','${pageContext.request.contextPath}/comp/school/edit')" />
									<input name="" class="input_btn" type="button" value="重置" onclick="formReset()"/> <input
									name="" class="input_btn" type="button" value="返回"
									onclick="doReturn('${pageContext.request.contextPath}/comp/school/list')" /></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>