package org.java2.lesson2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Type your string of numbers here: ");
        Scanner scanner = new Scanner(System.in);
        Matrix matrix = new Matrix();
        if (scanner.hasNextLine()){
            matrix.setStr(scanner.nextLine());
        }
        try {
            matrix.stringToMatrix();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(matrix.toIntMatrix());

    }
}
