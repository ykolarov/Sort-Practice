package com.sparta.sort;

import java.util.Random;
import java.util.Scanner;

public class SortManager {
    private static boolean continueProgram = true;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SorterFactory sorterFactory = new SorterFactory();
        Sorter sorter;

        while(continueProgram) {
            System.out.println("\n" + sorterFactory.getUserInstructions() + " 9: Exit the program");

            int algoChoice = scanner.nextInt();
            if(algoChoice==9) {continueProgram=false; break;}
            sorter = sorterFactory.getSorter(algoChoice);
            if(sorter==null) continue;

            System.out.println("Please choose the array length:");
            int lengthChoice = scanner.nextInt();

            int[] randomArr = generateRandomArray(lengthChoice);

            printArrayElements(randomArr);
            //TODO: System.out.println("Algorithm to be used: " + Algorithms.values()[algoChoice]);

            long startTime = System.currentTimeMillis();
            int[] sortedArr = sorter.sortArray(randomArr);
            long stopTime = System.currentTimeMillis();
            System.out.println("Time to complete " + "sort: " + (stopTime - startTime) + "ms");

            printArrayElements(sortedArr);
        }
    }

    private static int[] generateRandomArray(int length) {
        Random random = new Random();
        int[] result = new int[length];
        for (int i = 0; i < length ; i++) {
            result[i] = random.nextInt(1, 1000);
        }
        return result;
    }

    private static void printArrayElements(int[] array) {
        for (int i: array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}