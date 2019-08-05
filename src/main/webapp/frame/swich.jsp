<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MAIN</title>
<!--框架必需start-->
<link href="${pageContext.request.contextPath}/css/css.css"
	rel="stylesheet" type="text/css" />

<!--框架必需end-->

<!-- 颜色 -->
<link href="${pageContext.request.contextPath}/css/frame.css"
	rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/js/calendar/WdatePicker.js"
	language="javascript"></script>
<script type="text/javascript">
	/*function beyondReadTime() {
		var schoolId = '${local_user.school.id}';
		$.post("${pageContext.request.contextPath}/readRegist/findBeyondTime",
				{
					"schoolId" : schoolId,
				}, function(data) {
					if (data != null && data != '') {
						alert("有读者阅览超过5小时，请登出");
						return;
					}
				}, "text");
	}
	var timer = window.setInterval(beyondReadTime, 60 * 60 * 1000);*/
</script>
<!-- 颜色end -->

<!-- png 透明-->
<!--[if lte IE 6]>
<script src="../../js/PNGimg.js" type="text/javascript"></script>    
<script type="text/javascript">        
DD_belatedPNG.fix('div, ul, img, li, input ,a, .tab_title, .tab_titlebg ');    
</script>
<![endif]-->
<style>
.floatCount {
	position: fixed;
	width: 100%;
	height: 40px;
	line-height: 40px;
	left: 0px;
	bottom: 4px; /*background:rgba(51,102,153,0.5) !important;*/
	background: #369;
	text-indent: 20px;
	color: #FFF;
}
</style>
</head>

<body>
	<div class="main">
		<div class="welcome">
			<div class="comp_welcome_pic"></div>
		</div>
	</div>
</body>
</html>
