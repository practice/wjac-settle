<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create User Group</title>
</head>
<body>
<form method="post">
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
								<input type="radio" name="role" value="A">관리자
								<input type="radio" name="role" value="C">회계법인
								<input type="radio" name="role" value="O">전담기관
								<input type="radio" name="role" value="S" checked="checked">주관기관
							</li>
						</ul>
					</td>
				</tr>
			</tbody>      	
		</table>
		<div class="button">
	        <div class="b_blue">
	          <ul>
	          	<li><a href="<c:url value="/user/userGroupList" />">취소</a></li>
	            <li><a href="#" onClick="submit();return false;">저장</a></li>	            
	          </ul>
	        </div>
	      </div>
		</div>
	</div>
  </div>
</form>
</body>
</html>