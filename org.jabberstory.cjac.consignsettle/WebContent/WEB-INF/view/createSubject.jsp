<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CJAC</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/PopupCalendar.js"></script>
<script type="text/javascript">
<!--
	function requiredFieldCheck(){

		var selObjOwnerGroup = document.form1.ownerGroupId;	
		var IndexOwnerGroup = selObjOwnerGroup.selectedIndex;
		var selObjSubjectGroup = document.form1.subjectGroupId;	
		var IndexSubjectGroup = selObjSubjectGroup.selectedIndex;

		if(selObjOwnerGroup.options[IndexOwnerGroup].value == ""){
			alert("전담기관을 선택해주세요.");
			selObjOwnerGroup.focus();			
			return false;
		}

		if(selObjSubjectGroup.options[IndexSubjectGroup].value == ""){
			alert("주관기관을 선택해주세요.");
			selObjSubjectGroup.focus();			
			return false;
		}

		return true;
	}
	
	function saveSubject(){
		if(requiredFieldCheck()){
			document.form1.action = "${pageContext.request.contextPath}/organ/createSubject";
			document.form1.submit();
		}
	}

	function gotoList(){
		document.form1.action = "${pageContext.request.contextPath}/organ/subjectList";
		document.form1.submit();
	}

	function popUpZipCode(openerZipCode1, openerZipCode2, openerAddr){
		window.open("${pageContext.request.contextPath}/organ/zipCodeList?openerZipCode1=" + openerZipCode1 + "&openerZipCode2=" + openerZipCode2 + "&openerAddr=" + openerAddr , "_pop", "width=400,height=450,history=no,resizable=no,status=no,scrollbars=no,menubar=no");
	}

	function checkMoney(targetId){
		var oTarget = document.getElementById(targetId);
		var test = oTarget.value;
		test = test.num();
		oTarget.value = test.money();		
	}

	function checkEmail(targetId){
		var oTarget = document.getElementById(targetId);
		var test = oTarget.value;

		if(!test.isEmail()){
			alert("Email을 확인해주세요.");
			oTarget.focus();
		}
	}

	function checkPhone(targetId,cnt){
		var oTarget = document.getElementById(targetId);
		var test = oTarget.value;

		oTarget.value = test.num();
				
	}
		
