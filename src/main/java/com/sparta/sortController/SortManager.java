package com.sparta.sortController;

import com.sparta.sortView.DisplayManager;
import org.apache.logging.log4j.*;
public class SortManager {
    public static Logger logger = LogManager.getLogger("SortManger Logger");

    public static void main(String[] args) {
        DisplayManager displayManager = new DisplayManager();
        displayManager.start();
    }
}