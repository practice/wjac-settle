<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>CJAC</title>
<script type="text/javascript">
<!--
	function updateNonApproval1(){
		document.form1.action = "${pageContext.request.contextPath}/organ/updateNonApproval1";
		document.form1.submit();
	}

	function showSubject() {
		document.form1.action = "${pageContext.request.contextPath}/organ/showSubject";
		document.form1.submit();
	}

	function deleteNonApproval1() {
		if(confirm("�����Ͻðڽ��ϱ�?")){
			document.form1.action = "${pageContext.request.contextPath}/organ/deleteNonApproval1";
			document.form1.submit();
		}
	}

	function showCostDetail() {
		document.form1.action = "${pageContext.request.contextPath}/organ/showCostDetail";
		document.form1.submit();
	}

	function showNonApproval1() {
		document.form1.action = "${pageContext.request.contextPath}/organ/showNonApproval1";
		document.form1.submit();
	}

	function showNonApproval2() {
		document.form1.action = "${pageContext.request.contextPath}/organ/showNonApproval2";
		document.form1.submit();
	}
//-->
</script>
</head>
<body>
<form name="form1">
<input type="hidden" name="organId" value="${organ.organId}"/>
<div id="container">
  <div id="content">
    <div id="content_top">
      <p id="title"> 1�� ������ ���� ��ȸ : ${organ.subjectGroup.groupName} </p>
      <p id="path"> PATH : �ְ������Ȳ  &#62; �ְ������ȸ  &#62; <span id="path_b">1�� ������ ���� ��ȸ</span></p>
    </div>
    <div class="button">
      <div class="b_blue">
        <ul>
          <li><a href="#" onClick="showNonApproval2();return false;">���� ������ ����</a></li>
          <li><a href="#" onClick="showNonApproval1();return false;">1�� ������ ����</a></li>
          <li><a href="#" onClick="showCostDetail();return false;">��������</a></li>
        </ul>
      </div>
    </div>
    <br />
    <div id="table">
	<table width="100%" cellspacing="0">
        <tbody>
          <tr>
            <td colspan="6" style="height:300px">
            <c:choose>		
				<c:when test="${organ.nonApproval1 == null || organ.nonApproval1 == ''}">
					��ϵ� 1�� ������ ������ �����ϴ�.
				</c:when>	
				<c:otherwise>			
					${organ.nonApproval1}			
				</c:otherwise>
			</c:choose>
            </td>
          </tr>
        </tbody>
      </table>
      <div class="button">
        <div class="b_blue">
          <ul>
          	<li><a href="#" onClick="alert('�غ���...');return false;">�μ�</a></li>
		    <li><a href="#" onClick="showSubject();return false;">�ְ���� ��Ȳ</a></li>
            <li><a href="#" onClick="deleteNonApproval1();return false;">1�� ������ ���� ����</a></li>
            <li><a href="#" onClick="updateNonApproval1();return false;">1�� ������ ����  ���/����</a></li>
          </ul>
        </div>
      </div>
  </div>
</div>
</div>
</form>
</body>
</html>