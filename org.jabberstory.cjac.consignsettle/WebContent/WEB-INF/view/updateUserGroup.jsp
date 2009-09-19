<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script>
$(document).ready(function() {
	$('#submit').bind('click', function() {
		document.thisform.submit();
	});
});

// 부모 전담기관을 하나 선택하기.
$(document).ready(function() {
	var parents = $('#parentGroup').find('input');
	var hasSelection;
	for (var i=0; i < parents.length; i++) {
		if (parents[i].checked) {
			hasSelection = true;
			break;
		}
	}
	if (!hasSelection) {
		$('#parentGroup').find('input:eq(0)').attr('checked', 'true');
	}
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

// 처음에 주관기관이 선택되어 있지 않으면 부모 전담기관 선택을 숨긴다.
$(document).ready(function() {
	var roles = $('.groupRole');
	for (var i=0; i < roles.length; i++) {
		if (roles[i].value != 'S' && roles[i].checked) {
			$('#parentGroup').hide();
		}
	}
});
</script>

<form name="thisform" method="post">
<div id="container">
  <div id="content">
    <div id="content_top">
      <p id="title">사용자그룹수정 </p>
      <p id="path"> PATH : Admin &#62; 사용자그룹관리 &#62;<span id="path_b">사용자그룹수정</span></p>
    </div>
    <br />
	<div id="table">
		<table width="100%" cellspacing="0">
			<tbody>
				<tr>
					<td>
						<ul>
							<li>
								그룹명 <input name="groupName" type="text" value="${updateUserGroup.groupName }" class="line_box" style="width:200px"/>
							</li>
							<li>
								<form:radiobuttons cssClass="groupRole" items="${availableRoles}" path="updateUserGroup.role" />
							</li>
						</ul>
					</td>
				</tr>
			</tbody>      	
		</table>
		<div id="parentGroup">
		전담기관:
		<form:radiobuttons cssClass="parent" items="${ownerGroups}" path="updateUserGroup.parentGroup"/>
		</div>
		<div class="button">
	        <div class="b_blue">
	          <ul>
	          	<li><a href="<c:url value="/user/userGroupList" />">취소</a></li>
	          	<li><a href="<c:url value="/user/removeUserGroup?groupId=${updateUserGroup.groupId }" />">삭제</a></li>
	            <li><a href="#" id="submit">저장</a></li>	            
	          </ul>
	        </div>
	      </div>
		</div>
	</div>
  </div>
</form>
