package com.alex.jobs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Innotech {
    /*
        Массив слов, на латинице. Вход лист стрингов, на выходе тоже.
        Обработать по 3м правилам:
        1) все слова должны быть в верхнем регистре на выходе
        2) все слова должны быть уникальными // все слова одинковые; все слова разные
        3) во всех словах все буквы "а" нужно заменить на 4ки. // а - в начале; середине; конце; одна буква вообще
     */
    public static List<String> processWords(List<String> words) throws NullPointerException {
        return words.stream()
                .map(word -> word == null ? "" : word.toUpperCase().replace('A', '4'))
                .distinct()
                .filter(word -> !"".equals(word))
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
        List<String> testData = new ArrayList<>();
        testData.add("ababa"); // 4B4B4
        testData.add("AbAbA"); // пропасть
        testData.add(null); // замениться на пустую строку
        testData.add("a"); // 4
        testData.add("4b4b4"); // пропасть
        System.out.println(processWords(testData));

        // пустой лист
        List<String> testData2 = new ArrayList<>();
        System.out.println(processWords(testData2));

        // лист только с 2мя одинаковыми словами
        List<String> testData3 = new ArrayList<>();
        testData3.add("word");
        testData3.add("word");
        System.out.println(processWords(testData3)); // word

        try {
            System.out.println(processWords(null)); // ""
        } catch (NullPointerException e) {
            System.out.println("Error:" + e);
        }
    }
}
