<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>  
<%@ include file="../include/includeTags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${goodsReviews.goods.prodName}</title>

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
  width: 850px;
  border: 1px solid;
  border-spacing: 8px;
}
</style>

<script src="https://code.jquery.com/jquery-latest.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.3.0/jquery.form.js"></script>
<script type="text/javascript">
	$(function(){
		
		$("#cart").click(function(){
			var cartQty = $("#cartQty").val();
			var prodNum = ${goodsReviews.goods.prodNum}			
			$.ajax({
				type : "post",
				url : "<c:url value='/cart/goodsCartAdd'/>",
				dataType : "text",
				data : {"cartQty":cartQty, "prodNum":prodNum, "prodPrice":${goodsReviews.goods.prodPrice}}, // data : "cartQty="+cartQty+"prodNum="+prodNum
				success : function(result){
					if(result.trim() == "1"){ // 정상적으로 장바구니에 상품 등록
						if(confirm("계속 쇼핑하시려면 '아니오'를 누르시오.")){
							location.href="<c:url value='/cart/goodsCartList'/>";
						}
					}else {
						alert("장바구니에 담기지 않았습니다. 다시 시도해주세요.");
					}
				}
				
			});
		});		
		
		
		 $("#wishBtn").click(function(){				 
			 $.ajax({
				type : "post",
				url : "../goods/goodsWishAdd",
				data : {"prodNum":${goodsReviews.goods.prodNum}}, 
				dataType : "text",
				success : function(result){
					if(result.trim()=="1"){
						$("#wishBtn").attr("src","../images/fullHeart.png");
						alert("관심상품이 등록되었습니다.")
					}else if(result.trim()=="0"){
						$("#wishBtn").attr("src","../images/emptyHeart.png");
						alert("관심상품이 해지되었습니다.")
					}else{
						alert("로그인을 해주세요.")
					}
				},
				error: function(){
					alert('로그아웃되었습니다. \n 다시 로그인해주세요.')
					location.href="../main";
					return;
				}
			 });
		});

	 });

</script>
</head>
<body>
<table align="center">
<tr><td align=right colspan="2">관심상품 
								<c:if test="${num==0}">
								<img src="../images/emptyHeart.png" id="wishBtn" width="10px"/>
								</c:if>
								<c:if test="${num==1}">
								<img src="../images/fullHeart.png" id="wishBtn" width="10px"/>
								</c:if>
								</td></tr>								
	<tr><td rowspan="5"> <br/>
	<img src="../goods/upload/${goodsReviews.goods.prodImage.split(',')[0]}" width="300px"/></td>
								<th align=right>${goodsReviews.goods.prodName}</th>
								</tr>
								
	<tr>						<td align=right>상품가격: <fmt:formatNumber value="${goodsReviews.goods.prodPrice}" type="number"/>원</td></tr>
	<tr>						<td align=right>배송비: <fmt:formatNumber value="${goodsReviews.goods.prodDelFee}" type="number"/>원</td></tr>
	<tr>						<td align=right>수량
								<input type = "number" min="1" step="1" value="1" name="cartQty" id="cartQty"/>
								</td></tr>
	<tr>						<td align=right>
								<button id="cart">장바구니</button>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<button type="button" id="buy" onclick="javascript:location.href='../cart/goodsBuy?prodNum=${goodsReviews.goods.prodNum}&cartQty=#cartQty&prodPrice=${goodsReviews.goods.prodPrice}'"> 바로구매</button>
								</td></tr>						
								
	<tr><td colspan="2">
	<hr/>
	${goodsReviews.goods.prodDetail}
	<p>
	<c:forTokens items="${goodsReviews.goods.prodImage}" delims="," var="image">	
		<img src="../goods/upload/${image }" width="500px"/><br/>
	</c:forTokens>
	</p>
	</td></tr>
</table>
 

<c:if test="${goodsReviews.reviews != null}">
<table align="center">
<hr/>
<h3 align="center">리뷰</h3>
<p align="center">
<c:forEach items="${goodsReviews.reviews }" var="dto"> 
구매일자 : <br/>
<fmt:formatDate value="${dto.reviewDate }" type="date" pattern="yyyy-MM-dd"/> <br/>
리뷰내용 : <br/>
${fn:replace(dto.reviewContent,br,"<br />")}<br/>
<c:if test="${dto.reviewImg != null}">
<img src="../goods/review/${dto.reviewImg }" width="70"/>
</c:if>
</p>
<hr/>
</c:forEach>

<c:if test="${goodsReviews.reviews == null}">
</c:if>


</table>
</c:if>
</body>
</html>