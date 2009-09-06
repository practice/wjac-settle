<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
<!--
	function updateNonApproval1(){
		document.form1.action = "${pageContext.request.contextPath}/subject/updateNonApproval1";
		document.form1.submit();
	}

	function showSubject() {
		document.form1.action = "${pageContext.request.contextPath}/subject/showSubject";
		document.form1.submit();
	}

	function deleteNonApproval1() {
		if(confirm("삭제하시겠습니까?")){
			document.form1.action = "${pageContext.request.contextPath}/subject/deleteNonApproval1";
			document.form1.submit();
		}
	}
//-->
</script>
</head>
<body>
<!-- Start Content Title -->
<div>
	<H3>1차 불인정 내역:${organ.organName}</H3>
</div>
<!-- End Content Title -->
<form name="form1">
<input type="hidden" name="organId" value="${organ.organId}"/>
<table border="1" cellspacing="0" cellpadding="0" class="">
	<caption class="">
	</caption>
	<colgroup>
	<col width="15%">
	<col width="18%">
	<col width="15%">
	<col width="18%">
	<col width="15%">
	<col width="19%">
	</colgroup>
	<tbody>
		<tr>
		<c:choose>		
			<c:when test="${organ.nonApproval1 == null || organ.nonApproval1 == ''}">
				<td colspan="6" class="">입력된 1차 불인정 내역이 없습니다.</td>
			</c:when>	
			<c:otherwise>			
				<td colspan="6" class="">${organ.nonApproval1 }</td>			
			</c:otherwise>
		</c:choose>
		</tr>		
	</tbody>
</table>
</form>
<div>
	<a href="#" onClick="updateNonApproval1();return false;">1차 불인정 내역 입력/수정</a>
	<a href="#" onClick="deleteNonApproval1();return false;">삭제</a>
	<a href="#" onClick="showSubject();return false;">주관기관 현황</a>
	<a href="#" onClick="alert('준비중...');return false;">인쇄</a>
</div>
</body>
</html>