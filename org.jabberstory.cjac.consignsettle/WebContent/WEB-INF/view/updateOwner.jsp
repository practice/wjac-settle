<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CJAC</title>
<script language="javascript">
<!--
	function saveOwner(){
		document.form1.action = "${pageContext.request.contextPath}/owner/updateOwner";
		document.form1.submit();
	}

	function gotoList(){
		document.form1.action = "${pageContext.request.contextPath}/owner/showOwner";
		document.form1.submit();
	}

//-->
</script>
</head>
<body>
<!-- Start Content Title -->
<div>
	<H3>전담 기관 수정</H3>
</div>
<!-- End Content Title -->
<form name="form1" method="post">
<input type="hidden" name="organId" value="${organ.organId}">
전담 기관명: <input type="text" size="32" name="organName" value="${organ.organName}"/>
</form>
<div>
	<a href="#" onClick="saveOwner();return false;">저장</a>
	<a href="#" onClick="gotoList();return false;">취소</a>
</div>	
</body>
</html>
