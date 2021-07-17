<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 작성</title>
<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap');

body {
  font-family: 'Noto Sans KR', sans-serif;
}
table{
  font-size: 15px/1;
  width: 600px;
  border: 1px solid;
  border-spacing: 8px;
}
</style>
</head>
<body>

<h1 align="center">신규 리뷰 작성</h1>
<form action="reviewWrite" method="post" enctype="multipart/form-data">
<input type="hidden" name="prodNum" value="${prodNum }"/>
<input type="hidden" name="purchaseNum" value="${purchaseNum }"/>
<table align="center">
	<tr><th>리뷰작성</th>
		<td align="center"><textarea rows="5" cols="50" name="reviewContent"></textarea></td></tr>		
	<tr><th>파일</th>
		<td align="center"><input type="file" name="reviewImg" /></td></tr>
	<tr align="center"><td colspan="2">
		<input type="submit" value="등록"/></td></tr>
</table>
</form>
</body>
</html>