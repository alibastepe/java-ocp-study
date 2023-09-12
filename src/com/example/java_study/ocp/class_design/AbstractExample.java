package com.example.java_study.ocp.class_design;

public abstract class AbstractExample  {

    //no argumnet constructor is inserted by compiler

    public abstract String str = "";
    public static abstract String myStaticStr = "";
    public abstract void myMethod();  // only instance methods can be abstract
    abstract public void myMethod2();  //order can change, but must be before return type and "class" keyword



}

class abc extends AbstractExample {

    public abc() {

    }



    @Override
    public void myMethod() {

    }

    @Override
    public void myMethod2() {

    }
}
