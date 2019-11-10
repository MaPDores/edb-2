package listeners;

import controller.WebServiceController;
import static spark.Spark.post;
import view.block.BlockHolder;

public class GameWebListener extends ExtendableListener {

    public GameWebListener (BlockHolder[][] holders) {
        super(holders);
    }
    
    public void initServer() {
        post("/control", (req, res) -> { return WebServiceController.executeCommand(req, res, holders); });
    }
}
