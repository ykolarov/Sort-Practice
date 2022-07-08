package com.sparta.sortController;

import com.sparta.sortModel.AbstractFactory;
import com.sparta.sortModel.AbstractSorter;
import com.sparta.sortModel.SorterFactory;
import com.sparta.sortView.DisplayManager;
import com.sparta.sortView.View;
import org.apache.logging.log4j.*;


public class SortManager {
    public static Logger logger = LogManager.getLogger("SortManger Logger");

    public static void main(String[] args) {
        AbstractFactory<AbstractSorter> factory = new SorterFactory();  // model
        View displayManager = new DisplayManager(factory);              // view
        displayManager.display();
    }
}