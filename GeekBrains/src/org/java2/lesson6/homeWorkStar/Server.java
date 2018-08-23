package org.java2.lesson6.homeWorkStar;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private ServerSocket serverSocket;
    private Socket socket;
    private final boolean id = false;
    private SendMessage sender;
    private GetMessage getter;

    public Server(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        System.out.println("Server is up, waiting for connect...");

    }

    @Override
    public void run() {
        try {
            this.socket = this.serverSocket.accept();
            System.out.println("Client connected");
            this.sender = new SendMessage(this.socket);
            this.getter = new GetMessage(this.socket, this.id);
            this.sender.setDaemon(true);
            this.getter.setDaemon(true);
            this.sender.start();
            this.getter.start();
            while (this.sender.isAlive()&&this.getter.isAlive()){
                this.getter.join();
                this.sender.join();
            }
        } catch (IOException e) {
            System.out.println("Server initialization error");
        } catch (InterruptedException e) {
            e.printStackTrace();
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
/*    private void sendMessage(){
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = this.writer;
        while (true){
            try {
                String message = in.readLine();
                if (!message.isEmpty()){
                    if (message.equalsIgnoreCase("exit")) break;
                    out.write(message);
                    out.flush();
                }
            } catch (IOException e) {
            }
        }
        try {
            out.close();
        } catch (IOException e) {
        }
    }*/
  /*  private void getMessage(){
        BufferedReader in = this.reader;
        while (true) {
            try {
                String message = in.readLine();
                if (!message.isEmpty()){
                    if (message.equalsIgnoreCase("exit")) break;
                    System.out.println(String.format("FROM %s: %s", "CLIENT", message));
                }
            } catch (IOException e) {
            }
        }
    }
}*/