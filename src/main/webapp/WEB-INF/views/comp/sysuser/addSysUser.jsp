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
<title>系统用户添加</title>

<script type="text/javascript">
	function judgeSubmit() {
		if ($("#name").val() == '') {
			$("#nameInfo").text("系统用户名称不能为空*");
			return;
		}
		if ($("#userName").val() == '') {
			$("#userInfo").text("用户名不能为空*");
			return;
		}
		if ($("#password").val() == '') {
			$("#passInfo").text("密码不能为空*");
			return;
		}
		if ($("#schoolId").val() == 0) {
			$("#schoolInfo").text("学校不能为空*");
			return;
		}
		if ($("#sysRoleId").val() == 0) {
			$("#roleInfo").text("角色不能为空*");
			return;
		}
		$("#formId").submit();
	}

	function getRoles(obj, url) {
		$("#sysRoleId").empty();
		$("#sysRoleId").append("<option value='0'>--请选择--</option>");
		var $obj = $(obj);
		var value = $obj.val();
		$.ajax({
			url : url,
			type : "POST",
			dataType : "json",
			data : {
				"schoolId" : value
			},
			async : false,
			cache : false,
			success : function(data) {
				for ( var i = 0; i < data.length; i++) {
					var role = data[i];
					$("#sysRoleId").append(
							"<option value='"+role.id+"'>--" + role.name
									+ "--</option>");
				}
			}
		});
	}
	function getSchoolsAndRoleByName(url){
		getSchoolsByName(url);
		getRoles($("#schoolId")[0],'${pageContext.request.contextPath}/comp/sysUser/getRoles');
		
	}
</script>

</head>
<body>
	<form action="${pageContext.request.contextPath}/comp/sysUser/add"
		method="post" id="formId">
		<div class="main">
			<div class="path">
				<div class="path_left"></div>
				<div class="path_module">当前位置：系统管理 → 系统用户管理 → 系统用户添加</div>
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
								<th align="right" width="150">系统用户名称：</th>
								<td align="left"><input name="name" type="text" value=""
									id="name" /><span style="color: red" id="nameInfo">*</span></td>
							</tr>
							<tr>
								<th align="right">登录名称：</th>
								<td align="left"><input name="userName" type="text"
									value="" id="userName"> <span style="color: red"
									id="userInfo">*</span></td>
							</tr>
							<tr>
								<th align="right">登录密码：</th>
								<td align="left"><input name="password" type="password"
									value="" id="password" /><span style="color: red"
									id="passwordInfo">*</span></td>
							</tr>
							<tr>
								<th align="right">所属学校：</th>
								<td align="left"><select name="school.id" id="schoolId"
									onchange="getRoles(this,'${pageContext.request.contextPath}/comp/sysUser/getRoles')">
										<option value="0">--请选择--</option>
										<c:forEach items="${schools}" var="i">
											<option value="${i.id}"
												<c:if test="${sysUser.school.id==i.id}">selected="selected"</c:if>>${i.schoolName}</option>
										</c:forEach>
								</select><span style="color: red" id="schoolInfo">*</span><input
									type="text" name="schoolNameSelect" /><input
									name="schoolNameInput" class="input_btn" type="button"
									onclick="getSchoolsAndRoleByName('${pageContext.request.contextPath}/comp/school/getAllSchools');"
									value="查询" /><span id="schoolNameSpan"
									style="color: red; display: none;">数据加载中,请稍候</span></td>
							</tr>
							<tr>
								<th align="right">所属角色：</th>
								<td colspan="3" align="left"><select name="sysRole.id"
									id="sysRoleId">
										<option value="0">--请选择--</option>

								</select><span style="color: red" id="roleInfo">*</span></td>
							</tr>

							<tr>
								<th align="right">EAMIL：</th>
								<td align="left"><input name="email" type="text" value="" /></td>
							</tr>
							<tr>
								<th align="right">联系电话：</th>
								<td align="left"><input name="phone" type="text" value="" /></td>
							</tr>

							<tr>
								<th>&nbsp;</th>
								<td><input name="" class="input_btn" type="button"
									value="保存" onclick="judgeSubmit()" /> <input name=""
									class="input_btn" type="button" value="重置"
									onclick="formReset()" /> <input name="" class="input_btn"
									type="button" value="返回"
									onclick="doReturn('${pageContext.request.contextPath}/comp/sysUser/list')" /></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>