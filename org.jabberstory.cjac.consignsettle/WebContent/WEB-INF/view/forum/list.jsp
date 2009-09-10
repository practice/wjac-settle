<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>




<div id="container">
  <div id="content">
    <div id="content_top">
      <p id="title"> 공지사항 : 원주대학교 </p>
      <p id="path"> PATH : 정산진행현황 &gt; <span id="path_b">현재위치</span></p>
    </div>
    <div class="button">
      <div class="b_blue">
        <ul>
          <li><a href="#">최종 불인정 내역</a></li>
          <li><a href="#">1차 불인정 내역</a></li>
          <li><a href="#">사업비 사용명세</a></li>
          <li><a href="#">사업정보 상세</a></li>
        </ul>
      </div>
    </div>
    <div id="table">
		<c:choose>
			<c:when test="${!isEmptyList}">
				<div id="wrapper"><div id="container"><div id="content">
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
						<!-- td>${post.id}</td --><td style="text-overflow:ellipsis; overflow: hidden; ">
							<a href="showpost?id=${post.id}&page=${currentPage}"><nobr>${post.subject}</nobr></a></td>
						<td>${post.user.username}</td>
						<td>${post.createdDate}</td>
					</tr>
					</c:forEach>
					</tbody>
				</table>
				</div></div></div>
			</c:when>
			<c:otherwise>
					등록된  글이 없습니다. 첫 번째 글을 <a href="write">작성</a>해 주십시오.
			</c:otherwise>
		</c:choose>
      <table width="100%" cellspacing="0">
        <tbody>
          <tr>
            <td>3</td>
            <td>건기평</td>
            <td>원주대학교</td>
            <td class="cell"><a href="#">이런 집행내역 <img src="${imgpath}/icon_new.gif" width="12" height="12" align="absmiddle"/></a></td>
            <td>2009.09.09</td>
            <td>홍길동</td>
            <td><img src="${imgpath}/icon_file.gif" width="13" height="12" /></td>
            <td>1234</td>
          </tr>
          <tr>
            <td>2</td>
            <td>건기평</td>
            <td>원주대학교</td>
            <td class="cell"><a href="#">이런 집행내역</a></td>
            <td>2009.09.09</td>
            <td>홍길동</td>
            <td><img src="${imgpath}/icon_file.gif" width="13" height="12" /></td>
            <td>1234</td>
          </tr>
          <tr>
            <td>1</td>
            <td>건기평</td>
            <td>원주대학교</td>
            <td class="cell"><a href="#">이런 집행내역</a></td>
            <td>2009.09.09</td>
            <td>홍길동</td>
            <td><img src="${imgpath}/icon_file.gif" width="13" height="12" /></td>
            <td>1324</td>
          </tr>
        </tbody>
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
