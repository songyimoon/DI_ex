<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보 수정</title>

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
<form action="empModifyOk" method="get" name="frm" id="frm">
<input type="hidden" name="employeeId" value="${emp.employeeId }"/> 
<!-- 화면에는 보이지 않지만, employeeId를 키처럼 사용하는 것 -->
<table align = "center">
	<tr><td>사원번호</td>
		<td>
			${emp.employeeId }
			</td></tr>
	<tr><td>사원아이디</td>
		<td>	
			${emp.empUserId }	
			</td></tr>
	<tr><td>이름</td>
		<td>
			${emp.empName }	
		</td></tr>
	<tr><td>입사일</td>
		<td>
			<fmt:formatDate value="${emp.hireDate }" type="date" pattern="yyyy-MM-dd"/>
		</td></tr>
	<tr><td>직무</td>
		<td>
			<input type="text" name="jobId" value="${emp.jobId }"/>
		</td></tr>
	<tr><td>연락처</td>
		<td>
			<input type="text" name="PhNumber" placeholder="010-1234-1234" value="${emp.phNumber }"/>
		</td></tr>
	<tr><td>사무실번호</td>
		<td>
			<input type="text" name="officeNumber" placeholder="02-1234-1234" value="${emp.officeNumber }"/>
		</td></tr>
	<tr><td>이메일</td>
		<td>
			<input type="text" name="empEmail" value="${emp.empEmail }"/>
		</td></tr>
	<tr><td>주소</td>
		<td>
			<input type="text" name="empAddress" value="${emp.empAddress }"/>
		</td></tr>
	<tr><td colspan="2" align="center">
			<input type="submit" value="직원정보 수정"/>
			<input type="button" value="직원 삭제" onclick="javascript:location.href='empDelete?empId=${emp.employeeId }'"/>
		</td></tr>	
</table>
</form>
</body>
</html>