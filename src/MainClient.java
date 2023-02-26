import java.io.IOException;

public class MainClient {
    public static void main(String[] args) throws IOException {
       Client client = new Client(5555,"230.0.0.1");
        client.runClient();
    }
}
