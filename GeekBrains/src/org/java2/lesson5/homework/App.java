package org.java2.lesson5.homework;

import java.util.ArrayList;
import java.util.List;

public class App {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("For method #1 it takes " + method_1() + "millis");
        System.out.println("For method #2 it takes " + method_2() + "millis");

    }

    private static long method_1(){
        float[] arr = newArray();
        if (arr == null) {
            throw new IllegalArgumentException("empty arr");
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return System.currentTimeMillis() - a;
    }

    private static long method_2() throws InterruptedException {
        float[] arr = newArray();
        float[] newArr_1 = new float[h];
        float[] newArr_2 = new float[h];
        List<Thread> threads = new ArrayList<>();
        threads.add(new Method(newArr_1));
        threads.add(new Method(newArr_2));
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, newArr_1, 0, h);
        System.arraycopy(arr, h, newArr_2, 0, h);
        for (Thread thread : threads){
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.arraycopy(newArr_1, 0, arr, 0, h);
        System.arraycopy(newArr_2, 0, arr, h, h);
        return System.currentTimeMillis() - a;
    }

    private static float[] newArray(){
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        return arr;
    }
}
