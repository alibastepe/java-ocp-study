package com.example.java_study.arrays;

public class Arrays {

    int[] multiArr[];   //array initialization. Initialized as null
    int[][] multiArr2;
    int multiArr3[][];



    void arrayDeclarationWithVar()  {
        var[] arr;  //invalid
        var arr[];  //invalid
        var arr2 = new int[3];

        var arr3 = new int[-10];  //compiles

        var strArr = new String[2] {"str1", "str2"};  //invalid. do not give size

    }


}
