<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
<!--
	function createCostDetail(){
		document.form1.action = "${pageContext.request.contextPath}/subject/createCostDetail";
		document.form1.submit();
	}

	function editCostDetail() {
		document.form1.action = "${pageContext.request.contextPath}/subject/editCostDetail";
		document.form1.submit();
	}

	function showSubject() {
		document.form1.action = "${pageContext.request.contextPath}/subject/showSubject";
		document.form1.submit();
	}

	function deleteSubject() {
		if(confirm("삭제하시겠습니까?")){
			document.form1.action = "${pageContext.request.contextPath}/subject/deleteCostDetail";
			document.form1.submit();
		}
	}
//-->
</script>
</head>
<body>
<form name="form1">
<input type="text" name="subjectId" value="${subjectId}"/>"
<div>
	사업비사용명세가 없습니다.
</div>
</form>
<div>
	<a href="#" onClick="createCostDetail();return false;">사업비사용명세 생성</a>
	<a href="#" onClick="editCostDetail();return false;">수정</a>
	<a href="#" onClick="deleteCostDetail();return false;">삭제</a>
	<a href="#" onClick="showSubject();return false;">주관기관 현황</a>
</div>
</body>
</html>