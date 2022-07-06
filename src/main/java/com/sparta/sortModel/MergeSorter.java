package com.sparta.sortModel;

import java.util.Arrays;

public class MergeSorter implements Sorter{


    @Override
    public int[] sortArray(int[] arrayToSort) {
        int middle = arrayToSort.length/2;
        if(middle == 0) return arrayToSort;

        int[] firstHalf = Arrays.copyOfRange(arrayToSort, 0, middle);
        int[] secondHalf = Arrays.copyOfRange(arrayToSort,  middle, arrayToSort.length);

        firstHalf = sortArray(firstHalf);
        secondHalf = sortArray(secondHalf);
        return mergeTwoArrays(firstHalf, secondHalf);
    }

    public int[] mergeTwoArrays(int[] firstArr, int[] secondArr) {
        int[] result = new int[firstArr.length + secondArr.length];
        int firstCounter, secondCounter, resCounter;
        firstCounter = secondCounter = resCounter = 0;

        while (true) { // will continue until one of the arrays is exhausted
            try { // try to append the smaller value of either array to the result array
                if (firstArr[firstCounter] <= secondArr[secondCounter])
                    result[resCounter++] = firstArr[firstCounter++];
                if (secondArr[secondCounter] <= firstArr[firstCounter])
                    result[resCounter++] = secondArr[secondCounter++];
            } catch(ArrayIndexOutOfBoundsException e) {
                break; // we reached the end of one of the arrays
            }
        }
        // check both arrays to find the one for which we have not reached the end:
        while(firstCounter < firstArr.length){
            result[resCounter++] = firstArr[firstCounter++];
        }
        while(secondCounter < secondArr.length) {
            result[resCounter++] = secondArr[secondCounter++];
        }

        return result;
    }

}