<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>CJAC</title>
<script type="text/javascript">
<!--
	function updateCostDetail(){
		document.form1.action = "${pageContext.request.contextPath}/organ/updateCostDetail";
		document.form1.submit();
	}

	function showSubject() {
		document.form1.action = "${pageContext.request.contextPath}/organ/showSubject";
		document.form1.submit();
	}

	function deleteCostDetail() {
		if(confirm("�����Ͻðڽ��ϱ�?")){
			document.form1.action = "${pageContext.request.contextPath}/organ/deleteCostDetail";
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
      <p id="title"> ����� ���� ��ȸ : ${organ.subjectGroup.groupName} </p>
      <p id="path"> PATH : �ְ������Ȳ  &#62; �ְ������ȸ  &#62; <span id="path_b">����� ���� ��ȸ</span></p>
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
				<c:when test="${organ.costDetail == null || organ.costDetail == ''}">
					��ϵ� ���������� �����ϴ�.
				</c:when>	
				<c:otherwise>			
					${organ.costDetail}			
				</c:otherwise>
			</c:choose>
            </td>
          </tr>
          <tr>
            <td class="cell_title" width="100">����ܾ�</td>
            <td class="cell">${organ.currentAccount}�� </td>
            <td class="cell_title" width="100">�߻�����(�ܾ�)</td>
            <td class="cell">${organ.currentInterest}�� </td>
            <td class="cell_title" width="100">��������</td>
            <td class="cell">${organ.currentNonPropriety}�� </td>
          </tr>
        </tbody>
      </table>
      <div class="button">
        <div class="b_blue">
          <ul>
          	<li><a href="#" onClick="alert('�غ���...');return false;">�μ�</a></li>
		    <li><a href="#" onClick="showSubject();return false;">�ְ���� ��Ȳ</a></li>
            <li><a href="#" onClick="deleteCostDetail();return false;">�������� ����</a></li>
            <li><a href="#" onClick="updateCostDetail();return false;">�������� ���/����</a></li>
          </ul>
        </div>
      </div>
      
    </div>
  </div>
</div>
</form>
</body>
</html>