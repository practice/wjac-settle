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
      <p id="title"> 전담기관 게시판 리스트 </p>
    </div>
    <div id="table">
		<c:choose>
			<c:when test="${!isEmptyList}">
				<table id="table" width="100%" class="paginated" style="table-layout: fixed">
					<thead>
						<tr>
							<th>전담기관</th>
							<th>게시판</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="forum" items="${forums}">
					<tr>
						<td>${forum.prop["userGroup"].groupName}</td>
						<td style="text-overflow:ellipsis; overflow: hidden; " class="cell">
							<a href="<c:url value="/forum/${forum.id}/list" />"><nobr>${forum.name}</nobr></a></td>
					</tr>
					</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
					전담기관이 없습니다. 전담기관을 만들면, 각 전담기관별 게시판을 볼 수 있습니다.
			</c:otherwise>
		</c:choose>
    </div>
  </div>
</div>
<span id="numPages" style="display: none">${numPages}</span>
<span id="currentPage" style="display: none">${currentPage}</span>	
