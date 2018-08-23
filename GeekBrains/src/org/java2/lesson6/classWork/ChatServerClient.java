package org.java2.lesson6.classWork;

import java.io.*;
import java.net.Socket;

public class ChatServerClient implements Runnable{

    private Socket socket;
    private BufferedWriter writer;
    private BufferedReader reader;
    private ChatServer server;

    public ChatServerClient(Socket socket, ChatServer chatServer) throws IOException {
        this.socket = socket;
        this.server = chatServer;
        this.writer = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
        this.reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
    }

    public void sendMessage(String s) throws IOException {
        this.writer.write(s);
        this.writer.newLine();
        this.writer.flush();
    }

    @Override
    public void run() {
        while (true){
            try {
                String s = this.reader.readLine();
                for (ChatServerClient chatServerClient : this.server.getClients()) {
                    chatServerClient.sendMessage(s);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
