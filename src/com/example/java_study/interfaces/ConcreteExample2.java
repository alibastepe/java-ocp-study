package com.example.java_study.interfaces;

//
public class ConcreteExample2 implements InterfaceExample1, InterfaceExample2{
    public ConcreteExample2() {
        //System.out.println(MIN_DISTANCE);  //NOT valid. ambiguous
        System.out.println(InterfaceExample1.MIN_DISTANCE);  //valid;
    }


    @Override
    //since the methods in interfaces have same signature, no problem
    public int myIntMethod() {
        return myVar;
    }

    @Override
    //since the default methods in interfaces have the same name, this class must override the default method
    public void myDefaultMethod() {
        InterfaceExample1.super.myDefaultMethod();
    }
}
