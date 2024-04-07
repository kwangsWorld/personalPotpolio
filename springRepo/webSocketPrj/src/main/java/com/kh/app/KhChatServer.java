package com.kh.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

//WebSocketHandler 인터페이스를 상속받아서 해도 되긴 함
public class KhChatServer extends TextWebSocketHandler {
   
   private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();

   // 소켓 연결 되었을 때 동작할 내용
   @Override
   public void afterConnectionEstablished(WebSocketSession session) throws Exception {
      System.out.println("연결됨 ~~~");
      sessionList.add(session);
   }

   // 메세지 받았을 때 동작할 내용
   @Override
   public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
      System.out.println("메세지 받음 ~~~");
      System.out.println( message.getPayload() );
      
      //연결된 모든 세션에 메세지를 보냄 //broadcast
      TextMessage x = new TextMessage(message.getPayload().toString());
      for (WebSocketSession webSocketSession : sessionList) {
         webSocketSession.sendMessage(x);
      }
   }

   // 소켓 연결 끊겼을 때 동작할 내용
   @Override
   public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
      System.out.println("연결 끊김 ~~~");
      sessionList.remove(session);
   }
   
   // 서버 -> 클라 메세지 보내기 
   
   
   

}