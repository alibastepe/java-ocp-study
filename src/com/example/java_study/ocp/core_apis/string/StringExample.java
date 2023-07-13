package com.example.java_study.ocp.core_apis.string;

public class StringExample {

    void stringInitialization()  {
        String str1 = "fluffy";
        String str2 = new String("fluffy");
        String str3 = """
                fluffy""";
    }

    void concatenationExample() {
        //The expression is evaluated left to right.
        System.out.println(1 + 2 + "c");     // 3c
        System.out.println("c" + 1 + 2);     // c12
        System.out.println("c" + null);      // cnull
    }

    void substringExample() {
         //endIndex doesn't give an out-of-bounds exception when it is one past the end of the String
        var name = "animals";
        System.out.println(name.substring(3));                 // mals
        System.out.println(name.substring(name.indexOf('m'))); // mals
        System.out.println(name.substring(3, 4));              // m
        System.out.println(name.substring(3, 7));              // mals
        System.out.println(name.substring(3, 3)); // empty string
        System.out.println(name.substring(3, 2)); // exception
        System.out.println(name.substring(3, 8)); // exception
    }

    void removeWhitespace() {
        //remember that \t is a single character
        System.out.println("abc".strip());                 // abc
        System.out.println("\t   a b c\n".strip());        // a b c

        String text = " abc\t ";
        System.out.println(text.trim().length());          // 3
        System.out.println(text.strip().length());         // 3
        System.out.println(text.stripLeading().length());  // 5
        System.out.println(text.stripTrailing().length()); // 4
    }

    void indentation() {
        // The indent() method adds the same number of blank spaces to the beginning of each line if you pass a positive number.
        // If you pass a negative number, it tries to remove that number of whitespace characters from the beginning of the line.
        // If you pass zero, the indentation will not change.
    }

}
