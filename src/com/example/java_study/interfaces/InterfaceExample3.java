package com.example.java_study.interfaces;

//top plevel JAva types (class, enum, interface) can be public or default
public interface InterfaceExample3 extends InterfaceExample1, InterfaceExample2 {  //can extend multiple interface.
    //variables are implicitly public, static and final
    public static final int myInt = 5;

    //methods in interface are implicitly public and abstract.
    public abstract void myMethod();

    //static methods in interface must be called with interface name (InterfaceExample3.myStaticMethod())
    static void myStaticMethod() {

    }

    default void myDefaultMethod()  {

    }
}
