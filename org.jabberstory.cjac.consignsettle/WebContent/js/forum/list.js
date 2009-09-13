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
