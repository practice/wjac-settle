<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
<!--
	function createCostDetail(){
		document.form1.action = "${pageContext.request.contextPath}/subject/createCostDetail";
		document.form1.submit();
	}

	function editCostDetail() {
		document.form1.action = "${pageContext.request.contextPath}/subject/editCostDetail";
		document.form1.submit();
	}

	function showSubject() {
		document.form1.action = "${pageContext.request.contextPath}/subject/showSubject";
		document.form1.submit();
	}

	function deleteSubject() {
		if(confirm("�����Ͻðڽ��ϱ�?")){
			document.form1.action = "${pageContext.request.contextPath}/subject/deleteCostDetail";
			document.form1.submit();
		}
	}
//-->
</script>
</head>
<body>
<form name="form1">
<input type="text" name="subjectId" value="${subjectId}"/>"
<div>
	���������� �����ϴ�.
</div>
</form>
<div>
	<a href="#" onClick="createCostDetail();return false;">�������� ����</a>
	<a href="#" onClick="editCostDetail();return false;">����</a>
	<a href="#" onClick="deleteCostDetail();return false;">����</a>
	<a href="#" onClick="showSubject();return false;">�ְ���� ��Ȳ</a>
</div>
</body>
</html>