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
		document.form1.action = "${pageContext.request.contextPath}/organ/updateCostDetail";
		document.form1.submit();
	}

	function showSubject() {
		document.form1.action = "${pageContext.request.contextPath}/organ/showSubject";
		document.form1.submit();
	}

	function deleteCostDetail() {
		if(confirm("�����Ͻðڽ��ϱ�?")){
			document.form1.action = "${pageContext.request.contextPath}/organ/deleteCostDetail";
			document.form1.submit();
		}
	}
//-->
</script>
</head>
<body>
<!-- Start Content Title -->
<div>
	<H3>����� ����:${organ.organName}</H3>
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
			<c:when test="${organ.costDetail == null || organ.costDetail == ''}">
				<td colspan="6" class="">�Էµ� ����� �������� �����ϴ�.</td>
			</c:when>	
			<c:otherwise>			
				<td colspan="6" class="">${organ.costDetail }</td>			
			</c:otherwise>
		</c:choose>
		</tr>
		<tr>
			<td class="">����ܾ�</td>
			<td class="">${organ.currentAccount}</td>
			<td class="">�߻�����(�ܾ�)</td>
			<td class="">${organ.currentInterest}</td>
			<td class="">��������</td>
			<td class="">${organ.currentNonPropriety}</td>
		</tr>
	</tbody>
</table>
</form>
<div>
	<a href="#" onClick="updateCostDetail();return false;">�������� �Է�/����</a>
	<a href="#" onClick="deleteCostDetail();return false;">����</a>
	<a href="#" onClick="showSubject();return false;">�ְ���� ��Ȳ</a>
	<a href="#" onClick="alert('�غ���...');return false;">�μ�</a>
</div>
</body>
</html>