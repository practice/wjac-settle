<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>FCKeditor - Sample</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="robots" content="noindex, nofollow">
<script type="text/javascript" src="/fckeditor/fckeditor.js"></script>
<script type="text/javascript">
window.onload = function()
{
var oFCKeditor = new FCKeditor( 'MyTextarea' ) ;
oFCKeditor.BasePath = "/fckeditor/" ;
oFCKeditor.ReplaceTextarea() ;
}
</script>
</head>
<body>
<textarea id="MyTextarea" name="MyTextarea">This is <b>the</b> initial value.</textarea>
</body>
</html>
