package com.sparta.sortTest;

import com.sparta.sortModel.BubbleSorter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSorterTest {

    BubbleSorter bubbleSorter;

    @BeforeEach
    void setUp() {
        bubbleSorter = new BubbleSorter();
    }
    @Test
    void bubbleSortReverse() {
        int[] actual = {1000, 8, 6, 5, 3, 1};
        bubbleSorter.sortArray(actual);
        int[] expected = {1, 3, 5, 6, 8, 1000};
        assertArrayEquals(expected, actual);
    }

    @Test
    void bubbleSortRandom() {
        int[] actual = {6, 8, 66, 5, 6, 6};
        bubbleSorter.sortArray(actual);
        int[] expected = {5, 6, 6, 6, 8, 66};
        assertArrayEquals(expected, actual);
    }
}