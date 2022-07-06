package com.sparta.sortModel;

public class BubbleSorter implements Sorter {

    /**
     * Performs a BubbleSort with a swap flag to stop as soon as an iteration with no swaps occurs.
     * @param input the array of integers to be sorted
     * @return pointer to the sorted array (in this case same pointer as the input)
     */
    public int[] sortArray(int[] input) {
        boolean noSwaps;
        do {
            noSwaps = true;
            for (int i = 0; i<input.length - 1; i++) {
                // Look at the first number in the list.
                int this_val = i;
                int next_val = i + 1;
                //  Is the next number smaller than the current number? If so,
                //     swap the two numbers around. If not, do not swap.
                if (input[this_val] > input[this_val+1]) {
                    noSwaps = false; // If any numbers were swapped, repeat from step 1.
                    int temp = input[this_val];
                    input[this_val] = input[next_val];
                    input[next_val] = temp;
                }
                // Move to the next number along in the list and make this the current number
            }// If the end of the list is reached without any swaps being made,
            // then the list is ordered and the algorithm can stop
        } while (!noSwaps);
        return input;
    }

}
