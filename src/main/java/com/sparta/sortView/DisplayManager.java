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
            int algoChoice = getIntFromUser(scanner, 0, "algorithm option");
            if (algoChoice == 9) {
                logger.info("User chose to exit the application");
                break;
            }
            AbstractSorter sorter = factory.create(algoChoice);
            try {
                logger.info("User chose option of " + sorter.getDescription());
                System.out.println("Please enter a number for the length of the array");
                int lengthChoice = getIntFromUser(scanner, 1, "length of array");
                if (lengthChoice >= 1000)
                    logger.warn("User inputted a big number for length: " + lengthChoice);
                else logger.info("Length of the array has been chosen successfully:" + lengthChoice);

                String result = sorter.getResultFromRunningAlgorithm(lengthChoice);
                System.out.println(result);

                logger.info("App successfully presented output using " + sorter.getDescription());
            } catch(NullPointerException e) { // in case sorter is null from the factory
                logger.warn("User picked an invalid option for a sorting algorithm: " + algoChoice, e);
            } // continues while loop to ask user to choose a valid sorting algorithm next
        }
        scanner.close();
    }

    private int getIntFromUser(Scanner scanner, int minAcceptable, String reason) {
        int userInput = Integer.MIN_VALUE; // smaller than minimum acceptable value
        do{
            logger.info("Asking user to input a new integer for " + reason);
            try{
                userInput = Integer.parseInt(scanner.next());;
            } catch(NumberFormatException e) {
                logger.error("EXCEPTION CAUGHT: User entered bad input for length : " + e.getMessage(), e);
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
