<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
      <div class="list_table_title">
			<h3>借阅清单</h3></div>
			   <div class="list" id="list1" style="overflow-y:auto;height:285px;border:0px;">
					<table id="myTable01" class="list_table" width="100%" border="0"
						cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<th width="2%">序号</th>
								<th width="6%">条码号</th>
								<th width="12%">题名</th>
								<th width="8%">馆藏地点</th>
								<th width="8%">文献流通类型</th>
								<th width="4%">索书号</th>
								<th width="4%">卷册信息</th>
								<th width="4%">单价</th>
								<th width="12%">借书日期</th>
								<th width="12%">应还日期</th>
								<th width="4%">续借次数</th>
								<th width="4%">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${page}" var="i" varStatus="status">		
								<tr>											
									<td>${status.count}</td>
									<td>${i.barcode}</td>
									<td>${i.title}</td>
									<td>${i.collectionPlace.name}</td>
									<td>${i.bookCirculateType.name}</td>
									<td>${i.callno}</td>
									<td>${i.volInfo}</td>
									<td>${i.singlePrice}</td>
									<td><fmt:formatDate pattern='yyyy-MM-dd hh-mm-ss' value="${i.lendDate}"/></td>
									<td><fmt:formatDate pattern='yyyy-MM-dd hh-mm-ss' value="${i.returnDate}"/></td>
									<td>${i.renewCount}</td>
									<td><a href="javascript:doFormSubmit('readerLendRecordForm','${pageContext.request.contextPath}/lend/renewBook/${i.id}')"
							class="btn btn_edit">续借</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>