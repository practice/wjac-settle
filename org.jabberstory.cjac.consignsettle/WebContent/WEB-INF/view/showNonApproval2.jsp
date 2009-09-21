<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>CJAC</title>
</head>
<body>
<form name="form1">
<input type="hidden" name="organId" value="${organ.organId}"/>
<div id="container">
  <div id="content">
    <div id="content_top">
      <p id="title"> 최종 불인정 내역 조회 : ${organ.subjectGroup.groupName} </p>
      <p id="path"> PATH : 주관기관현황  &#62; 주관기관조회  &#62; <span id="path_b">최종 불인정 내역 조회</span></p>
    </div>
    <div class="button">
      <div class="b_blue">
        <ul>
          <li><a href="<c:url value="/organ/showNonApproval2?organId=${organ.organId}" />">최종 불인정 내역</a></li>
          <li><a href="<c:url value="/organ/showNonApproval1?organId=${organ.organId}" />">1차 불인정 내역</a></li>
          <li><a href="<c:url value="/organ/showCostDetail?organId=${organ.organId}" />">사업비사용명세</a></li>
        </ul>
      </div>
    </div>
    <br />
    <div id="table">
	<table width="100%" cellspacing="0">
        <tbody>
          <tr>
            <td class="cell_title" width="130px">최종 불인정 내역</td>
            <td class="cell">
            	<c:set var="attCount" scope="page" value="0"></c:set>
            	<c:forEach var="file" items="${organ.attachments}" varStatus="status">
					<c:choose>
						<c:when test="${file.filetype == '1'}">
							<div><a href="download?organId=${organ.organId}&attId=${file.id}">${file.filename}</a> (${file.filesize} bytes)
								&nbsp;&nbsp; <a href="deleteNonApproval2Attachment?attId=${file.id}&organId=${organ.organId}"><img src="<c:url value="/img/btn_b_commt_del.gif" />"></a></div>
							<c:set var="attCount" scope="page" value="${status.count}"></c:set>	
						</c:when>
					</c:choose>												
				</c:forEach>
            	<c:choose>
            		<c:when test="${attCount == '0'}">
            			최종 불인정 내역이 없습니다.
            		</c:when>
				</c:choose>           	
			</td>
          </tr>
        </tbody>
      </table>
      <div class="button">
        <div class="b_blue">
          <ul>
          	<li><a href="<c:url value="/organ/showSubject?organId=${organ.organId}" />">주관기관 현황 조회</a></li>
		    <sec:authorize ifAllGranted="ROLE_ADMIN">
	            <li><a href="<c:url value="/organ/updateNonApproval2?organId=${organ.organId}" />">최종 불인정 내역  등록</a></li>
	        </sec:authorize>
          </ul>
        </div>
      </div>
  </div>
</div>
</div>
</form>
</body>
</html>