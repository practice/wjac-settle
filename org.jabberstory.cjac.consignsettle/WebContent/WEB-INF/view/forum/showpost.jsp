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
<table>
<c:forEach var="file" items="${post.attachments}">
<tr>
	<td><a href="download?post=${post.id}&file=${file.id}">${file.filename}</a></td>
	<td>${file.filesize} bytes</td>
</tr>
</c:forEach>
</table>
</body>
</html>
