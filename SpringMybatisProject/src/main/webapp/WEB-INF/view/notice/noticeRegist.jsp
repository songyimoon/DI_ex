<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 등록 페이지</title>

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
<form action="noticeJoin" method="post" name="frm" enctype="multipart/form-data">
<table align="center">

	<tr><th bgcolor=#e0e0eb>제목</th>
	<td><input type="text" name="noticeSub"/></td></tr>
	<tr><th bgcolor=#e0e0eb>내용</th>
	<td><textarea rows="10" cols="50" name="noticeCon"></textarea></td></tr>
	<tr><th bgcolor=#e0e0eb>공지종류</th>
	<td>
	<select name="noticeKind">
		<option value="not">일반공지</option>
		<option value="deliv">배송</option>	
		<option value="prod">상품관련공지</option>	
		<option value="refund">교환반품</option>	
	</select></td></tr>
	<tr><th bgcolor=#e0e0eb>첨부파일</th>
	<td><input type="file" name="noticeFile" multiple="multiple"/></td></tr>

	<tr><th bgcolor=#e0e0eb>글쓴이(사원)</th>
	<td><input type="text" name="employeeId" value="${employeeId }" readonly="readonly"/></td></tr>
	<tr><th colspan="2">
		<input type="submit" value="등록"/>
		<input type="reset" value="취소" onclick="javascript:history.back();"/>
		<input type="button" value="홈으로" onclick="javascript:location.href='../main'"/>
</table>
</form>
</body>
</html>