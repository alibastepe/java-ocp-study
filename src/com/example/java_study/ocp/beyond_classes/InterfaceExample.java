package com.example.java_study.ocp.beyond_classes;

import java.util.Iterator;
import java.util.concurrent.Callable;

public interface InterfaceExample  {

    private void myMethod();  //private methods must have a body
    default void myMethod2();  //default methods must have a body
    static void myMethod3();  //static methods must have a body



}

interface HasTail {
    int getTailLength();
}

interface HasWhiskers {
    int getNumberOfWhiskers();
}

abstract class HarborSeal implements HasTail, HasWhiskers {
    //abstract class does not have to implement interfce methods
}


class CommonSeal extends HarborSeal {
    //must implement methods in interfaces
}

