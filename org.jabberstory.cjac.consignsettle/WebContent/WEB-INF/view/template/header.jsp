<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div id="header">
  <div>
    <h1 id="logo"><a href="#">천지회계법인 위탁정산시스템</a></h1>
  </div>
  <div id="top_menu"><a href='#'>공지사항</a> | <a href='#'>Q&amp;A</a> | <a href='#'>회계세무 자료실</a></div>
  <div id="gnb">
    <ul>
      <li id="menu01"><a href="<c:url value="/organ/subjectList" />">주관기관 현황</a></li>
      <li id="division">|</li>
      <sec:authorize ifAnyGranted="ROLE_OWNER,ROLE_ADMIN">
		  <li id="menu02"><a href="<c:url value="/organ/settlementList" />">정산진행 현황</a></li>
	      <li id="division">|</li>
      </sec:authorize>
    </ul>
  </div>
  <div id="log">
    <ul>
      <li class="white_11">${user.username} (<sec:authentication property="principal.username" />)님 환영합니다. </li>
      <li>
        <input name="logout" type="button" value="Log-out" class="b_log" onClick="location.href='<c:url value="/j_spring_security_logout" />'"/>
      </li>
      <sec:authorize ifAllGranted="ROLE_ADMIN">
	    <li>
	        <input name="close" type="button" value="Admin"  class="b_close" onClick="location.href='<c:url value="/admin/showUserAuthAdmin" />'"/>
	    </li>
	  </sec:authorize>
    </ul>
  </div>
</div>
