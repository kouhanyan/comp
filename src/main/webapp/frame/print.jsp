<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MAIN</title>
<!--框架必需start-->
<link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css"/>

<!--框架必需end-->

<!-- 颜色 -->
<link href="${pageContext.request.contextPath}/css/frame.css" rel="stylesheet" type="text/css"/>

<!-- 颜色end -->

<!-- png 透明-->
<!--[if lte IE 6]>
<script src="../../js/PNGimg.js" type="text/javascript"></script>    
<script type="text/javascript">        
DD_belatedPNG.fix('div, ul, img, li, input ,a, .tab_title, .tab_titlebg ');    
</script>
<![endif]-->
</head>

<body style="margin:0; padding:0; overflow:hidden;">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" style="table-layout:fixed;">
	<tr>
		<td width="186" id="frmTitle" noWrap name="fmTitle" align="center" valign="top"><iframe name="left" height="100%" width="186" src="left.jsp" border="0" frameborder="0" scrolling="no"> </iframe></td>
		<td width="100%" valign="top"><iframe name="main" height="100%" width="100%" border="0" frameborder="0" src="swich.jsp"> </iframe></td>
	</tr>
</table>
</body>
</html>
