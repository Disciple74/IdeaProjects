package org.java2.lesson5.homework;

public class Method extends Thread{
    float[] arr;

    @Override
    public void run() {
        if (arr == null) {
            throw new IllegalArgumentException("empty arr");
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = setArray(i, arr[i]);
        }
    }
    public Method(float arr[]){
        this.arr = arr;
    }

    public float setArray(int i, float old){
        return (float)(old * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }
}
