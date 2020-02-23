import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8181);
            //Client Socket (:- An end-point for communication between two machines)
            Socket socket = serverSocket.accept(); //Listens for a connection & Accepts the connection from the Client

            //Reads the receiving message from Client
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = bufferedReader.readLine();

            System.out.println("Received from Client: " + message);

            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            //Received message from the Client
//            printWriter.println("Server echoing back the following message " + message + " from Client");
            printWriter.println("Client says:" + message);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

}
