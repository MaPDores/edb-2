package listeners;

import controller.WebSocketController;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import view.block.BlockHolder;

import java.net.URI;
import java.net.URISyntaxException;

public class GameWebSocketListener extends ExtendableListener {

    private WebSocketClient webSocketClient;
    private String serverUri;

    public GameWebSocketListener(String serverUri, BlockHolder[][] holders) {
        super(holders);
        this.serverUri = serverUri;
    }

    public void connectToWebSocket() {
        URI uri;
        try {
            uri = new URI(this.serverUri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }

        webSocketClient = new WebSocketClient(uri) {
            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                System.out.println("Connected!");
            }

            @Override
            public void onMessage(String control) {
                WebSocketController.executeCommand(control, holders);
            }

            @Override
            public void onClose(int i, String s, boolean b) {
                System.out.println("Socket closed!");
            }

            @Override
            public void onError(Exception e) {
                e.printStackTrace();
            }
        };
        webSocketClient.connect();
    }
}