<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 페이지</title>
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
회원정보 페이지입니다. <br/>

아이디 : ${lists[0].memId }<br/>
이름 : ${lists[0].memName }<br/>
생년월일 : <fmt:formatDate value="${lists[0].memBirth }" type="date" pattern="yyyy-MM-dd"/><br/>
성별 : ${lists[0].memGender }<br/>
우편번호 : ${lists[0].postNumber }<br/>
주소 : ${lists[0].memAddress }<br/>
상세주소 : ${lists[0].detailAdd }<br/>
연락처 : ${lists[0].memPhone }<br/>
이메일 : ${lists[0].memEmail }<br/>
계좌번호 : ${lists[0].memAccount }<br/>
수신여부 : <c:if test="${lists[0].memEmailCk == 'Y' }">
		이메일수신 동의
		</c:if>
		<c:if test="${lists[0].memEmailCk == 'N' }">
		이메일수신 거부
		</c:if>
		<br/>
<a href="../memMod/${lists.get(0).memId }">수정</a>

</body> 
</html>