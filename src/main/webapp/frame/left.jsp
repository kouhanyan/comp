<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>LEFT</title>
<!--框架必需start-->
<link href="${pageContext.request.contextPath}/css/css.css"
	rel="stylesheet" type="text/css" />
<!--框架必需end-->

<!-- 颜色 -->
<link href="${pageContext.request.contextPath}/css/frame.css"
	rel="stylesheet" type="text/css" />
<!-- 颜色end -->

<script src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js"
	language="javascript"></script>

<!-- png 透明-->
<!--[if lte IE 6]>
<script src="../../js/PNGimg.js" type="text/javascript"></script>    
<script type="text/javascript">        
DD_belatedPNG.fix('ul, img, li, input ');    
</script>
<![endif]-->

<script type="text/javascript">
	$(document).ready(
			function() {
				$(".mTitle").click(
						function() {
							$(this).next("div").slideToggle("slow").siblings(
									".mCon:visible").slideUp("slow");
						});

				$(".mCon a").hover(function() {
					$(this).removeClass("mCon_a");
					$(this).addClass("mCon_a_h");
				}, function() {
					$(this).removeClass("mCon_a_h");
					$(this).addClass("mCon_a");
				});
				$(".mCon a").mousedown(function() {
					$(".mCon_a_h2").removeClass("mCon_a_h2");
					$(this).addClass("mCon_a_h2");
				});

			});
</script>
</head>

<body>
	<div class="leftNav">
		<div class="leftName">
			您好！管理员<br /> 云图书馆云端管理
		</div>
		<div class="leftNav_list">
			<div class="mTitle">
				<img
					src="${pageContext.request.contextPath}/images/leftNav_icon1.png"
					width="15" height="15" align="absmiddle" /> 系统管理
			</div>
			<div class="mCon" style="display: block;">
				<a href="${pageContext.request.contextPath}/comp/sysDic/list"
					class="mCon_a" target="main">数据字典管理</a> <a
					href="${pageContext.request.contextPath}/comp/sysRegion/list"
					class="mCon_a" target="main">行政区划管理</a> <a
					href="${pageContext.request.contextPath}/comp/school/list"
					class="mCon_a" target="main">学校管理</a> <a
					href="${pageContext.request.contextPath}/comp/sysResource/list"
					class="mCon_a" target="main">菜单资源管理</a> <a
					href="${pageContext.request.contextPath}/comp/sysRole/list"
					class="mCon_a" target="main">角色管理</a> <a
					href="${pageContext.request.contextPath}/comp/sysUser/list"
					class="mCon_a" target="main">系统用户管理</a> <a
					href="${pageContext.request.contextPath}/comp/sysDesktop/list"
					class="mCon_a" target="main">桌面管理</a> <a
					href="${pageContext.request.contextPath}/comp/z3950/list"
					class="mCon_a" target="main">Z3950地址管理</a> <a
					href="${pageContext.request.contextPath}/comp/sysPublisher/list"
					class="mCon_a" target="main">出版社管理</a> <a
					href="${pageContext.request.contextPath}/comp/sysAnnouncement/list"
					class="mCon_a" target="main">系统公告</a> <a
					href="${pageContext.request.contextPath}/comp/sysVersion/list"
					class="mCon_a" target="main">版次管理</a>
				<!--<a
					href="${pageContext.request.contextPath}/comp/biblioAuthorize/list"
					class="mCon_a" target="main">编目授权管理</a>-->
				<a href="${pageContext.request.contextPath}/comp/feedBack/list"
					class="mCon_a" target="main">反馈信息管理</a> <a
					href="${pageContext.request.contextPath}/comp/sysSmsApplyDeal/list"
					class="mCon_a" target="main">短信申请处理</a> <a
					href="${pageContext.request.contextPath}/comp/dataManage/list"
					class="mCon_a" target="main">数据恢复</a> <a
					href="${pageContext.request.contextPath}/comp/cloudManager/list"
					class="mCon_a" target="main">云端维护</a> <a
					href="${pageContext.request.contextPath}/comp/compLog/list"
					class="mCon_a" target="main">系统日志</a> <a
					href="${pageContext.request.contextPath}/comp/marc/add"
					class="mCon_a" target="main">MARC导入</a>
				<a href="${pageContext.request.contextPath}/comp/readerLendRecord/add" class="mCon_a" target="main">流通记录导入</a>
			</div>
		</div>
</body>
</html>
