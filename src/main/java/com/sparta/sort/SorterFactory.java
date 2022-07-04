package com.sparta.sort;

public class SorterFactory {

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

    public Sorter getSorter(int type) {
        if(Options.BUBBLE == Options.values()[type]) return new BubbleSorter();
        if(Options.MERGE == Options.values()[type]) return new MergeSorter();
        if(Options.BINARY == Options.values()[type]) return new BinarySorter();
        if(Options.INSERTION == Options.values()[type]) return new InsertionSorter();
        if(Options.QUICK == Options.values()[type]) return new QuickSorter();
        return null; // if type argument is invalid
    }

    public String getUserInstructions() {
        String result = "Please choose a sorting algorithm:\n(";
        result += "0: Bubble | ";
        result += "1: Merge | ";
        result += "2: Binary | ";
        result += "3: Insertion | ";
        result += "4: Quick";
        return result + ")";
    }


}
