import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server extends Thread{
    private final int serverPort;

    private ArrayList<ServerUser> userList = new ArrayList<>();

    public Server(int serverPort) {
        this.serverPort = serverPort;
    }

    public List<ServerUser> getUserList() {
        return userList;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);

            while (true) {
                System.out.println("About to accept client connection...");
                //Client Socket (:- An end-point for communication between two machines)
                Socket clientSocket = serverSocket.accept(); //Listens for a connection & Accepts the connection from the Client
                System.out.println("Accepted client connection");

                ServerUser user = new ServerUser(this, clientSocket);
                userList.add(user);
                user.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
