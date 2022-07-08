package com.sparta.sortView;
import com.sparta.sortController.SortManager;
import com.sparta.sortModel.AbstractFactory;
import com.sparta.sortModel.AbstractSorter;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

public class DisplayManager implements View {

    private final Logger logger;
    private final AbstractFactory<AbstractSorter> factory;
    private static final int VALUE_TO_EXIT = 9;

    public DisplayManager(AbstractFactory<AbstractSorter> factory) {
         this.logger = SortManager.logger;
         this.factory = factory;
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println(factory.userInstructions());
            System.out.println(" " + VALUE_TO_EXIT + ": Exit the program");
            int algoChoice = getIntFromUser(scanner, 0, "algorithm option");
            if (algoChoice == VALUE_TO_EXIT) break;

            try {
                AbstractSorter sorter = factory.create(algoChoice);
                logger.info("User chose option of " + sorter.getDescription());
                System.out.println("Please enter a number for the length of the array");
                int lengthChoice = getIntFromUser(scanner, 1, "length of array");
                if (lengthChoice >= 1000)
                    logger.warn("User inputted a big number for length: " + lengthChoice);
                else logger.info("Length of the array has been chosen successfully:" + lengthChoice);

                int[] randomArr = AbstractSorter.generateRandomArray(lengthChoice);
                int[] randomArrCopy = randomArr.clone();
                System.out.println(sorter.getResultFromRunningAlgorithm(randomArr));
                allowUserToCompareAlgorithms(scanner, randomArrCopy);

                logger.info("App successfully presented output using " + sorter.getDescription());
            } catch (NullPointerException e) { // in case sorter is null from the factory
                logger.warn("User picked an invalid option for a sorting algorithm: " + algoChoice, e);
                System.out.println("No such algorithm option");
            } catch (Exception e) {
                logger.fatal("Unexpected exception encountered: ", e);
            }
        }
        scanner.close();
        logger.info("User chose to exit the application"); // via input of 9 into scanner
    }

    private void allowUserToCompareAlgorithms(Scanner scanner, int[] randomArr) {
        System.out.println("Would you like to compare this algorithm with another one:\n(Y/N)");
        String compareChoice = scanner.nextLine();
        if(compareChoice.equalsIgnoreCase("Y")){
            System.out.println(factory.userInstructions() + " [for comparison]");
            int algoChoice2 = getIntFromUser(scanner, 0, "algorithm option");
            try{
                AbstractSorter sorter2 = factory.create(algoChoice2);
                String result2 = sorter2.getResultFromRunningAlgorithm(randomArr);
                logger.info("User successfully compared previous algorithm with " + sorter2.getDescription());
                System.out.println(result2);
            } catch(NullPointerException e) { // in case sorter is null from the factory
                logger.error("User picked an invalid option for a sorting algorithm in comparison: ", e);
                System.out.println("No such algorithm option");
            } catch (Exception e) {
                logger.fatal("Unexpected exception encountered: ", e);
            }
        } else if (!compareChoice.equalsIgnoreCase("N")){
            logger.warn("User entered bad input for comparison - neither Y nor N: " + compareChoice);
        }
    }

    private int getIntFromUser(Scanner scanner, int minAcceptable, String reason) {
        int userInput = Integer.MIN_VALUE; // smaller than minimum acceptable value
        do{
            logger.info("Asking user to input an integer for " + reason);
            try{
                userInput = Integer.parseInt(scanner.nextLine());;
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
}
