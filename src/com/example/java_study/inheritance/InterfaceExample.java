package com.example.java_study.inheritance;

public  interface InterfaceExample {
    int intField = 5;
    int finalIntField = 5;

    default void myDefaultMethod()  {  //"this" can be used to access fields and methods(default or abstract)
        int intField = this.intField;
        this.myMethod();
        this.myDefaultMethod2();
        //this.myStaticMethod();  //not allowed
        InterfaceExample.myStaticMethod();   //allowed
    }

    default  void myDefaultMethod2()  {  //"this" can be used to access fields and methods

    }

    static void myStaticMethod() {

    }

    void myMethod();

}
