<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
#price{
	font-size: 13px;
	color: #708090;
}
 
table {
	font-size: 15px/1;	
	border-spacing: 8px;
}
</style>
</head>
<body>
	<c:if test="${empty authInfo }">
		<!-- 로그인 안된 경우 -->
		<form:form action="login" method="post" name="frm" modelAttribute="loginCommand">

			<table align="center" width="500" >
				<tr>
					<td colspan="3" align="center"> 아이디저장 <input type="checkbox" name="idStore" <c:if test="${!empty isId }">checked</c:if>/> 				
					
					 | 자동로그인  <input type="checkbox" name="autoLogin"/> </td>
				</tr>

				<tr>
					<th>아이디</th>
					<td align="center"><form:input path="userId" value="${isId }"/>
						<form:errors path="userId" /></td>
					<td rowspan="2"><input type="image" src="images/login64.png" width="60" alt="login" /></td>
				</tr>

				<tr>
					<th>비밀번호</th>
					<td align="center"><form:password path="userPw" />
						<form:errors path="userPw" /></td>
				</tr>

				<tr>
					<td colspan="3" align="center">
					
					<a href="search/idFind">아이디찾기</a> | <a href="search/findPassword">비밀번호 찾기</a> | <a href="register/agree">회원가입
					</a>
					</td>
				</tr>
			</table>
		</form:form>
	</c:if>


	<c:if test="${!empty authInfo }">
		<!-- 로그인 되었을 때 -->
		<c:if test="${authInfo.grade == 1 }">


		<!-- 일반 사용자 -->
		<a href="edit/myPage">마이페이지</a>
		<a href="cart/goodsCartList">장바구니</a>
		<a href="cart/orderProcessList">구매확인</a>
				
	<!--<a href="ajaxTest">ajax</a>
		<a href="ajaxTest2">ajaxTest2</a>-->	
		</c:if>

		<c:if test="${authInfo.grade != 1 }">

		<!-- 관리자 -->
		
			<a href="empMenu/myPage">마이페이지</a>
			<a href="notice/noticeList">공지사항</a>			
			<a href="member/memList">회원리스트</a>
			<a href="emp/empList">직원리스트</a>
			<a href="goods/goodsList">상품리스트</a>
			<a href="lib/libBoard">자료실</a>
		</c:if>
		<a href="login/logOut">로그아웃</a>



	</c:if>
	<table align = "center">
	<tr>
	<c:forEach items="${lists }" var="dto" varStatus="cnt">
		<td>
			<a href="prod/goodsView?prodNum=${dto.prodNum }">
			<c:if test="${dto.prodImage != null }">
			<img width="200" height="200" src="goods/upload/${dto.prodImage.split(',')[0] }" /><br/>
			</c:if>
			<span id="name">${dto.prodName }</span><br/>
			<span id="price"><fmt:formatNumber value="${dto.prodPrice }" type="number" />원</span>
			</a>
		</td>
		<c:if test="${cnt.count % 4 == 0 }">
			</tr><tr>
		</c:if>
	</c:forEach>
	</tr>
	</table>
</body>
</html>