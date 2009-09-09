<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create User Group</title>
</head>
<body>
<form method="post">
Group ID: ${updateUserGroup.groupId }
Group Name: <input type="text" size="15" name="groupName" value="${updateUserGroup.groupName }"/>
<form:radiobuttons items="${availableRoles}" path="updateUserGroup.role" />
<input type="submit" value="Save" />
</form>
</body>
</html>