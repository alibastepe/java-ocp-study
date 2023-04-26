package com.example.java_study.interfaces;

public class ConcreteExample1 implements InterfaceExample3{
    @Override
    public void myMethod() {

    }

    @Override
    //do NOT use "default" here. Normal method overriding rules apply
    public void myDefaultMethod() {
        InterfaceExample3.super.myDefaultMethod();

    }

    //same method exist in the interface but they are not related. This method does not hide the method in interface
    static void myStaticMethod() {
        InterfaceExample3.myStaticMethod();
    }
}
