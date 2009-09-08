<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<title>Simple Forum</title>
<style> 
<!--
label.write {
	width:100px;  
	float:left;  
	margin-right:10px;  
	text-align:right;  
}

input {
}  
-->
</style>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<h1>Write</h1>

<form method="post" enctype="multipart/form-data">
	<p><label class="write">Title</label><input type="text" name="title" value="${updatePost.title}"/><form:errors path="write.title" /><br>
	</p>
	<p><textarea name="body" cols="80" rows="20"><form:errors path="write.body" />${updatePost.body}</textarea><br/>
	</p>
	<p><input type="submit" value="Save" /><br>
</form>

</body>
</html>
