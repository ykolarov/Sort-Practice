package com.sparta.sort;

import java.util.Arrays;

public class MergeSorter implements Sorter{
    public static void main(String[] args) {
        int[] test = {1, 5, 6, 9, 1, 1, 4};
        var res = new MergeSorter().sortArray(test);
        System.out.println(Arrays.toString(res));
    }
    @Override
    public int[] sortArray(int[] arrayToSort) {
        int[] result = new int[arrayToSort.length];

        //Step 1: Find the middle index of the array and divide into two.
        int middle = arrayToSort[arrayToSort.length/2];
        // Get the first and second halves of the array.
        int[] firstHalf = Arrays.copyOfRange(arrayToSort, 0, middle);
        int[] secondHalf = Arrays.copyOfRange(arrayToSort,  middle, arrayToSort.length);
        if(middle != 0) {
            this.sortArray(firstHalf);
            this.sortArray(secondHalf);
        }
        //Merge the two sorted halves into a single sorted array.
        return new int[0];
    }

}
