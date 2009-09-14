<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CJAC</title>
</head>
<body>
<form method="post">
<div id="container">
  <div id="content">
    <div id="content_top">
      <p id="title">사용자수정 </p>
      <p id="path"> PATH : Admin &#62; 사용자관리 &#62;<span id="path_b">사용자수정</span></p>
    </div>
    <br />
	<div id="table">
		<table width="100%" cellspacing="0">
			<tbody>
				<tr>
					<td>
						<ul>
							<li>
								사용자ID : ${updateUser.userId } &nbsp;
							</li>
							<li>
								Password <input name="password" type="password" value="${updateUser.password }" class="line_box" style="width:100px"/>
							</li>
							<li>
								Confirm Password <input name="passwordConfirm" type="password" value="${updateUser.passwordConfirm }"class="line_box" style="width:100px"/>
							</li>
							<li>
								사용자명 <input name="username" type="text" value="${updateUser.username }"class="line_box" style="width:100px"/>
							</li>							
							<li>
								Email <input name="email" type="text" value="${updateUser.email }"class="line_box" style="width:100px"/>
							</li>
						</ul>
					</td>
				</tr>				
			</tbody>      	
		</table>
		<div class="button">
	        <div class="b_blue">
	          <ul>
	          	<li><a href="<c:url value="/user/list" />">취소</a></li>
	          	<li><a href="<c:url value="/user/removeUser?userId=${updateUser.userId }" />">삭제</a></li>
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