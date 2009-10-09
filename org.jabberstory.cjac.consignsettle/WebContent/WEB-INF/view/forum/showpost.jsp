<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<script>
$(document).ready(function() {
	$('#saveButton').bind('click', function(event) {
		document.thisform.submit();
	});
});

$(document).ready(function() {
	$('.body').each(function() {
		$(this).css('height', $(this).attr('scrollheight'));
	});
});
</script>
<div id="container">
  <div id="content">
    <div id="content_top">
      <p id="title"> ${forum.name}</p>
    </div>
    <div id="table">
      <table width="100%" cellspacing="0" style="table-layout: fixed">
        <tbody>
          <tr>
            <td width="100px" class="cell_title">제목</td>
            <td colspan="3" class="cell">${post.subject}</td>
          </tr>
          <tr>
            <td width="100" class="cell_title">작성자</td>
            <td class="cell">${post.user.username}</td>
            <td width="100px" class="cell_title">작성일</td>
            <td class="cell" width="200px">${post.createdDate}</td>
          </tr>
          <tr>
            <td class="cell_title">첨부파일</td>
            <td class="cell"  colspan="3">
            	<ul><c:forEach var="file" items="${post.attachments}">
					<li><a href="download?post=${post.id}&file=${file.id}">${file.filename}</a> (${file.filesize} bytes)</li>
					</c:forEach>
				</ul>
			</td>
          </tr>
          <tr>
            <td colspan="4" class="cell_contents"><textarea class="body" readonly style="margin: 0; padding: 0; border:0; width='100%'; overflow: hidden">${post.body}</textarea></td>
          </tr>
        </tbody>
      </table>
    </div>
    <div class="button">
      <div class="b_blue">
        <ul>
          <li><a href="<c:url value="/forum/${forum.id}/list?page=${param.page}" />">목록</a></li>
          <c:if test="${post.prop['canModify']}">
          <li><c:if test="${childrenCount == 0}"><a href="removePost?id=${post.id}&page=${param.page}">삭제</a></c:if></li>
          <li><a href="<c:url value="/forum/${forum.id}/updatePost?id=${post.id}&page=${param.page}" />">수정하기</a></li>
          </c:if>
        </ul>
      </div>
    </div>

	<!-- Reply area -->
	<c:forEach var="child" items="${children}">
    <div id="table">
      <table width="100%" cellspacing="0" style="table-layout: fixed">
        <tbody>
          <c:if test="${not empty child.subject}">
          <tr>
            <td width="100px" class="cell_title">제목</td>
            <td colspan="3" class="cell">${child.subject}</td>
          </tr>
          </c:if>
          <tr>
            <td width="100" class="cell_title">작성자</td>
            <td class="cell">${child.user.username}</td>
            <td width="100px" class="cell_title">작성일</td>
            <td class="cell" width="200px">${child.createdDate}</td>
          </tr>
          <tr>
            <td class="cell_title">첨부파일</td>
            <td class="cell"  colspan="3">
            	<ul><c:forEach var="file" items="${child.attachments}">
					<li><a href="download?post=${child.id}&file=${file.id}">${file.filename}</a> (${file.filesize} bytes)</li>
					</c:forEach>
				</ul>
			</td>
          </tr>
          <tr>
            <td colspan="4" class="cell_contents" style="overflow: auto"><textarea class="body" readonly style="border:0; width='100%'; overflow: auto">${child.body}</textarea></td>
          </tr>
        </tbody>
      </table>
    </div>
    <div class="button">
      <div class="b_blue">
        <ul>
          <li><a href="<c:url value="/forum/${forum.id}/list?page=${param.page}" />">목록보기</a></li>
          <c:if test="${child.prop['canModify']}">
          <li><a href="removePost?id=${child.id}&page=${param.page}">삭제</a></li>
          <li><a href="<c:url value="/forum/${forum.id}/updatePost?id=${child.id}&page=${param.page}" />">수정하기</a></li>
          </c:if>
        </ul>
      </div>
    </div>
	</c:forEach>
	<div style="clear: right"></div>
    <c:if test="${forum.prop['canReply']}">
		<h2>답변하기</h2>
		<div>
			<form name="thisform" action="write" method="post" enctype="multipart/form-data">
				<input type="hidden" name="id" value="${param.id }" />
				<input type="hidden" name="page" value="${param.page }" />
				<div><label>제목</label><input type="text" name="title" class="line_box" style="width:650px" /></div>
				<div><label>내용</label><textarea name="body" style="height:100px; width:650px" ></textarea></div>
				<div><input type="file" name="files" /></div>
			    <div class="button">
			      <div class="b_blue">
			        <ul>
			          <li><a href="#" id="saveButton">저장</a></li>
			        </ul>
			      </div>
			    </div>
			</form>
		</div>
	</c:if>
  </div>
</div>

