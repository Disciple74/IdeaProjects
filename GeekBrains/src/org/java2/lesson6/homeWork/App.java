package org.java2.lesson6.homeWork;

import java.io.*;


public class App {

    public static void main(String[] args) throws IOException {
        server();
        new Window();
    }

    private static void server() throws IOException {
        Thread thread = new Thread(new Server(8981));
        thread.start();
    }
}
