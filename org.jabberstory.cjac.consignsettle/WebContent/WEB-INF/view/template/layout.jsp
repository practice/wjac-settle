<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" type="text/css" media="screen" charset="utf-8" />
<script src="${pageContext.request.contextPath}/jquery-1.2.6.js" type="text/javascript"></script>
<tiles:importAttribute name="jsfile" ignore="true"/>
<c:choose>
	<c:when test="${not empty pageScope.jsfile}"><script src="${pageContext.request.contextPath}/${pageScope.jsfile}" type="text/javascript"></script>
	</c:when>
</c:choose>

</head>
<body>
<tiles:insertAttribute name="header" />
<hr />
<tiles:insertAttribute name="body" />
<hr/>
<tiles:insertAttribute name="footer" />
</body>
</html>
