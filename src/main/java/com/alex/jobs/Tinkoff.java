package com.alex.jobs;

import java.util.Arrays;

public class Tinkoff {

    // Найти недостающее число из набора от 0 до N.
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 1, 0};
        int N = arr.length + 1;
        int expectedSum = N * (N - 1) / 2;
        int actualCount = Arrays.stream(arr).sum();
        System.out.println(expectedSum - actualCount);
    }

}
