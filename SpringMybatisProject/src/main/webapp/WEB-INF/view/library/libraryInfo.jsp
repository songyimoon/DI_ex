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
  width: 1200px;
  border: 1px solid;
  border-spacing: 8px;
}
</style>
</head>
<body>
글번호:  ${dto.noticeNo}<br/>
제목:  ${dto.noticeSub}<br/>
내용:  ${dto.noticeCon}<br/>
등록일:  <fmt:formatDate value="${dto.noticeDate }" type="date" pattern="yyyy-MM-dd"/><br/>
조회수:  ${dto.noticeHits}<br/>
등록자:  ${dto.employeeId}<br/>
파일: <br />

	<c:forTokens items="${dto.noticeOrgFile }" delims="," var="fileName" varStatus="idx">
		<a href="fileDown?str=${dto.noticeFile.split(',')[idx.index]}&org=${fileName}">${fileName }</a>
		/ ${dto.noticeFileSize.split(',')[idx.index]}바이트<br />
	</c:forTokens>

<a href="libModify?noticeNo=${dto.noticeNo }">수정</a>
</body>
</html>