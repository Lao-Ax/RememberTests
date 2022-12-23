package com.alex.jobs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ozon2 {

    /*
        Удалить все дубликаты из списка.
        Пример:
        Input: [ 3, 2, 1, 1, 0, 4, 5, 2, 0]
        Output: [ 3, 2, 1, 0, 4, 5]
     */
    public static List<Integer> removeDuplicates(int[] digits) {
        List<Integer> found = new ArrayList<>();
        Arrays.sort(digits);
        found.add(digits[0]);
        for (int i = 1; i < digits.length; i++) {
            int digit = digits[i];
            if (digit != digits[i-1]) {
                found.add(digit);
            }
        }

        return found;
    }

    public static void main(String[] args) {
        int[] digits = {3, 2, 1, 1, 0, 4, 5, 2, 0};

        // null
        // []
        // [1]
        // [1,1,1]
        // [-1,1,-1]
        removeDuplicates(digits).forEach(System.out::println);
    }
}
