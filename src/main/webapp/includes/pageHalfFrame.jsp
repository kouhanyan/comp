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
			href="javascript:framePage('${pageContext.request.contextPath}/#midUrl#/query','${midUrl}','1')">首页</a>
	</c:if>

	<c:if test="${page.number<=1}">
		<span class="page_gray">上一页</span>
	</c:if>

	<c:if test="${page.number>1}">
		<a
			href="javascript:framePage('${pageContext.request.contextPath}/#midUrl#/query','${midUrl}','${page.number-1}')">上一页</a>
	</c:if>

	<c:if test="${page.number>=page.totalPages}">
		<span class="page_gray">下一页</span>
	</c:if>

	<c:if test="${page.number<page.totalPages}">
		<a
			href="javascript:framePage('${pageContext.request.contextPath}/#midUrl#/query','${midUrl}','${page.number+1}')">下一页</a>
	</c:if>

	<c:if test="${page.number>=page.totalPages}">
		<span class="page_gray">未页</span>
	</c:if>

	<c:if test="${page.number<page.totalPages}">
		<a
			href="javascript:framePage('${pageContext.request.contextPath}/#midUrl#/query','${midUrl}','${page.totalPages}')">末页</a>
	</c:if>
	<span>转至 <input id="forward" class="input_in" type="text" /> <input
		type="button" class="input_btn" value="GO" id="pageNum"
		onclick="framePageForward('${pageContext.request.contextPath}/#midUrl#/query','${midUrl}','${page.totalPages}')" />
	</span>
</div>