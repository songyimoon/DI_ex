<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../include/includeTags.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
  width: 400px;
  border: 1px solid;
  border-spacing: 8px;
}
</style>
</head>
<body align="center">
<c:if test="${rpadMemId==null}">입력한 정보가 부족하여 아이디를 찾지 못했습니다.</c:if>
<c:if test="${rpadMemId!=null}">찾으신 아이디는 ${rpadMemId } 입니다.</c:if><br/><br/>
<a href="../">메인으로 가기</a>
</body>
</html>