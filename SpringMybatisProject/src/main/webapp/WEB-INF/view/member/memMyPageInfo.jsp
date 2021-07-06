<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 상세 정보</title>

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

<form:form method="post" name="frm" modelAttribute="memberCommand"> 
아이디 : ${memberCommand.memId }<br/>
이름 : ${memberCommand.memName }<br/>
생년월일 : <fmt:formatDate value="${memberCommand.memBirth }" type="date" pattern="yyyy-MM-dd"/><br/>
성별 : ${memberCommand.memGender }<br/>
우편번호 : ${memberCommand.postNumber }<br/>
주소 : ${memberCommand.memAddress }<br/>
상세주소 : ${memberCommand.detailAdd }<br/>
연락처 : ${memberCommand.memPhone }<br/>
이메일 : ${memberCommand.memEmail }<br/>
계좌번호 : ${memberCommand.memAccount }<br/>
수신여부 : <c:if test="${memberCommand.memEmailCk == 'Y' }">
		이메일수신 동의
		</c:if>
		<c:if test="${memberCommand.memEmailCk == 'N' }">
		이메일수신 거부
		</c:if>
</form:form>		
<br/>

<a href="memMypageInfoModify">수정</a>


</body>
</html>