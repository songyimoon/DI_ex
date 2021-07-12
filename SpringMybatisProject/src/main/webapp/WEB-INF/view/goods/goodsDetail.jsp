<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품상세정보</title>

<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap');

body {
  font-family: 'Noto Sans KR', sans-serif;
}
table{
  font-size: 15px/1;
  width: 1000px;
  border: 1px solid;
  border-spacing: 8px;
}

</style>
</head>


<body> 
<a href="goodsModify?prodNum=${goodsCommand.prodNum }">수정</a><br/>

카테고리 : 
	<c:if test="${goodsCommand.ctgr == 'wear'}">의류</c:if>
	<c:if test="${goodsCommand.ctgr == 'cosmetic'}">화장품</c:if>
	<c:if test="${goodsCommand.ctgr == 'food'}">식품</c:if>
	<c:if test="${goodsCommand.ctgr == 'car'}">자동차용품</c:if><br/>
상품번호 : ${goodsCommand.prodNum }<br/>
상품명 : ${goodsCommand.prodName }<br/>
상품 가격 : 
	<fmt:formatNumber>${goodsCommand.prodPrice } </fmt:formatNumber>원<br/>
규격 : ${goodsCommand.prodCapacity }<br/>
공급 업체 : ${goodsCommand.prodSupplier }<br/>
배송비 : 
	<fmt:formatNumber>${goodsCommand.prodDelFee }</fmt:formatNumber>원<br/>
추천 여부 : 
	<c:if test="${goodsCommand.recommend == 'Y'}">추천</c:if>
	<c:if test="${goodsCommand.recommend == 'N'}">비추천</c:if><br/>
상세정보 : ${goodsCommand.prodDetail }<br/>
이미지 :<br/>
	<c:forTokens items="${goodsCommand.prodImage }" delims="," var="prodImage">
		<img src="../goods/upload/${prodImage }"/>
	</c:forTokens> <br/>
</body>
</html>