<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>위탁정산시스템</title>
</head>
<body>
<c:if test="${not empty param.error}">
	<font color="red">
	Login error. <br />
	Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
	</font>
</c:if>
<form method="post" action="j_spring_security_check">
User ID: <input type="text" size="15" name="j_username" />
Password: <input type="password" size="15" name="j_password" />
<input type="submit" value="Login" />
</form>
</body>
</html>