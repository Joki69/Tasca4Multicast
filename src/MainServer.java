import java.io.IOException;

public class MainServer {
    public static void main(String[] args) throws IOException {
     Server server = new Server(5555,"230.0.0.1");
     server.runServer();
    }
}