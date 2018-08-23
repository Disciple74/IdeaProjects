package org.java2.lesson6.homeWorkStar;

import java.io.*;
import java.net.Socket;

public class GetMessage extends Thread{
    private BufferedReader in;
    private BufferedWriter out;
    Socket socket;
    private boolean id;

    public GetMessage(Socket socket, boolean id) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        this.out = new BufferedWriter(new OutputStreamWriter(System.out));
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = in.readLine();
                if (message != null){
                    if (message.equalsIgnoreCase("exit")) {break;}
                    System.out.println(String.format("FROM %s: %s", id ? "SERVER" : "CLIENT", message));
                }
            } catch (IOException e) {
            }
        }
    }
}
