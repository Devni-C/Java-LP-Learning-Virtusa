import sun.net.www.http.HttpClient;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpChatClient {
    private static Scanner scanner;
    private static String userName;
    private static String serverURL;
    private static boolean isConnected = false;
    private static Pattern pattern;
    private static Matcher matcher;


    public static void main(String args[]) throws IOException, ProtocolException {
        scanner = new Scanner(System.in);

        while (true) {
            try {
                Thread.sleep(1000);
                String input = scanner.nextLine();

                if (input.matches("connect [a-z0-9:.] + as [a-z0-9] + ")) {
                    if (!isConnected) {
                        String[] split = input.split(" ", 4);
                        serverURL = split[1];
                        userName = split[3];
                        connectUser();
                    } else {
                        System.out.println("You have connected as " + userName);
                    }
                } else if (isConnected && input.matches("list")) {
                    sendUserList();
                } else if (isConnected && input.matches("send .* -> .*")){
                    String[] subString = input.substring(5).split(" -> ");
                    sendMessage(subString[0], subString[1]);
                } else if (isConnected && input.matches("exit")) {
                    sendDisconnect();
                } else if (isConnected) {
                    System.out.println("INVALID INPUT!");
                } else {
                    System.out.println("NOT CONNECTED!");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


        /*URL url = new URL("http://localhost:8181/test");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }

        in.close();*/
    }

    private static void sendDisconnect() {
        try {
            URL url = new URL("http://" + serverURL + "/disconnect");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream()));
            bufferedWriter.write(userName);
            bufferedWriter.close();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String input = bufferedReader.readLine();

            if (input.equals("Disconnected")) {
                isConnected = false;
                userName = null;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendMessage(String message, String receiver) {
        try {
            URL url = new URL("http://" + serverURL + "/connect");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream()));
            bufferedWriter.write(userName);
            bufferedWriter.newLine();
            bufferedWriter.write(receiver);
            bufferedWriter.newLine();
            bufferedWriter.write(message);
            bufferedWriter.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String input = bufferedReader.readLine();
            if ("no".equals(input)) {
                System.out.println("User doesn't Exist!");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendUserList() {
        try {
            URL url = new URL("http://" + serverURL + "/connect");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream()));
            bufferedWriter.write(userName);
            bufferedWriter.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String input = bufferedReader.readLine();

            if (input.isEmpty()) {
                System.out.println("No user exist!");
            } else {
                System.out.print(input.replaceAll("%%", System.lineSeparator()));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void connectUser() {
        if (!isConnected) {
            try {
                URL url = new URL("http://" + serverURL + "/connect");
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("POST");
                urlConnection.setDoOutput(true);

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream()));
                bufferedWriter.write(userName);
                bufferedWriter.close();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

                String input = bufferedReader.readLine();

                if (input.equals("taken")) {
                    userName = null;
                    isConnected = false;
                    System.out.println("User Exist! Select Another Name!");
                } else {
                    isConnected = true;
                    System.out.println("Connected");
//                    new MessageChecker().start();
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
