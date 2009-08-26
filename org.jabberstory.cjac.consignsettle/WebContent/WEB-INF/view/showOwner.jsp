<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CJAC</title>
<script language="JavaScript">
<!--
	function gotoList(){
		document.form1.action = "${pageContext.request.contextPath}/owner/listOwner";
		document.form1.submit();
	}

	function editOwner() {
		document.form1.action = "${pageContext.request.contextPath}/owner/updateOwner";
		document.form1.submit();
	}

	function deleteOwner() {
		if(confirm("삭제하시겠습니까?")){
			document.form1.action = "${pageContext.request.contextPath}/owner/deleteOwner";
			document.form1.submit();
		}
	}
//-->
</script>
</head>
<body>
<!-- Start Content Title -->
<div>
	<H3>전담 기관 보기</H3>
</div>
<!-- End Content Title -->
<form name="form1" method="post">
<input type="hidden" name="ownerId" value="${owner.ownerId}">
전담 기관명: ${owner.ownerName}
</form>
<div>
	<a href="#" onClick="editOwner();return false;">수정</a>
	<a href="#" onClick="deleteOwner();return false;">삭제</a>
	<a href="#" onClick="gotoList();return false;">목록</a>
</div>
</body>
</html>
