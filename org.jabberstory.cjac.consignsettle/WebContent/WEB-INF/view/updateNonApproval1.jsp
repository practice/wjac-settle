<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CJAC</title>
<script type="text/javascript" src="/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
<!--
	window.onload = function()
	{
		CKEDITOR.replace( 'nonApproval1' );
	}

	function saveNonApproval1(){
		document.form1.action = "${pageContext.request.contextPath}/subject/updateNonApproval1";
		document.form1.submit();
	}
	
	function showNonApproval1(){
		document.form1.action = "${pageContext.request.contextPath}/subject/showNonApproval1";
		document.form1.submit();
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
<form name="form1" method="post">
<input type="hidden" name="organId" value="${organ.organId}" />
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
			<td colspan="6" class=""><textarea id="nonApproval1" name="nonApproval1">${organ.nonApproval1}</textarea></td>
		</tr>		
	</tbody>
</table>
</form>
<div>
	<a href="#" onClick="saveNonApproval1();return false;">저장</a>
	<a href="#" onClick="showNonApproval1();return false;">취소</a>
</div>	
</body>
</html>