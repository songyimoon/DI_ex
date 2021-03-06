<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 리스트</title>

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
<h1 align="center">상품 리스트 페이지입니다.</h1><br/>
<h3 align="center"> 상품의 개수는 ${count }개입니다</h3>
<table align= "center">
<tr bgcolor=#e0e0eb><th>상품번호</th>
	<th>카테고리</th>
	<th>상품명</th>
	<th>가격</th>
	<th>배송비</th></tr>
	
	<c:forEach items="${lists }" var="dto">
	<tr><td align="center"><a href="goodsDetail?prodNum=${dto.prodNum }">${dto.prodNum }</a></td>
		<td align="center">
		
			<c:if test="${dto.ctgr == 'wear'}">의류</c:if>
			<c:if test="${dto.ctgr == 'cosmetic'}">화장품</c:if>
			<c:if test="${dto.ctgr == 'food'}">식품</c:if>
			<c:if test="${dto.ctgr == 'car'}">자동차용품</c:if>
		
		</td>
		
		
		<td align="center">${dto.prodName }</td>
		<td align="center"><fmt:formatNumber value="${dto.prodPrice }" type="currency"/></td>
		<td align="center"><fmt:formatNumber value="${dto.prodDelFee }" type="currency"/></td></tr>
	</c:forEach>	
		<tr><td colspan="8" align="center">
				<%@include file="../include/includePage.jsp" %>
		</td></tr>
</table>
<p align="center"><a href="goodsRegist">상품등록</a></p>
</body>
</html>