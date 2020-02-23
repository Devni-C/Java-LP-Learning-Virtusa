import java.io.*;
import java.net.Socket;
import java.util.Date;

public class ServerUser extends Thread {
    private final Socket clientSocket;

    public ServerUser(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            handleClientSocket();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void handleClientSocket() throws IOException, InterruptedException {
        InputStream inputStream = clientSocket.getInputStream();
        OutputStream outputStream = clientSocket.getOutputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;

        while ((line = reader.readLine())!= null){
            if ("quit".equalsIgnoreCase(line)) {
                break;
            }
            String message = "You typed: " + line;
            outputStream.write(message.getBytes());
        }

        clientSocket.close();
    }
}
