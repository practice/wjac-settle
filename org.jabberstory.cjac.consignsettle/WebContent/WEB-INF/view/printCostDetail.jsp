<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<title>CJAC</title>
<link href="${pageContext.request.contextPath}/basic.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	.title_pop {
	    float:left;
		font-size:12px;
		font-weight:bold;
		padding:5px 0 10 5px;
	}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-1.2.6.js"></script>
<script>
$(document).ready(function() {
	$("li").addClass("title_pop");
	window.print();
});
	
</script>
</head>
<body>
<form name="form1">
<div id="popup_top"> 
  <div id="title"> 사업비 사용 명세 조회 </div>
</div>
<br />
<div id="popup_container">
  <div>
    <ul>
      <li>전담기관: </li>
      <li>${organ.subjectGroup.parentGroup.groupName}</li>      
    </ul>
   </div>
   <br />
   <div>
    <ul>
      <li>주관기관: </li>
      <li>${organ.subjectGroup.groupName}</li>      
    </ul>
   </div>
   <br />
   <div>
    <ul>
      <li>사업명: </li>
      <li>${organ.businessName}</li>      
    </ul>
   </div>
   <br />
   <div>
    <ul>
      <li>과제명: </li>
      <li>${organ.projectName}</li>      
    </ul>
   </div>  
  <br />
  <div id="table">
  	<c:choose>		
		<c:when test="${organ.costDetail == null || organ.costDetail == ''}">
			등록된 사업비사용명세가 없습니다.
		</c:when>	
		<c:otherwise>			
			${organ.costDetail}			
		</c:otherwise>
	</c:choose>
  </div>
</div>
</form>
</body>
</html>