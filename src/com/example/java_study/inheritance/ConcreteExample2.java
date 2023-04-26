package com.example.java_study.inheritance;

public class ConcreteExample2 extends AbstractExample2{
    @Override
    public void myMethod() {
        super.myMethod2();  //access to parent class
    }

    @Override
    //access level var package private in base class. We can assign less restrictive in subclass
    //return type can be different as long as it is a subclass of base class method's return type (covariant return type)
    public Integer myIntMethod() {
        return 0;
    }
}
