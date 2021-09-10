package controller.chatting;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
 
@ServerEndpoint("/chat/{userId}")
public class WebSocketController {
	static HashMap<String, Session> userList = new HashMap<String, Session>();
	
	@OnOpen
	public void onOpen(Session session, @PathParam("userId") String id) {
		if(userList.get(id)!=null) {
			try {
				session.getBasicRemote().sendText("사용중인 아이디입니다.");
			} catch (IOException e) { e.printStackTrace();}
		}else {
			userList.put(id, session);
		}
	}
	@OnClose
	public void onClose(Session session) {
		String val =  session.getId();
		
		Set<String> keys = userList.keySet();
		for(String key: keys) {
			if(val.equals(userList.get(key).getId())) {
				userList.remove(key, session);
				try {
					session.getBasicRemote().sendText(key+"님이 나갔음");
				} catch (IOException e) {e.printStackTrace();}
			}
		}
	}
	@OnMessage
	public void onMessage(String msg, Session session) {
		broadCast(msg);
				
	}
	// 여러사람에게 동시에 메시지 전송
	public void broadCast(String msg) {
		Set<String> keys = userList.keySet();
		try {
			for(String key : keys) {
				Session session = userList.get(key);
				session.getBasicRemote().sendText(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 한사람에게
	private void sendMsg(String userId, String msg) {
		try {
			Session session = userList.get(userId);
			session.getBasicRemote().sendText(msg);
				} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
