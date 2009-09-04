<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Forum</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" type="text/css" media="screen" charset="utf-8" />
<script src="${pageContext.request.contextPath}/jquery-1.2.6.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/tables.js" type="text/javascript"></script>
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
		$pager.insertBefore($table);
	});
});
</script>
</head>
<body>
<h1>Simple Forum</h1>
<c:choose>
	<c:when test="${!isEmptyList}">
		<div id="wrapper"><div id="container"><div id="content">
		<table width="800" class="paginated" style="table-layout: fixed">
			<thead>
			<tr>
			<th width="30">ID</th><th width="500">Title</th><th width="100">Author</th><th>Date</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="post" items="${posts}">
			<tr>
				<td>${post.id}</td><td style="text-overflow:ellipsis; overflow: hidden; ">
					<a href="showpost?id=${post.id}"><nobr>${post.subject}</nobr></a></td>
				<td>${post.user.username}</td>
				<td>${post.createdDate}</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		</div></div></div>
		<span id="numPages" style="display: none">${numPages}</span>
		<span id="currentPage" style="display: none">${currentPage}</span>	
	</c:when>
	<c:otherwise>
			등록된  글이 없어부러~ 이런... 썅~
	</c:otherwise>
</c:choose>
<p><a href="write">Write</a>
</body>
</html>
