<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CJAC</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/PopupCalendar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.dateentry.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.selectboxes.js"></script>
<script>
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
	
	$(document).ready(function() {
		$('#submit').bind('click', function(ev) {
			if(requiredFieldCheck()){
				$('#form1').submit();
				ev.preventDefault();
				return false;
			}			
		});
	});

	$(document).ready(function(ev) {
		$('#postnumSearch1').bind('click', function(ev) {
			window.open('${pageContext.request.contextPath}/organ/zipCodeList?openerZipCode1=organResponsiblePostNumber1&openerZipCode2=organResponsiblePostNumber2&openerAddr=organResponsibleAddress' , '_pop', 'width=400,height=450,history=no,resizable=no,status=no,scrollbars=no,menubar=no');
			ev.preventDefault();
			return false;
		});
	});

	$(document).ready(function(ev) {
		$('#postnumSearch2').bind('click', function(ev) {
			window.open('${pageContext.request.contextPath}/organ/zipCodeList?openerZipCode1=consignSettlementPostNumber1&openerZipCode2=consignSettlementPostNumber2&openerAddr=consignSettlementAddress' , '_pop', 'width=400,height=450,history=no,resizable=no,status=no,scrollbars=no,menubar=no');
			ev.preventDefault();
			return false;
		});
	});

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

	$(document).ready(function(){
		$('#contractStartDate').dateEntry({dateFormat: 'ymd-'});
		$('#contractEndDate').dateEntry({dateFormat: 'ymd-'});
		$('#useResultDate').dateEntry({dateFormat: 'ymd-'});
		$('#formalObjectAcceptanceDate').dateEntry({dateFormat: 'ymd-'});
		$('#formalObjectResultDate').dateEntry({dateFormat: 'ymd-'});
		$('#consignSettlementResultDate').dateEntry({dateFormat: 'ymd-'});
		$('#govContributeAmount').blur(function (){
			checkMoney('govContributeAmount');
		});
		$('#nonGovContributeAmount').blur(function (){
			checkMoney('nonGovContributeAmount');
		});
		$('#goodsAmount').blur(function (){
			checkMoney('goodsAmount');
		});
		$('#subtotal').blur(function (){
			checkMoney('subtotal');
		});
		$('#totalCashAmount').blur(function (){
			checkMoney('totalCashAmount');
		});
		$('#consignSettlementCommission').blur(function (){
			checkMoney('consignSettlementCommission');
		});
		$('#totalResearchAmount').blur(function (){
			checkMoney('totalResearchAmount');
		});
		$('#govInterests').blur(function (){
			checkMoney('govInterests');
		});
		$('#currentAccount').blur(function (){
			checkMoney('currentAccount');
		});
		$('#currentInterest').blur(function (){
			checkMoney('currentInterest');
		});
		$('#currentNonPropriety').blur(function (){
			checkMoney('currentNonPropriety');
		});
		$('#currentSubTotal').blur(function (){
			checkMoney('currentSubTotal');
		});
		$('#currentRedemtion').blur(function (){
			checkMoney('currentRedemtion');
		});
		$('#organResponsibleEmail').blur(function (){
			checkEmail('organResponsibleEmail');
		});
		$('#consignSettlementEmail').blur(function (){
			checkEmail('consignSettlementEmail');
		});
		$('#organResponsiblePhone1').blur(function (){
			checkPhone('organResponsiblePhone1');
		});
		$('#organResponsiblePhone2').blur(function (){
			checkPhone('organResponsiblePhone2');
		});
		$('#organResponsiblePhone3').blur(function (){
			checkPhone('organResponsiblePhone3');
		});
		$('#consignSettlementPhone1').blur(function (){
			checkPhone('consignSettlementPhone1');
		});
		$('#consignSettlementPhone2').blur(function (){
			checkPhone('consignSettlementPhone2');
		});
		$('#consignSettlementPhone3').blur(function (){
			checkPhone('consignSettlementPhone3');
		});		
	});

	$(document).ready(function(){
		$('#ownerGroupId').change(function(){
			var selVal = $("#ownerGroupId > option:selected").val();
			$.getJSON("${pageContext.request.contextPath}/organ/getAjaxData?groupId=" + selVal, function(data, textStatus){
				if(textStatus == 'success' && data.length > 0){	
					$('#subjectGroupId').removeOption(/./);	
					for(var i = 0; i< data.length; i++){
						$('#subjectGroupId').addOption(data[i].id, data[i].value);
						$("#subjectGroupId > option[@value='']").attr("selected", "true");											
					}
				}else{
					$('#subjectGroupId').removeOption(/./);
					$('#subjectGroupId').addOption("","선택");
				}
			});
		});
	});

	$(document).ready(function(){
		$('#subjectGroupId').change(function(){
			var selVal = this.value;
			if(selVal == ""){
				//removeSubjectPerson();
			}else{
				$.getJSON("${pageContext.request.contextPath}/organ/getAjaxData?dataType=1&groupId=" + selVal, function(data, textStatus){
					if(textStatus == 'success' && data.length > 0){		
						setSubjectPerson(data[0].organResponsiblePerson,
								data[0].organResponsiblePhone1,
								data[0].organResponsiblePhone2,
								data[0].organResponsiblePhone3,
								data[0].organResponsibleEmail,
								data[0].organResponsiblePostNumber1,
								data[0].organResponsiblePostNumber2,
								data[0].organResponsibleAddress);
					}else{
						removeSubjectPerson();
					}
				});
			}
		});
	});

	function setSubjectPerson(organResponsiblePerson, 
								organResponsiblePhone1,
								organResponsiblePhone2,
								organResponsiblePhone3,
								organResponsibleEmail,
								organResponsiblePostNumber1,
								organResponsiblePostNumber2,
								organResponsibleAddress){

		$('#organResponsiblePerson').val(organResponsiblePerson);
		$('#organResponsiblePhone1').val(organResponsiblePhone1);
		$('#organResponsiblePhone2').val(organResponsiblePhone2);
		$('#organResponsiblePhone3').val(organResponsiblePhone3);
		$('#organResponsibleEmail').val(organResponsibleEmail);
		$('#organResponsiblePostNumber1').val(organResponsiblePostNumber1);
		$('#organResponsiblePostNumber2').val(organResponsiblePostNumber2);
		$('#organResponsibleAddress').val(organResponsibleAddress);		
	}

	function removeSubjectPerson(){
		$('#organResponsiblePerson').val("");
		$('#organResponsiblePhone1').val("");
		$('#organResponsiblePhone2').val("");
		$('#organResponsiblePhone3').val("");
		$('#organResponsibleEmail').val("");
		$('#organResponsiblePostNumber1').val("");
		$('#organResponsiblePostNumber2').val("");
		$('#organResponsibleAddress').val("");		
	}
	
