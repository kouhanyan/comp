<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input type="hidden" id="pageNumber" name="pageNumber"
	<c:choose>
	<c:when
		test="${param != null && param.pageNumber != null && param.pageNumber != '' }">value="${ param.pageNumber }"</c:when>
	<c:otherwise>value="1"</c:otherwise>
</c:choose> />

<input type="hidden" id="properties" name="properties"
	<c:choose>
	<c:when
		test="${param != null && param.properties != null && param.properties != '' }">value="${ param.properties }"</c:when>
	<c:otherwise>value="id"</c:otherwise>
</c:choose> />
<input type="hidden" id="direction" name="direction"
	<c:choose>
	<c:when
		test="${param != null && param.direction != null && param.direction != '' }">value="${ param.direction }" </c:when>
	<c:otherwise>value="DESC"</c:otherwise>
</c:choose> />

<input type="hidden" id="pageSize" name="pageSize"
	<c:choose>
	<c:when
		test="${param != null && param.pageSize != null && param.pageSize != '' }">value="${ param.pageSize }" </c:when>
	<c:otherwise>value="10"</c:otherwise>
</c:choose> />