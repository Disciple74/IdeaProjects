package org.java2.lesson6.classWork;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Random;

public class ServerSocketHandler implements Runnable {

    private Socket socket;

    public ServerSocketHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        Random random = new Random();
        String response = String.format("Hello, user. Your ID = [%s]", random.nextInt());
        try (BufferedWriter bufferedWriter =
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    this.socket.getOutputStream()))) {
            bufferedWriter.write(response);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (Throwable t){
            t.printStackTrace();
        } finally {
            try {
                this.socket.close();
            } catch (IOException e) {}
        }

    }
}
