package com.sparta.sortView;
import com.sparta.sortController.SortManager;
import com.sparta.sortModel.AbstractFactory;
import com.sparta.sortModel.AbstractSorter;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DisplayManager implements View {

    private final Logger logger;
    private final AbstractFactory<AbstractSorter> factory;

    public DisplayManager(AbstractFactory<AbstractSorter> factory) {
         this.logger = SortManager.logger;
         this.factory = factory;
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            logger.info("Asking user to choose algorithm option");
            System.out.println("\n" + factory.userInstructions() + " 9: Exit the program");
            int algoChoice = getIntFromUser(scanner, 0, "algorithm option");
            if(algoChoice==9) {
                logger.info("User chose to exit the application");
                break;
            }
            AbstractSorter sorter = factory.create(algoChoice);
            if(sorter ==null) {
                logger.warn("User picked an invalid option for a sorting algorithm");
                continue;
            }
            logger.info("User chose option of " + sorter.getDescription());
            System.out.println("Please enter a number for the length of the array");
            int lengthChoice = getIntFromUser(scanner, 1, "length of array");
            if(lengthChoice>=1000)
                logger.warn("User inputted a big number for length: " + lengthChoice);
            else logger.info("Length of the array has been chosen successfully:" + lengthChoice);

            displayAlgorithmInAction(sorter, sorter.generateRandomArray(lengthChoice));
            logger.info("App successfully presented output using " + sorter.getDescription());
        }
        scanner.close();
    }

    private void displayAlgorithmInAction(AbstractSorter sorter, int[] randomArr) {
        printArrayElements(randomArr);
        System.out.println("Algorithm to be used: " + sorter.getDescription());
        long startTime = System.currentTimeMillis();
        int[] sortedArr = sorter.sortArray(randomArr);
        long stopTime = System.currentTimeMillis();
        System.out.println("Time to complete " + sorter.getDescription()
                + ": " + (stopTime - startTime) + "ms");
        printArrayElements(sortedArr);
    }

    private int getIntFromUser(Scanner scanner, int minAcceptable, String reason) {
        int userInput = Integer.MIN_VALUE; // smaller than minimum acceptable value
        do{
            try{
                logger.info("Asking user to input a new integer for " + reason);
                userInput = Integer.parseInt(scanner.next());;
            } catch(NumberFormatException e) {
                logger.error("EXCEPTION CAUGHT: User entered bad input for length : " + e.getMessage());
                System.out.println("Entered number is invalid, please try again");
                continue;
            }
            if(userInput < minAcceptable) {
                logger.warn("User chose invalid int as input");
                System.out.println("Entered number is invalid, please try again");
            }
        } while(userInput < minAcceptable);
        return userInput;
    }

    private void printArrayElements(int[] array) {
        for (int i: array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
