<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/dialog.css"
	type="text/css" />
<script type="text/javascript">
	$(function() {

		$("#fullbg1,#dialog1").hide();
		var isFree = "${local_user.school.free}";
		var isManadate = "${local_user.school.manadateBoolean}";
		if (isFree != "true" && isManadate == "true") {
			//不是免费  而且超期
			/**学校激活码过期的弹出框**/
			openHelp();
		}

		$("#close").click(function() {
			hideMessage();
		});
		if ('${message_success}' != "") {
			$("#divmsg").removeClass();
			$("#divmsg").addClass("tip tRight");
			$("#pMsg")
					.text(
							'<spring:message code="${message_success}" arguments="${arguments}" argumentSeparator="," text="1"/><c:remove var="message_success" scope="session" />');
			setTimeout('hideMessage()', 5000);
		} else if ('${message_warn}' != "") {
			$("#divmsg").removeClass();
			$("#divmsg").addClass("tip");
			$("#pMsg")
					.text(
							'<spring:message code="${message_warn}" arguments="${arguments}" argumentSeparator="," text="2"/><c:remove var="message_warn" scope="session" />');
		} else if ('${message_error}' != "") {
			$("#divmsg").removeClass();
			$("#divmsg").addClass("tip tError");
			$("#pMsg")
					.text(
							'<spring:message code="${message_error}" arguments="${arguments}" argumentSeparator="," text="3"/><c:remove var="message_error" scope="session" />');
		} else {
			$("#divmsg").hide();
		}
	});
	function openHelp() {
		var bh = $("html").height();
		var bw = $("html").width();
		$("#fullbg1").css({
			height : bh,
			width : bw,
			display : "block"
		});
		$("#dialog1").show();
	}

	function hideMessage() {
		$(".tip .close").parents(".tip").animate({
			opacity : 'hide'
		}, "slow");
	}

	function showMsg(msg, msgType) {
		if (msgType == "warn") {
			$("#divmsg").removeClass();
			$("#divmsg").addClass("tip");
		} else if (msgType == "success") {
			$("#divmsg").removeClass();
			$("#divmsg").addClass("tip tRight");
			setTimeout('hideMessage()', 5000);
		} else {
			$("#divmsg").removeClass();
			$("#divmsg").addClass("tip tError");
		}
		$("#pMsg").text(msg);
		$("#divmsg").show();
	}
</script>

<div id="divmsg">
	<div class="tipBox">
		<div class="ico"></div>
		<p id="pMsg"></p>
		<div class="close" id="close"></div>
		<div class="clear"></div>
	</div>
</div>

<div id="fullbg1"></div>
<div id="dialog1">
	<p id="message_prompt_title" class="title">温馨提示</p>
	<span
		style="color: black; text-align: center; display: block; font-size: 20px;">内容说明</span>
	<span style="color: black;">&nbsp;您的激活码</span>
	<p class="close1" onclick="closeHelp();">关闭</p>
</div>