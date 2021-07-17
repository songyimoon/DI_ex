<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제페이지</title>
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

<h1 align="center">결제 페이지</h1>
<hr />
 
<form action="doPayment" method="post">
<input type="hidden" name="purchaseNum" value="${purchNo }" />
<input type="hidden" name="paymentApprPrice" value="${payPrice }" />

<table align="center">
	<tr align="center"><th>구매번호: </th><td>${purchNo }</td></tr>
	<tr align="center"><th>결제금액: </th><td>${payPrice }</td></tr>
	<tr align="center"><th>결제방법: </th><td>카드</td></tr>
	<tr align="center"><th>카드번호: </th><td><input type="text" name="paymentNumber"></td></tr>
	<tr align="center"><th align="center" colspan="2">
		<input type="submit" value="결제완료"/>
		<input type="button" value="뒤로 가기" onclick="javascript:history.back();"/>
		
		</th><td></td></tr>

</table>
</form>
</body>
</html>