<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- javascript:checkIds() -->
<div class="pager">
	<span style="margin-left: 10px; float: left; "><input class="input_none" type="checkbox" onclick="javascript:checkIds();"/> </span ><span style="float: left;">全选/反选</span> <span>第${page.number}/${page.totalPages}页
		共${page.totalElements}条</span>

	<c:if test="${page.number<=1}">
		<span class="page_gray">首页</span>
	</c:if>

	<c:if test="${page.number>1}">
		<a href="javascript:goPage(1)">首页</a>
	</c:if>

	<c:if test="${page.number<=1}">
		<span class="page_gray">上一页</span>
	</c:if>

	<c:if test="${page.number>1}">
		<a href="javascript:goPage(${page.number-1})">上一页</a>
	</c:if>

	<c:if test="${page.number>=page.totalPages}">
		<span class="page_gray">下一页</span>
	</c:if>

	<c:if test="${page.number<page.totalPages}">
		<a href="javascript:goPage(${page.number+1})">下一页</a>
	</c:if>

	<c:if test="${page.number>=page.totalPages}">
		<span class="page_gray">未页</span>
	</c:if>

	<c:if test="${page.number<page.totalPages}">
		<a href="javascript:goPage(${page.totalPages})">末页</a>
	</c:if>
	<span>转至 <input id="forward" class="input_in" type="text" /> <input
		type="button" class="input_btn" value="GO" id="pageNum"
		onclick="forwardPage('${page.totalPages}')" />
	</span>
</div>