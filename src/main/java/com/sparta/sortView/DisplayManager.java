package com.sparta.sortView;


import com.sparta.sortController.SortManager;
import com.sparta.sortModel.AbstractFactory;
import com.sparta.sortModel.AbstractSorter;
import org.apache.logging.log4j.Logger;
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
            int algoChoice = scanner.nextInt();
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
            logger.info("Asking user to choose length for random array");
            int lengthChoice = getLengthChoiceFromUser(scanner);
            if(lengthChoice>=1000)
                logger.warn("User inputted a big number for length: " + lengthChoice);
            else logger.info("Length input:" + lengthChoice);

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

    private int getLengthChoiceFromUser(Scanner scanner) {
        System.out.println("Please choose the array length:");
        int lengthChoice;
        do{
            lengthChoice = scanner.nextInt();
            if(lengthChoice < 1) System.out.println("Please enter a positive number for length");
        } while(lengthChoice < 1);
        return lengthChoice;
    }

    private static void printArrayElements(int[] array) {
        for (int i: array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
