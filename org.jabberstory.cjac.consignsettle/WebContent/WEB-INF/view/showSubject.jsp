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
		document.form1.action = "${pageContext.request.contextPath}/subject/listSubject";
		document.form1.submit();
	}

	function editSubject() {
		document.form1.action = "${pageContext.request.contextPath}/subject/updateSubject";
		document.form1.submit();
	}

	function showCostDetail() {
		document.form1.action = "${pageContext.request.contextPath}/subject/showCostDetail";
		document.form1.submit();
	}

	function deleteSubject() {
		if(confirm("삭제하시겠습니까?")){
			document.form1.action = "${pageContext.request.contextPath}/subject/deleteSubject";
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
<input type="hidden" name="subjectId" value="${subject.subjectId}">
<table border="1" cellspacing="0" cellpadding="0" class="">
	<caption class="">
		사업정보 입력
	</caption>
	<colgroup>
	<col width="15%">
	<col width="35%">
	<col width="15%">
	<col width="35%">
	</colgroup>
	<tbody>
		<tr>
			<th scope="row">전담기관</th>
			<td class="">${subject.owner.ownerName}</td>
			<th scope="row">주관기관</th>
			<td class="">${subject.subjectName}</td>
		</tr>
		<tr>
			<th scope="row">사업명</th>
			<td class="">${subject.businessName}</td>
			<th scope="row">과제명</th>
			<td class="">${subject.projectName}</td>
		</tr>
		<tr>
			<th scope="row">연구기관명</th>
			<td class="">${subject.researchAgency}</td>
			<th scope="row">연구책임자</th>
			<td class="">${subject.researchResponsiblePerson}</td>
		</tr>
		<tr>
			<th scope="row">협약기관 시작일</th>
			<td class="">${subject.contractStartDate}</td>
			<th scope="row">협약기관 종료일</th>
			<td class="">${subject.contractEndDate}</td>
		</tr>
	</tbody>
</table>
<table border="1" cellspacing="0" cellpadding="0" class="">
	<caption class="">
		사업비 정보
	</caption>
	<colgroup>
	<col width="15%">
	<col width="35%">
	<col width="15%">
	<col width="35%">
	</colgroup>
	<tbody>
		<tr>
			<th scope="row">정부출현금</th>
			<td class="">${subject.govContributeAmount}</td>
			<th scope="row">민감부담금</th>
			<td class="">${subject.nonGovContributeAmount}</td>
		</tr>
		<tr>
			<th scope="row">현물</th>
			<td class="">${subject.goodsAmount}</td>
			<th scope="row">총현금</th>
			<td class="">${subject.totalCashAmount}</td>
		</tr>
		<tr>
			<th scope="row">정부지분</th>
			<td class="">${subject.govInterests}</td>
			<th scope="row">위탁정산 수수료</th>
			<td class="">${subject.consignSettlementCommission}</td>
		</tr>
</table>
<table border="1" cellspacing="0" cellpadding="0" class="">
	<caption class="">
		일정 정보
	</caption>
	<colgroup>
	<col width="15%">
	<col width="35%">
	<col width="15%">
	<col width="35%">
	</colgroup>
	<tbody>
		<tr>
			<th scope="row">사용실적 제출일</th>
			<td class="">${subject.useResultDate}</td>
			<th scope="row">이의 신청 접수일</th>
			<td class="">${subject.formalObjectAcceptanceDate}</td>
		</tr>
		<tr>
			<th scope="row">이의신청 결과통보일</th>
			<td class="">${subject.formalObjectResultDate}</td>
			<th scope="row">정산결과 보고일</th>
			<td class="">${subject.consignSettlementResultDate}</td>
		</tr>
</table>
<table border="1" cellspacing="0" cellpadding="0" class="">
	<caption class="">
		주관기관 담당자 정보
	</caption>
	<colgroup>
	<col width="15%">
	<col width="35%">
	<col width="15%">
	<col width="35%">
	</colgroup>
	<tbody>
		<tr>
			<th scope="row">주관기관담당자</th>
			<td class="">${subject.subjectResponsiblePerson}</td>
			<th scope="row">정산기관담당자</th>
			<td class="">${subject.consignSettlementPerson}</td>
		</tr>
		<tr>
			<th scope="row">연락처</th>
			<td class="">
				${subject.subjectResponsiblePhone1}-${subject.subjectResponsiblePhone2}-${subject.subjectResponsiblePhone3}
			</td>
			<th scope="row">연락처</th>
			<td class="">
				${subject.consignSettlementPhone1}-${subject.consignSettlementPhone2}-${subject.consignSettlementPhone3}
			</td>
		</tr>
		<tr>
			<th scope="row">주소</th>
			<td class="">
				${subject.subjectResponsiblePostNumber1}-${subject.subjectResponsiblePostNumber2}
				${subject.subjectResponsibleAddress}
			</td>
			<th scope="row">주소</th>
			<td class="">
				${subject.consignSettlementPostNumber1}-${subject.consignSettlementPostNumber2}
				${subject.consignSettlementAddress}
			</td>
		</tr>
		<tr>
			<th scope="row">E-mail</th>
			<td class="">${subject.subejctResponsibleEmail}</td>
			<th scope="row">E-mail</th>
			<td class="">${subject.consignSettlementEmail}</td>
		</tr>
</table>
<table border="1" cellspacing="0" cellpadding="0" class="">
	<caption class="">
		정산결과 정보
	</caption>
	<colgroup>
	<col width="15%">
	<col width="35%">
	<col width="15%">
	<col width="35%">
	</colgroup>
	<tbody>
		<tr>
			<th scope="row">사용잔액</th>
			<td class="">${subject.currentAccount}</td>
			<th scope="row">발생이자</th>
			<td class="">${subject.currentInterest}</td>
		</tr>
		<tr>
			<th scope="row">부적정금액</th>
			<td class="">${subject.currentNonPropriety}</td>
			<th scope="row">소계</th>
			<td class="">${subject.currentSubTotal}</td>
		</tr>
		<tr>
			<th scope="row">환수대상액</th>
			<td colspan="3" class="">${subject.currentRedemtion}</td>
		</tr>		
</table>
</form>
<div>
	<a href="#" onClick="showCostDetail();return false;">사업비사용명세</a>
	<a href="#" onClick="editSubject();return false;">수정</a>
	<a href="#" onClick="deleteSubject();return false;">삭제</a>
	<a href="#" onClick="gotoList();return false;">목록</a>
</div>
</body>
</html>
