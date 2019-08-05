<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="search">
	<select name="searchParameterField" class="select">
		<c:choose>
			<c:when
				test="${not empty (easySearchQueryForm.searchParameterField) && easySearchQueryForm.searchParameterField != '' }">
				<c:forEach items="${fields}" var="i">
					<option value="${i.value}"
						<c:if test="${i.value == easySearchQueryForm.searchParameterField }">selected="selected"</c:if>>${i.key}</option>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<c:forEach items="${fields}" var="i">
					<option value="${i.value}"
						<c:if test="${i.value == 'title' }">selected="selected"</c:if>>${i.key}</option>
				</c:forEach>

			</c:otherwise>
		</c:choose>
	</select> <input class="text" name="searchParameterValue"
		id="searchParameterValue" type="text"
		value="${easySearchQueryForm.searchParameterValue }" /> <input
		class="but_search" name="" type="button" value="检索"
		onclick="doFormSubmit('formId','${pageContext.request.contextPath}/webOpac/query')" />
	<input class="but_search_high" name="" type="button" value="高级检索"
		onclick="doFormSubmit('formId','${pageContext.request.contextPath}/webOpac/highQueryForWard')" />
</div>