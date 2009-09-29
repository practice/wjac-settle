<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>CJAC</title>
<script>
$(document).ready(function() {
	$('#printCostDetail').bind('click', function(ev) {
		window.open('${pageContext.request.contextPath}/organ/printCostDetail?organId=${organ.organId}', '_costdetail', 'width=900,height=532,history=no,resizable=yes,status=no,scrollbars=yes,menubar=no');
		ev.preventDefault();
		return false;
	});
});
</script>
</head>
<body>
<form name="form1">
<input type="hidden" name="organId" value="${organ.organId}"/>
<div id="container">
  <div id="content">
    <div id="content_top">
      <p id="title"> 사업비 사용명세 조회 : ${organ.subjectGroup.groupName} </p>
      <p id="path"> PATH : 주관기관현황  &#62; 주관기관조회  &#62; <span id="path_b">사업비 사용명세 조회</span></p>
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
            <td colspan="6" style="height:300px">
            <c:choose>		
				<c:when test="${organ.costDetail == null || organ.costDetail == ''}">
					등록된 사업비사용명세가 없습니다.
				</c:when>	
				<c:otherwise>			
					${organ.costDetail}			
				</c:otherwise>
			</c:choose>
            </td>
          </tr>
          <tr>
            <td class="cell_title" width="100">사용잔액</td>
            <td class="cell">${organ.currentAccount}원 </td>
            <td class="cell_title" width="100">발생이자(잔액)</td>
            <td class="cell">${organ.currentInterest}원 </td>
            <td class="cell_title" width="100">불인정액</td>
            <td class="cell">${organ.currentNonPropriety}원 </td>
          </tr>
        </tbody>
      </table>
      <div class="button">
        <div class="b_blue">
          <ul>
          	<li><a href="#" id="printCostDetail">인쇄</a></li>
		    <li><a href="<c:url value="/organ/showSubject?organId=${organ.organId}" />">주관기관 현황 조회</a></li>
		    <sec:authorize ifAllGranted="ROLE_ADMIN">
	            <li><a href="<c:url value="/organ/deleteCostDetail?organId=${organ.organId}" />">사업비사용명세 삭제</a></li>
	            <li><a href="<c:url value="/organ/updateCostDetail?organId=${organ.organId}" />">사업비사용명세 등록/수정</a></li>
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