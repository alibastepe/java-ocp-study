package com.example.java_study.methods;

public class Constructors {

    {
        //initializer blocks is called before constructor
    }

    {
        //initializer blocks is called before constructor and with placement order (this block will be called after the block above)
    }

    //can be defined with all four access levels
    //since we defined a constructor, compiler will not create a default constructor
    public Constructors()  {
        this(5);  //must be the first statement
    }

    private Constructors(int a)  {

    }

    private Constructors(int a, int b)  {

    }

    //this is treated as a method, not a constructor
    public double Constructors()  {
        return  0;
    }



}
