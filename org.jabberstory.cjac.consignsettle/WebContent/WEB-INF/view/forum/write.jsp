<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<title>Simple Forum</title>
</head>
<body>
<h1>Write</h1>

<form action="write" method="post" enctype="multipart/form-data">
	Title: <input type="text" name="title" /><form:errors path="write.title" /><br>
	<textarea name="body" cols="80" rows="20"><form:errors path="write.body" /></textarea><br/>
	<input type="file" name="file0" />
	<input type="file" name="file1" />
	<p><input type="submit" value="Save" /><br>
</form>

</body>
</html>
