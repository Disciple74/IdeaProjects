package org.java2.lesson5;

public class Organization extends Thread{
    @Override
    public void run() {
        System.out.println("Bank.getMONEY(20) = " + Bank.getMONEY(20));
    }
}
