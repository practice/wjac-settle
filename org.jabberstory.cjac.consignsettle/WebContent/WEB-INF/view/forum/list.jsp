<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script>
$(document).ready(function() {
	var numPages = $('#numPages').text();
	var currentPage = $('#currentPage').text();
	$('table.paginated').each(function() {
		var $table = $(this);
		var $pager = $('<div class="pager"></div>');
		// first page.
		$toFirst = $('<img src="${imgpath}/page_first.gif" align="absmiddle"/>').appendTo($pager);
		$toFirst.bind('click', function() {
			location.href = 'list?page=1';
		}).addClass('clickable');
		// pre first.
		$preFirst = $('<img src="${imgpath}/page_pre.gif" align="absmiddle"/>').appendTo($pager);
		$preFirst.bind('click', function() {
			location.href = 'list?page=' + getPreFirst(currentPage);
		}).addClass('clickable');
		// each page.
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
		// next first.
		$preFirst = $('<img src="${imgpath}/page_next.gif" align="absmiddle"/>').appendTo($pager);
		$preFirst.bind('click', function() {
			location.href = 'list?page=' + getNextFirst(currentPage, numPages);
		}).addClass('clickable');
		// last page.
		$toLast = $('<img src="${imgpath}/page_end.gif" align="absmiddle"/>').appendTo($pager);
		$toLast.bind('click', function() {
			location.href = 'list?page=' + numPages;
		}).addClass('clickable');
	});
});

function getPreFirst(current) {
	var v = current - 10;
	v = Math.floor(v / 10) * 10; // 나머지를  없애고,
	if (v < 0)
		v = 0;
	v++;
	return v;
}
function getNextFirst(current, lastPage) {
	var v = parseInt(current) + 10;
	v = Math.floor(v / 10) * 10; // 나머지를  없애고,
	if (v < 0)
		v = 0;
	v++;
	if (v > lastPage)
		v = lastPage;
	return v;
}

</script>
<div id="container">
  <div id="content">
    <div id="content_top">
      <p id="title"> ${userGroup.groupName} ${forum.name} </p>
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
