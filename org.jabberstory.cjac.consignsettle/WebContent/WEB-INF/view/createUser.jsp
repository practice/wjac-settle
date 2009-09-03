<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create User</title>
</head>
<body>
<form method="post">
User ID: <input type="text" size="15" name="userId" />
Password: <input type="password" size="15" name="password" />
Confirm password: <input type="password" size="15" name="passwordConfirm" />
User Name: <input type="text" size="15" name="username" />
E-Mail: <input type="text" size="15" name="email" />
Role: <select name="role">
		<option value="">선택</option>
		<option value="A">Admin</option>
		<option value="C">천지회계법인</option>
		<option value="O">전담기관</option>
		<option value="S">주관기관</option>
	</select>
<input type="submit" value="생성" />
</form>
</body>
</html>