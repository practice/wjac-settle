<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CJAC</title>
<script language="JavaScript">
<!--
	/** 중복 체크 **/
	function duplicatedElementCheck(checkValue, targetObj){
		var elms = targetObj.options;
	    for( j = 0, l = elms.length; j < l; j++ ){
	        if( checkValue == elms[j].value ){
		        return true;            
	        }
	    }
	    return false;
	}
	
	/** 복사 **/
	function copyElement(sourceObj, targetObj){
	    var elms = sourceObj.options;
	    for( i = 0, k = elms.length; i < k; i++ ){
	        if( elms[i].selected && !duplicatedElementCheck(elms[i].value, targetObj)){
	        //if( elms[i].selected ){
	            targetObj.add(new Option(elms[i].text, elms[i].value, false, false));
	        }
	    }
	    sourceObj.selectedIndex=-1;
	}

	/** 제거 **/
	function removeElement(sourceObj){
	    var elms = sourceObj.options;
	    var posArr = new Array();
	    var increase = 0;
	    for( i = 0, k = elms.length; i < k; i++ ){
	        if( elms[i].selected ){
	            posArr[increase++] = elms[i].value;
	        }
	    }
	    for( i = 0, k = posArr.length; i < k; i++ ){
	        for( x = 0, y = elms.length; x < y; x++ ){
	            if( (posArr[i] == elms[x].value) && elms[x].selected ){
	                sourceObj.remove(x);
	                x = 0;
	                y--;
	            }
	        }
	    }
	}

	/** 이동 **/	
	function moveElement(sourceObj, targetObj){
	    var elms = sourceObj.options;
	    for( i = 0, k = elms.length; i < k; i++ ){
	        if( elms[i].selected ){
	            targetObj.add(new Option(elms[i].text, elms[i].value, false, false));
	        }
	    }
	    removeElement(sourceObj);
	    sourceObj.selectedIndex = -1;
	}

	function saveData(){
		if(document.form1.selectedGroupId.selectedIndex == -1)
		{
			alert("사용자그룹을 선택하세요.");	
			return;				
		}
		
		var elms = document.form1.selectedUserId.options;
		for( i = 0; i < elms.length; i++ ) 
		{ 
			elms[i].selected = true;
			elms.focus();	
		}				

		document.form1.action = "${pageContext.request.contextPath}/auth/updateUserAuthAdmin";
		document.form1.submit();
	}

	function loadData(){
		if(document.form1.selectedGroupId.selectedIndex == -1)
		{
			alert("사용자그룹을 선택하세요.");	
			return;				
		}
		document.form1.action = "${pageContext.request.contextPath}/auth/showUserAuthAdmin";
		document.form1.submit();
	}

//-->
</script>
</head>
<body>
<!-- Start Content Title -->
<div>
	<H3>사용자 권한 관리</H3>
</div>
<!-- End Content Title -->
<form name="form1" method="post">
<table>
	<caption>
	</caption>
	<colgroup>
		<col width="27%">
		<col width="10%">
		<col width="27%">
		<col width="10%">
		<col width="26%">
	</colgroup>
	<thead>
	</thead>
	<tbody>
		<tr>
			<td>
				사용자 그룹<p/>
				<select name="selectedGroupId" size="10" style="width:200px;" onChange="loadData();">
					<c:forEach items="${userGroups}" var="userGroup">
						<c:choose>		
							<c:when test="${userGroup.groupId == selectedGroupId}">
								<option value="${userGroup.groupId }" selected>${userGroup.groupName }[${userGroup.role }]</option>
							</c:when>
							<c:otherwise>
								<option value="${userGroup.groupId }">${userGroup.groupName }[${userGroup.role }]</option>
							</c:otherwise>
						</c:choose>						
					</c:forEach>
				</select>
			</td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td>
				가용 사용자 목록<p/>
				<select id="availableUserId" name="availableUserId" multiple size="10" style="width:200px;" onDblClick="moveElement(this, selectedUserId);">
					<c:forEach items="${availableUsers}" var="availableUser">		
						<option value="${availableUser.userId }">${availableUser.username }[소속]</option>
					</c:forEach>
				</select>
			</td>
			<td>
				<input type="button" value="선택" onClick="moveElement(availableUserId, selectedUserId);"/><p/>
				<input type="button" value="제거" onClick="moveElement(selectedUserId, availableUserId);"/>
			</td>
			<td>
				선택한 사용자 목록<p/>
				<select id="selectedUserId" name="selectedUserId" multiple size="10" style="width:200px" onDblClick="moveElement(this, availableUserId);">
					<c:forEach items="${selectedUsers}" var="selectedUser">		
						<option value="${selectedUser.userId }">${selectedUser.username }[소속]</option>
					</c:forEach>
				</select>
			</td>
		</tr>	
	</tbody>
</table>
</form>
<div>
	<!-- a href="#" onClick="loadData();return false;">조회</a-->
	<a href="#" onClick="saveData();return false;">저장</a>
</div>
</body>
</html>
