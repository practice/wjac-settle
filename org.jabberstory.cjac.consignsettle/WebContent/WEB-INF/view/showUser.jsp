<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User List</title>
</head>
<body>
<div>
User Info: ${user.userId}, ${user.username}, ${user.email}, <a href="showUserGroup?groupId=${user.group.groupId }">${user.group.name}</a>
</div>
<div>
<a href="list">User / Group Home</a>, <a href="updateUser?userId=${user.userId}">Edit</a>,
<a href="removeUser?userId=${user.userId}">Remove</a> 
</div>
</body>
</html>