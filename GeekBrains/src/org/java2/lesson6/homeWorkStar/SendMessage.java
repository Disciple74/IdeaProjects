package org.java2.lesson6.homeWorkStar;

import java.io.*;
import java.net.Socket;

public class SendMessage extends Thread{
    private BufferedReader in;
    private BufferedWriter out;
    Socket socket;

    public SendMessage(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(System.in));
        this.out = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
    }

    @Override
    public void run() {
        while (true){
            try {
                String message = this.in.readLine();
                if (!message.isEmpty()){
                    if (message.equalsIgnoreCase("exit")) {break;}
                    this.out.write(message);
                    this.out.newLine();
                    this.out.flush();
                }
            } catch (IOException e) {
            }
        }
        try {
            this.out.close();
        } catch (IOException e) {}
    }
}
