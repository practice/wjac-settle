<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CJAC</title>
</head>
<body>
<form name="form1" method="post">
<input type="hidden" name="organId" value="${organ.organId}">
<div id="container">
  <div id="content">
    <div id="content_top">
      <p id="title"> 주관기관조회 : ${organ.subjectGroup.groupName} </p>
      <p id="path"> PATH : 주관기관현황 &#62; <span id="path_b">주관기관조회</span></p>
    </div>
    <div class="button">
      <div class="b_blue">
        <ul>
          <li><a href="<c:url value="/organ/showNonApproval2?organId=${organ.organId}" />">최종 불인정 내역</a></li>
          <li><a href="<c:url value="/organ/showNonApproval1?organId=${organ.organId}" />">1차 불인정 내역</a></li>
          <li><a href="<c:url value="/organ/showCostDetail?organId=${organ.organId}" />">사업비사용명세</a></li>
        </ul>
      </div>
    </div>
    <br />
    <div class="subtitle">01 / 사업정보</div>
	<div id="table">
		<table width="100%" cellspacing="0">
			<tbody>
				<tr>
					<td class="cell_title" width="130px">전담기관</td>
					<td class="cell" width="330px">${organ.ownerGroup.groupName}</td>
					<td class="cell_title" width="130px">주관기관</td>
					<td class="cell" width="330px">${organ.subjectGroup.groupName}</td>
				</tr>
				<tr>
					<td class="cell_title">사업명</td>
					<td class="cell">${organ.businessName}</td>
					<td class="cell_title">과제명</td>
					<td class="cell">${organ.projectName}</td>
				</tr>
				<tr>
					<td class="cell_title">연구기관명</td>
					<td class="cell">${organ.researchAgency}</td>
					<td class="cell_title">연구책임자</td>
					<td class="cell">${organ.researchResponsiblePerson}</td>
				</tr>
				<tr>
					<td class="cell_title">협약기관시작일</td>
					<td class="cell">${organ.contractStartDate}</td>
					<td class="cell_title">협약기관종료일</td>
					<td class="cell">${organ.contractEndDate}</td>
				</tr>
			</tbody>
		</table>
    </div>
	<br />
    <div class="subtitle">02 / 사업비 정보</div>
    <div id="table">
      <table width="100%" cellspacing="0">
        <tbody>
          	<tr>
				<td class="cell_title" width="130px">정부출연금</td>
				<td class="cell" width="330px">${organ.govContributeAmount}원</td>
				<td class="cell_title" width="130px">기업부담금</td>
				<td class="cell" width="330px">
					<div>
						현금 ${organ.nonGovContributeAmount}원
					</div>
					<div>
						현물 ${organ.goodsAmount}원
					</div>
					<div>
						소개 ${organ.subtotal}원
					</div>					
				</td>
			</tr>
			<tr>
				<td class="cell_title">총현금</td>
				<td class="cell">${organ.totalCashAmount}원</td>
				<td class="cell_title">총연구개발비</td>
				<td class="cell">${organ.totalResearchAmount}원</td>
			</tr>
			<tr>
				<td class="cell_title">위탁정산수수료</td>
				<td class="cell">${organ.consignSettlementCommission}원</td>
				<td class="cell_title">정부지분</td>
				<td class="cell">${organ.govInterests}%</td>				
			</tr>	
        </tbody>
      </table>
    </div>
    <br />
    <div class="subtitle">03 / 일정 정보</div>
    <div id="table">
      <table width="100%" cellspacing="0">
        <tbody>
	        <tr>
				<td class="cell_title" width="130px">사용실적 제출일</td>
				<td class="cell" width="330px">${organ.useResultDate}</td>
				<td class="cell_title" width="130px">이의 신청 접수일</td>
				<td class="cell" width="330px">${organ.formalObjectAcceptanceDate}</td>
			</tr>
			<tr>
				<td class="cell_title"> 이의신청 결과통보일</td>
				<td class="cell">${organ.formalObjectResultDate}</td>
				<td class="cell_title">정산결과 보고일</td>
				<td class="cell">${organ.consignSettlementResultDate}</td>
			</tr>
        </tbody>
      </table>
    </div>
    <br />
    <div class="subtitle">04 / 주관기관 담당자 정보</div>
    <div id="table">
      <table width="100%" cellspacing="0">
        <tbody>
          <tr>
            <td class="cell_title" width="130px">주관기관 담당자</td>
            <td class="cell" width="100px">${organ.organResponsiblePerson}</td>
            <td class="cell_title" width="50">연락처</td>
            <td class="cell" width="100px">${organ.organResponsiblePhone1}-${organ.organResponsiblePhone2}-${organ.organResponsiblePhone3}</td>
            <td class="cell_title" width="50">이메일</td>
            <td class="cell" width="470px">${organ.organResponsibleEmail}</td>
          </tr>
          <tr>
            <td class="cell_title">주소</td>
            <td colspan="5" class="cell">(${organ.organResponsiblePostNumber1}-${organ.organResponsiblePostNumber2}) ${organ.organResponsibleAddress}</td>
          </tr>
        </tbody>
      </table>
    </div>
    <br />
    <div class="subtitle">05 / 정산기관 담당자 정보</div>
    <div id="table">
      <table width="100%" cellspacing="0">
        <tbody>
          <tr>
            <td class="cell_title" width="130px">정산기관 담당자</td>
            <td class="cell" width="100px">${organ.consignSettlementPerson}</td>
            <td class="cell_title" width="50">연락처</td>
            <td class="cell" width="100px">${organ.consignSettlementPhone1}-${organ.consignSettlementPhone2}-${organ.consignSettlementPhone3}</td>
            <td class="cell_title" width="50">이메일</td>
            <td class="cell" width="470px">${organ.consignSettlementEmail}</td>
          </tr>
          <tr>
            <td class="cell_title">주소</td>
            <td colspan="5" class="cell">(${organ.consignSettlementPostNumber1}-${organ.consignSettlementPostNumber2}) ${organ.consignSettlementAddress}</td>
          </tr>
        </tbody>
      </table>
    </div>
     <br />
    <div class="subtitle">06 / 정산결과 정보</div>   
    <div id="table">
      <table width="100%" cellspacing="0">
        <tbody>
          	<tr>
				<td class="cell_title" width="130px">사용잔액</td>
				<td class="cell" width="330px">${organ.currentAccount}원</td>
				<td class="cell_title" width="130px">발생이자</td>
				<td class="cell" width="330px">${organ.currentInterest}원</td>
			</tr>
			<tr>
				<td class="cell_title">부적정금액</td>
				<td class="cell">${organ.currentNonPropriety}원</td>
				<td class="cell_title">소계</td>
				<td class="cell">${organ.currentSubTotal}원</td>
			</tr>
			<tr>
				<td class="cell_title">환수대상액</td>
				<td colspan="3" class="cell">${organ.currentRedemtion}원</td>
			</tr>	
        </tbody>
      </table>
	<div class="button">
        <div class="b_blue">
          <ul>
          	<li><a href="#" onClick="window.print();return false;">인쇄</a></li>
          	<li><a href="<c:url value="/organ/subjectList" />">목록</a></li>
          	<sec:authorize ifAllGranted="ROLE_ADMIN">
            	<li><a href="<c:url value="/organ/deleteSubject?organId=${organ.organId}" />">삭제</a></li>
            	<li><a href="<c:url value="/organ/updateSubject?organId=${organ.organId}" />">수정</a></li>
            </sec:authorize>
          </ul>
        </div>
      </div>      
    </div>
    
  </div>
</div>
</form>
</body>   
</html>