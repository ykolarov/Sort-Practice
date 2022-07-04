package com.sparta.sort;

public class SortFactory {
    public Sorter getSorter(int type) {
        if(Options.BUBBLE == Options.values()[type]) {
            return new BubbleSorter();
        }
        return null;
    }

    public String getUserInstructions() {
        String result = "Please choose a sorting algorithm: (";
        result += "0: Bubble";
        return result + ")";
    }

    private enum Options {
        BUBBLE(0),
        MERGE(1),
        BINARY(2),
        INSERTION(3),
        QUICK(4);

        final int index;

        Options(int index) {
            this.index = index;
        }
    }
}
