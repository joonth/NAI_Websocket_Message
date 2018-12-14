package com.hk.web;


import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.hk.web.daos.MessageDao;
 

 

@Controller
public class EchoHandler extends TextWebSocketHandler {
	  
	@Autowired
	MessageDao dao;
	private static Logger logger = LoggerFactory.getLogger(EchoHandler.class);
	  
	  
	  // 서버에 연결한 사용자들을 저장하는 리스트
	  private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	 
	  // 클라이언트와 연결 이후에 실행되는 메서드
	  @Override
	  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	    sessionList.add(session);
	    System.out.println(sessionList.size());
	    logger.info("{} 연결됨", session.getId());
	  }
	 
	  // 클라이언트가 서버로 메시지를 전송했을 때 실행되는 메서드
	  @Override
	  protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception  {
	    logger.info("{}로 부터 {} 받음", session.getId(), message.getPayload());
	    for(WebSocketSession ss : sessionList) {
	    	//if절 로그인할때 session에 들어간 id와 message.getPayload의 값이 일치하면 보낸다.
	    	ss.sendMessage(new TextMessage(dao.getMsgNum(message.getPayload())));

	    }
	  }
	 
	  // 클라이언트와 연결을 끊었을 때 실행되는 메소드
	  @Override
	  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
	    sessionList.remove(session);
	    logger.info("{} 연결 끊김", session.getId());
	  }
		
}


