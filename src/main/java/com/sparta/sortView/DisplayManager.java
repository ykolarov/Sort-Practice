package com.sparta.sortView;


import com.sparta.sortController.SortManager;
import com.sparta.sortModel.Sorter;
import com.sparta.sortModel.SorterFactory;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.Scanner;

public class DisplayManager {

    private final Logger logger;
    private SorterFactory sorterFactory;
    private Sorter sorter;

    public DisplayManager() {
         // TODO: refactor this class to reduce it to a single purpose
         this.logger = SortManager.logger;
         sorterFactory = new SorterFactory();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("\n" + sorterFactory.getUserInstructions() + " 9: Exit the program");
            int algoChoice = scanner.nextInt();
            if(algoChoice==9) {
                logger.info("User chose to exit the application");
                break;
            }
            sorter = sorterFactory.getSorter(algoChoice);
            if(sorter==null) {
                logger.warn("User picked an invalid option for a sorting algorithm");
                continue;
            }

            System.out.println("Please choose the array length:");
            int lengthChoice;
            do{
                lengthChoice = scanner.nextInt();
                if(lengthChoice < 1) System.out.println("Please enter a positive number for length");
            } while(lengthChoice < 1);

            if(lengthChoice>=1000)
                logger.warn("User inputted a big number for length: " + lengthChoice);
            else logger.info("Length input:" + lengthChoice);

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
