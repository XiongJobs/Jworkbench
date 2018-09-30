package websocket;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

//ws://127.0.0.1:8080/JF1703AWebSocket/ChatServer
@ServerEndpoint("/ChatServer")
public class ChatServer {
	
	private static Map<String, Session> onlineMap = new HashMap<String, Session>();
	//当浏览的websocket客户端连接上来的时候自动调用@OnOpen注解下的方法
	@OnOpen
	public void onOpen(Session session){
		String param = session.getQueryString();
		System.out.println("param is"+param);
		String params[] = param.split("=");
		
		synchronized (onlineMap) {
			System.err.println("客户端连接上了:" + params[0]);
			onlineMap.put(params[1], session);
		}
	}
	
	@OnMessage
	public void onMessage(String message, Session session){
		
		
		Iterator iterator = onlineMap.entrySet().iterator();
		while (iterator.hasNext()) {
			System.out.println(message);
			Entry<String, Session> entry = (Entry<String, Session>) iterator.next();
			
			Session remoteSession = entry.getValue();
			try {
				remoteSession.getBasicRemote().sendText(message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
