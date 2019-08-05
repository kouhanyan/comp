<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>     
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
      <table class="edit_table" width="100%" border="0" cellspacing="0" cellpadding="5">
          <tr>
            <td width="20%" rowspan="9" align="center" valign="middle">
                <div class="photoPic">
                <img src="${pageContext.request.contextPath}/reader/image_idStr/id${readerLendRecordQueryForm.readerId}" width="150" height="210" /> </div>
            </td>
  		   <th align="right">【读者证号】</th>
          <td><input name="readerBarcodeTmp" id="readerBarcodeTmp" size="40" value=""/></td>
           <th align="right">【图书条码】</th>
          <td><input name="collectionBarcodeTmp" id="collectionBarcodeTmp" size="40" value=""/></td>
          </tr>
        <tr>
          <th align="right">【读者证号】</th>
          <td>&nbsp;${readerInfo.readerBarcode}</td> 
          <th align="right">【图书条码】</th>
          <td>&nbsp;${collectionInfo.collectionBarcode}</td>
        </tr>
        <tr>
          <th align="right">【读者姓名】</th>
          <td>&nbsp;${readerInfo.readerName}</td>
          <th align="right">【书　　名】</th>
          <td>&nbsp;${collectionInfo.title}</td>
        </tr>
        <tr>
          <th align="right">【证 状 态】</th>
          <td>&nbsp;${readerInfo.statusName}</td>
          <th align="right">【ＩＳＢＮ】</th>
          <td>&nbsp;${collectionInfo.isbn}</td>
        </tr>
        <tr>
          <th align="right">【班级组织】</th>
          <td>&nbsp;${readerInfo.reader.schoolDept.name}</td>
          <th align="right">【分 类 号】</th>
          <td>&nbsp;${collectionInfo.collection.callNo}</td>
        </tr>
        <tr>
          <th align="right">【有 效 期】</th>
          <td><fmt:formatDate pattern='yyyy-MM-dd' value="${readerInfo.startDate}"/>至<fmt:formatDate pattern='yyyy-MM-dd' value="${readerInfo.endDate}"/></td>
          <th align="right">【出 版 社】</th>
          <td>&nbsp;${collectionInfo.publisher}</td>
        </tr>
        <tr>
          <th align="right">【可 借 数】</th>
          <td>&nbsp;${readerInfo.readerType.lendNum}</td>
          <th align="right">【责 任 者】</th>
          <td>&nbsp;${collectionInfo.author}</td>
        </tr>
        <tr>
          <th align="right">【已 借 数】</th>
          <td>&nbsp;${readerInfo.totalLendNum}</td>
          <th align="right">【附　　件】</th>
          <td>&nbsp;${collectionInfo.attachment}</td>
        </tr>
        <tr>
          <th align="right">【资金余额】</th>
          <td>&nbsp;${readerInfo.prepay}</td>
          <th align="right">【价　　格】</th>
          <td>&nbsp;${collectionInfo.price}</td>
        </tr>
      </table>