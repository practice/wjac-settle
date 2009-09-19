<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
$(document).ready(function() {
	$('#submit').bind('click', function() {
		document.thisform.submit();
	});
});

// 부모 전담기관을 하나 선택하기.
$(document).ready(function() {
	$('#parentGroup').find('input:eq(0)').attr('checked', 'true');
});

// 주관기관을 생성하는 경우 부모전담기관 목록을 보여줌.
$(document).ready(function() {
	$('.groupRole').bind('click', function() {
		if (this.value == 'S') {
			$('#parentGroup').fadeIn('fast');
		} else {
			$('#parentGroup').fadeOut('fast');
		}
	});
});
</script>

<form name="thisform" method="post">
<div id="container">
  <div id="content">
    <div id="content_top">
      <p id="title">사용자그룹등록 </p>
      <p id="path"> PATH : Admin &#62; 사용자그룹관리 &#62;<span id="path_b">사용자그룹등록</span></p>
    </div>
    <br />
	<div id="table">
		<table width="100%" cellspacing="0">
			<tbody>
				<tr>
					<td>
						<ul>
							<li>
								그룹명 <input name="groupName" type="text" class="line_box" style="width:200px"/>
							</li>
							<li>
								<input class="groupRole" type="radio" name="role" value="A">관리자
								<input class="groupRole" type="radio" name="role" value="C">회계법인
								<input class="groupRole" type="radio" name="role" value="O">전담기관
								<input class="groupRole" type="radio" name="role" value="S" checked="checked">주관기관
							</li>
						</ul>
					</td>
				</tr>
			</tbody>      	
		</table>
		<div id="parentGroup">
		전담기관:
		<c:forEach var="ownerGroup" items="${ownerGroups}">
			<ul>
				<li style="clear: both"><input type="radio" name="parentGroup" value="${ownerGroup.groupId}">${ownerGroup.groupName}</li>
			</ul>
		</c:forEach>
		</div>
		<div class="button">
	        <div class="b_blue">
	          <ul>
	          	<li><a href="<c:url value="/user/userGroupList" />">취소</a></li>
	            <li><a href="#" id="submit">저장</a></li>	            
	          </ul>
	        </div>
	      </div>
		</div>
	</div>
  </div>
</form>
