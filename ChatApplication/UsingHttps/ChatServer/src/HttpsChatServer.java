import com.sun.net.httpserver.*;

import javax.net.ssl.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HttpsChatServer {
    private static Map<String, ArrayList<String>> usersMap = new HashMap<>();

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("/home/user/Desktop/Devni/Github/Java-LP-Learning-Virtusa/ChatApplication/UsingHttps/SSL/ChatKeyStore.jks");
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(fileInputStream, "devni123".toCharArray());

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
            keyManagerFactory.init(keyStore, "devni123".toCharArray());

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
            trustManagerFactory.init(keyStore);

            HttpsServer httpsServer = HttpsServer.create(new InetSocketAddress(8181), 0);
            SSLContext context = SSLContext.getInstance("TLS");

            context.init(keyManagerFactory.getKeyManagers(),
                    trustManagerFactory.getTrustManagers(), null);
            httpsServer.setHttpsConfigurator(new HttpsConfigurator(context) {
                @Override
                public void configure(HttpsParameters httpsParameters) {
                    SSLContext sslContext = getSSLContext();
                    SSLEngine sslEngine = sslContext.createSSLEngine();
                    httpsParameters.setNeedClientAuth(false);
                    httpsParameters.setCipherSuites(sslEngine.getEnabledCipherSuites());
                    httpsParameters.setProtocols(sslEngine.getEnabledProtocols());
                    SSLParameters defaultSSLParameters = sslContext.getSupportedSSLParameters();
                    httpsParameters.setSSLParameters(defaultSSLParameters);
                }
            });

            httpsServer.createContext("/connect", HttpsChatServer::handleConnect);
            httpsServer.createContext("/send", HttpsChatServer::handleSend);
            httpsServer.createContext("/receive", HttpsChatServer::handleReceive);
            httpsServer.createContext("/list", HttpsChatServer::handleUserList);
            httpsServer.createContext("/disconnect", HttpsChatServer::handleDisconnect);
            httpsServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
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
                response = "No Users";
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
