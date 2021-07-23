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
  width: 800px;
  border: 1px solid;
  border-spacing: 8px;
  }
</style>
</head>
<body>
<h1>공지사항</h1>
<a href="libRegist">자료실 등록</a>
<table>
<tr><th>번호</th><th>제목</th><th>등록일</th><th>조회수</th></tr>
<c:forEach items="${list }" var="dto" varStatus="cnt">

<tr><td align="center">${cnt.count }</td>
	<td align="center"><a href="libraryInfo?noticeNo=${dto.noticeNo }">${dto.noticeSub }</a></td>
	<td align="center"> <fmt:formatDate value="${dto.noticeDate }" type="date" pattern="yyyy-MM-dd"/>  </td>
	<td align="center">${dto.noticeHits }</td>
	</tr>
</c:forEach>


</table>

</body>
</html>