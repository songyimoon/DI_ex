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
p{
 font-size: 10px;}
</style>

</head>
<body>
<form action="libModifyOk" method="post" enctype="multipart/form-data">
<input type="hidden" value="${dto.noticeNo}" name="noticeNo"/>

글번호 ${dto.noticeNo}<br/>
제목 <input type="text" value="${dto.noticeSub}" name="noticeSub"/><br/>
내용 <input type="text" value="${dto.noticeCon}" name="noticeCon"/><br/>
등록일 <fmt:formatDate value="${dto.noticeDate }" type="date" pattern="yyyy-MM-dd"/><br/>
조회수 ${dto.noticeHits}<br/>
등록자 ${dto.employeeId}<br/>
파일: <br />
	<c:forTokens items="${dto.noticeOrgFile }" delims="," var="original" varStatus="idx">
	<p>
	<span id = "file">
	      ${original },${dto.noticeFile.split(',')[idx.index] },${dto.noticeFileSize.split(',')[idx.index] }</span>
		  <input type="button" id="btn" onclick = "fileDel1(this)" value="삭제"/>
	</p>
	</c:forTokens>
	파일추가: <input type="file" name="noticeFile" multiple="multiple"/>
	<br />

<input type="hidden" name="fileDel" id="fileDel" size="100"/>
<br/>

<input type="submit" value="게시글 수정" />
<input type="button" value="글 삭제" onclick="javascript:location.href='libDel?noticeNo=${dto.noticeNo}'"/>

</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">

function fileDel1(btn){
	   var fileDel = $("#fileDel").val();
	   if($(btn).attr("value") == "삭제"){
	      $(btn).attr("value","삭제 취소");
	      $("#fileDel").val($(btn).parent().children("#file").text().trim()+"/" + fileDel);
	   }else{
	      $(btn).attr("value","삭제")
	      fileName = $(btn).parent().children("#file").text().trim();
	      $("#fileDel").val(fileDel.replace(fileName+"/",""));
	   }
	}		
</script>

</body>
</html>