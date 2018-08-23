package org.java2.lesson6.classWork;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer implements Runnable{

    private java.net.ServerSocket serverSocket;

    private List<ChatServerClient> clients = new ArrayList<>();

    public ChatServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    @Override
    public void run() {
        while (true){
            try {
                Socket accept = this.serverSocket.accept();
                ChatServerClient chatServerClient = new ChatServerClient(accept, this);
                Thread thread = new Thread(chatServerClient);
                thread.start();
                for (ChatServerClient client : this.clients) {
                    client.sendMessage("New user added");
                }
                this.clients.add(chatServerClient);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }

    public List<ChatServerClient> getClients() {
        return this.clients;
    }
}
