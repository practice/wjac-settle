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
		document.form1.action = "${pageContext.request.contextPath}/organ/subjectList";
		document.form1.submit();
	}

	function doOrderedSearch(sortColumn){
		document.form1.sortColumn.value = sortColumn;
		doSearch(1);
	}

	function createSubject(){
		document.form1.action = "${pageContext.request.contextPath}/organ/createSubject";
		document.form1.submit();
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
      <p id="title"> 주관기관목록 </p>
      <p id="path"> PATH : 주관기관현황 &#62; <span id="path_b">주관기관목록</span></p>
    </div>
    <div class="button">
      <div class="b_blue">
        <ul>
          <li><a href="#">주관기관별 보기</a></li>
          <li><a href="#">최근등록순 보기</a></li>
        </ul>
      </div>
    </div>
	<div id="table">
		<table width="100%" cellspacing="0">
			<colgroup>
				<col id="select" />
		        <col id="number" />
		        <col id="title" />
		        <col id="date" />
		        <col id="preview" />
			</colgroup>
			<thead>
				<tr>
					<th width="40">번호</th>
					<th width="90">전담기관</th>
					<th width="90">주관기관</th>
					<th width="150">사업명</th>
					<th>과제명</th>
					<th width="120">협약일/종료일</th>
					<th width="60">사업내용</th>
					<th width="70">사업비내용</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>		
					<c:when test="${pagingList.totalCount == 0}">
						<tr>
							<td class="" colspan="8">검색 결과가 없습니다.</td>
						</tr>
					</c:when>	
					<c:otherwise>
						<c:forEach items="${pagingList.items}" var="organ" varStatus="status">		
							<tr>
								<td>${(pagingList.currentPage - 1) * 10 + status.count}</td>
								<td>${organ.ownerGroup.groupName}</td>
								<td><a href="#" onClick="showSubject('${organ.organId}');return false;">${organ.subjectGroup.groupName}</a></td>
								<td>${organ.businessName}</td>
								<td>${organ.projectName}</td>
								<td>${organ.contractStartDate}-${organ.contractEndDate}</td>
								<td><input class="b_view" type="button" value="보기" name="preview2" /></td>
								<td><input class="b_view" type="button" value="보기" name="preview3" /></td>
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
	          <li><a href="#" onClick="createSubject();return false;">주관기관입력</a></li>
	        </ul>
	      </div>
	    </div>
	</div>
  </div>
</form>
</body>
</html>