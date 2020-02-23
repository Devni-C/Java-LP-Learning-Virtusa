import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket {
    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                Socket socket = new Socket("localhost", 8181);

                //Sends a message to the Server
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                //Command line argument as the message
                printWriter.println(args[0]);

                //Reads the message from the Server
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("Received from: " + bufferedReader.readLine());

            } catch (UnknownHostException e) {
                e.printStackTrace();
                System.exit(1);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(2);
            }
        } else {
            System.err.println("Usage: Client <server> <name>");
        }
    }
}
