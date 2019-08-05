<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/includes/head.jsp"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link href="${pageContext.request.contextPath}/css/series/ctDialog.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/css/uiprogressbar/jquery.ui.all.css"
	rel="stylesheet" type="text/css" />
<script
	src="${pageContext.request.contextPath}/js/uiprogressbar/jquery-1.10.2.js"
	language="javascript"></script>
<script
	src="${pageContext.request.contextPath}/js/uiprogressbar/jquery.ui.core.js"
	language="javascript"></script>
<script
	src="${pageContext.request.contextPath}/js/uiprogressbar/jquery.ui.widget.js"
	language="javascript"></script>
<script
	src="${pageContext.request.contextPath}/js/uiprogressbar/jquery.ui.progressbar.js"
	language="javascript"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/ajaxfileupload.js"
	language="javascript"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/series/ctDialog.js"></script>
<script type="text/javascript">
	$(function() {
		$("#upload")
				.click(
						function() {
							var x = $("#formId").serializeArray();
							var str = "";
							$.each(x, function(i, field) {
								str = str + '"' + field.name + '"' + ':' + '"'
										+ field.value + '"' + ',';
							});
							console.log(str);
							data = $.parseJSON('{'
									+ str.substr(0, str.length - 1) + '}');
							
							var value = $("#dataType").val();
							var url = "http://127.0.0.1:8080/cloudlib/rest/readerLendRecord/importData";
							/**
							if (value == 1) {
								url = "http://127.0.0.1:8080/cloudlib/r/uploadMarc";
							} else {
								url = "http://127.0.0.1:8080/cloudlib/marc/uploadExcel"
							}**/
							$.ajaxFileUpload({
								url : url,//用于文件上传的服务器端请求地址
								secureuri : false,//一般设置为false
								fileElementId : 'file',//文件上传空间的id属性  <input type="file" id="file" name="file" />
								dataType : 'text',//返回值类型 一般设置为json
								data : data,
								success : function(data) {//服务器成功响应处理函数	
									alert(data);
								},
							});
						});
	});
	/***查询学校**/
	function searchSchool() {
		var schoolName = $("#schoolInput").val();
		$.ajax({
			url : "${pageContext.request.contextPath}/comp/readerLendRecord/searchSchool",
			type : "POST",
			dataType : "json",
			data : {
				"schoolName" : schoolName
			},
			async : false,
			cache : false,
			success : function(data) {
				$("#schoolName").empty();
				$("#schoolName").append('<option value="0">--请选择--</option>');
				if (data != null) {
					for (schoolIndex in data) {
						var school = data[schoolIndex];
						$("#schoolName").append(
								"<option value='"+school.id+"'>"
										+ school.schoolName + "</option>");
					}
				}
			}
		});

	}
	function dataTypeShow() {
		var value = $("#dataType").val();
		if (value == 1) {
			$("#filedDiv").show();
		} else {
			$("#filedDiv").hide();
		}

	}
	/***获取学校管理员**/
	function chooseSysUser() {
		var schoolName = $("#schoolName").val();
		$
				.ajax({
					url : "${pageContext.request.contextPath}/comp/readerLendRecord/getSysUser",
					type : "POST",
					dataType : "json",
					data : {
						"schoolName" : schoolName
					},
					async : false,
					cache : false,
					success : function(data) {

						$("#sysUser").empty();
						$("#sysUser").append('<option value="0">--请选择--</option>');
						if (data != null) {
							for ( var key in data) {
								if (key == "sysUsers") {
									var sysUsers = data[key];
									for (sysUsersIndex in sysUsers) {
										var sysUser = sysUsers[sysUsersIndex];
										$("#sysUser").append(
												"<option value='"+sysUser.id+"'>"
														+ sysUser.userName
														+ "</option>");
									}
								}
								/**
								if (key == "places") {
									var places = data[key];
									for (placeIndex in places) {
										var place = places[placeIndex];
										$("#place").append(
												"<option value='"+place.id+"'>"
														+ place.name
														+ "</option>");
									}
								}**/

							}
						}
					}
				});
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>征订目录接收</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/comp/marc/upload"
		method="post" id="formId" enctype="multipart/form-data">
		<input type="hidden" name="userId" value="${userId }" />
		<div class="main">
			<div class="path">
				<div class="path_left"></div>
				<div class="path_module">当前位置：流通管理 → 流通数据导入</div>
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
								<th align="right" width="200">学校选择：</th>
									<td align="left">
										<input name="" value="" id="schoolInput">
										<select onchange="chooseSysUser();" name="schoolName" id="schoolName">
												<option value="0">--请选择--</option>
										</select>
										<input class="input_btn" type="button" value="查询" onclick="searchSchool();">
										<span style="color: red" id="marcInfo">*</span>
									</td>
							</tr>
							<tr>
								<th align="right">学校管理员：</th>
								<td align="left">
									<select name="sysUser" id="sysUser">
										<option value="">---请选择---</option>
									</select>
									<span style="color: red" id="bookInfo">*</span>
								</td>
							</tr>
							<!-- 
							<tr>
								<th align="right">文献流通类型：</th>
								<td align="left"><select name="type" id="type">
										<option value="">---请选择---</option>
								</select><span style="color: red" id="bookInfo">*</span></td>
							</tr>
							<tr>
								<th align="right">数据类型</th>
								<td><select id="dataType" onchange="dataTypeShow();">
										<option value="1">MARC</option>
										<option value="2">EXCEL</option>
								</select></td>
							</tr>
							
								<tr>
								<th align="right">书目类型</th>
								<td><select name="bookType">
										<option value="1">图书</option>
										<option value="2">期刊</option>
								</select></td>
							</tr>
 -->
							<tr>
								<th align="right">流通数据文件：</th>
								<td align="left"><input id="file" type="file" name="file"
									style="width: 150px" /> <span style="color: red" id="fileInfo">*</span></td>
							</tr>
<!-- 
							<tr>
								<th align="right">数据文件字符集：</th>
								<td align="left"><select name="charset" id="charset">
										<c:forEach items="${charsets}" var="i">
											<option value="${i.dicKey}"
												<c:if test="${batchQueryForm.charset==i.dicKey}">selected="selected"</c:if>>${i.dicValue}</option>
										</c:forEach>
								</select></td>
							</tr>
 -->
							<tr>
								<th>&nbsp;</th>

								<td><input name="" id="upload" class="input_btn"
									type="button" value="上传文件" onclick="" /> <input name=""
									class="input_btn" type="button" value="重置"
									onclick="formReset()" /></td>
							</tr>
						</table>
						<div id="progressbar" style="display: none;">
							<div style="display: none;" id="progress-label"
								class="progress-label">Loading...</div>
						</div>
					</div>
				</div>
			</div>
	<!--
			<div id="reg" class="ctDialogDiv"></div>
 		
			<div class="main_content" id="filedDiv">

				<div class="row_half edit">
					<div class="row_half_right">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<th align="right" width="200"><input name="filed0" value=""
									type="text" /></th>
								<td align="left">条码号</td>
							</tr>
							<tr>
								<th align="right" width="200"><input name="filed1" value=""
									type="text" /></th>
								<td align="left">索书号</td>
							</tr>
							<tr>
								<th align="right" width="200"><input name="filed2" value=""
									type="text" /></th>
								<td align="left">单价</td>
							</tr>
							<tr>
								<th align="right" width="200"><input name="filed3" value=""
									type="text" /></th>
								<td align="left">总价</td>
							</tr>
							<tr>
								<th align="right" width="200"><input name="filed4" value=""
									type="text" /></th>
								<td align="left">文献来源</td>
							</tr>
							<tr>
								<th align="right" width="200"><input name="filed5" value=""
									type="text" /></th>
								<td align="left">介质类型</td>
							</tr>
							<tr>
								<th align="right" width="200"><input name="filed6" value=""
									type="text" /></th>
								<td align="left">装帧信息</td>
							</tr>
							<tr>
								<th align="right" width="200"><input name="filed7" value=""
									type="text" /></th>
								<td align="left">卷册数量</td>
							</tr>
							<tr>
								<th align="right" width="200"><input name="filed8" value=""
									type="text" /></th>
								<td align="left">卷册信息</td>
							</tr>


						</table>
					</div>
				</div>
				 -->
	</form>
</body>
<style>
.ui-progressbar {
	position: relative;
}

.progress-label {
	position: absolute;
	left: 50%;
	top: 4px;
	font-weight: bold;
	text-shadow: 1px 1px 0 #fff;
}
</style>
</html>