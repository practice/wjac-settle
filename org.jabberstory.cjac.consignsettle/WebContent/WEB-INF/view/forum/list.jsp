<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script>
$(document).ready(function() {
	var numPages = $('#numPages').text();
	var currentPage = $('#currentPage').text();
	// alert(numPages);
	$('table.paginated').each(function() {
		var $table = $(this);
		var $pager = $('<div class="pager"></div>');
		for (var page = 1; page <= numPages; page++) {
			var pageButton = $('<span class="page-number">' + page + '</span>').appendTo($pager);
			if (pageButton.text() == currentPage)
				pageButton.addClass('active');
			else {
				pageButton.bind('click', { newPage : page }, function(event) {
					location.href = 'list?page=' + event.data['newPage'];
				}).addClass('clickable');	
			}
		}
		$pager.insertAfter($table);
	});
});
</script>
<div id="container">
  <div id="content">
    <div id="content_top">
      <p id="title"> ${forum.name} </p>
    </div>
    <div id="table">
		<c:choose>
			<c:when test="${!isEmptyList}">
				<table id="table" width="100%" class="paginated" style="table-layout: fixed">
					<thead>
						<tr>
							<th>제목</th>
							<th width="80">작성자</th>
							<th width="120">작성일</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="post" items="${posts}">
					<tr>
						<!-- td>${post.id}</td --><td style="text-overflow:ellipsis; overflow: hidden; " class="cell">
							<a href="showpost?id=${post.id}&page=${currentPage}"><nobr>${post.subject}</nobr></a></td>
						<td>${post.user.username}</td>
						<td>${post.createdDate}</td>
					</tr>
					</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
					등록된  글이 없습니다. 첫 번째 글을 <a href="write">작성</a>해 주십시오.
			</c:otherwise>
		</c:choose>
      <table width="100%" cellspacing="0">
        <tfoot>
          <tr>
            <td colspan="8">
            	<a href="#"><img src="${imgpath}/page_first.gif" align="absmiddle"/></a>
            	<a href="#"><img src="${imgpath}/page_pre.gif" align="absmiddle"/></a> 
            	| <a href="#">1</a> 
            	| <a href="#">2</a> | <a href="#">3</a> | <a href="#">4</a> | <a href="#">5</a> | <a href="#">6</a> 
            	| <a href="#">7</a> | <a href="#">8</a> | <a href="#">9</a> | <a href="#">10</a> | 
            	<a href=""><img src="${imgpath}/page_next.gif" align="absmiddle"/></a>
            	<a href="#"><img src="${imgpath}/page_end.gif" align="absmiddle"/></a>
            </td>
          </tr>
        </tfoot>
      </table>
    </div>
    <div class="button">
      <div class="b_blue">
        <ul>
          <li><a href="write">글쓰기</a></li>
        </ul>
      </div>
    </div>
  </div>
</div>
<span id="numPages" style="display: none">${numPages}</span>
<span id="currentPage" style="display: none">${currentPage}</span>	
