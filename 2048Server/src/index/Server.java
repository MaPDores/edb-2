package index;

import static spark.Spark.port;

public class Server {
    public Server(int port) {
        port(port);
        new Router();
        System.out.println("Server connected!");
    }
}
