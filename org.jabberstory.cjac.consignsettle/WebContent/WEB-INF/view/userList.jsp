<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="caf" uri="/WEB-INF/tlds/cjac-tags.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CJAC</title>
<script>
	function doSearch(pageNo){
		document.form1.pageNo.value = pageNo;
		document.form1.action = "${pageContext.request.contextPath}/user/list";
		document.form1.submit();
	}

	$(document).ready(function(){
		$('#doKeywordSearch').bind('click', function(ev) {
			doSearch(1);
		});
	});	
</script>
</head>
<body>
<form id="form1" name="form1" method="post">
<input type="hidden" name="pageNo" value="1">
<div id="container">
  <div id="content">
    <div id="content_top">
      <p id="title">사용자관리 </p>
      <p id="path"> PATH : Admin &#62; <span id="path_b">사용자관리</span></p>
    </div>
    <div class="button">
      <div class="b_blue">
        <ul>          
	        <li><a href="<c:url value="/user/userGroupList" />">사용자그룹관리</a></li>          
	        <li><a href="<c:url value="/user/list" />">사용자관리</a></li>	        
  		</ul>
      </div>
    </div>
    <br />
    <div>
      <ul>
	    <li>
	      <input name="userQuery" type="text" value="${userQuery}" class="line_box" style="width:100px"/>
	    </li>
	    <li>
	      <div class="b_gray">
	        <ul>
	          <li><a href="#" id="doKeywordSearch">검색</a></li>
	        </ul>
	      </div>
	    </li>
	  </ul>
	<div>  
	<br />  
	<div id="table">
		<table width="100%" cellspacing="0">      	
	      	<thead>
	        	<tr>
	        		<th>번호</th>
	          		<th>사용자 ID</th>
	          		<th>사용자명</th>
	          		<th>Email</th>
	          		<th>그룹명</th>
	        	</tr>
	      	</thead>	
	      	<tbody> 
		      	<c:choose>	
			      	<c:when test="${pagingList.totalCount == 0}">
				      	<tr>
							<td colspan="5">검색 결과가 없습니다.</td>
						</tr>		    	
					</c:when>	
					<c:otherwise>	
					   <c:forEach items="${pagingList.items}" var="user" varStatus="status">
							<tr>
								<td>${(pagingList.currentPage - 1) * 10 + status.count}</td>
								<td>${user.userId}</td>
								<td>
									<a href="<c:url value="/user/updateUser?userId=${user.userId}" />">${user.username}</a>
								</td>
								<td>${user.email}</td>
								<td>
									<c:choose>
										<c:when test="${user.userGroup.role == 'S'}">
											${user.userGroup.parentGroup.groupName}/${user.userGroup.groupName}
										</c:when>
										<c:otherwise>
											${user.userGroup.groupName}
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</c:forEach>				
					</c:otherwise>
				</c:choose> 
			</tbody>	 
			<tfoot>				
	          <tr>
	            <td colspan="5">		
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
          <li><a href="<c:url value="/user/createUser" />">사용자등록</a></li>
        </ul>
      </div>
    </div>
  </div>
</div>
</form>
</body>
</html>