</script>
</head>
<body>
<form id="form1" name="form1" method="post">
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
					<td class="cell_title" width="130px">전담기관</td>
					<td class="cell" width="330px"><select id="ownerGroupId" name="ownerGroupId">
									<option value="">선택</option>
									<c:forEach items="${ownerGroups}" var="ownerGroup">		
										<option value="${ownerGroup.groupId }">${ownerGroup.groupName }</option>
									</c:forEach>
								</select></td>
					<td class="cell_title" width="130px">주관기관</td>
					<td class="cell" width="330px"><select id="subjectGroupId" name="subjectGroupId"><option value="">선택</option></select></td>
				</tr>
				<tr>
					<td class="cell_title">사업명</td>
					<td class="cell"><input type="text" id="businessName" name="businessName" class="line_box" style="width:280px"></td>
					<td class="cell_title" >과제명</td>
					<td class="cell"><input type="text" id="projectName" name="projectName" class="line_box" style="width:280px"></td>
				</tr>
				<tr>
					<td class="cell_title">연구기관명</td>
					<td class="cell"><input type="text" id="researchAgency" name="researchAgency" class="line_box" style="width:280px"></td>
					<td class="cell_title">연구책임자</td>
					<td class="cell"><input type="text" id="researchResponsiblePerson" name="researchResponsiblePerson" title="연구책임자" class="line_box" style="width:280px"></td>
				</tr>
				<tr>
					<td class="cell_title">협약기관 시작일</td>
					<td class="cell">
						<ul>
			                <li>
								<input type="text" id="contractStartDate" name="contractStartDate" class="line_box" style="width:64px">
							</li>							
			        	</ul>
	                </td>
					<td class="cell_title">협약기관 종료일</td>
					<td class="cell">
						<ul>
			                <li>
								<input type="text" id="contractEndDate" name="contractEndDate" class="line_box" style="width:64px">
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
					<td class="cell_title" width="130px">정부출연금</td>
					<td class="cell" width="330px"><input type="text" id="govContributeAmount" name="govContributeAmount" class="line_box" style="width:150px">원</td>
					<td class="cell_title" width="130px">기업부담금</td>
					<td class="cell" width="330px">
						<div>
							현금 <input type="text" id="nonGovContributeAmount" name="nonGovContributeAmount" class="line_box" style="width:150px">원
						</div>
						<div>
							현물 <input type="text" id="goodsAmount" name="goodsAmount" class="line_box" style="width:150px">원
						</div>		
						<div>
							소계 <input type="text" id="subtotal" name="subtotal" class="line_box" style="width:150px">원								
						</div>
					</td>																
				</tr>
				<tr>
					<td class="cell_title">총현금</td>
					<td class="cell"><input type="text" id="totalCashAmount" name="totalCashAmount" class="line_box" style="width:150px">원</td>
					<td class="cell_title">총연구개발비</td>
					<td class="cell"><input type="text" id="totalResearchAmount" name="totalResearchAmount" class="line_box" style="width:150px">원</td>
				</tr>
				<tr>
					<td class="cell_title">위탁정산 수수료</td>
					<td class="cell"><input type="text" id="consignSettlementCommission" name="consignSettlementCommission" class="line_box" style="width:150px">원</td>
					<td class="cell_title">정부지분</td>
					<td class="cell"><input type="text" id="govInterests" name="govInterests" class="line_box" style="width:150px" maxlength="3">%</td>
				</tr>
		</table>
	</div>
    <br />
    <div class="subtitle">03 / 일정 정보</div>
    <div id="table">
		<table width="100%" cellspacing="0">
			<tbody>
				<tr>
					<td class="cell_title" width="130px">사용실적 제출일</td>
					<td class="cell">						
						<ul>
			                <li>
								<input type="text" id="useResultDate" name="useResultDate" class="line_box" style="width:64px">
							</li>
			        	</ul>
					</td>
					<td class="cell_title" width="130px">이의 신청 접수일</td>
					<td class="cell">
						<ul>
			                <li>
								<input type="text" id="formalObjectAcceptanceDate" name="formalObjectAcceptanceDate" class="line_box" style="width:64px">
							</li>
			        	</ul>
			        </td>
				</tr>
				<tr>
					<td class="cell_title">이의신청 결과통보일</td>
					<td class="cell">						
						<ul>
			                <li>
								<input type="text" id="formalObjectResultDate" name="formalObjectResultDate" class="line_box" style="width:64px">
							</li>
			        	</ul>
			        </td>
					<td class="cell_title">정산결과 보고일</td>
					<td class="cell">						
						<ul>
			                <li>
								<input type="text" id="consignSettlementResultDate" name="consignSettlementResultDate" class="line_box" style="width:64px">
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
		            <td class="cell"><input type="text" id="organResponsiblePerson" name="organResponsiblePerson" class="line_box" style="width:100px"></td>
		            <td class="cell_title" width="50">연락처</td>
		            <td class="cell">
						<input type="text" id="organResponsiblePhone1" name="organResponsiblePhone1" class="line_box" style="width:30px" maxlength="4">
						-
						<input type="text" id="organResponsiblePhone2" name="organResponsiblePhone2" class="line_box" style="width:30px" maxlength="4">
						-
						<input type="text" id="organResponsiblePhone3" name="organResponsiblePhone3" class="line_box" style="width:30px" maxlength="4">
					</td>
		            <td class="cell_title" width="50">이메일</td>
		            <td class="cell"><input type="text" id="organResponsibleEmail" name="organResponsibleEmail" class="line_box" style="width:200px"></td>
		        </tr>
		        <tr>
		            <td class="cell_title">주소</td>
		            <td colspan="5" class="cell">
		            	<ul>
			                <li>
			                  	<input type="text" id="organResponsiblePostNumber1" name="organResponsiblePostNumber1" class="line_box" style="width:30px" maxlength="3">
			                  	-
								<input type="text" id="organResponsiblePostNumber2" name="organResponsiblePostNumber2" class="line_box" style="width:30px" maxlength="3">&nbsp;
			                </li>
			                <li>
			                  <div class="b_gray">
			                    <ul>
			                      <li><a href="#" id="postnumSearch1">우편번호검색</a></li>
			                    </ul>
			                  </div>
			                </li>
			                <li>
			                	&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="organResponsibleAddress" name="organResponsibleAddress" class="line_box" style="width:520px">
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
		            <td class="cell"><input type="text" id="consignSettlementPerson" name="consignSettlementPerson" class="line_box" style="width:100px"></td>
		            <td class="cell_title" width="50">연락처</td>
		            <td class="cell">
						<input type="text" id="consignSettlementPhone1" name="consignSettlementPhone1" class="line_box" style="width:30px" maxlength="4">
						-
						<input type="text" id="consignSettlementPhone2" name="consignSettlementPhone2" class="line_box" style="width:30px" maxlength="4">
						-
						<input type="text" id="consignSettlementPhone3" name="consignSettlementPhone3" class="line_box" style="width:30px" maxlength="4">
					</td>
		            <td class="cell_title" width="50">이메일</td>
		            <td class="cell"><input type="text" name="consignSettlementEmail" class="line_box" style="width:200px"></td>
		        </tr>
		        <tr>
		            <td class="cell_title">주소</td>
		            <td colspan="5" class="cell">
		            	<ul>
			                <li>
			                  	<input type="text" id="consignSettlementPostNumber1" name="consignSettlementPostNumber1" class="line_box" style="width:30px" maxlength="3">
			                  	-
								<input type="text" id="consignSettlementPostNumber2" name="consignSettlementPostNumber2" class="line_box" style="width:30px" maxlength="3">&nbsp;
			                </li>
			                <li>
			                  <div class="b_gray">
			                    <ul>
			                      <li><a href="#" id="postnumSearch2">우편번호검색</a></li>
			                    </ul>
			                  </div>
			                </li>
			                <li>
			                	&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="consignSettlementAddress" name="consignSettlementAddress" class="line_box" style="width:520px">
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
					<td class="cell_title" width="130px">사용잔액</td>
					<td class="cell"><input type="text" id="currentAccount" name="currentAccount" class="line_box" style="width:150px">원</td>
					<td class="cell_title" width="130px">발생이자</td>
					<td class="cell"><input type="text" id="currentInterest" name="currentInterest" class="line_box" style="width:150px">원</td>
				</tr>
				<tr>
					<td class="cell_title">부적정금액</td>
					<td class="cell"><input type="text" id="currentNonPropriety" name="currentNonPropriety" class="line_box" style="width:150px">원</td>
					<td class="cell_title">소계</td>
					<td class="cell"><input type="text" id="currentSubTotal" name="currentSubTotal" class="line_box" style="width:150px">원</td>
				</tr>
				<tr>
					<td class="cell_title">환수대상액</td>
					<td colspan="3" class="cell"><input type="text" id="currentRedemtion" name="currentRedemtion" class="line_box" style="width:150px">원</td>
				</tr>		
				<tr>
					<td class="cell_title">검토의견</td>
					<td colspan="3" class="cell"><textarea id="opinion" name="opinion"></textarea></td>
				</tr>
				<tr>
					<td class="cell_title">비고</td>
					<td colspan="3" class="cell"><textarea id="remark" name="remark"></textarea></td>
				</tr>
		</table>
		<div class="button">
	        <div class="b_blue">
	          <ul>
	          	<li><a href="<c:url value="/organ/subjectList" />">취소</a></li>
	            <li><a href="#" id="submit">저장</a></li>         
	          </ul>
	        </div>
	      </div>
		</div>
  </div>
</div>

</form>	
</body>
</html>
