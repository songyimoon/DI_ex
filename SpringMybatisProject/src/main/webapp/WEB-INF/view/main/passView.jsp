<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기 메일전송 완료</title>
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
고객님의 이메일 주소 ${email}로 임시 비밀번호가 전송되었습니다.
<br/>
<a href="../">메인으로 가기</a>
</body>
</html>