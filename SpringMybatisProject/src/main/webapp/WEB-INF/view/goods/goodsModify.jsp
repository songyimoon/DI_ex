<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정</title>
<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap');

body {
  font-family: 'Noto Sans KR', sans-serif;
}
table{
  font-size: 15px/1;
  width: 600px;
  border: 1px solid;
  border-spacing: 8px;
}
p{
  font-size: 12px;
}
</style>
</head>
<body>
<form:form action="goodsUpdate" name="frm" method="post" modelAttribute="goodsCommand" enctype="multipart/form-data">
<input type="hidden" name="prodNum" value="${goodsCommand.prodNum }"/>
<input type="hidden" name="prodName" value="${goodsCommand.prodName }"/>
<table align="center">
	<tr><th width="150px">상품번호</th><td width="450px">${goodsCommand.prodNum }</td></tr>
	<tr><th>상품명</th><td>${goodsCommand.prodName }</td></tr>
	<tr><th>가격</th> <td><input type="number" name="prodPrice" min="10" step="10" value="${goodsCommand.prodPrice }"/>
						 <form:errors path="prodPrice"/></td></tr>
	<tr><th>규격</th> <td><input type="number" name="prodCapacity" min="0" value="${goodsCommand.prodCapacity }"/>
					 	 <form:errors path="prodCapacity"/></td></tr>
	<tr><th>공급 업체</th><td><input type="text" name="prodSupplier" value="${goodsCommand.prodSupplier }"/>  
							<form:errors path="prodSupplier"/></td></tr>
	<tr><th>배송비</th><td><input type="number" name="prodDelFee" min="0" step="100" value="${goodsCommand.prodDelFee }"/>
						  <form:errors path="prodDelFee"/></td></tr>
	<tr><th>추천여부</th>
		<td>
		<input type="radio" name="recommend" value="Y" <c:if test="${goodsCommand.recommend == 'Y' }">checked</c:if>/>추천	
		<input type="radio" name="recommend" value="N" <c:if test="${goodsCommand.recommend == 'N' }">checked</c:if>/>비추천</td></tr>
	<tr><th>카테고리</th>
		<td><select name="ctgr">
			<option value="wear" <c:if test="${goodsCommand.ctgr == 'wear' }">selected</c:if> >의류</option>
			<option value="cosmetic" <c:if test="${goodsCommand.ctgr == 'cosmetic' }">selected</c:if> >화장품</option>
			<option value="food" <c:if test="${goodsCommand.ctgr == 'food' }">selected</c:if> >식품</option>
			<option value="car" <c:if test="${goodsCommand.ctgr == 'car' }">selected</c:if> >자동차용품</option></select></td></tr>
	
	<tr><th>상세정보</th>
		<td><textarea rows="5" cols="50" name="prodDetail">${goodsCommand.prodDetail }</textarea>
			<form:errors path="prodDetail"/></td></tr>
	<tr><th>이미지</th><td>
	
	<c:forTokens items="${goodsCommand.prodImage }" delims="," var="prodImage">
		<p>
		<span id="fileName"> ${prodImage }	</span>
		<input type="button" id="btn" value="삭제" onclick="fileDel(this)"/>
		</p>
	</c:forTokens>
	파일추가 : <input type="file" name="prodImage" multiple="multiple"/>
	</td></tr>
	
	<tr><td colspan="2" align="center">
	
		<br/>
	<input type="hidden" name="fileDel1" id="fileDel1"/> <br/>
	<input type="submit" value="수정하기"/>
	<input type="button" value="삭제하기" onclick="javascript:location.href='goodsDel?prodNum=${goodsCommand.prodNum }'"/>
	<input type="button" value="리스트"/>
	</td></tr>
</table>
</form:form>

<!-- 이미지 삭제버튼 스크립트 -->
<script type="text/javascript" src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript">
function fileDel(btn){
   var delFile = $("#fileDel1").val()
   if($(btn).attr("value") == "삭제"){
      $(btn).attr("value","삭제취소");
      $("#fileDel1").val($(btn).parent().children("#fileName").text().trim() + "," + delFile)
   }else{
      $(btn).attr("value","삭제");
      fileName = $("#fileDel1").parent().children("#fileName").text().trim()+",";
      $("#fileDel1").val(delFile.replace(fileName,""));
   }
}
</script>
</body>
</html>