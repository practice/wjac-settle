<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<html>
<head>
<title>Simple Forum</title>
</head>
<body>

<p>ID: ${post.id }
<p>Author: ${post.user.username }</p>
<p>Subject: ${post.subject }
<p>Body: ${post.body }</p>
<p>At: ${post.createdDate }</p>
<p>Attachments</p>
<ul><c:forEach var="file" items="${post.attachments}">
	<li><a href="download?post=${post.id}&file=${file.id}">${file.filename}</a> ${file.filesize} bytes</li>
</c:forEach>
</ul>
<a href="list?page=${param.page}">List</a>, <a href="updatePost?id=${post.id}">수정</a>
<hr/>
<c:forEach var="child" items="${children}">
<p>ID: ${child.id }
<p>Author: ${child.user.username }</p>
<p>Subject: ${child.subject }
<p>Body: ${child.body }</p>
<p>At: ${child.createdDate }</p>
<p>Attachments</p>

<ul><c:forEach var="file" items="${child.attachments}">
	<li><a href="download?post=${child.id}&file=${file.id}">${file.filename}</a> ${file.filesize} bytes</li>
</c:forEach>
</ul>
</c:forEach>

<form action="write" method="post" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${param.id }" />
	<div><label>제목</label><input type="text" name="subject" /></div>
	<div><textarea name="body" rows="10" cols="80"></textarea></div>
	<div><input type="file" name="files" /></div>
	<div><input type="submit" value="Reply" /></div>
</form>
</body>
</html>
