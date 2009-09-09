<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:useAttribute id="list" name="jsfilesList" classname="java.util.List" />
<c:forEach var="jsfileName" items="${list}">
	<script src="${pageContext.request.contextPath}/${jsfileName}" type="text/javascript"></script>
</c:forEach>
