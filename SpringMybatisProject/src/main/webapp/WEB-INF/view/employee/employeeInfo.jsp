<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 페이지</title>
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
  width: 1200px;
  border: 1px solid;
  border-spacing: 8px;

</style>
</head>
<body>

사원번호 : ${emp.employeeId }<br />
아이디 : ${emp.empUserId }<br />
이름 : ${emp.empName }<br />
입사일 : <fmt:formatDate value="${emp.hireDate }" type="date" pattern="yyyy-MM-dd"/><br />
직무 : ${emp.jobId }<br />
연락처 : ${emp.phNumber }<br />
사무실 번호 : ${emp.officeNumber }<br />
이메일 : ${emp.empEmail }<br />
주소 : ${emp.empAddress }<br />
<a href="empModify?empId=${emp.employeeId }">수정</a>
<a href="empList">리스트로 가기</a>
</body>
</html>