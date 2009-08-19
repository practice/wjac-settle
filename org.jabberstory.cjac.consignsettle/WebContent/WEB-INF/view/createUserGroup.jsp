<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create User Group</title>
</head>
<body>
<form method="post">
Group ID: <input type="text" size="15" name="groupId" />
Group Name: <input type="text" size="15" name="name" />
<input type="radio" name="role" value="A">관리자
<input type="radio" name="role" value="C">회계법인
<input type="radio" name="role" value="O">전담기관
<input type="radio" name="role" value="S">주관자
</form>
</body>
</html>