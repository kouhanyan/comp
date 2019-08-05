     <%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
     <div class="reader_title">
        <ul>
         <li class="reader_title_hide">
           <div class="fleft_bg"></div><span>
           <a href="${pageContext.request.contextPath}/webOpac/loginReader">
           <img src="${pageContext.request.contextPath}/images/webOpac/reader_icon1.png" width="13" height="16" />个人资料
          </a>
           </span><div class="fright"></div>
        </li>
        <li class="reader_title_hide">
          <div class="fleft"></div><span>
           <a href="${pageContext.request.contextPath}/webOpac/readerLendRecord">
          <img src="${pageContext.request.contextPath}/images/webOpac/reader_icon2.png" width="17" height="11" />借阅查询
           </a>
          </span><div class="fright_bg"> 
          </div>       	
        </li>
        <li class="reader_title_select">
          <div class="fleft"></div><span>
          <a href="${pageContext.request.contextPath}/webOpac/bookRecommendList">
          <img src="${pageContext.request.contextPath}/images/webOpac/reader_icon3.png" width="18" height="16" />荐购管理
          </a>
          </span><div class="fright"></div>
        </li>
        <li class="reader_title_hide">
          <div class="fleft"></div><span>
          <a href="${pageContext.request.contextPath}/webOpac/sysMessage">
		  <img src="${pageContext.request.contextPath}/images/webOpac/reader_icon4.png" width="19" height="18" />信息中心
          </a>
          </span><div class="fright"></div>
        </li>
        </ul>
     </div>