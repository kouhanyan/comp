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
		var name=$("#name").val();
		var reg = /^[1-9]\d*$/;
		if(name==''){	
			$("#nameInfo").text("名称不能为空");
			return;
		}
		var country=$("#country").val();
		if(country==''){	
			$("#countryInfo").text("国家不能为空");
			return;
		}
		var server=$("#server").val();
		if(server==''){	
			$("#serverInfo").text("服务器地址不能为空");
			return;
		}
		var port=$("#port").val();
		if(port==''){	
			$("#portInfo").text("端口不能为空");
			return;
		}
		var userName=$("#userName").val();
		if(userName==''){	
			$("#userInfo").text("用户名不能为空");
			return;
		}
		var password=$("#password").val();
		if(password==''){	
			$("#passInfo").text("密码不能为空");
			return;
		}
		var authType=$("#authType").val();
		if(!reg.test(authType)){	
			$("#authInfo").text("验证类型必须为大于0的整数");
			return;
		}
		var charset=$("#charset").val();
		if(charset==''){	
			$("#charsetInfo").text("编码不能为空");
			return;
		}
		var database=$("#database").val();
		if(database==''){	
			$("#dataInfo").text("数据库不能为空(多个数据库用,隔开)");
			return;
		}
		$("#formId").submit();
	}
</script>
<title>Z3950修改</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/comp/z3950/edit"
		method="post" id="formId">
		<input type="hidden" name="id" value="${z3950.id}">
		<div class="main">
			<div class="path">
				<div class="path_left"></div>
				<div class="path_module">当前位置：系统管理 → Z3950管理→ Z3950修改 </div>
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
								<th align="right" width="150">名称：</th>
								<td align="left"><input name="name" type="text"
									value="${z3950.name}" id="name" /><span
									style="color: red" id="nameInfo">*</span></td>
							</tr>
							<tr>
								<th align="right">国家：</th>
								<td align="left"><input name="country" type="text"
									value="${z3950.country}" id="country" /><span
									style="color: red" id="countryInfo">*</span></td>
							</tr>
							<tr>
								<th align="right">服务器：</th>
								<td align="left"><input name="server" type="text"
									value="${z3950.server}" id="server"/><span
									style="color: red" id="serverInfo">*</span></td>
							</tr>
							<tr>
								<th align="right">端口：</th>
								<td align="left"><input name="port" type="text"
									value="${z3950.port}" id="port"/><span
									style="color: red" id="portInfo">*</span></td>
							</tr>

                             <tr>
								<th align="right">用户名：</th>
								<td align="left"><input name="userName" type="text"
									value="${z3950.userName}" id="userName"/><span
									style="color: red" id="userInfo">*</span></td>
							</tr>
							<tr>
								<th align="right">密码：</th>
								<td align="left"><input name="password" type="password"
									value="${z3950.password}" id="password"/><span
									style="color: red" id="passInfo">*</span></td>
							</tr>
							
							 <tr>
								<th align="right">验证类型：</th>
								<td align="left"><input name="authType" type="text"
									value="${z3950.authType}" id="authType"/><span
									style="color: red" id="authInfo">*</span></td>
							</tr>
							<tr>
								<th align="right">编码：</th>
								<td align="left"><input name="charset" type="text"
									value="${z3950.charset}" id="charset"/><span
									style="color: red" id="charsetInfo">*</span></td>
							</tr>
							
							<tr>
								<th align="right">数据库：</th>
								<td colspan="3" align="left"><textarea name="database"
										id="database" cols="50" rows="3">${z3950.database}</textarea><span
									style="color: red" id="dataInfo">*</span></td>
							</tr>
							
							<tr>
								<th>&nbsp;</th>
								<td><input name=""
									class="input_btn" type="button" value="保存"
									onclick="judgeSubmit()" /> <input name="" class="input_btn"
									type="button" value="重置" onclick="formReset()"/> <input name="" class="input_btn"
									type="button" value="返回"
									onclick="doReturn('${pageContext.request.contextPath}/comp/z3950/list')" /></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>