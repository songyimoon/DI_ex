<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../include/includeTags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정</title>
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
p{
  font-size: 12px;
}

</style>
</head>
<body>
<form:form action="noticeModifyOk" method="post" name="frm" modelAttribute="noticeCommand" enctype="multipart/form-data">
<input type="hidden" name="noticeNo" value="${noticeCommand.noticeNo }">

<table align="center">
	<tr><th>글 번호</th>
	<td>${noticeCommand.noticeNo }</td></tr>
	<tr><th>제목</th>
	<td><input type="text" name="noticeSub" value="${noticeCommand.noticeSub }"/></td></tr>
	<tr><th>내용</th>
	<td><textarea rows="10" cols="50" name="noticeCon" > ${noticeCommand.noticeCon }</textarea></td></tr>
	<tr><th>날짜</th>
	<td>
	<fmt:formatDate value="${noticeCommand.noticeDate }" type="date" pattern="yyyy-MM-dd"/>	
	</td></tr>
	<tr><th>공지종류</th>
	<td>
		<select name="noticeKind">
		<option value="not">일반공지</option>
		<option value="deliv">배송</option>	
		<option value="prod">상품관련공지</option>	
		<option value="refund">교환반품</option>	
	</select></td></tr>
	
	<tr><th>첨부파일</th>
	<td>
	
	<c:forTokens items="${noticeCommand.noticeFile }" delims="," var="noticeFile">
	
	<p>
	<span id="fileName">${noticeFile}</span>
	<input type="button" id="btn" value="삭제" onclick="fileDel(this)"/>
	</p>
	</c:forTokens>
	파일 추가: <input type="file" name="noticeFile" multiple="multiple"/>
	</td></tr>
	
	
	
	<tr><th>조회수</th>
	<td>${noticeCommand.noticeHits }</td></tr>
	<tr><th>글쓴이(사원)</th>
	<td>${noticeCommand.employeeId }</td></tr>
	
	<tr><th colspan="2">
		<input type="hidden" name="fileDel1" id="fileDel1"/>
		<input type="submit" value="공지수정"/>
		<input type="button" value="취소" onclick="javascript:history.back();"/>
		<input type="button" value="삭제" onclick="javascript:location.href='noticeDel?noticeNo=${noticeCommand.noticeNo}'"/>
		<input type="button" value="홈으로" onclick="javascript:location.href='../main'"/>

</table>
</form:form>

<script type="text/javascript" src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript">
	function fileDel(btn){
		var delFile = $("#fileDel1").val()
		
		if($(btn).attr("value")=="삭제"){
			$(btn).attr("value","삭제취소");
			$("#fileDel1").val($(btn).parent().children("#fileName").text().trim() + "," + delFile)
		}else{
			$(btn).attr("value","삭제");
			fileName = $(btn).parent().children("#fileName").text().trim()+",";
			$("#fileDel1").val(delFile.replace(fileName,""));
		}
	}



</script>
</body>
</html>