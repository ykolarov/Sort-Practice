package com.sparta.sortModel;

import java.util.ArrayList;
import java.util.List;

public class BinarySorter extends AbstractSorter {
    @Override
    public int[] sortArray(int[] arrayToSort) {
        // Create binary tree from unsorted array
        Node rootNode = unsortedArrToBinaryTree(arrayToSort);
        // Create sorted Integer list from binary tree
        List<Integer> sorted = new ArrayList<>();
        sortBinaryTreeToList(rootNode, sorted);
        // Convert Integer list to an int array and return
        return sorted.stream().mapToInt(i -> i).toArray();
    }

    private Node unsortedArrToBinaryTree(int[] arrayToSort) {
        Node rootNode = new Node(arrayToSort[0], null, null);
        Node currentNode = rootNode;
        int i = 1; // 0th element used for root, so we start at 1
        // TODO:  implement recursively
        return rootNode;
    }

    private void sortBinaryTreeToList(Node currentNode, List<Integer> list) {
        // 1. if you have left, go to your left
        if(currentNode.leftChild != null) sortBinaryTreeToList(currentNode.leftChild, list);
        // 2. put yourself in the array,
        list.add(currentNode.value);
        // 3. if you have right, go to your right
        if(currentNode.rightChild != null) sortBinaryTreeToList(currentNode.rightChild, list);
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
        public Node(int value, Node leftChild, Node rightChild){
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

    }
}
