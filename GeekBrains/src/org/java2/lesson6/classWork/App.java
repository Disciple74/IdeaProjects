package org.java2.lesson6.classWork;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        t04();
        t05();
    }

    private static void t05() throws Exception {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            ChatClient chatClient = new ChatClient("localhost", 9999);
            Thread thread = new Thread(chatClient);
            thread.start();
            String s = String.format("Hello all, I'm user #%s", random.nextInt());
            chatClient.sendMessage(s);
        }
    }

    private static void t04() throws Exception {
        Thread thread = new Thread(new ChatServer(9999));
        thread.start();
    }

    private static void t03()throws Exception{
        for (int i = 0; i < 10; i++) {
            System.out.println(new SimpleClient("localhost", 9999).request());
        }
    }


    private static void t02()throws Exception{
        Thread thread = new Thread(
                new ServerSocket(80));
        thread.start();
    }

    public static void t01() throws Exception{
        URL url = new URL("https://www.yandex.ru");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        int responseCode = urlConnection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK){
            System.out.println("Request is done");
            try (BufferedReader reader =
                         new BufferedReader(new InputStreamReader(
                                 urlConnection.getInputStream()
                         ))){
                System.out.println(reader.readLine());
            }
        } else System.out.println("We're f*cked");
    }

}
