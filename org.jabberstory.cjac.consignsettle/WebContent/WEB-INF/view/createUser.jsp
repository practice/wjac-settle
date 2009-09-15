<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
$(document).ready(function() {
	$('#submit').bind('click', function() {
		document.thisform.submit();
	});
});
</script>

<form name="thisform" method="post">
<div id="container">
  <div id="content">
    <div id="content_top">
      <p id="title">사용자등록 </p>
      <p id="path"> PATH : Admin &#62; 사용자관리 &#62;<span id="path_b">사용자등록</span></p>
    </div>
    <br />
	<div id="table">
		<table width="100%" cellspacing="0">
			<tbody>
				<tr>
					<td>
						<ul>
							<li>
								사용자ID <input name="userId" type="text" class="line_box" style="width:100px"/>
							</li>
							<li>
								Password <input name="password" type="password" class="line_box" style="width:100px"/>
							</li>
							<li>
								Confirm Password <input name="passwordConfirm" type="password" class="line_box" style="width:100px"/>
							</li>
							<li>
								사용자명 <input name="username" type="text" class="line_box" style="width:100px"/>
							</li>							
							<li>
								Email <input name="email" type="text" class="line_box" style="width:100px"/>
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
	            <li><a href="#" id="submit">저장</a></li>	            
	          </ul>
	        </div>
	      </div>
		</div>
	</div>
  </div>
</form>
