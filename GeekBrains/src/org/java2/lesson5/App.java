package org.java2.lesson5;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws InterruptedException {
        t02();
    }

    private static void t02() throws InterruptedException{
        MyDaemon myDaemon = new MyDaemon();
        myDaemon.setDaemon(true);
        myDaemon.start();
        Thread.sleep(100);
        //myDaemon.join();
        System.out.println("Finish!");
    }

    private static void t01() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Organization organization = new Organization();

            threads.add(organization);

            organization.start();

        }
        for (Thread thread : threads){
            thread.join();
        }
        System.out.println("Bank.MONEY = " + Bank.MONEY);
    }
}
