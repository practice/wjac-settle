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
		document.form1.action = "${pageContext.request.contextPath}/organ/settlementList";
		document.form1.submit();
	}

	function doOrderedSearch(sortColumn){
		document.form1.sortColumn.value = sortColumn;
		doSearch(1);
	}

	function showSubject(organId){
		document.form1.organId.value = organId;
		document.form1.action = "${pageContext.request.contextPath}/organ/showSubject";
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
<div id="container">
  <div id="content">
    <div id="content_top">
      <p id="title"> 정산진행현황목록</p>
      <p id="path"> PATH : 정산진행현황  &#62; <span id="path_b">정산진행현황목록</span></p>
    </div>    
    <div id="table">    
	<!-- table cellspacing="0" style="table-layout:fixed"-->
	<table cellspacing="0">
		<thead>
			<tr>
				<th rowspan="2" nowrap>번호</th>
				<th rowspan="2" nowrap>사업명</th>
				<th rowspan="2" nowrap>과제명</th>
				<th rowspan="2" nowrap>연구기관명</th>
				<th rowspan="2" nowrap>연구책임자</th>
				<th colspan="2" nowrap>당해년도협약기간</th>
				<th rowspan="2" nowrap>사용실적제출일</th>
				<th colspan="2" nowrap>이의신청접수일</th>
				<th rowspan="2" nowrap>정산결과보고일</th>
				<th rowspan="2" nowrap>총연구개발비</th>
				<th rowspan="2" nowrap>정부출연금</th>
				<th colspan="3" nowrap>기업부담금</th>
				<th rowspan="2" nowrap>총현금</th>
				<th rowspan="2" nowrap>정부지분</th>
				<th rowspan="2" nowrap>위탁정산수수료</th>
				<th colspan="5" nowrap>총환수대상액</th>
				<th rowspan="2" nowrap>검토의견<br/>(부적정집행내역)</th>
				<th rowspan="2" nowrap>정산담당자</th>
				<th rowspan="2" nowrap>비고</th>
			</tr>
			<tr>				
				<th nowrap>시작일</th>
				<th nowrap>종료일</th>				
				<th nowrap>접수일</th>
				<th nowrap>결과통보일</th>				
				<th nowrap>현금</th>
				<th nowrap>현물</th>
				<th nowrap>소계</th>				
				<th nowrap>사용잔액</th>
				<th nowrap>발생이자</th>
				<th nowrap>부적정금액</th>
				<th nowrap>소계</th>
				<th nowrap>환수대상액</th>
				
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
							<td nowrap>${(pagingList.currentPage - 1) * 10 + status.count}</td>
							<td nowrap>${organ.businessName}</td>
							<td nowrap>${organ.projectName}</td>
							<td nowrap>${organ.researchAgency}</td>
							<td nowrap>${organ.researchResponsiblePerson}</td>
							<td nowrap>${organ.contractStartDate}</td>
							<td nowrap>${organ.contractEndDate}</td>
							<td nowrap>${organ.useResultDate}</td>
							<td nowrap>${organ.formalObjectAcceptanceDate}</td>
							<td nowrap>${organ.formalObjectResultDate}</td>
							<td nowrap>${organ.consignSettlementResultDate}</td>
							<td nowrap class="cell_right">${organ.totalResearchAmount}</td>
							<td nowrap class="cell_right">${organ.govContributeAmount}</td>							
							<td nowrap class="cell_right">${organ.nonGovContributeAmount}</td>
							<td nowrap class="cell_right">${organ.goodsAmount}</td>
							<td nowrap class="cell_right">${organ.subtotal}</td>							
							<td nowrap class="cell_right">${organ.totalCashAmount}</td>
							<td nowrap class="cell_right">${organ.govInterests}</td>
							<td nowrap class="cell_right">${organ.consignSettlementCommission}</td>
							<td nowrap class="cell_right">${organ.currentAccount}</td>
							<td nowrap class="cell_right">${organ.currentInterest}</td>
							<td nowrap class="cell_right">${organ.currentNonPropriety}</td>
							<td nowrap class="cell_right">${organ.currentSubTotal}</td>
							<td nowrap class="cell_right">${organ.currentRedemtion}</td>
							<td nowrap>${organ.opinion}</td>
							<td nowrap>${organ.consignSettlementPerson}</td>
							<td nowrap><font color="red">${organ.remark}</font></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
		<tfoot>				
	          <tr>
	            <td colspan="8">
	            	<!-- Start Paginate -->
					<caf:paging formTagName="form1"	searchFunctionName="doSearch" pagingList="${pagingList}" pageNoTagName="pageNo" />
					<!-- End Paginate -->
				</td>
	          </tr>
        </tfoot>
	</table>
	</div>
    <div class="button">
      <div class="b_blue">
        <ul>
          <li><a href="<c:url value="/organ/excelDownload" />">엑셀 다운로드</a></li>
        </ul>
      </div>
    </div>
    </div>
</div>	
</form>
</body>
</html>