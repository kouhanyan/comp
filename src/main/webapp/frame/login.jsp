<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet"
	type="text/css" />
<link href="${pageContext.request.contextPath}/css/login.css"
	rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js" language="javascript"></script>
<script src="${pageContext.request.contextPath}/js/common_list.js" language="javascript"></script>
<script type="text/javascript">
  function loginSubmit(){	
	  $("#form").submit();
  }
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>公司登陆页面</title>
</head>
<body>
	<table class="table">
		<tr>
			<td valign="middle"><div class="light">
					<div class="comp_login png">
					    <form action="${pageContext.request.contextPath}/login/company" method="post" id="form">
						<table width="245" style="margin: 0 auto;" border="0"
							cellspacing="0" cellpadding="0">
							<tr>
								<td valign="middle" align="left">
									<ul>
										<li><div class="L_name"></div> <input name="userName"
											type="text" value="" /></li>
										<li><div class="L_pass"></div> <input name="rawPass"
											type="password" value="" /></li>
										<li style="color:red;">${login_error}</li>
										<li class="tool"><input name="login" type="button"
											class="btn" onclick="loginSubmit()"/>
										</li>
									</ul>
								</td>
							</tr>
						</table>
						</form>
					</div>
				</div></td>
		</tr>
	</table>
</body>
</html>