package org.java2.lesson3;

import java.util.ArrayList;
import java.util.HashSet;


public class App {
    public static void main(String[] args) {
        String[] words = {"fast", "furious", "march", "solo", "queen", "fast", "fast", "percent", "solo",
                            "march", "solo", "fast", "cast", "magic", "similar", "magic", "percent", "queen",
                            "anyway", "cast", "sorry"};
        ArrayList<String> wordsList = new ArrayList<>();
        for (String word : words){
            wordsList.add(word);
            //System.out.println("Word \"" + word + "\" appears " + countSimilarWords(words, word) + " times");
        }
        HashSet<String> hashWordsSet = new HashSet<>();
        for (String word : wordsList) {
            hashWordsSet.add(word);
        }
        for (String word : hashWordsSet) {
            System.out.println("Word \"" + word + "\" appears " + countSimilarWords(wordsList, word) + " times");
        }
        System.out.println("This text contains words:\n" + hashWordsSet);

    }

    private static int countSimilarWords(ArrayList<String> words, String buffer){
        int count = 0;
        for (String word : words){
            if (buffer == word) count++;
        }
        return count;
    }


}
