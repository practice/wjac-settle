<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="caf" uri="/WEB-INF/tlds/cjac-tags.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CJAC</title>
<link href="${pageContext.request.contextPath}/basic.css" rel="stylesheet" type="text/css" />
<script language="javascript">
<!--
	function doSearch(pageNo){
		document.form1.pageNo.value = pageNo;
		document.form1.action = "${pageContext.request.contextPath}/organ/zipCodeList";
		document.form1.submit();
	}
//-->
</script>
</head>
<body>
<form name="form1" method="post">
<input type="hidden" name="pageNo">
<div id="popup_top">
  <div id="title"> 우편번호 검색 </div>
</div><br />
<div id="popup_container">
  <ul>
    <li>
      <input name="keyword" type="text" value="${keyword}" class="line_box" style="width:200px"/>
    </li>
    <li>
      <div class="b_gray">
        <ul>
          <li><a href="#" onClick="doSearch('1');return false;">우편번호검색</a></li>
        </ul>
      </div>
    </li>
  </ul>
  <br />
  <br />
  <div id="table">
  	<table width="350" cellspacing="0">      	
      	<thead>
        	<tr>
          		<th width="80">우편번호</th>
          		<th width="270">주소 
        	</tr>
      	</thead>	 
      	<c:choose>	
	      	<c:when test="${zipCodes.totalCount == null || zipCodes.totalCount == 0}">			      
		      	<tbody>		
					<tr>
						<td colspan="2">검색 결과가 없습니다.</td>
					</tr>
				</tbody>		    	
			</c:when>	
			<c:otherwise>
			   	<tbody>	
				<c:forEach items="${zipCodes.items}" var="zipCode" varStatus="status">
					<tr>
						<td>${fn:substring(zipCode.zipcode,0,3)}-${fn:substring(zipCode.zipcode,3,6)}</td>				
						<td>${zipCode.addr}</td>
					</tr>
				</c:forEach>
				</tbody>
				<tfoot>				
			          <tr>
			            <td colspan="2">
							<caf:paging formTagName="form1"	searchFunctionName="doSearch" pagingList="${zipCodes}" pageNoTagName="pageNo" />
						</td>
			          </tr>
		        </tfoot>
			</c:otherwise>
		</c:choose>  
		</table>      
  	</div>
</div>
<div id="popup_footer"> </div>
</form>
</body>
</html>