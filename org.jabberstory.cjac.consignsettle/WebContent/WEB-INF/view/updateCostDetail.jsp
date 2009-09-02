<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CJAC</title>
<script type="text/javascript" src="/fckeditor/fckeditor.js"></script>
<script type="text/javascript">
<!--
	window.onload = function()
	{
		var oFCKeditor = new FCKeditor( 'costDetail' ) ;
		oFCKeditor.BasePath = "/fckeditor/" ;
		oFCKeditor.ReplaceTextarea() ;
	}

	function saveSubject(){
		document.form1.action = "${pageContext.request.contextPath}/subject/updateCostDetail";
		document.form1.submit();
	}
	
	function showCostDetail(){
		document.form1.action = "${pageContext.request.contextPath}/subject/showCostDetail";
		document.form1.submit();
	}
//-->
</script>
</head>
<body>
<!-- Start Content Title -->
<div>
	<H3>사업비 사용명세  입력</H3>
</div>
<!-- End Content Title -->
<form name="form1" method="post">
<input type="hidden" name="subjectId" value="${subject.subjectId}" />
<table border="1" cellspacing="0" cellpadding="0" class="">
	<caption class="">
	</caption>
	<colgroup>
	<col width="15%">
	<col width="35%">
	<col width="15%">
	<col width="35%">
	</colgroup>
	<tbody>
		<tr>
			<td colspan="4" class=""><textarea id="costDetail" name="costDetail">${subject.costDetail}</textarea></td>
		</tr>
	</tbody>
</table>
</form>
<div>
	<a href="#" onClick="saveSubject();return false;">저장</a>
	<a href="#" onClick="showCostDetail();return false;">취소</a>
</div>	
</body>
</html>
