<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script>
$(document).ready(function() {
	$('#saveButton').bind('click', function(event) {
		document.thisform.submit();
	});
});
</script>
<div id="container">
  <div id="content">
    <div id="content_top">
      <p id="title"> ${forum.name } </p>
    </div>
    <div id="table">
		<form name="thisform" method="post" enctype="multipart/form-data">
      <table width="100%" cellspacing="0">
        <tbody>
          <tr>
            <td class="cell_title">제목</td>
            <td class="cell"><input name="title" type="text" value="${updatePost.title}" class="line_box" style="width:650px"/><form:errors path="write.title" /></td>
          </tr>
          <tr>
            <td class="cell_title">내용</td>
            <td class="cell">
                <textarea name="body" id="textarea" style="height:300px"><form:errors path="write.body" />${updatePost.body}</textarea>
              </td>
          </tr>
          <tr>
            <td class="cell_title">비밀글</td>
            <td class="cell"><input type="checkbox" name="hiddenCheckbox" value="Y" <c:if test="${updatePost.hidden}">checked</c:if>></input> (회계법인 이외의 다른 기관은 볼 수 없습니다)</td>
          </tr>
        </tbody>
      </table>
      </form>
    </div>
    <div class="button">
      <div class="b_blue">
        <ul>
          <li><a href="<c:url value='/forum/${forum.id}/showpost?id=${param.id}&page=${param.page}' />">취소</a></li>
          <li><a href="#" id="saveButton">등록하기</a></li>
        </ul>
      </div>
    </div>
    <div id="table"></div>
  </div>
</div>
