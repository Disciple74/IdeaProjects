package org.java2.lesson6.homeWorkStar;

import java.io.*;
import java.net.Socket;

public class Client implements Runnable {

    private final String SERVER_ADDRESS = "localhost";
    private final int SERVER_PORT = 8981;
    private Socket socket;
    private SendMessage sender;
    private GetMessage getter;
    private final boolean id = true;


    public Client() throws IOException {
        this.socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
        System.out.println("Connection successful");
        this.sender = new SendMessage(this.socket);
        this.getter = new GetMessage(this.socket, this.id);
        this.sender.setDaemon(true);
        this.getter.setDaemon(true);
    }

    @Override
    public void run() {
        this.sender.start();
        this.getter.start();
        while (this.sender.isAlive()&&this.getter.isAlive()){
            try {
                this.getter.join();
                this.sender.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

  //  private void sendMessage() {
/*        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
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
        } catch (IOException e) {}
    }*/
 /*   private void getMessage(){
        BufferedReader in = this.reader;
        while (true) {
            try {
                String message = in.readLine();
                if (!message.isEmpty()){
                    if (message.equalsIgnoreCase("exit")) break;
                    System.out.println(String.format("FROM %s: %s", "SERVER", message));
                }
            } catch (IOException e) {
            }
        }
    }*/
}
