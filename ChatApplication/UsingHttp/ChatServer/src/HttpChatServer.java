import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HttpChatServer {
    private static Map<String, ArrayList<String>> usersMap = new HashMap<>();

    public static void main(String[] args) {
        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(8181), 0);
            httpServer.createContext("/connect", HttpChatServer::handleConnect);
            httpServer.createContext("/send", HttpChatServer::handleSend);
            httpServer.createContext("/receive", HttpChatServer::handleReceive);
            httpServer.createContext("/list", HttpChatServer::handleUserList);
            httpServer.createContext("/disconnect", HttpChatServer::handleDisconnect);
            httpServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleDisconnect(HttpExchange httpExchange) {
        InputStream requestBody = httpExchange.getRequestBody();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(requestBody));
        OutputStream responseBody = httpExchange.getResponseBody();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(responseBody));

        try {
            String name = bufferedReader.readLine();
            bufferedReader.close();
            String response = "User doesn't exist!";
            if (usersMap.containsKey(name)) {
                usersMap.remove(name);
                response = "Disconnected";
            }
            httpExchange.sendResponseHeaders(200, response.length());
            bufferedWriter.write(response);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpExchange.close();
        }

    }

    private static void handleUserList(HttpExchange httpExchange) {
        InputStream requestBody = httpExchange.getRequestBody();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(requestBody));
        OutputStream responseBody = httpExchange.getResponseBody();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(responseBody));

        try {
            String name = bufferedReader.readLine();
            bufferedReader.close();

            StringBuffer responseBuffer = new StringBuffer();
            usersMap.keySet().stream()
                    .filter(s -> !s.equals(name))
                    .forEach(s -> {
                        responseBuffer.append(s);
                        responseBuffer.append("%%");
                    });

            String response = responseBuffer.toString();
            httpExchange.sendResponseHeaders(200, response.length());
            bufferedWriter.write(response);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpExchange.close();
        }
    }

    private static void handleReceive(HttpExchange httpExchange) {
        InputStream requestBody = httpExchange.getRequestBody();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(requestBody));
        OutputStream responseBody = httpExchange.getResponseBody();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(responseBody));

        try {
            String name = bufferedReader.readLine();
            bufferedReader.close();

            StringBuffer buffer = new StringBuffer();
            ArrayList<String> list = usersMap.get(name);
            usersMap.put(name, null);

            if (list != null) {
                list.stream().forEach(s -> {
                    buffer.append(s);
                    buffer.append("%%");
                });
            }
            String response = buffer.toString();
            System.out.println(response);
            httpExchange.sendResponseHeaders(200, response.length());
            bufferedWriter.write(response);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void handleSend(HttpExchange httpExchange) {
        InputStream requestBody = httpExchange.getRequestBody();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(requestBody));
        OutputStream responseBody = httpExchange.getResponseBody();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(responseBody));

        try {
            String name = bufferedReader.readLine();
            String receiver = bufferedReader.readLine();
            String message = bufferedReader.readLine();
            bufferedReader.close();

            String response = "";

            if (usersMap.containsKey(receiver)) {
                ArrayList<String> list = usersMap.get(receiver);

                if (list == null) {
                    list = new ArrayList<>();
                    usersMap.put(receiver, list);
                }
                list.add(name + " -> " + message);
            } else {
                response = "No messages";
            }
            httpExchange.sendResponseHeaders(200, response.length());
            bufferedWriter.write(response);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpExchange.close();
        }
    }

    private static void handleConnect(HttpExchange httpExchange) {
        InputStream requestBody = httpExchange.getRequestBody();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(requestBody));
        OutputStream responseBody = httpExchange.getResponseBody();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(responseBody));

        try {
//            String response = "Hello Devni";
            String name = bufferedReader.readLine();
            bufferedReader.close();

            String response = "Connected!";

            if (usersMap.containsKey(name)) {
                response = "Username is Taken!";
            } else {
                response = "User Added!";
                usersMap.put(name, null);
                System.out.println(usersMap.get(name));
            }
            httpExchange.sendResponseHeaders(200, response.getBytes().length);
            bufferedWriter.write(response);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpExchange.close();
        }
    }
}
