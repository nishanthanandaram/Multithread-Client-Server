import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

 private static ServerSocket serverSocket;
 private static Socket clientSocket = null;

public static void main(String[] args) throws IOException {

try {
    serverSocket = new ServerSocket(4446);
    System.out.println("Server started.");
} catch (Exception e) {
    System.err.println("Port already in use.");
    System.exit(1);
}

while (true) {
    try {
        clientSocket = serverSocket.accept();
        System.out.println("Accepted connection : " + clientSocket);
        Thread serverThread = new Thread(new ServerToClientConnection(clientSocket));
        serverThread.start();

    } catch (Exception e) {
        System.err.println("Error in connection attempt.");
     }
    }
  }
}