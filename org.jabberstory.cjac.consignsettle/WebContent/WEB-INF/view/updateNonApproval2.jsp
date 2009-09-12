<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CJAC</title>
<script type="text/javascript" src="/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
<!--
	window.onload = function()
	{
		CKEDITOR.replace( 'nonApproval2' );
	}

	function saveNonApproval2(){
		document.form1.action = "${pageContext.request.contextPath}/organ/updateNonApproval2";
		document.form1.submit();
	}
	
	function showNonApproval2(){
		document.form1.action = "${pageContext.request.contextPath}/organ/showNonApproval2";
		document.form1.submit();
	}
//-->
</script>
</head>
<body>
<form name="form1" method="post">
<input type="hidden" name="organId" value="${organ.organId}" />

<div id="container">
  <div id="content">
    <div id="content_top">
      <p id="title"> 최종 불인정 내역 등록/수정  : ${organ.subjectGroup.groupName}</p>
      <p id="path"> PATH : 주관기관현황  &#62; 주관기관조회  &#62; <span id="path_b">최종 불인정 내역 등록/수정</span></p>
    </div>
    <div>
		<table width="100%" cellspacing="0">
			<tbody>
				<tr>
					<td colspan="6" style="height:300px">
						<textarea id="nonApproval2" name="nonApproval2">${organ.nonApproval2}</textarea>
					</td>
				</tr>
			</tbody>
		</table>
	</div>	
	<div class="button">
        <div class="b_blue">
          <ul>
            <li><a href="#" onClick="showNonApproval2();return false;">취소</a></li>
            <li><a href="#" onClick="saveNonApproval2();return false;">저장</a></li>
          </ul>
        </div>
      </div>
	
  </div>
</div>
</form>
</body>
</html>
