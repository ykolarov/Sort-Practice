package com.sparta.sortModel;

import java.util.Arrays;
import java.util.Random;

public abstract class AbstractSorter implements Sorter {

    public abstract String getDescription();

    public String getResultFromRunningAlgorithm(int length) {
        int[] randomArr = generateRandomArray(length);
        String result = "Random array: " + Arrays.toString(randomArr) + "\n";

        long startTime = System.currentTimeMillis();
        int[] sortedArray = this.sortArray(randomArr);
        long stopTime = System.currentTimeMillis();

        result += "Sorted array: " + Arrays.toString(sortedArray) + "\n";
        result += "Time to complete " + getDescription() +
                ": " + (stopTime - startTime) + "ms";
        return result;
    }
    public int[] generateRandomArray(int length) {
        Random random = new Random();
        int[] result = new int[length];
        for (int i = 0; i < length ; i++) {
            result[i] = random.nextInt(1, 1000);
        }
        return result;
    }
}
