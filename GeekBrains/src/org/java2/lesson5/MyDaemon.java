package org.java2.lesson5;

public class MyDaemon extends Thread {
    @Override
    public void run() {
        System.out.println("MyDaemon Start");
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyDaemon End");
    }
}
