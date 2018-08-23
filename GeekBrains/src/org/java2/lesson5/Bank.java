package org.java2.lesson5;

public class Bank {

    public static int MONEY = 100;

    public synchronized static int getMONEY(int need) {
        if (MONEY >= need){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MONEY -= need;
            return need;
        }
        return 0;
    }
}
