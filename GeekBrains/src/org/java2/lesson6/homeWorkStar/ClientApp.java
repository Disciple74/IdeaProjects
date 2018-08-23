package org.java2.lesson6.homeWorkStar;

import java.io.IOException;

public class ClientApp{
    public static void main(String[] args) throws IOException {
        Thread client = new Thread(new Client());
        client.start();
    }
}
