package com.example.java_study.ocp.core_apis.string;

public class StringPoolExamples {
    //The string pool contains literal values and constants that appear in your program.
    void basics() {
        var x = "Hello World";
        var y = "Hello World";
        System.out.println(x == y); // true


        var z = " Hello World".trim();  //a new String object is created
        System.out.println(x == z); // false


        var x1 = "Hello World";
        var y1 = new String("Hello World");
        System.out.println(x1 == y1); // false
    }

    void internExample() {
        //The intern() method will use an object in the string pool if one is present
        //If the literal is not yet in the string pool, Java will add it at this time.
        var name = "Hello World";
        var name2 = new String("Hello World").intern();
        System.out.println(name == name2); // true


        var first = "rat" + 1;  //compile time constant, use pool
        var second = "r" + "a" + "t" + "1";  //compile time constant, use pool
        var third = "r" + "a" + "t" + new String("1");
        System.out.println(first == second);   //true
        System.out.println(first == second.intern());  //true
        System.out.println(first == third);  //false
        System.out.println(first == third.intern());  //true
    }
}
