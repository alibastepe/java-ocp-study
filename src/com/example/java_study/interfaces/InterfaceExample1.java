package com.example.java_study.interfaces;

public interface InterfaceExample1 {
    int MIN_DISTANCE = 10;
    int myVar = 5;

    //no constructor allowed in interfaces

    int myIntMethod();

    default void myDefaultMethod() {
        int myVar2 = myVar;
    }
}
