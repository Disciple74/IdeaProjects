package org.java2.lesson6.classWork;

import java.io.IOException;


public class ServerSocket implements Runnable{

    private java.net.ServerSocket serverSocket;

    public ServerSocket(int port) throws IOException {
        this.serverSocket = new java.net.ServerSocket(port);

    }

    @Override
    public void run() {
        while (true){
            try {
                Thread thread = new Thread(
                        new ServerSocketHandler(
                                this.serverSocket.accept()
                        ));
                thread.setDaemon(true);
                thread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
