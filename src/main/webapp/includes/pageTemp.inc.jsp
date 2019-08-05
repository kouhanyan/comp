<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pager">
	<span>第${page.number}/${page.totalPages}页
		共${page.totalElements}条</span>

	<c:if test="${page.number<=1}">
		<span class="page_gray">首页</span>
	</c:if>

	<c:if test="${page.number>1}">
		<a
			href="javascript:partPage('${pageContext.request.contextPath}/z3950DownLoad/z3950PartPage/#number#/#urlMark#','1',${urlMark})">首页</a>
	</c:if>

	<c:if test="${page.number<=1}">
		<span class="page_gray">上一页</span>
	</c:if>

	<c:if test="${page.number>1}">
		<a
			href="javascript:partPage('${pageContext.request.contextPath}/z3950DownLoad/z3950PartPage/#number#/#urlMark#','${page.number-1}',${urlMark})">上一页</a>
	</c:if>

	<c:if test="${page.number>=page.totalPages}">
		<span class="page_gray">下一页</span>
	</c:if>

	<c:if test="${page.number<page.totalPages}">
		<a
			href="javascript:partPage('${pageContext.request.contextPath}/z3950DownLoad/z3950PartPage/#number#/#urlMark#','${page.number+1}',${urlMark})">下一页</a>
	</c:if>

	<c:if test="${page.number>=page.totalPages}">
		<span class="page_gray">未页</span>
	</c:if>

	<c:if test="${page.number<page.totalPages}">
		<a
			href="javascript:partPage('${pageContext.request.contextPath}/z3950DownLoad/z3950PartPage/#number#/#urlMark#','${page.totalPages}',${urlMark})">末页</a>
	</c:if>
	<span>转至 <input id="forward" class="input_in" type="text" /> <input
		type="button" class="input_btn" value="GO" id="pageNum"
		onclick="partPageForward('${pageContext.request.contextPath}/z3950DownLoad/z3950PartPage/#number#/#urlMark#','${page.totalPages}',${urlMark})" />
	</span>
</div>