package com.sparta.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortManagerTest {

    SortManager sortManager;

    @BeforeEach
    void setUp() {
        sortManager = new SortManager();
    }
    @Test
    void bubbleSortReverse() {
        int[] actual = {1000, 8, 6, 5, 3, 1};
        sortManager.sortArray(actual);
        int[] expected = {1, 3, 5, 6, 8, 1000};
        assertArrayEquals(expected, actual);
    }

    @Test
    void bubbleSortRandom() {
        int[] actual = {6, 8, 66, 5, 6, 6};
        sortManager.sortArray(actual);
        int[] expected = {5, 6, 6, 6, 8, 66};
        assertArrayEquals(expected, actual);
    }
}