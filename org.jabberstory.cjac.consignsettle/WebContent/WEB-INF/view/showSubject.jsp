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
		document.form1.action = "${pageContext.request.contextPath}/subject/subjectList";
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

	function showNonApproval1() {
		document.form1.action = "${pageContext.request.contextPath}/subject/showNonApproval1";
		document.form1.submit();
	}

	function showNonApproval2() {
		document.form1.action = "${pageContext.request.contextPath}/subject/showNonApproval2";
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
	<H3>주관 기관 현황</H3>
</div>
<!-- End Content Title -->
<form name="form1" method="post">
<input type="hidden" name="organId" value="${organ.organId}">
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
			<td class="">${organ.owner.groupName}</td>
			<th scope="row">주관기관</th>
			<td class="">${organ.subject.groupName}</td>
		</tr>
		<tr>
			<th scope="row">사업명</th>
			<td class="">${organ.businessName}</td>
			<th scope="row">과제명</th>
			<td class="">${organ.projectName}</td>
		</tr>
		<tr>
			<th scope="row">연구기관명</th>
			<td class="">${organ.researchAgency}</td>
			<th scope="row">연구책임자</th>
			<td class="">${organ.researchResponsiblePerson}</td>
		</tr>
		<tr>
			<th scope="row">협약기관 시작일</th>
			<td class="">${organ.contractStartDate}</td>
			<th scope="row">협약기관 종료일</th>
			<td class="">${organ.contractEndDate}</td>
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
			<td class="">${organ.govContributeAmount}</td>
			<th scope="row">민감부담금</th>
			<td class="">${organ.nonGovContributeAmount}</td>
		</tr>
		<tr>
			<th scope="row">현물</th>
			<td class="">${organ.goodsAmount}</td>
			<th scope="row">총현금</th>
			<td class="">${organ.totalCashAmount}</td>
		</tr>
		<tr>
			<th scope="row">정부지분</th>
			<td class="">${organ.govInterests}</td>
			<th scope="row">위탁정산 수수료</th>
			<td class="">${organ.consignSettlementCommission}</td>
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
			<td class="">${organ.useResultDate}</td>
			<th scope="row">이의 신청 접수일</th>
			<td class="">${organ.formalObjectAcceptanceDate}</td>
		</tr>
		<tr>
			<th scope="row">이의신청 결과통보일</th>
			<td class="">${organ.formalObjectResultDate}</td>
			<th scope="row">정산결과 보고일</th>
			<td class="">${organ.consignSettlementResultDate}</td>
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
			<td class="">${organ.organResponsiblePerson}</td>
			<th scope="row">정산기관담당자</th>
			<td class="">${organ.consignSettlementPerson}</td>
		</tr>
		<tr>
			<th scope="row">연락처</th>
			<td class="">
				${organ.organResponsiblePhone1}-${organ.organResponsiblePhone2}-${organ.organResponsiblePhone3}
			</td>
			<th scope="row">연락처</th>
			<td class="">
				${organ.consignSettlementPhone1}-${organ.consignSettlementPhone2}-${organ.consignSettlementPhone3}
			</td>
		</tr>
		<tr>
			<th scope="row">주소</th>
			<td class="">
				${organ.organResponsiblePostNumber1}-${organ.organResponsiblePostNumber2}
				${organ.organResponsibleAddress}
			</td>
			<th scope="row">주소</th>
			<td class="">
				${organ.consignSettlementPostNumber1}-${organ.consignSettlementPostNumber2}
				${organ.consignSettlementAddress}
			</td>
		</tr>
		<tr>
			<th scope="row">E-mail</th>
			<td class="">${organ.organResponsibleEmail}</td>
			<th scope="row">E-mail</th>
			<td class="">${organ.consignSettlementEmail}</td>
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
			<td class="">${organ.currentAccount}</td>
			<th scope="row">발생이자</th>
			<td class="">${organ.currentInterest}</td>
		</tr>
		<tr>
			<th scope="row">부적정금액</th>
			<td class="">${organ.currentNonPropriety}</td>
			<th scope="row">소계</th>
			<td class="">${organ.currentSubTotal}</td>
		</tr>
		<tr>
			<th scope="row">환수대상액</th>
			<td colspan="3" class="">${organ.currentRedemtion}</td>
		</tr>		
</table>
</form>
<div>
	<a href="#" onClick="showCostDetail();return false;">사업비사용명세</a>
	<a href="#" onClick="showNonApproval1();return false;">1차 불인정 내역</a>
	<a href="#" onClick="showNonApproval2();return false;">최종 불인정 내역</a>
	<a href="#" onClick="editSubject();return false;">수정</a>
	<a href="#" onClick="deleteSubject();return false;">삭제</a>
	<a href="#" onClick="gotoList();return false;">목록</a>
	<a href="#" onClick="alert('준비중...');return false;">인쇄</a>
</div>
</body>
</html>
