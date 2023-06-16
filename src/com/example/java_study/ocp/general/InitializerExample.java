package com.example.java_study.ocp.general;

public class InitializerExample {
    String name = "str";

    {
        System.out.println("name is: " + name);  //name must be defined before this line
    }
}
