package handler;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebSocket
public class GameWebSocketHandler {
    public static final Map<Session, String> connectedGames = new ConcurrentHashMap<>();
    private int gameCounter = 0;

    @OnWebSocketConnect
    public void onConnect(Session session) throws Exception {
        String newUser = "" + gameCounter++;
        connectedGames.put(session, newUser);
        System.out.println("New Session Connected: "+ gameCounter);
    }

    @OnWebSocketClose
    public void onClose(Session session, int statuCode, String reason) {
        connectedGames.remove(session);
    }
}
