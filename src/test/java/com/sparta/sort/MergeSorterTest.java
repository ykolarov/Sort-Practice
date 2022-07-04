package com.sparta.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSorterTest {

    MergeSorter mergeSorter;

    @BeforeEach
    void setUp() {
        mergeSorter = new MergeSorter();
    }

    @Test
    void sortArrayRandom() {
        int[] a = {1, 3, 9, 5, 5, 1, 1};
        int[] res = new int[]{1,1,1,3,5,5,9};
        assertArrayEquals(res, mergeSorter.sortArray(a));
    }
    @Test
    void sortArrayReverse() {
        int[] a = {9,5,5,3,1,1,1};
        int[] res = new int[]{1,1,1,3,5,5,9};
        assertArrayEquals(res, mergeSorter.sortArray(a));
    }
    @Test
    void sortArrayAlreadySorted() {
        int[] a = {1,1,1,3,5,5,9};
        int[] res = new int[]{1,1,1,3,5,5,9};
        assertArrayEquals(res, mergeSorter.sortArray(a));
    }

    @Test
    void mergeTwoArrays() {
        int[] a = {1, 3, 4, 4};
        int[] b = {1, 3, 5, 5};
        int[] res = new int[]{1,1,3,3,4,4,5,5};
        assertArrayEquals(res, mergeSorter.mergeTwoArrays(a,b));
    }
    @Test
    void mergeTwoArrays2() {
        int[] a = {5,5};
        int[] b = {1, 1};
        int[] res = new int[]{1,1,5,5};
        assertArrayEquals(res, mergeSorter.mergeTwoArrays(a,b));
    }
    @Test
    void mergeTwoArraysDiffSize() {
        int[] a = {1};
        int[] b = {1, 3, 5, 5};
        int[] res = new int[]{1,1,3,5,5};
        assertArrayEquals(res, mergeSorter.mergeTwoArrays(a,b));
    }
    @Test
    void mergeTwoArraysDiffSize2() {
        int[] a = {1, 3, 4, 4};
        int[] b = {1};
        int[] res = new int[]{1,1,3,4,4};
        assertArrayEquals(res, mergeSorter.mergeTwoArrays(a,b));
    }
    @Test
    void mergeTwoArraysDiffSize3() {
        int[] a = {1, 3, 4, 4};
        int[] b = {0};
        int[] res = new int[]{0,1,3,4,4};
        assertArrayEquals(res, mergeSorter.mergeTwoArrays(a,b));
    }
    @Test
    void mergeTwoArraysDiffSize4() {
        int[] a = {1, 3, 4, 4};
        int[] b = {0, 1};
        int[] res = new int[]{0,1,1,3,4,4};
        assertArrayEquals(res, mergeSorter.mergeTwoArrays(a,b));
    }
    @Test
    void mergeTwoArraysOneEmpty() {
        int[] a = {1, 3, 4, 4};
        int[] b = {};
        int[] res = new int[]{1,3,4,4};
        assertArrayEquals(res, mergeSorter.mergeTwoArrays(a,b));
    }


}