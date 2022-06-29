package com.sparta.sort;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

public class SortManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose a sorting algorithm (0:Bubble):");
        int algoChoice = scanner.nextInt();
        System.out.println("Please choose the array length:");
        int lengthChoice = scanner.nextInt();
        scanner.close();

        int[] randomArr = generateRandomArray(lengthChoice);
        int[] sortedArr = new int[lengthChoice];

        printArrayElements(randomArr);
        System.out.println("Algorithm to be used: " + Algorithms.values()[algoChoice]);

        var startTime = System.currentTimeMillis();
        if(Algorithms.values()[algoChoice] == Algorithms.BUBBLE) {
            sortedArr = new BubbleSorter().sortArray(randomArr);
        }
        long stopTime = System.currentTimeMillis();
        printArrayElements(sortedArr);
        System.out.println("Time to complete " +
                Algorithms.values()[algoChoice] +
                "sort: " + (stopTime - startTime) + "ms");
    }

    private static void printArrayElements(int[] array) {
        System.out.print("Current values of array: ");
        for (int i: array) {
            System.out.print(i + " ");
        }
        System.out.println();
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
