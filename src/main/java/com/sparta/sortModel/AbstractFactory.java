package com.sparta.sortModel;

public interface AbstractFactory<T> {
    T create(int type);
    String userInstructions();
}
