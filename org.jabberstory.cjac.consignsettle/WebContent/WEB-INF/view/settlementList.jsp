<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="caf" uri="/WEB-INF/tlds/cjac-tags.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CJAC</title>
<script language="javascript">
<!--
	function doSearch(pageNo){
		document.form1.pageNo.value = pageNo;
		document.form1.action = "${pageContext.request.contextPath}/subject/subjectList";
		document.form1.submit();
	}

	function doOrderedSearch(sortColumn){
		document.form1.sortColumn.value = sortColumn;
		doSearch(1);
	}

	function showSubject(organId){
		document.form1.organId.value = organId;
		document.form1.action = "${pageContext.request.contextPath}/subject/showSubject";
		document.form1.submit();
	}

//-->
</script>
</head>
<body>
<form name="form1" method="post">
<input type="hidden" name="pageNo">
<input type="hidden" name="organId">
<input type="hidden" name="sortColumn" value="${sortColumn}">
<!-- Start Content Title -->
<div>
	<H3>정산 진행 현황</H3>
</div>
<!-- End Content Title -->
<div>
	<a href="#" onClick="excelDownLoad();return false;">엑셀다운로드</a>
	<a href="#" onClick="printPage();return false;">인쇄</a>
</div>
<!-- Start Content Area -->	
<div>
	<table cellspacing="0" cellpadding="0" class="" border="1">
		<caption>
		</caption>
		
		<thead>
			<tr>
				<th scope="col" class="" rowspan="2">번호</th>
				<th scope="col" class="" rowspan="2">사업명</th>
				<th scope="col" class="" rowspan="2">과제명</th>
				<th scope="col" class="" rowspan="2">연구기관명</th>
				<th scope="col" class="" rowspan="2">연구책임자</th>
				<th scope="col" class="" colspan="2">당해년도협약기간</th>
				<th scope="col" class="" rowspan="2">사용실적제출일</th>
				<th scope="col" class="" colspan="2">이의신청접수일</th>
				<th scope="col" class="" rowspan="2">정산결과보고일</th>
				<th scope="col" class="" rowspan="2">총연구개발비</th>
				<th scope="col" class="" rowspan="2">정부출연금</th>
				<th scope="col" class="" colspan="3">기업부담금</th>
				<th scope="col" class="" rowspan="2">총현금</th>
				<th scope="col" class="" rowspan="2">정부지분</th>
				<th scope="col" class="" rowspan="2">위탁정산수수료</th>
				<th scope="col" class="" colspan="5">총환수대상액</th>
				<th scope="col" class="" rowspan="2">검토의견(부적정집행내역)</th>
				<th scope="col" class="" rowspan="2">정산담당자</th>
				<th scope="col" class="" rowspan="2">비고</th>
			</tr>
			<tr>				
				<th scope="col" class="">시작일</th>
				<th scope="col" class="">종료일</th>				
				<th scope="col" class="">접수일</th>
				<th scope="col" class="">결과통보일</th>				
				<th scope="col" class="">현금</th>
				<th scope="col" class="">현물</th>
				<th scope="col" class="">소계</th>				
				<th scope="col" class="">사용잔액</th>
				<th scope="col" class="">발생이자</th>
				<th scope="col" class="">부적정금액</th>
				<th scope="col" class="">소계</th>
				<th scope="col" class="">환수대상액</th>
				
			</tr>
		</thead>
		<tbody>
			<c:choose>		
				<c:when test="${pagingList.totalCount == 0}">
					<tr>
						<td class="" colspan="27">검색 결과가 없습니다.</td>
					</tr>
				</c:when>	
				<c:otherwise>
					<c:forEach items="${pagingList.items}" var="organ" varStatus="status">		
						<tr>
							<td class="">${(pagingList.currentPage - 1) * 10 + status.count}</td>
							<td class="">${organ.businessName}</td>
							<td class="">${organ.projectName}</td>
							<td class="">${organ.researchAgency}</td>
							<td class="">${organ.researchResponsiblePerson}</td>
							<td class="">${organ.contractStartDate}</td>
							<td class="">${organ.contractEndDate}</td>
							<td class="">${organ.useResultDate}</td>
							<td class="">${organ.formalObjectAcceptanceDate}</td>
							<td class="">${organ.formalObjectResultDate}</td>
							<td class="">${organ.consignSettlementResultDate}</td>
							<td class=""><font color="red">알수없는데이터</font></td>
							<td class="">${organ.govContributeAmount}</td>							
							<td class=""><font color="red">알수없는데이터</font></td>
							<td class="">${organ.goodsAmount}</td>
							<td class=""><font color="red">알수없는데이터</font></td>							
							<td class="">${organ.totalCashAmount}</td>
							<td class="">${organ.govInterests}</td>
							<td class="">${organ.consignSettlementCommission}</td>
							<td class="">${organ.currentAccount}</td>
							<td class="">${organ.currentInterest}</td>
							<td class="">${organ.currentNonPropriety}</td>
							<td class="">${organ.currentSubTotal}</td>
							<td class="">${organ.currentRedemtion}</td>
							<td class=""><font color="red">알수없는데이터</font></td>
							<td class="">${organ.consignSettlementPerson}</td>
							<td class=""><font color="red">알수없는데이터</font></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>	
<!-- End Content Area -->
</div>		
<!-- Start Paginate -->
<caf:paging 
	formTagName="form1" 
	searchFunctionName="doSearch" 
	pagingList="${pagingList}" 
	pageNoTagName="pageNo" />
<!-- End Paginate -->
</form>
</body>
</html>