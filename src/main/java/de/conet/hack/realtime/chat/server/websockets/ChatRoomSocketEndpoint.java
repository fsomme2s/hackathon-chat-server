package de.conet.hack.realtime.chat.server.websockets;

import java.io.Serializable;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;

@ServerEndpoint(value = "/websockets/chat")
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class ChatRoomSocketEndpoint implements Serializable {
	private static final long serialVersionUID = 6544892925052520463L;
	
	@Inject
    private Logger logger;

    @OnOpen
    public void open(Session session) {
        logger.info("User joined Chatroom...");
    }


    @OnMessage
    public void onEvent(Session sender, String event) {
        logger.info("Recieved event from session {}: {}", sender.getId(), event);
    }

    @OnClose
    public void close(Session session) {
    	logger.info("Last user left '{}'", session);
    }

}