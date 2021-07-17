<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 수정</title>
<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap');

body {
  font-family: 'Noto Sans KR', sans-serif;
}
table{
  font-size: 15px/1;
  width: 700px;
  border: 1px solid;
  border-spacing: 8px;
}

</style>
</head>
<body>
<h1 align="center">리뷰 수정</h1>
<form action="reviewUpdate" method="post">
<input type="hidden" name="prodNum" value="${prodNum }"/>
<input type="hidden" name="purchaseNum" value="${purchaseNum }"/>
<table align="center">
	<tr><td>리뷰수정</td>
		<td><textarea rows="10" cols="80" name="reviewContent">${dto.reviewContent }</textarea></td></tr>
	<tr ><td colspan="2" align="center"><input type="button" value="뒤로가기" onclick="javascript:history.back();"/>  <input type="submit" value="수정완료"/></td></tr>
</table>
</form>
</body>
</html>