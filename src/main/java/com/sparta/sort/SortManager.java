package com.sparta.sort;

import java.util.Random;
import java.util.Scanner;

public class SortManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SortFactory sortFactory = new SortFactory();

        System.out.println(sortFactory.getUserInstructions());
        int algoChoice = scanner.nextInt();

        Sorter sorter = sortFactory.getSorter(algoChoice);

        /*
        System.out.println("Please choose the array length:");
        int lengthChoice = scanner.nextInt();
        scanner.close();

        int[] randomArr = generateRandomArray(lengthChoice);
        int[] sortedArr = new int[lengthChoice];

        printArrayElements();
        System.out.println("Algorithm to be used: " + Algorithms.values()[algoChoice]);

        var startTime = System.currentTimeMillis();
        if(Algorithms.values()[algoChoice] == Algorithms.BUBBLE) {
            sortedArr = new BubbleSorter().sortArray(randomArr);
        }
        long stopTime = System.currentTimeMillis();
        bubble.printArrayElements();
        System.out.println("Time to complete " +
                Algorithms.values()[algoChoice] +
                "sort: " + (stopTime - startTime) + "ms");
        */
    }

    private static int[] generateRandomArray(int length) {
        Random random = new Random();
        int[] result = new int[length];
        for (int i = 0; i < length ; i++) {
            result[i] = random.nextInt(1, 1000);
        }
        return result;
    }

}