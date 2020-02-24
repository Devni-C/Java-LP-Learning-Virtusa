import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.List;

public class ServerUser extends Thread {
    private final Socket clientSocket;
    private final Server server;
    private String username = null;
    private OutputStream outputStream;


    public ServerUser(Server server, Socket clientSocket) {
        this.server = server;
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

    public String getUsername() {
        return username;
    }

    private void handleClientSocket() throws IOException, InterruptedException {
        InputStream inputStream = clientSocket.getInputStream();
        this.outputStream = clientSocket.getOutputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] tokens = StringUtils.split(line);
            if (tokens != null && tokens.length > 0) {
                String command = tokens[0];
                if (("logoff".equals(command))||("quit".equalsIgnoreCase(command))) {
                    handleLogOff();
                    break;
                } else if ("connect".equalsIgnoreCase(command)) {
                    handleConnectingClient(outputStream, tokens);
                } else if ("send->".equalsIgnoreCase(command)) {
                    String[] tokensMsg = StringUtils.split(line, null, 3);
                    handleMessage(tokensMsg);
                } else {
                    String message = "unknown " + command + "\n";
                    outputStream.write(message.getBytes());
                }
            }
        }
        clientSocket.close();
    }

    //format: 'send-> username message'
    private void handleMessage(String[] tokens) throws IOException {
        String sendTo = tokens[1];
        String msgBody = tokens[2];

        List<ServerUser> userList = server.getUserList();
        for (ServerUser user : userList) {
            if (sendTo.equalsIgnoreCase(user.getUsername())) {
                String outMsg = "send->" + username + " " + msgBody + "\n";
                user.send(outMsg);
            }
        }

    }

    private void handleLogOff() throws IOException {
        server.removeUser(this);
        List<ServerUser> userList = server.getUserList();

        //send other online users to current user's status
        String onlineMsg = username + " is offline\n";
        for (ServerUser user : userList) {
            if (!username.equals(user.getUsername())) {
                user.send(onlineMsg);
            }
        }
        clientSocket.close();
    }

    private void handleConnectingClient(OutputStream outputStream, String[] tokens) throws IOException {
        if (tokens.length == 3) {
            String username = tokens[2];
            System.out.println(username);

            if (username.equals("devni") || username.equals("manuri") || username.equals("kasun")) {
                String message = "You're now online!";
                outputStream.write(message.getBytes());
                this.username = username;
                System.out.println(username + message);

                List<ServerUser> userList = server.getUserList();

                //send current user to all other users' statuses
                for (ServerUser user : userList) {
                    if (user.getUsername() != null) {
                        if (!username.equals(user.getUsername())) {
                            String onMsg = "Online " + user.getUsername();
                            send(onMsg);
                        }
                    }
                }

                //send other online users to current user's status
                String onlineMsg = username + " is online\n";
                for (ServerUser user : userList) {
                    if (!username.equals(user.getUsername())) {
                        user.send(onlineMsg);
                    }
                }
            } else {
                String message = "Error!!!";
                outputStream.write(message.getBytes());
            }
        }
    }

    private void send(String msg) throws IOException {
        if (username != null) {
            outputStream.write(msg.getBytes());
        }
    }
}
