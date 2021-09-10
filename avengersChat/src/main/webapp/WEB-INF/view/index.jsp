<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	 
	var url = "ws:192.168.0.88:8080/avengersChat/chat/"
	var webSocket = null;
 
	$(function(){
		$("#login").click(function() {
		url += $("#nick").val();
		//url += ${userId}; //로그인했을때의 정보
		
		console.log(url);
		webSocket = new WebSocket(url); // 소켓접속
	
		webSocket.onopen = function(e) {
			console.log(e); // 접속
		}
		webSocket.onclose = function(e) {
			console.log(e); // 접속ㅃㅇ
			if (e.type == "close") {
				monitor.innerHTML += "접속이 종료 되었습니다.<br/>";
			}
		}
		//소켓으로부터 날아온 데이터처리
		webSocket.onmessage = function(e) {
			monitor.innerHTML += e.data + "<br/>";
		}
	});	
});
	
	// 메시지 전달
	function sendMsg() {
		webSocket.send($("#nick").val() + "> " + $("#msg").val());
		$("#msg").val("");
	}
	
	//웹소켓 종료(client -> server)
	function disConn() {
		webSocket.close();
	}
	</script>
 
</head>
<body>
<h3>웹 소켓 페이지</h3>
	<form>
		대화명 : 
		<input id="nick" type="text" />
		<input id="login" type="button" value="로그인" />
		<div id="monitor" contentEditable="true"></div>
		
		<div>
			메시지 : <input id="msg" type="text" /> <!-- 사용자를 이용해서 세션을 알아내자 -->
			<input type="button" value="전송" onClick="sendMsg()" />
			<input type="button" value="나가기" onClick="disConn()" />
		</div>
	</form>

</body>
</html>