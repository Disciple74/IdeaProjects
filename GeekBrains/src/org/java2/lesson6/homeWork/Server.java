package org.java2.lesson6.homeWork;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
    private ServerSocket serverSocket;
    private Socket socket;
    BufferedReader reader;
    BufferedWriter writer;

    public Server(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        System.out.println("Server is up, waiting for connect...");
    }

    @Override
    public void run() {
        try {
            this.socket = this.serverSocket.accept();
            System.out.println("Client connected");
            this.reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.writer = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
            while (true) {
                String message = reader.readLine();
                if (message.equals("end")) break;
                writer.write(message);
                System.out.println(message);
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            System.out.println("Server initialization error");
        } finally {
            try {
                System.out.println("Server disconnected");
                this.serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
