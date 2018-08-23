package org.java2.lesson1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Course course = new Course();
        Team t1 = new Team();
        Team t2 = new Team();
        course.doIt(t1);
        course.doIt(t2);
        System.out.println("Wanna get all information or only about winners? A/W");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            switch (scanner.nextLine()) {
                case "A": {
                    t1.showResults();
                    t2.showResults();
                    break;
                }
                case "a": {
                    t1.showResults();
                    t2.showResults();
                    break;
                }
                case "W": {
                    t1.showWinResults();
                    t2.showWinResults();
                    break;
                }
                case "w": {
                    t1.showWinResults();
                    t2.showWinResults();
                    break;
                }
                default:
                    System.out.println("Can't understand you:(");
                    break;
            }
        }
    }
}
