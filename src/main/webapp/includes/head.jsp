<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
    String base = request.getContextPath();
%>
<!-- css -->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/images/favicon.ico" />

<link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico"
	type="image/x-icon" />
<link href="${pageContext.request.contextPath}/css/css.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/frame.css"
	rel="stylesheet" type="text/css" />

<!-- js -->
<script src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js"
	type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/js/common_list.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common_list_pager.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/js/calendar/WdatePicker.js"
	type="text/javascript"></script>
<script type="text/javascript">
	var base = "<%=base%>";
	function closeHelp() {
		$("#fullbg1,#dialog1").hide();
	}

</script>