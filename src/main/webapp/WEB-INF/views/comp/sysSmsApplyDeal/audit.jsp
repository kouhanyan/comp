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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript">
	
</script>
</head>
<body>
	<form
		action="${pageContext.request.contextPath}/comp/sysSmsApplyDeal/audit"
		method="post" id="formId">
		<input type="hidden" name="id" value="${smsApply.id}">
		<div class="main">
			<div class="main_content">
				<div class="edit">
					<div class="edit_table_title">审核内容</div>
					<table class="edit_table" width="100%" border="0" cellspacing="0"
						cellpadding="5">
						<tr>
							<th width="15%" align="right">申请学校：</th>
							<td width="35%">${smsApply.schoolName }</td>
							<th width="15%" align="right">申请人姓名：</th>
							<td width="35%">${smsApply.userName }</td>
						</tr>

						<tr>
							<th width="15%" align="right">申请套餐：</th>
							<td width="35%">${smsApply.project }</td>
							<th width="15%" align="right">申请金额：</th>
							<td width="35%">${smsApply.amount }</td>
						</tr>
						<tr>
							<th width="15%" align="right">申请条数：</th>
							<td width="35%">${smsApply.applyNum }</td>
							<th width="15%" align="right">申请日期：</th>
							<td width="35%"><fmt:formatDate pattern='yyyy-MM-dd'
									value='${smsApply.applyDate}' /></td>
						</tr>
						<tr>
							<th width="15%" align="right">联系人：</th>
							<td width="35%">${smsApply.contactName }</td>
							<th width="15%" align="right">联系电话：</th>
							<td width="35%">${smsApply.contactPhone }</td>
						</tr>
						<tr>
							<th width="15%" align="right">联系邮箱：</th>
							<td width="35%" colspan="3">${smsApply.contactEmail}</td>
							
						</tr>


						<tr>
							<td colspan="6" align="center">
								<div class="edit_table_btn">
									<input type="submit" class="btn_ok1" />
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