package com.alex.jobs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The vowels in English are a, e, i, o, u
 * Строка для проверки метода "Lorem ipsum dolor sit amet, consectetur adipiscing elit"
 * <p>
 * Разработать метод, принимающий на вход строку, и выводящий на экран статистику количества гласных букв в строке
 * Пример вывода:
 * e: 1
 * o: 3
 * i: 1
 * u: 0
 * etc...
 */

public class Innotech2 {

    public static Map<Character, Integer> getStats(String str) {
        HashMap<Character, Integer> stats = new HashMap<>();
        List<Character> vovles = Arrays.asList('a', 'e', 'i', 'o', 'u');
        for (int i = 0; i < str.toCharArray().length; i++) {
            char symbol = str.charAt(i);
            if (vovles.contains(symbol)) {
                if (stats.containsKey(symbol)) {
                    int count = stats.get(symbol);
                    count++;
                    stats.put(symbol, count);
                } else {
                    stats.put(symbol, 1);
                }
            }
        }
        return stats;
    }

    public static void main(String[] args) {
        getStats("Lorem ipsum dolor sit amet, consectetur adipiscing elit").entrySet().stream().forEach(
                (entry) -> System.out.println(entry.getKey() + ":" + entry.getValue())
        );
    }
}
