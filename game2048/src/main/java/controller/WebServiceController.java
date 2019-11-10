package controller;

import com.google.gson.Gson;
import dto.Command;
import enumerators.Direction;
import spark.Request;
import spark.Response;
import static spark.Spark.halt;
import view.block.BlockHolder;


public class WebServiceController {
    
    static Gson gson = new Gson();
    
    public static String executeCommand(Request req, Response res, BlockHolder[][] holders) {
            res.header("Content-Type", "application/json");
            boolean hasMoved = false;
            String response = "";
            
            Command command = gson.fromJson(req.body(), Command.class);

            Direction direction = command.getDirection();
            if (direction == null) {
                res.status(400);
                return response = "{ \"error\": \"Invalid Params\"}";
            }
            
            switch(direction) {
            case up:
                hasMoved = BoardController.moveUp(holders);
                res.status(200);
                response = "{ \"status\": \"ok\" }";
                break;
            case left:
                hasMoved = BoardController.moveLeft(holders);
                res.status(200);
                response = "{ \"status\": \"ok\" }";
                break;
            case down:
                hasMoved = BoardController.moveDown(holders);
                res.status(200);
                response = "{ \"status\": \"ok\" }";
                break;
            case right:
                hasMoved = BoardController.moveRight(holders);
                res.status(200);
                response = "{ \"status\": \"ok\" }";
                break;
            default:
            }
            if (hasMoved) {
                BoardController.createRandom(holders);
            }
            
            
            if (res.status() != 200 && res.status() != 400) {
                response = "{ \"error\": \"INTERNAL\" }";
                res.status(500);
            }
            return response;
        }
}