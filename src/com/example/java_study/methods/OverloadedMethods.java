package com.example.java_study.methods;

public class OverloadedMethods {

    //----------------
    //arguments are same. cannot be defined as overloaded
    void myMethod(int... args)  {

    }

    void myMethod(int[] args)  {

    }


    //------------
    //Only return types are different, cannot be defined as overloaded
    int myMethod2() {

    }

    double myMethod2()  {

    }

    //----------
    //
    void myMethod3(int a, double b)  {

    }

    void myMethod3(double a, int b)  {

    }

    void otherMethod()  {
        myMethod3(2,3);    //cannot determine which method to call. ERROR
    }

    //--------------------
    //only differ in access levels, cannot be defined as overloaded
    public double myMethod4(int a, int b) {

    }

    private double myMethod4(int a, int b)  {

    }

    //-----------------


}
