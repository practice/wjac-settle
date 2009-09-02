<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
<!--
	function updateCostDetail(){
		document.form1.action = "${pageContext.request.contextPath}/subject/updateCostDetail";
		document.form1.submit();
	}

	function showSubject() {
		document.form1.action = "${pageContext.request.contextPath}/subject/showSubject";
		document.form1.submit();
	}

	function deleteCostDetail() {
		if(confirm("�����Ͻðڽ��ϱ�?")){
			document.form1.action = "${pageContext.request.contextPath}/subject/deleteCostDetail";
			document.form1.submit();
		}
	}
//-->
</script>
</head>
<body>
<!-- Start Content Title -->
<div>
	<H3>����� ����:${subject.subjectName}</H3>
</div>
<!-- End Content Title -->
<form name="form1">
<input type="hidden" name="subjectId" value="${subject.subjectId}"/>
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
		<c:choose>		
			<c:when test="${subject.costDetail == ''}">
				<td colspan="4" class="">�Էµ� ����� �������� �����ϴ�.</td>
			</c:when>	
			<c:otherwise>			
				<td colspan="4" class="">${subject.costDetail }</td>			
			</c:otherwise>
		</c:choose>
		</tr>
	</tbody>
</table>
</form>
<div>
	<a href="#" onClick="updateCostDetail();return false;">�������� �Է�/����</a>
	<a href="#" onClick="deleteCostDetail();return false;">����</a>
	<a href="#" onClick="showSubject();return false;">�ְ���� ��Ȳ</a>
</div>
</body>
</html>