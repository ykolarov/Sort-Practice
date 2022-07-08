package com.sparta.sortModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySorter extends AbstractSorter {

    @Override
    public int[] sortArray(int[] arrayToSort) { // Adaptor method
        if (arrayToSort == null || arrayToSort.length == 0) return new int[] {}; // empty array instead of null to avoid null crash
        // Create binary tree from unsorted array
        Queue<Integer> valuesLeft = new LinkedList<>();
        for (int currentInt : arrayToSort) {
            valuesLeft.add(currentInt);
        }
        Node rootNode = new Node(valuesLeft.remove());
        while(!valuesLeft.isEmpty()) unsortedArrToBinaryTree(rootNode, valuesLeft);
        // Create sorted Integer list from binary tree
        List<Integer> sorted = new ArrayList<>();
        sortBinaryTreeToList(rootNode, sorted);
        // Convert Integer list to an int array and return
        return sorted.stream().mapToInt(i -> i).toArray();
    }

    private void unsortedArrToBinaryTree(Node currentNode, Queue<Integer> valuesLeft) {
        if( valuesLeft.isEmpty() ) return;

        if (currentNode.value < valuesLeft.peek()) {
            if(currentNode.leftChild == null) currentNode.leftChild = new Node(valuesLeft.remove());
            else unsortedArrToBinaryTree(currentNode.leftChild, valuesLeft);
        } else {
            if(currentNode.rightChild == null) currentNode.rightChild = new Node(valuesLeft.remove());
            else unsortedArrToBinaryTree(currentNode.rightChild, valuesLeft);
        }
    }

    private void sortBinaryTreeToList(Node currentNode, List<Integer> list) {
        // 1. if you have left, go to your left
        if(currentNode.rightChild != null) sortBinaryTreeToList(currentNode.rightChild, list);
        // 2. put yourself in the array,
        list.add(currentNode.value);
        // 3. if you have right, go to your right
        if(currentNode.leftChild != null) sortBinaryTreeToList(currentNode.leftChild, list);
        // 4. if you have an up go to your up - return
    }

    @Override
    public String getDescription() {
        return "Binary sort";
    }

    private class Node {
        int value;
        Node leftChild;
        Node rightChild;
        public Node(int value) {
            this.value = value;
        }

    }
}
