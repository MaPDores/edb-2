package controller;

import com.google.gson.Gson;
import dto.Command;
import enumerators.Direction;
import view.block.BlockHolder;

public class WebSocketController {

    static Gson gson = new Gson();

    public static String executeCommand(String control, BlockHolder[][] holders) {
        boolean hasMoved = false;
        String response = "";

        Command command = gson.fromJson(control, Command.class);

        Direction direction = command.getDirection();
        if (direction == null) {
            return "{ \"error\": \"Invalid Params\"}";
        }

        switch(direction) {
            case up:
                hasMoved = BoardController.moveUp(holders);
                response = "{ \"status\": \"ok\" }";
                break;
            case left:
                hasMoved = BoardController.moveLeft(holders);
                response = "{ \"status\": \"ok\" }";
                break;
            case down:
                hasMoved = BoardController.moveDown(holders);
                response = "{ \"status\": \"ok\" }";
                break;
            case right:
                hasMoved = BoardController.moveRight(holders);
                response = "{ \"status\": \"ok\" }";
                break;
            default:
        }
        if (hasMoved) {
            BoardController.createRandom(holders);
        }

        return response;
    }
}

