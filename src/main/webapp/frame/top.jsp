<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>头部HEADER</title>
<!--框架必需start-->
<link href="${pageContext.request.contextPath}/css/css.css"
	rel="stylesheet" type="text/css" />

<!--框架必需end-->

<!-- 颜色 -->
<link href="${pageContext.request.contextPath}/css/frame.css"
	rel="stylesheet" type="text/css" />

<!-- 颜色end -->

<!-- png 透明-->
<!--[if lte IE 6]>
<script src="../../js/PNGimg.js" type="text/javascript"></script>    
<script type="text/javascript">        
DD_belatedPNG.fix('div, img, ul, li, .topNav_bg, .t_sNav_news, .t_sNav_help, .t_sNav_count, .t_sNav_quit, .topNav a:hover, .t_sNav_point');    
</script>
<![endif]-->
<script src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js"
	language="javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#topNav li a").hover(function() {
			$(this).addClass("topNav_bg");
		}, function() {
			$(this).removeClass("topNav_bg");
		});
		$("#topNav li a").mousedown(function() {
			$(".topNav_bgH").removeClass("topNav_bgH");
			$(this).addClass("topNav_bgH");
		}); //鼠标经过图标出现背景
	});
</script>
</head>

<body>
	<div class="topbg">
		<div class="topLogo"><span class="vS">II</span><span class="vB">V2.0</span></div>
		<div class="topSubNav_ul">
			<li class="t_sNav_news"><a  href="javascript:opeanFeedBackWindow()">反馈</a></li>
			<!-- li class="t_sNav_count"><a href="javascript:openCountWindow()">统计</a></li-->
			<li class="t_sNav_help"><a href="javascript:openUserWindow()">修改</a></li>
			<li class="t_sNav_quit"><a
				href="${pageContext.request.contextPath}/login/compOut"
				target="frameset">退出</a></li>
		</div>
	</div>	
</body>
</html>
