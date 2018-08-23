package com.company;

public class Main {

    static int beerNum = 99;

    public static void main(String[] args) {
        // write your code here

        while (beerNum > 0) {
            if ((beerNum > 19)||(beerNum < 10)) {
                if ((beerNum % 10 == 1)||(beerNum == 1)) songOutput("бутылка"); else
                if (((beerNum % 10 >= 2)&&(beerNum % 10 <= 4))||(beerNum >= 2)&&(beerNum <=4))
                    songOutput("бутылки");
                else songOutput("бутылок");
            } else songOutput("бутылок");
        }

    }

    public static void songOutput(String word) {
        System.out.println(beerNum + " " + word + " пива на стене");
        System.out.println(beerNum + " " + word + " пива.");
        System.out.println("Возьми одну.\nПусти по кругу.");
        beerNum--;
        if (beerNum != 0){
            System.out.println(beerNum + " " + word + " пива на стене");
        }else
            System.out.println("Нет бутылок пива на стене");
    }
}
