package org.java2.lesson6.homeWorkStar;

import java.io.IOException;

public class ServerApp {
    public static void main(String[] args) throws IOException {
        Thread server = new Thread(new Server(8981));
        server.start();
    }
}
