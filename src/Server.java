import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Random;

public class Server {
    String[] frases = {
            "¡Busco aprender y adoptar todas las facetas de la humanidad!",
            "¿Qué es lo que separa a las máquinas de los androides como nosotros? Las máquinas han desarrollado emociones. . . Conciencia. Los gritos finales que convocaron al borde de su muerte. . . Todavía resuenan dentro de mí",
            "Nunca me di cuenta. . . de lo hermoso que es este mundo",
            "No te sientas mal por eso. Estamos vivos, después de todo. Y estar vivo es más o menos un flujo constante de vergüenza",
            "Todo lo que vive está diseñado para terminar. Están perpetuamente atrapados en una espiral interminable de vida y muerte. Sin embargo, la vida tiene que ver con la lucha dentro de este ciclo. Eso es lo que 'nosotros' creemos",
            "Aquí hay una lección importante: cuanto más tonto te tome la gente, más aprenderás de su verdadera naturaleza"
    };
    MulticastSocket socket;
    boolean continueRunning = true;
    int port;
    InetAddress multicastIP;

    public Server(int port, String multicastIP) throws IOException {
        socket = new MulticastSocket(port);
        this.port = port;
        this.multicastIP = InetAddress.getByName(multicastIP);
    }

    Random randomFrase = new Random();


    public void runServer(){

        while (continueRunning){
            String frase = frases[randomFrase.nextInt(frases.length)];
            byte[] sendingFrases = frase.getBytes();
            DatagramPacket packet = new DatagramPacket(sendingFrases, sendingFrases.length, multicastIP, port);
            try {
                socket.send(packet);
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
        socket.close();
    }
}


