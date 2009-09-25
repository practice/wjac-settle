<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript">
$(document).ready(function() {
	$('#submit').bind('click', function() {
		$('#createUser').submit();
	});
});
$(document).ready(function(ev) {
	$('#postnumSearch').bind('click', function(ev) {
		window.open('${pageContext.request.contextPath}/organ/zipCodeList?openerZipCode1=' + 'postnum1' + '&openerZipCode2=' + 'postnum2' + '&openerAddr=' + 'address' , '_pop', 'width=400,height=450,history=no,resizable=no,status=no,scrollbars=no,menubar=no');
		ev.preventDefault();
		return false;
	});
});
</script>

<form:form commandName="createUser">
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
					<td class="cell_title" >
						사용자ID					
					</td>
					<td class="cell">
						<input name="userId" type="text" class="line_box" style="width:100px"/><form:errors path="userId" />					
					</td>
				</tr>				
				<tr>
					<td class="cell_title" >
						Password					
					</td>
					<td class="cell">
						<input name="password" type="password" class="line_box" style="width:100px"/><form:errors path="password" />									
					</td>
				</tr>
				<tr>
					<td class="cell_title" >
						Confirm Password					
					</td>
					<td class="cell">
						<input name="passwordConfirm" type="password" class="line_box" style="width:100px"/><form:errors path="passwordConfirm" />					
					</td>
				</tr>				
				<tr>
					<td class="cell_title" >
						사용자명					
					</td>
					<td class="cell">
						 <input name="username" type="text" class="line_box" style="width:100px"/><form:errors path="username" />					
					</td>
				</tr>
				<tr>
					<td class="cell_title" >
						Email 					
					</td>
					<td class="cell">
						<input name="email" type="text" class="line_box" style="width:200px"/><form:errors path="email" />				
					</td>
				</tr>
				<tr>
					<td class="cell_title" >
						연락처 					
					</td>
					<td class="cell">
						<input name="phone1" type="text" class="line_box" style="width:30px" maxlength="4"/><form:errors path="phone1" />
						-					
						<input name="phone2" type="text" class="line_box" style="width:30px" maxlength="4"/><form:errors path="phone2" />
						-
						<input name="phone3" type="text" class="line_box" style="width:30px" maxlength="4"/><form:errors path="phone3" />
					</td>
				</tr>
				<tr>
					<td class="cell_title">주소</td>
		            <td class="cell">
		            	<ul>
			                <li>
			                  	<input type="text" id="postnum1" name="postnum1" class="line_box" style="width:30px" maxlength="3"/><form:errors path="postnum1" />
			                  	-
								<input type="text" id="postnum2" name="postnum2" class="line_box" style="width:30px" maxlength="3"/><form:errors path="postnum2" />&nbsp;
			                </li>
			                <li>
			                  <div class="b_gray">
			                    <ul>
			                      <li><a href="#" id="postnumSearch">우편번호검색</a></li>
			                    </ul>
			                  </div>
			                </li>
			                <li>
			                	&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="address" name="address" class="line_box" style="width:520px"><form:errors path="address" />
			                </li>
			        	</ul>
					</td>
				</tr>				
				<tr>
					<td class="cell_title" >
						사용자그룹 					
					</td>
					<td class="cell">
						<select name="groupId">
							<option value="">선택</option>
							<c:forEach items="${groups}" var="group">
								<c:choose>
									<c:when test="${group.role == 'S'}">
										<option value="${group.groupId }">${group.parentGroup.groupName }/${group.groupName }</option>
									</c:when>
									<c:otherwise>
										<option value="${group.groupId }">${group.groupName }</option>
									</c:otherwise>
								</c:choose>								
							</c:forEach>
						</select>												
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
</form:form>
