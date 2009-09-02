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
<form method="post">사용자 검색<input type="text" size="10" name="userQuery"><input type="submit" value="검색"></form>
<form method="post">사용자그룹 검색<input type="text" size="10" name="groupQuery"><input type="submit" value="검색"></form>
<div id="groupList">
<c:choose>
	<c:when test="${groupCount > 0}">
		<table width="800" class="paginated" style="table-layout: fixed">
			<thead>
			<tr>
			<th width="30">Group ID</th><th width="500">Group Name</th><th width="100">Role</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="group" items="${groups}">
			<tr>
				<td>${group.groupId}</td><td style="text-overflow:ellipsis; overflow: hidden; ">
					<a href="showUserGroup?groupId=${group.groupId}"><nobr>${group.name}</nobr></a></td>
				<td>${group.role}</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		<span id="numPages" style="display: none">${numPages}</span>
		<span id="currentPage" style="display: none">${currentPage}</span>	
	</c:when>
	<c:when test="${groupCount == 0}">
			검색 결과가 없습니다.
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>
</div>
<div id="userList">
<c:choose>
	<c:when test="${userCount > 0}">
		<table width="800" class="paginated" style="table-layout: fixed">
			<thead>
			<tr>
			<th width="30">User ID</th><th width="500">User Name</th><th width="100">E-Mail</th><th width="100">Group</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.userId}</td><td style="text-overflow:ellipsis; overflow: hidden; ">
					<a href="showUser?userId=${user.userId}"><nobr>${user.username}</nobr></a></td>
				<td>${user.email}</td>
				<td>-</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		<span id="numPages" style="display: none">${numPages}</span>
		<span id="currentPage" style="display: none">${currentPage}</span>	
	</c:when>
	<c:when test="${userCount == 0}">
			검색 결과가 없습니다.
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>
</div>
</div>
<div>
<a href="createUser">Create User</a>, <a href="createUserGroup">Create User Group</a>
</div>

<div><a href="<c:url value="/j_spring_security_logout" />">Logout</a>
</div>
</body>
</html>