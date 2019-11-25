package controller;

import org.jetbrains.annotations.NotNull;
import spark.Request;
import spark.Response;

import java.util.concurrent.atomic.AtomicInteger;

import static handler.GameWebSocketHandler.connectedGames;

public class CellphoneController {
    public static String broadCastControl(Request req, Response res) {
        res.header("Content-Type", "application/json");
        AtomicInteger failureCount = new AtomicInteger();
        int status = 200;

        connectedGames.keySet().stream().forEach(session -> {
            try {
                session.getRemote().sendString(req.body());
            } catch (Exception e) {
                failureCount.getAndIncrement();
            }
        });

        return "{ \"status\": \""+status+"\", \"failureCount\":"+ failureCount +" }";
    }
}
