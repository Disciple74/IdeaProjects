package ru.geekbrains.tasks.ed.art.Task_6;

import java.io.*;
import java.util.Scanner;

public class Search {
    public static void main(String args[]) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/text/text3.txt")); //Reading from file
            int readBuffer;
            String fileText = "";
            while ((readBuffer = bufferedReader.read()) != -1) {
                fileText += (char) readBuffer;
            }
            if (search(getKeyWord(), fileText)) System.out.println("Find it!"); // Searching keyword in file
            else System.out.println("Can't find it:(");                         // And printing result
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String getKeyWord(){
        Scanner scanner = new Scanner(System.in);
        String result;
        while(true) {
            System.out.println("Type the word you want to find in here: ");
            if (scanner.hasNextLine()) {
                result = scanner.nextLine();
                if (!result.isEmpty()) {
                    scanner.close();
                    return result;
                } else {
                    System.out.println("Alert! \"Find\" field is empty!");
                    scanner = new Scanner(System.in);
                }
            } else System.out.println("I found some problems. So sorry:(");
        }
    }

    private static boolean search(String key, String fileText) {
        if ((key == null) || (fileText == null)) {
            return false;
        }
        char[] text = fileText.toCharArray();

        for (int i = 0; i < text.length-key.length(); i++) {
            String buffer = "";
            for (int j = i; j < i + key.length(); j++) buffer += text[j];
            if (key.equals(buffer)) return true;
        }
        return false;
    }
}
