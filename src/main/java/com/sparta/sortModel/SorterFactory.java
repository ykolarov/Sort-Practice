package com.sparta.sortModel;

public class SorterFactory implements AbstractFactory<AbstractSorter> {

    private enum Options {
        BUBBLE(0), MERGE(1), BINARY(2);
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
        } catch(ArrayIndexOutOfBoundsException e) {
            return null; // invalid option, let the view deal with user communication
        }
        return null;
    }

    public String userInstructions() {
        String result = "Please choose a sorting algorithm:\n(";
        result += "0: Bubble | ";
        result += "1: Merge | ";
        result += "2: Binary";
        return result + ")";
    }


}
