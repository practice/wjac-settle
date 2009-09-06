<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
			<td class=""><select name="ownerId">
							<option value="">선택</option>
							<c:forEach items="${owners}" var="owner">
								<c:choose>		
									<c:when test="${owner.organId == organ.owner.organId}">
										<option value="${owner.organId }" selected>${owner.organName }</option>
									</c:when>
									<c:otherwise>
										<option value="${owner.organId }">${owner.organName }</option>
									</c:otherwise>
								</c:choose>								
							</c:forEach>
						</select></td>
			<th scope="row">주관기관</th>
			<td class=""><input type="text" name="organName" value="${organ.organName}" style="" title="주관기관"></td>
		</tr>
		<tr>
			<th scope="row">사업명</th>
			<td class=""><input type="text" name="businessName" value="${organ.businessName}" style="" title="사업명"></td>
			<th scope="row">과제명</th>
			<td class=""><input type="text" name="projectName" value="${organ.projectName}" style="" title="과제명"></td>
		</tr>
		<tr>
			<th scope="row">연구기관명</th>
			<td class=""><input type="text" name="researchAgency" value="${organ.researchAgency}" style="" title="연구기관명"></td>
			<th scope="row">연구책임자</th>
			<td class=""><input type="text" name="researchResponsiblePerson" value="${organ.researchResponsiblePerson}" style="" title="연구책임자"></td>
		</tr>
		<tr>
			<th scope="row">협약기관 시작일</th>
			<td class=""><input type="text" name="contractStartDate" value="${organ.contractStartDate}" style="" title="협약기관 시작일"></td>
			<th scope="row">협약기관 종료일</th>
			<td class=""><input type="text" name="contractEndDate" value="${organ.contractEndDate}" style="" title="협약기관 종료일"></td>
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
			<td class=""><input type="text" name="govContributeAmount" value="${organ.govContributeAmount}" style="" title="정부출현금"></td>
			<th scope="row">민감부담금</th>
			<td class=""><input type="text" name="nonGovContributeAmount" value="${organ.nonGovContributeAmount}" style="" title="민감부담금"></td>
		</tr>
		<tr>
			<th scope="row">현물</th>
			<td class=""><input type="text" name="goodsAmount" value="${organ.goodsAmount}" style="" title="현물"></td>
			<th scope="row">총현금</th>
			<td class=""><input type="text" name="totalCashAmount" value="${organ.totalCashAmount}" style="" title="총현금"></td>
		</tr>
		<tr>
			<th scope="row">정부지분</th>
			<td class=""><input type="text" name="govInterests" value="${organ.govInterests}" style="" title="정부지분"></td>
			<th scope="row">위탁정산 수수료</th>
			<td class=""><input type="text" name="consignSettlementCommission" value="${organ.consignSettlementCommission}" style="" title="위탁정산 수수료"></td>
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
			<td class=""><input type="text" name="useResultDate" value="${organ.useResultDate}" style="" title="사용실적 제출일"></td>
			<th scope="row">이의 신청 접수일</th>
			<td class=""><input type="text" name="formalObjectAcceptanceDate" value="${organ.formalObjectAcceptanceDate}" style="" title="이의 신청 접수일"></td>
		</tr>
		<tr>
			<th scope="row">이의신청 결과통보일</th>
			<td class=""><input type="text" name="formalObjectResultDate" value="${organ.formalObjectResultDate}" style="" title="이의신청 결과통보일"></td>
			<th scope="row">정산결과 보고일</th>
			<td class=""><input type="text" name="consignSettlementResultDate" value="${organ.consignSettlementResultDate}" style="" title="정산결과 보고일"></td>
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
			<td class=""><input type="text" name="organResponsiblePerson" value="${organ.organResponsiblePerson}" style="" title="주관기관담당자"></td>
			<th scope="row">정산기관담당자</th>
			<td class=""><input type="text" name="consignSettlementPerson" value="${organ.consignSettlementPerson}" style="" title="정산기관담당자"></td>
		</tr>
		<tr>
			<th scope="row">연락처</th>
			<td class="">
				<input type="text" name="organResponsiblePhone1" value="${organ.organResponsiblePhone1}" style="" title="연락처">-
				<input type="text" name="organResponsiblePhone2" value="${organ.organResponsiblePhone2}" style="" title="연락처">-
				<input type="text" name="organResponsiblePhone3" value="${organ.organResponsiblePhone3}" style="" title="연락처">
			</td>
			<th scope="row">연락처</th>
			<td class="">
				<input type="text" name="consignSettlementPhone1" value="${organ.consignSettlementPhone1}" style="" title="연락처">-
				<input type="text" name="consignSettlementPhone2" value="${organ.consignSettlementPhone2}" style="" title="연락처">-
				<input type="text" name="consignSettlementPhone3" value="${organ.consignSettlementPhone3}" style="" title="연락처">
			</td>
		</tr>
		<tr>
			<th scope="row">주소</th>
			<td class="">
				<input type="text" name="organResponsiblePostNumber1" value="${organ.organResponsiblePostNumber1}" style="" title="우편번호1">-
				<input type="text" name="organResponsiblePostNumber2" value="${organ.organResponsiblePostNumber2}" style="" title="우편번호2">우편번호찾기
				<input type="text" name="organResponsibleAddress" value="${organ.organResponsibleAddress}" style="" title="주소">
			</td>
			<th scope="row">주소</th>
			<td class="">
				<input type="text" name="consignSettlementPostNumber1" value="${organ.consignSettlementPostNumber1}" style="" title="우편번호1">-
				<input type="text" name="consignSettlementPostNumber2" value="${organ.consignSettlementPostNumber2}" style="" title="우편번호2">우편번호찾기
				<input type="text" name="consignSettlementAddress" value="${organ.consignSettlementAddress}" style="" title="주소">
			</td>
		</tr>
		<tr>
			<th scope="row">E-mail</th>
			<td class=""><input type="text" name="organResponsibleEmail" value="${organ.organResponsibleEmail}" style="" title="E-mail"></td>
			<th scope="row">E-mail</th>
			<td class=""><input type="text" name="consignSettlementEmail" value="${organ.consignSettlementEmail}" style="" title="E-mail"></td>
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
			<td class=""><input type="text" name="currentAccount" value="${organ.currentAccount}" style="" title="사용잔액"></td>
			<th scope="row">발생이자</th>
			<td class=""><input type="text" name="currentInterest" value="${organ.currentInterest}" style="" title="발생이자"></td>
		</tr>
		<tr>
			<th scope="row">부적정금액</th>
			<td class=""><input type="text" name="currentNonPropriety" value="${organ.currentNonPropriety}" style="" title="부적정금액"></td>
			<th scope="row">소계</th>
			<td class=""><input type="text" name="currentSubTotal" value="${organ.currentSubTotal}" style="" title="소계"></td>
		</tr>
		<tr>
			<th scope="row">환수대상액</th>
			<td colspan="3" class=""><input type="text" name="currentRedemtion" value="${organ.currentRedemtion}" style="" title="환수대상액"></td>
		</tr>		
</table>
</form>
<div>
	<a href="#" onClick="saveSubject();return false;">저장</a>
	<a href="#" onClick="gotoList();return false;">취소</a>
</div>	
</body>
</html>
