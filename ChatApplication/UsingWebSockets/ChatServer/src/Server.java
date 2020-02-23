import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
    public static void main(String[] args) {
        int port = 8181;
        try {
            ServerSocket serverSocket = new ServerSocket(port);

            while (true) {
                System.out.println("About to accept client connection...");
                //Client Socket (:- An end-point for communication between two machines)
                Socket clientSocket = serverSocket.accept(); //Listens for a connection & Accepts the connection from the Client
                System.out.println("Accepted client connection");

                ServerUser user = new ServerUser(clientSocket);
                user.start();

                /*
                //Reads the receiving message from Client
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String message = bufferedReader.readLine();

                System.out.println("Received from Client: " + message);

                PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(), true);
                //Received message from the Client
//            printWriter.println("Server echoing back the following message " + message + " from Client");
                printWriter.println("Client says:" + message);
                */
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
