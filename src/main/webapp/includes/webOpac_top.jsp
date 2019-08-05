<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="top">
     <ul class="topNav">
        <li><a href="${pageContext.request.contextPath}/webOpac/queryList/${schoolCode}">公共检索</a>
        </li>
        <li><a href="${pageContext.request.contextPath}/webOpac/schoolAnnouncementList/${schoolCode}">信息公告</a>
            <!-- <div class="topSubnav">
              <a href="${pageContext.request.contextPath}/webOpac/schoolAnnouncementList/${schoolCode}">学校公告</a>
            </div> -->
        </li>
        <li><a href="${pageContext.request.contextPath}/webOpac/batchList/${schoolCode}">新书通告</a></li>
        <li><a href="${pageContext.request.contextPath}/webOpac/readerLoginList/${schoolCode}">读者空间</a></li>
     </ul>
     <div class="top_right">
          <h2>${schoolName}，${readerName} 欢迎您！</h2>
          <span class="top_right_line"></span>
          <c:choose>
          	<c:when test="${empty reader_id}">
          		 <a href="${pageContext.request.contextPath}/webOpac/readerLoginList/${schoolCode}" class="top_login">登录</a>
          	</c:when><c:otherwise>
          		 <a href="${pageContext.request.contextPath}/webOpac/readerLoginOut/${schoolCode}" class="top_qdit">退出</a>          
          	</c:otherwise>
          </c:choose>
    	  
     </div>
</div>