//-->
</script>
</head>
<body>
<form name="form1" method="post">
<div id="container">
  <div id="content">
    <div id="content_top">
      <p id="title"> 주관기관등록 </p>
      <p id="path"> PATH : 주관기관현황 &#62; <span id="path_b">주관기관등록</span></p>
    </div>
    <br />
    <div class="subtitle">01 / 사업정보</div>
    <div id="table">
		<table width="100%" cellspacing="0">
			<tbody>
				<tr>
					<td class="cell_title" width="120px">전담기관</td>
					<td class="cell"><select name="ownerGroupId">
									<option value="">선택</option>
									<c:forEach items="${ownerGroups}" var="ownerGroup">		
										<option value="${ownerGroup.groupId }">${ownerGroup.groupName }</option>
									</c:forEach>
								</select></td>
					<td class="cell_title" width="120px">주관기관</td>
					<td class="cell"><select name="subjectGroupId">
									<option value="">선택</option>
									<c:forEach items="${subjectGroups}" var="subjectGroup">		
										<option value="${subjectGroup.groupId }">${subjectGroup.groupName }</option>
									</c:forEach>
								</select></td>
				</tr>
				<tr>
					<td class="cell_title">사업명</td>
					<td class="cell"><input type="text" name="businessName" style="" title="사업명" class="line_box" style="width:280px"></td>
					<td class="cell_title">과제명</td>
					<td class="cell"><input type="text" name="projectName" style="" title="과제명" class="line_box" style="width:280px"></td>
				</tr>
				<tr>
					<td class="cell_title">연구기관명</td>
					<td class="cell"><input type="text" name="researchAgency" style="" title="연구기관명" class="line_box" style="width:280px"></td>
					<td class="cell_title">연구책임자</td>
					<td class="cell"><input type="text" name="researchResponsiblePerson" style="" title="연구책임자" class="line_box" style="width:280px"></td>
				</tr>
				<tr>
					<td class="cell_title">협약기관 시작일</td>
					<td class="cell">
						<ul>
			                <li>
								<input type="text" name="contractStartDate" style="" title="협약기관 시작일" class="line_box" style="width:64px" readonly>
							</li>
							<li>
								<div class="b_gray">
			                    	<ul>
			                      		<li><a href="#" onClick="popUpCalendar(this, contractStartDate, 'yyyy-mm-dd');return false;">달력</a></li>
			                    	</ul>
			                  	</div>
			                 </li>
			        	</ul>
	                </td>
					<td class="cell_title">협약기관 종료일</td>
					<td class="cell">
						<ul>
			                <li>
								<input type="text" name="contractEndDate" style="" title="협약기관 종료일" class="line_box" style="width:64px" readonly>
							</li>
							<li>
								<div class="b_gray">
			                    	<ul>
			                      		<li><a href="#" onClick="popUpCalendar(this, contractEndDate, 'yyyy-mm-dd');return false;">달력</a></li>
			                    	</ul>
			                  	</div>
			                 </li>
			        	</ul>
					</td>
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
					<td class="cell_title" width="120px">정부출현금</td>
					<td class="cell"><input type="text" name="govContributeAmount" style="" title="정부출현금" class="line_box" style="width:150px" onblur="checkMoney('govContributeAmount');return false;">원</td>
					<td class="cell_title" width="120px">민간부담금</td>
					<td class="cell"><input type="text" name="nonGovContributeAmount" style="" title="민감부담금" class="line_box" style="width:150px" onblur="checkMoney('nonGovContributeAmount');return false;">원</td>
				</tr>
				<tr>
					<td class="cell_title">현물</td>
					<td class="cell"><input type="text" name="goodsAmount" style="" title="현물" class="line_box" style="width:150px" onblur="checkMoney('goodsAmount');return false;">원</td>
					<td class="cell_title">총현금</td>
					<td class="cell"><input type="text" name="totalCashAmount" style="" title="총현금" class="line_box" style="width:150px" onblur="checkMoney('totalCashAmount');return false;">원</td>
				</tr>
				<tr>
					<td class="cell_title">정부지분</td>
					<td class="cell"><input type="text" name="govInterests" style="" title="정부지분" class="line_box" style="width:150px" onblur="checkMoney('govInterests');return false;">원</td>
					<td class="cell_title">위탁정산 수수료</td>
					<td class="cell"><input type="text" name="consignSettlementCommission" style="" title="위탁정산 수수료" class="line_box" style="width:150px" onblur="checkMoney('consignSettlementCommission');return false;">원</td>
				</tr>
		</table>
	</div>
    <br />
    <div class="subtitle">03 / 일정 정보</div>
    <div id="table">
		<table width="100%" cellspacing="0">
			<tbody>
				<tr>
					<td class="cell_title" width="120px">사용실적 제출일</td>
					<td class="cell">						
						<ul>
			                <li>
								<input type="text" name="useResultDate" style="" title="사용실적 제출일" class="line_box" style="width:64px" readonly>
							</li>
							<li>
								<div class="b_gray">
			                    	<ul>
			                      		<li><a href="#" onClick="popUpCalendar(this, useResultDate, 'yyyy-mm-dd');return false;">달력</a></li>
			                    	</ul>
			                  	</div>
			                 </li>
			        	</ul>
					</td>
					<td class="cell_title" width="120px">이의 신청 접수일</td>
					<td class="cell">
						<ul>
			                <li>
								<input type="text" name="formalObjectAcceptanceDate" style="" title="이의 신청 접수일" class="line_box" style="width:64px" readonly>
							</li>
							<li>
								<div class="b_gray">
			                    	<ul>
			                      		<li><a href="#" onClick="popUpCalendar(this, formalObjectAcceptanceDate, 'yyyy-mm-dd');return false;">달력</a></li>
			                    	</ul>
			                  	</div>
			                 </li>
			        	</ul>
			        </td>
				</tr>
				<tr>
					<td class="cell_title">이의신청 결과통보일</td>
					<td class="cell">						
						<ul>
			                <li>
								<input type="text" name="formalObjectResultDate" style="" title="이의신청 결과통보일" class="line_box" style="width:64px" readonly>
							</li>
							<li>
								<div class="b_gray">
			                    	<ul>
			                      		<li><a href="#" onClick="popUpCalendar(this, formalObjectResultDate, 'yyyy-mm-dd');return false;">달력</a></li>
			                    	</ul>
			                  	</div>
			                 </li>
			        	</ul>
			        </td>
					<td class="cell_title">정산결과 보고일</td>
					<td class="cell">						
						<ul>
			                <li>
								<input type="text" name="consignSettlementResultDate" style="" title="정산결과 보고일" class="line_box" style="width:64px" readonly>
							</li>
							<li>
								<div class="b_gray">
			                    	<ul>
			                      		<li><a href="#" onClick="popUpCalendar(this, consignSettlementResultDate, 'yyyy-mm-dd');return false;">달력</a></li>
			                    	</ul>
			                  	</div>
			                 </li>
			        	</ul>
			        </td>
				</tr>
		</table>
	</div>
    <br />
    <div class="subtitle">04 / 주관기관 담당자 정보</div>
    <div id="table">
		<table width="100%" cellspacing="0">
			<tbody>
				<tr>
		        	<td class="cell_title" width="120">주관기관담당자</td>
		            <td class="cell"><input type="text" name="organResponsiblePerson" style="" title="주관기관담당자" class="line_box" style="width:100px"></td>
		            <td class="cell_title" width="50">연락처</td>
		            <td class="cell">
						<input type="text" name="organResponsiblePhone1" style="" title="연락처" class="line_box" style="width:30px" onblur="checkPhone('organResponsiblePhone1');return false;" maxlength="4">
						-
						<input type="text" name="organResponsiblePhone2" style="" title="연락처" class="line_box" style="width:30px" onblur="checkPhone('organResponsiblePhone2');return false;" maxlength="4">
						-
						<input type="text" name="organResponsiblePhone3" style="" title="연락처" class="line_box" style="width:30px" onblur="checkPhone('organResponsiblePhone3');return false;" maxlength="4">
					</td>
		            <td class="cell_title" width="50">이메일</td>
		            <td class="cell"><input type="text" name="organResponsibleEmail" style="" title="E-mail" class="line_box" style="width:200px" onblur="checkEmail('organResponsibleEmail');return false;"></td>
		        </tr>
		        <tr>
		            <td class="cell_title">주소</td>
		            <td colspan="5" class="cell">
		            	<ul>
			                <li>
			                  	<input type="text" id="organResponsiblePostNumber1" name="organResponsiblePostNumber1" style="" title="우편번호1" class="line_box" style="width:30px" readonly>
			                  	-
								<input type="text" id="organResponsiblePostNumber2" name="organResponsiblePostNumber2" style="" title="우편번호2" class="line_box" style="width:30px" readonly>&nbsp;
			                </li>
			                <li>
			                  <div class="b_gray">
			                    <ul>
			                      <li><a href="#" onClick="popUpZipCode('organResponsiblePostNumber1','organResponsiblePostNumber2', 'organResponsibleAddress');return false;">우편번호검색</a></li>
			                    </ul>
			                  </div>
			                </li>
			                <li>
			                	&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="organResponsibleAddress" name="organResponsibleAddress" style="" title="주소"  class="line_box" style="width:520px">
			                </li>
			        	</ul>
					</td>
		        </tr>		        
		</table>
	</div>
	<br />
	<div class="subtitle">05 / 정산기관 담당자 정보</div>
    <div id="table">
    	<table width="100%" cellspacing="0">
			<tbody>
				<tr>
		        	<td class="cell_title" width="120">정산기관담당자</td>
		            <td class="cell"><input type="text" name="consignSettlementPerson" style="" title="정산기관담당자" class="line_box" style="width:100px"></td>
		            <td class="cell_title" width="50">연락처</td>
		            <td class="cell">
						<input type="text" name="consignSettlementPhone1" style="" title="연락처" class="line_box" style="width:30px" onblur="checkPhone('consignSettlementPhone1');return false;" maxlength="4">
						-
						<input type="text" name="consignSettlementPhone2" style="" title="연락처" class="line_box" style="width:30px" onblur="checkPhone('consignSettlementPhone2');return false;" maxlength="4">
						-
						<input type="text" name="consignSettlementPhone3" style="" title="연락처" class="line_box" style="width:30px" onblur="checkPhone('consignSettlementPhone3');return false;" maxlength="4">
					</td>
		            <td class="cell_title" width="50">이메일</td>
		            <td class="cell"><input type="text" name="consignSettlementEmail" style="" title="E-mail" class="line_box" style="width:200px" onblur="checkEmail('consignSettlementEmail');return false;"></td>
		        </tr>
		        <tr>
		            <td class="cell_title">주소</td>
		            <td colspan="5" class="cell">
		            	<ul>
			                <li>
			                  	<input type="text" id="consignSettlementPostNumber1" name="consignSettlementPostNumber1" style="" title="우편번호1" class="line_box" style="width:30px" readonly>
			                  	-
								<input type="text" id="consignSettlementPostNumber2" name="consignSettlementPostNumber2" style="" title="우편번호2" class="line_box" style="width:30px" readonly>&nbsp;
			                </li>
			                <li>
			                  <div class="b_gray">
			                    <ul>
			                      <li><a href="#" onClick="popUpZipCode('consignSettlementPostNumber1','consignSettlementPostNumber2','consignSettlementAddress');return false;">우편번호검색</a></li>
			                    </ul>
			                  </div>
			                </li>
			                <li>
			                	&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="consignSettlementAddress" name="consignSettlementAddress" style="" title="주소"  class="line_box" style="width:520px">
			                </li>
			        	</ul>
					</td>
		        </tr>		        
		</table>		
	</div>
    <br />
    <div class="subtitle">06 / 정산결과 정보</div>
    <div id="table">
		<table width="100%" cellspacing="0">
			<tbody>
				<tr>
					<td class="cell_title" width="120px">사용잔액</td>
					<td class="cell"><input type="text" name="currentAccount" style="" title="사용잔액" class="line_box" style="width:150px" onblur="checkMoney('currentAccount');return false;">원</td>
					<td class="cell_title" width="120px">발생이자</td>
					<td class="cell"><input type="text" name="currentInterest" style="" title="발생이자" class="line_box" style="width:150px" onblur="checkMoney('currentInterest');return false;">원</td>
				</tr>
				<tr>
					<td class="cell_title">부적정금액</td>
					<td class="cell"><input type="text" name="currentNonPropriety" style="" title="부적정금액" class="line_box" style="width:150px" onblur="checkMoney('currentNonPropriety');return false;">원</td>
					<td class="cell_title">소계</td>
					<td class="cell"><input type="text" name="currentSubTotal" style="" title="소계" class="line_box" style="width:150px" onblur="checkMoney('currentSubTotal');return false;">원</td>
				</tr>
				<tr>
					<td class="cell_title">환수대상액</td>
					<td colspan="3" class="cell"><input type="text" name="currentRedemtion" style="" title="환수대상액" class="line_box" style="width:150px" onblur="checkMoney('currentRedemtion');return false;">원</td>
				</tr>		
		</table>
		<div class="button">
	        <div class="b_blue">
	          <ul>
	          	<li><a href="#" onClick="gotoList();return false;">취소</a></li>
	            <li><a href="#" onClick="saveSubject();return false;">저장</a></li>	            
	          </ul>
	        </div>
	      </div>
		</div>
  </div>
</div>

</form>	
</body>
</html>
