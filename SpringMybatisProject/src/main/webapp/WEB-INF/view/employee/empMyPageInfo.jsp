<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 상세 정보</title>
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
<form:form method="post" modelAttribute="employeeCommand">

사원번호 : ${employeeCommand.employeeId }<br />
사원아이디 :  ${employeeCommand.empUserId }<br/>
이름 : ${employeeCommand.empName }<br />
입사일 : <fmt:formatDate value="${employeeCommand.hireDate }" type="date" pattern="yyyy-MM-dd"/><br/>
직무 : ${employeeCommand.jobId }<br />
연락처 : ${employeeCommand.phNumber }<br />
사무실 번호 : ${employeeCommand.officeNumber }<br />
이메일 : ${employeeCommand.empEmail }<br />
주소 : ${employeeCommand.empAddress }<br />
</form:form>
<br/>

<a href="empMyPagInfoeModify">수정</a>

</body>
</html>