<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록form</title>
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
  width: 1200px;
  border: 1px solid;
  border-spacing: 8px;

</style>
</head>
<body>

<form action="libJoin" method="post" enctype="multipart/form-data">

<table align="center">

	<tr><th bgcolor=#e0e0eb>제목</th>
	<td><input type="text" name="noticeSub"/></td></tr>
	<tr><th bgcolor=#e0e0eb>내용</th>
	<td><textarea rows="10" cols="50" name="noticeCon"></textarea></td></tr>

	<tr><th bgcolor=#e0e0eb>첨부파일</th>
	<td><input type="file" name="noticeFile" multiple="multiple"/></td></tr>


	<tr><th colspan="2">
		<input type="submit" value="자료 등록"/>
		<input type="reset" value="조기화"/>
</table>
</form>
</body>
</html>