<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../include/includeTags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap');
*{text-decoration:none;
  color: black;
}
body {
  font-family: 'Noto Sans KR', sans-serif;
}
table{
  font-size: 15px/1;
  width: 500px;
  border: 1px solid;
  border-spacing: 8px;
}
</style>
</head>
<body>
<form action="findPasswordPro" method="post" name="frm">
<h2 align="center">비밀번호 찾기</h2>
<table align="center">
	<tr><th>아이디</th>  
		<td><input type="text" name="memId"/>&nbsp;&nbsp;${errMemId }</td></tr>		   
	<tr><th>이메일</th>     
		<td><input type="email" name="memEmail"/>&nbsp;&nbsp;${errEmail }</td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="비밀번호 찾기"></td></tr>
</table>
</form>
</body>
</html>