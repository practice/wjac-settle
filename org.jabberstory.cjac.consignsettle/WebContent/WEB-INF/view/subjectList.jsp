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

	function createSubject(){
		document.form1.action = "${pageContext.request.contextPath}/subject/createSubject";
		document.form1.submit();
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
	<H3>주관기관 현황</H3>
</div>
<!-- End Content Title -->
<!-- div>
	<a href="#" onClick="doOrderedSearch('createDate');return false;">최근등록별보기</a>
	<a href="#" onClick="doOrderedSearch('');return false;">주관기관별보기</a>
</div-->
<!-- Start Content Area -->	
<div>
	<table cellspacing="0" cellpadding="0" class="">
		<caption>
		</caption>
		<colgroup>
			<col width="10%">
			<col width="40%">
			<col width="40%">
			<col width="10%">
		</colgroup>
		<thead>
			<tr>
				<th scope="col" class="">번호</th>
				<th scope="col" class="">전담기관명</th>
				<th scope="col" class="">주관기관명</th>
				<th scope="col" class="">상세보기</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>		
				<c:when test="${pagingList.totalCount == 0}">
					<tr>
						<td class="" colspan="4">검색 결과가 없습니다.</td>
					</tr>
				</c:when>	
				<c:otherwise>
					<c:forEach items="${pagingList.items}" var="organ" varStatus="status">		
						<tr>
							<td class="">${(pagingList.currentPage - 1) * 10 + status.count}</td>
							<td class="">${organ.ownerGroup.groupName}</td>
							<td class="">${organ.subjectGroup.groupName}</td>
							<td class=""><a href="#" onClick="showSubject('${organ.organId}');return false;">상세보기</a></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>	
<!-- End Content Area -->
</div>		
<div>
	<a href="#" onClick="createSubject();return false;">주관기관생성</a>
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