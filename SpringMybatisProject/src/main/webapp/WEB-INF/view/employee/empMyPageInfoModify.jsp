<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 마이페이지 정보수정</title>
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
<form:form action="empMyPageModifyOk" method="post" name="frm" id="frm" modelAttribute="employeeCommand">
<form:hidden path = "employeeId"/>
<form:hidden path = "empUserId"/>
<form:hidden path = "empName"/>

<table align = "center">
<tr>
	<td>사원번호</td>
	<td>${employeeCommand.employeeId }</td>
</tr>
<tr>
	<td>사원아이디</td>
	<td>${employeeCommand.empUserId }</td>
</tr>
<tr>
	<td>비밀번호</td>
	<td><input type="password" name="empPw" />
		<form:errors path = "empPw"/>
	</td>
</tr>		
<tr>
	<td>이름</td>
	<td>${employeeCommand.empName }</td>
</tr>
<tr>
	<td>입사일</td>
	
	<td><input type="date" name="hireDate" value="<fmt:formatDate value="${employeeCommand.hireDate }" type="date" pattern="yyyy-MM-dd"/>"/>
	<br/>
	
	
	</td>
</tr>
<tr>
	<td>직무</td>
	<td><form:input path="jobId"/></td>
</tr>
<tr>
	<td>연락처</td>
	<td><form:input path="PhNumber" placeholder="010-1234-1234"/></td>
</tr>
<tr>
	<td>사무실번호</td>
	<td><form:input path="officeNumber" placeholder="02-1234-1234"/></td>
</tr>
<tr>
	<td>이메일</td>
	<td><form:input path="empEmail" /></td>
</tr>
<tr>
	<td>주소</td>
	<td><form:input path="empAddress"/></td>
</tr>
<tr>
	<td colspan="2" align="center">
	<input type="submit" value="직원정보 수정"/>
	<input type="button" value="직원 삭제" onclick="javascript:location.href='empDelete?empId=${employeeCommand.employeeId}'"/>
	</td>
</tr>	
</table>
</form:form>
</body>
</html>