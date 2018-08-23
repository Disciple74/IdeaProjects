package org.java2.lesson6.classWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SimpleClient {
    private Socket socket;

    public SimpleClient(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
    }

    public String request(){
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()))){
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                this.socket.close();
            } catch (IOException e) {
            }
        }
        return null;
    }
}
