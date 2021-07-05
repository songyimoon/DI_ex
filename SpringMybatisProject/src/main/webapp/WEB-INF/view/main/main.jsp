<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap');

*{
  color: black;
}
body {
  font-family: 'Noto Sans KR', sans-serif;
}
table{
  font-size: 15px/1;
  width: 800px;
  border: 1px solid;
  border-spacing: 8px;

</style>
</head>
<body>
<!-- 로그인 안된 경우 -->
	<a href="register/agree">회원가입 </a>
	
	
<!-- 로그인 되었을 때 -->	

<!-- 일반 사용자 -->

<!-- 관리자 -->
	<a href="member/memList">회원리스트</a>	
	<a href="emp/empList">직원리스트</a>
</body>
</html>