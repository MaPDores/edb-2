package index;

import controller.CellphoneController;
import handler.GameWebSocketHandler;

import static spark.Spark.post;
import static spark.Spark.webSocket;

public class Router {
    public Router() {
        webSocket("/game", GameWebSocketHandler.class);

        post("/control", (req, res) -> CellphoneController.broadCastControl(req, res));
    }
}