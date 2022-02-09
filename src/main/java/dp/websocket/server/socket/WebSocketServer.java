package dp.websocket.server.socket;

import java.io.IOException;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@ServerEndpoint("/websocket")
public class WebSocketServer {
	

    protected Logger logger = LoggerFactory.getLogger(WebSocketServer.class);

    @OnMessage
    public void handleMessage(Session session, String message) throws IOException {
        logger.info("Message received from client {}", message);
        
        if(message.matches(".*[a-zA-Z].*") && message.matches(".*[0-9].*")) {
        	 session.getBasicRemote().sendText("Received from Server: " + new StringBuilder(message));
        }
        else if(message.matches("[0-9]+")) {
        	session.getBasicRemote().sendText(ServiceClass.checkBalance(message));
        }
        else {
        String[] res=message.split("-");

		String accountID = res[0];

		String b = res[1];
		Double balance = Double.parseDouble(b);
		if(ServiceClass.searchbyID(accountID)){
			session.getBasicRemote().sendText("Received from Server: " + new StringBuilder(ServiceClass.debit(accountID, balance)));
		}
		else{
			 session.getBasicRemote().sendText("Received from Server: " + new StringBuilder("Invalid Accont id"));
		}
        }
    }

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        logger.info("Socket has opened with Session {} \n EndpointConfig {}", session, config);
        
    }

    @OnError
    public void errorOcured(Throwable throwable) throws IOException {
        logger.error("Error occured on socket connection", throwable);
    }

    @OnClose
    public void onClose(CloseReason closeReason) {
        logger.info("Socket has closed. Reason {}", closeReason);
    }

}
