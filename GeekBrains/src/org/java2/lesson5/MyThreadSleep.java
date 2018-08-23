package org.java2.lesson5;

public class MyThreadSleep extends Thread {
    @Override
    public void run() {

        try {
            System.out.println(this.getName() + " SLEEP!");
            Thread.sleep(5000);
            System.out.println(this.getName() + " WAKED UP!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
