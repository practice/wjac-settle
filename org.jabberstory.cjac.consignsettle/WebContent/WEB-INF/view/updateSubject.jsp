<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CJAC</title>
<script language="javascript">
<!--
	function saveSubject(){
		document.form1.action = "${pageContext.request.contextPath}/subject/updateSubject";
		document.form1.submit();
	}

	function gotoList(){
		document.form1.action = "${pageContext.request.contextPath}/subject/showSubject";
		document.form1.submit();
	}

//-->
</script>
</head>
<body>
<!-- Start Content Title -->
<div>
	<H3>주관 기관 수정</H3>
</div>
<!-- End Content Title -->
<form name="form1" method="post">
<input type="hidden" name="subjectId" value="${subject.subjectId}">
<input type="hidden" name="ownerId" value="${subject.owner.ownerId}">
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
			<td class=""><input type="text" name="subjectName" value="${subject.subjectName}" style="" title="주관기관"></td>
		</tr>
		<tr>
			<th scope="row">사업명</th>
			<td class=""><input type="text" name="businessName" value="${subject.businessName}" style="" title="사업명"></td>
			<th scope="row">과제명</th>
			<td class=""><input type="text" name="projectName" value="${subject.projectName}" style="" title="과제명"></td>
		</tr>
		<tr>
			<th scope="row">연구기관명</th>
			<td class=""><input type="text" name="researchAgency" value="${subject.researchAgency}" style="" title="연구기관명"></td>
			<th scope="row">연구책임자</th>
			<td class=""><input type="text" name="researchResponsiblePerson" value="${subject.researchResponsiblePerson}" style="" title="연구책임자"></td>
		</tr>
		<tr>
			<th scope="row">협약기관 시작일</th>
			<td class=""><input type="text" name="contractStartDate" value="${subject.contractStartDate}" style="" title="협약기관 시작일"></td>
			<th scope="row">협약기관 종료일</th>
			<td class=""><input type="text" name="contractEndDate" value="${subject.contractEndDate}" style="" title="협약기관 종료일"></td>
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
			<td class=""><input type="text" name="govContributeAmount" value="${subject.govContributeAmount}" style="" title="정부출현금"></td>
			<th scope="row">민감부담금</th>
			<td class=""><input type="text" name="nonGovContributeAmount" value="${subject.nonGovContributeAmount}" style="" title="민감부담금"></td>
		</tr>
		<tr>
			<th scope="row">현물</th>
			<td class=""><input type="text" name="goodsAmount" value="${subject.goodsAmount}" style="" title="현물"></td>
			<th scope="row">총현금</th>
			<td class=""><input type="text" name="totalCashAmount" value="${subject.totalCashAmount}" style="" title="총현금"></td>
		</tr>
		<tr>
			<th scope="row">정부지분</th>
			<td class=""><input type="text" name="govInterests" value="${subject.govInterests}" style="" title="정부지분"></td>
			<th scope="row">위탁정산 수수료</th>
			<td class=""><input type="text" name="consignSettlementCommission" value="${subject.consignSettlementCommission}" style="" title="위탁정산 수수료"></td>
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
			<td class=""><input type="text" name="useResultDate" value="${subject.useResultDate}" style="" title="사용실적 제출일"></td>
			<th scope="row">이의 신청 접수일</th>
			<td class=""><input type="text" name="formalObjectAcceptanceDate" value="${subject.formalObjectAcceptanceDate}" style="" title="이의 신청 접수일"></td>
		</tr>
		<tr>
			<th scope="row">이의신청 결과통보일</th>
			<td class=""><input type="text" name="formalObjectResultDate" value="${subject.formalObjectResultDate}" style="" title="이의신청 결과통보일"></td>
			<th scope="row">정산결과 보고일</th>
			<td class=""><input type="text" name="consignSettlementResultDate" value="${subject.consignSettlementResultDate}" style="" title="정산결과 보고일"></td>
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
			<td class=""><input type="text" name="subjectResponsiblePerson" value="${subject.subjectResponsiblePerson}" style="" title="주관기관담당자"></td>
			<th scope="row">정산기관담당자</th>
			<td class=""><input type="text" name="consignSettlementPerson" value="${subject.consignSettlementPerson}" style="" title="정산기관담당자"></td>
		</tr>
		<tr>
			<th scope="row">연락처</th>
			<td class="">
				<input type="text" name="subjectResponsiblePhone1" value="${subject.subjectResponsiblePhone1}" style="" title="연락처">-
				<input type="text" name="subjectResponsiblePhone2" value="${subject.subjectResponsiblePhone2}" style="" title="연락처">-
				<input type="text" name="subjectResponsiblePhone3" value="${subject.subjectResponsiblePhone3}" style="" title="연락처">
			</td>
			<th scope="row">연락처</th>
			<td class="">
				<input type="text" name="consignSettlementPhone1" value="${subject.consignSettlementPhone1}" style="" title="연락처">-
				<input type="text" name="consignSettlementPhone2" value="${subject.consignSettlementPhone2}" style="" title="연락처">-
				<input type="text" name="consignSettlementPhone3" value="${subject.consignSettlementPhone3}" style="" title="연락처">
			</td>
		</tr>
		<tr>
			<th scope="row">주소</th>
			<td class="">
				<input type="text" name="subjectResponsiblePostNumber1" value="${subject.subjectResponsiblePostNumber1}" style="" title="우편번호1">-
				<input type="text" name="subjectResponsiblePostNumber2" value="${subject.subjectResponsiblePostNumber2}" style="" title="우편번호2">우편번호찾기
				<input type="text" name="subjectResponsibleAddress" value="${subject.subjectResponsibleAddress}" style="" title="주소">
			</td>
			<th scope="row">주소</th>
			<td class="">
				<input type="text" name="consignSettlementPostNumber1" value="${subject.consignSettlementPostNumber1}" style="" title="우편번호1">-
				<input type="text" name="consignSettlementPostNumber2" value="${subject.consignSettlementPostNumber2}" style="" title="우편번호2">우편번호찾기
				<input type="text" name="consignSettlementAddress" value="${subject.consignSettlementAddress}" style="" title="주소">
			</td>
		</tr>
		<tr>
			<th scope="row">E-mail</th>
			<td class=""><input type="text" name="subejctResponsibleEmail" value="${subject.subejctResponsibleEmail}" style="" title="E-mail"></td>
			<th scope="row">E-mail</th>
			<td class=""><input type="text" name="consignSettlementEmail" value="${subject.consignSettlementEmail}" style="" title="E-mail"></td>
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
			<td class=""><input type="text" name="currentAccount" value="${subject.currentAccount}" style="" title="사용잔액"></td>
			<th scope="row">발생이자</th>
			<td class=""><input type="text" name="currentInterest" value="${subject.currentInterest}" style="" title="발생이자"></td>
		</tr>
		<tr>
			<th scope="row">부적정금액</th>
			<td class=""><input type="text" name="currentNonPropriety" value="${subject.currentNonPropriety}" style="" title="부적정금액"></td>
			<th scope="row">소계</th>
			<td class=""><input type="text" name="currentSubTotal" value="${subject.currentSubTotal}" style="" title="소계"></td>
		</tr>
		<tr>
			<th scope="row">환수대상액</th>
			<td colspan="3" class=""><input type="text" name="currentRedemtion" value="${subject.currentRedemtion}" style="" title="환수대상액"></td>
		</tr>		
</table>
</form>
<div>
	<a href="#" onClick="saveSubject();return false;">저장</a>
	<a href="#" onClick="gotoList();return false;">취소</a>
</div>	
</body>
</html>
