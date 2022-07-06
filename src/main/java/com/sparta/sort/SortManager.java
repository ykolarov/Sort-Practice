package com.sparta.sort;

import java.util.Random;
import java.util.Scanner;
import org.apache.logging.log4j.*;
public class SortManager {

    public static Logger logger = LogManager.getLogger("My Logger"); // loads property file

    public static void main(String[] args) {
        // low lvl -> high level
        // trace, debug, info, warn, error, fatal
        logger.info("Info message");


        Scanner scanner = new Scanner(System.in);
        SorterFactory sorterFactory = new SorterFactory();
        Sorter sorter;

        while(true) {
            System.out.println("\n" + sorterFactory.getUserInstructions() + " 9: Exit the program");
            int algoChoice = scanner.nextInt();
            if(algoChoice==9) break;   // User chose to exit the program
            sorter = sorterFactory.getSorter(algoChoice);
            if(sorter==null) continue; // Let user pick a valid sorter

            System.out.println("Please choose the array length:");
            int lengthChoice;
            do{
                lengthChoice = scanner.nextInt();
                if(lengthChoice < 1) System.out.println("Please enter a positive number for length");
            } while(lengthChoice < 1);


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