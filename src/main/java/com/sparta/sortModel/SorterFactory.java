package com.sparta.sortModel;

public class SorterFactory implements AbstractFactory<AbstractSorter> {

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
    @Override
    public AbstractSorter create(int type) {
        try {
            if (Options.BUBBLE == Options.values()[type]) return new BubbleSorter();
            if (Options.MERGE == Options.values()[type]) return new MergeSorter();
            if (Options.BINARY == Options.values()[type]) return new BinarySorter();
            if (Options.INSERTION == Options.values()[type]) return new InsertionSorter();
            if (Options.QUICK == Options.values()[type]) return new QuickSorter();
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid option, please try again");// if type argument is invalid
        }
        return null;
    }

    public String userInstructions() {
        String result = "Please choose a sorting algorithm:\n(";
        result += "0: Bubble | ";
        result += "1: Merge | ";
        result += "2: Binary | ";
        result += "3: Insertion | ";
        result += "4: Quick";
        return result + ")";
    }


}
