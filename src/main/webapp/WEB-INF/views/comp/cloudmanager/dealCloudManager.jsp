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
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common_list.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/calendar/WdatePicker.js"
	type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>云端维护列表</title>
<script type="text/javascript">
function deal() {
	var idAndNum = checkOne();
	var id = idAndNum[1];
	var row = idAndNum[0];
	$.post("${pageContext.request.contextPath}/comp/cloudManager/deal", {
		"id" : id
	}, function(data) {
		if (data == 'success') {
			$("#myTable01 tbody tr:eq(" + row + ")").children("td").eq(4)
					.text("已处理");
			showMsg("处理成功!", "success");
		}
	}, "text");
}

function cancel() {
	var idAndNum = checkOne();
	var id = idAndNum[1];
	var row = idAndNum[0];
	$.post("${pageContext.request.contextPath}/comp/cloudManager/cancel", {
		"id" : id
	}, function(data) {
		if (data == 'success') {
			$("#myTable01 tbody tr:eq(" + row + ")").children("td").eq(4)
					.text("未处理");
			showMsg("取消成功!", "success");
		}
	}, "text");
}

function findRegions(obj,dom){	
	var regionId=$(obj).val();
	if(regionId!=0){	
		$.post('${pageContext.request.contextPath}/comp/cloudManager/findRegions',{'regionId':regionId},function(data){	
			if(data!=null && data!=''){	
				var content='<option value="0">--请选择--</option>';
				for(var i=0;i<data.length;i++){
				content+='<option value="'+data[i].id+'">'+data[i].name+'</option>';
				}
				$(dom).html(content);
			}
		},'json');
	}
}

function findSchools(obj,dom){	
	var regionId=$(obj).val();
	if(regionId!=0){	
		$.post('${pageContext.request.contextPath}/comp/cloudManager/findSchools',{'regionId':regionId},function(data){	
			if(data!=null && data!=''){	
				var content='<option value="0">--请选择--</option>';
				for(var i=0;i<data.length;i++){
				content+='<option value="'+data[i].id+'">'+data[i].schoolName+'</option>';
				}
				$(dom).html(content);
			}
		},'json');
	}
}
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/comp/cloudManager/list"
		method="post" id="formId">
		<jsp:include page="/includes/writeHidden.jsp" flush="true" />
		<div class="main">
			<div class="path">
				<div class="path_left"></div>
				<div class="path_module">当前位置：系统管理 → 操作员参数设置→ 云端维护</div>
				<div class="path_right">
					<a href="javascript:history.go(1);" class="btn_next">向前</a> <a
						href="javascript:history.go(-1);" class="btn_back">返回</a>
				</div>
			</div>
			<div class="main_content">
				<jsp:include page="/includes/operate.info.jsp" />
				<div class="search">
					<div class="search_condition">
						<span><font>省：</font> <select name="provinceId" id="province" onchange="findRegions('#province','#city')">
								<option value="0">--请选择--</option>
								<c:forEach items="${provinces}" var="i">
									<option value="${i.id}"
										<c:if test="${cloudManagerQueryForm.provinceId==i.id}">selected="selected"</c:if>>${i.name}</option>
								</c:forEach>
						</select> </span> <span><font>市：</font> <select name="cityId" id="city" onchange="findRegions('#city','#county')">
								<option value="0">--请选择--</option>

						</select> </span> <span><font>县：</font> <select name="countyId" id="county" onchange="findSchools('#county','#school')">
								<option value="0">--请选择--</option>

						</select> </span> <span><font>所属学校：</font> <select name="schoolId" id="school">
								<option value="0">--请选择--</option>
						</select></span> <span><font>开始时间：</font> <input name="startDate"
							type="text" id="startDate"
							value="<fmt:formatDate pattern='yyyy-MM-dd' value='${cloudManagerQueryForm.startDate}' />"
							onclick="WdatePicker({skin:'blueFresh',dateFmt:'yyyy-MM-dd',el:'startDate'})" /></span>

						<span><font>结束时间：</font> <input name="endDate" type="text"
							id="endDate"
							value="<fmt:formatDate pattern='yyyy-MM-dd' value='${cloudManagerQueryForm.endDate}' />"
							onclick="WdatePicker({skin:'blueFresh',dateFmt:'yyyy-MM-dd',el:'endDate'})" /></span>

						<span class="search_button"
							onclick="doFormSubmit('formId','${pageContext.request.contextPath}/comp/cloudManager/query')">
							<input name="" type="button" value="查询" class="btn_orange" />
						</span>
					</div>
				</div>
				<div class="list_table_title">
					<h3>云端维护列表</h3>
					<ul>
						<li><span class="btn_left"></span><a href="javascript:deal()"
							class="btn btn_new">处理</a><span class="btn_right"></span></li>
						<li><font></font></li>
						<li><span class="btn_left"></span><a
							href="javascript:cancel()" class="btn btn_edit">取消</a><span
							class="btn_right"></span></li>
						<li><font></font></li>
					</ul>
				</div>
				<div class="list" id="list1">
					<table id="myTable01" class="list_table" width="100%" border="0"
						cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<th width="3%">选择</th>
								<th width="16%">维护内容</th>
								<th width="16%">所属学校</th>
								<th width="16%">创建日期</th>
								<th width="16%">处理状态</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${page.content}" var="i">
							    <input name="ids" type="hidden" value="${i.id}" />
								<tr onclick="checkedTr(this);">
									<td align="right"><input name="checks" type="checkbox"
										class="input_none" id="checks" value="${i.id}" /></td>
									<td>${i.describe}&nbsp;</td>
									<td>${i.school.schoolName}&nbsp;</td>
									<td>&nbsp;<fmt:formatDate pattern='yyyy-MM-dd'
											value='${i.createDate}' /></td>
									<td><c:forEach items="${dealStatuses}" var="j">
											<c:if test="${i.dealStatus==j.dicKey}">${j.dicValue}</c:if>
										</c:forEach></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<jsp:include page="/includes/pager.inc.jsp" flush="true" />
			</div>
		</div>
	</form>
</body>
</html>