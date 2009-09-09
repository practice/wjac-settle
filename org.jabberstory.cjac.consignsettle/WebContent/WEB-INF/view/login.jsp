<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>천지회계법인 위탁정산 시스템</title>
<style type="text/css">
<!--
* {
	font-family:"돋움";
	font-size:11px;
	color: #666666; 
	line-height:18px;
	margin:0;
	border:0;
}

.loginerror {
	color: red;
}

input {
	border: 1px  #CCCCCC solid;
}

.logininput {
	width:100px;
	height:14px;
	border: 1px #CCCCCC solid;
	background-color:#d3e0fd;
	color:#6b7896;
	padding:2px;
}
-->
</style>
</head>
<body background="img/index_bg.jpg" style="background-repeat:repeat-x" leftmargin="0" topmargin="0">
<center><form method="post" action="j_spring_security_check">
  <table width="765" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td><img src="img/index.jpg" width="765" height="404" /></td>
    </tr>
    <tr>
      <td align="right"><table border="0" cellspacing="3" cellpadding="0">
          <tr>
            <td><input name="j_username" type="text" class="logininput" />
            </td>
            <td><input name="j_password" type="text" class="logininput"  /></td>
            <td><input type="submit" value="로그인" /><a href="#"><!-- img src="img/btn_login.gif" width="55" height="21" border="0" /--></a></td>
            <td><a href="#"><img src="img/btn_toadmin.gif" width="55" height="21"  border="0"/></a></td>
          </tr>
      	  <tr>
      	  	<td colspan="4"><c:if test="${not empty param.error}"><span class="loginerror">Login error.<br/>
      	  		Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</span></c:if>
      	  	</td>
      	  </tr>
        </table></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="1px" bgcolor="#f2f2f2"></td>
    </tr>
    <tr>
      <td height="70" align="center"><table border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="180"><img src="img/footer.jpg" width="149" height="28" /></td>
            <td style="text-align:left">Copyright ⓒ CHEON JI ACCOUNTING Corp. All rights Reserved<br />
              서울특별시 서초구 서초동 1537-1 개념원리빌딩 Tel.02-3700-2200 Fax.02-508-0540</td>
          </tr>
        </table></td>
    </tr>
  </table>
</form></center>
</body>
</html>
