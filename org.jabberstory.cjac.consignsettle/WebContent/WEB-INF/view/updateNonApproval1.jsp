<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CJAC</title>
<script type="text/javascript">
<!--
	$(document).ready(function() {
		$('#saveMe').bind('click', function() {
			$('#form1').submit();			
		});
	});

//-->
</script>
</head>
<body>
<form id="form1" name="form1" method="post" enctype="multipart/form-data">
<div id="container">
  <div id="content">
    <div id="content_top">
      <p id="title"> 1차 불인정 내역 등록/수정  : ${organ.subjectGroup.groupName}</p>
      <p id="path"> PATH : 주관기관현황  &#62; 주관기관조회  &#62; <span id="path_b">1차 불인정 내역 등록/수정</span></p>
    </div>
    <div>
		<table width="100%" cellspacing="0">
			<tbody>
				<tr>
		            <td class="cell_title">첨부파일</td>
		            <td class="cell">
		              <ul>
		                <li><input name="file" type="file" value="" class="line_box01"/></li>		            
		              </ul>
		          </tr>
			</tbody>
		</table>
	</div>	
	<div class="button">
        <div class="b_blue">
          <ul>
            <li><a href="<c:url value="/organ/showNonApproval1?organId=${updateNonApproval1.organId }" />">취소</a></li>
            <li><a href="#" id="saveMe">저장</a></li>
          </ul>
        </div>
      </div>
	
  </div>
</div>
</form>
</body>
</html>

