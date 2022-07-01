package com.sparta.sort;

public enum Algorithms {
    BUBBLE(0),
    MERGE(1),
    BINARY(2),
    INSERTION(3),
    QUICK(4);

    final int index;

    Algorithms(int index) {
        this.index = index;
    }
}
