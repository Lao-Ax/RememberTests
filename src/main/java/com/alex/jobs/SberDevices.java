package com.alex.jobs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SberDevices {

    public static String findTheSame(String str) throws NumberFormatException {
        int[] numbers = Arrays.stream(str.split(", ")).mapToInt(Integer::parseInt).sorted().toArray();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                result.add(numbers[i]);
                while (numbers[i] == numbers[i + 1]) {
                    i++;
                }
            }
        }
        return result.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        try {
            System.out.println(findTheSame("1, 0, 3, 0, 4, 2, 3, 5, 4"));
        } catch (NumberFormatException e) {
            System.out.println("error :)");
        }
    }
}
