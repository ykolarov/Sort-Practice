package com.sparta.sortModel;

import java.util.Random;

public abstract class AbstractSorter implements Sorter {

    public abstract String getDescription();

    public int[] generateRandomArray(int length) {
        Random random = new Random();
        int[] result = new int[length];
        for (int i = 0; i < length ; i++) {
            result[i] = random.nextInt(1, 1000);
        }
        return result;
    }
}
