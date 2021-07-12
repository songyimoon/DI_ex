<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${noticeCommand.noticeSub } </title>

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
}

</style>
</head>
<body>
<form:form method="post" name="frm" modelAttribute="noticeCommand">
<input type="hidden" name="noticeNo" value="${noticeCommand.noticeNo }"> 


<table border = 1 align="center">
	<tr>

	<th bgcolor=#e0e0eb>공지종류</th>
	<td>
	
		<c:if test="${noticeCommand.noticeKind == 'not'}">일반공지</c:if>
		<c:if test="${noticeCommand.noticeKind == 'deliv'}">배송</c:if>
		<c:if test="${noticeCommand.noticeKind == 'prod'}">상품관련공지</c:if>
		<c:if test="${noticeCommand.noticeKind == 'refund'}">교환반품</c:if>
	
	</td>
	<th bgcolor=#e0e0eb>조회수</th>
	<td>${noticeCommand.noticeHits }</td>
	</tr>
	
	<tr>
	<th bgcolor=#e0e0eb>날짜</th>
	<td>
	<fmt:formatDate value="${noticeCommand.noticeDate }"/>	
  
	</td>
	<th bgcolor=#e0e0eb>글쓴이(사원)</th>
	<td>${noticeCommand.employeeId }</td>
	</tr>
	
	<tr><th bgcolor=#e0e0eb>제목</th>
	<td colspan="4">${noticeCommand.noticeSub }</td></tr>
	
	<tr height="600"><th bgcolor=#e0e0eb>내용</th>
	<td colspan="4">${noticeCommand.noticeCon }</td></tr>
	<tr></tr>

	
	<tr><th bgcolor=#e0e0eb>첨부파일</th>
	<td colspan="4"> 
	
	<c:if test="${!empty noticeCommand.noticeFile }">
	<img width = "250" height="280" src="notice/upload/${noticeCommand.noticeFile }">
	</c:if>
	
	</td></tr>

	
	<tr><th colspan="4" bgcolor=#e0e0eb>
		<input type="button" value="홈으로" onclick="javascript:location.href='main.sm'"/>

</table>
</form:form>

</body>
</html>