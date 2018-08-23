package org.java2.lesson6.classWork;

import java.io.*;
import java.net.Socket;

public class ChatClient implements Runnable{
    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;


    public ChatClient(String host, int port) throws IOException {
        this.socket = new Socket(host,port);
        this.reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        this.writer = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
    }

    public void sendMessage(String message) throws IOException {
        this.writer.write(message);
        this.writer.newLine();
        this.writer.flush();
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = reader.readLine();
                System.out.println(String.format("FROM SERVER = [%s]", message));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
