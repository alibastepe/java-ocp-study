package com.example.java_study.operators_decision_constructs;

public class Operators {
    int a = 0, b = 4, c= 8;


    public Operators()  {

        //basic operators
        a = b = c;   //starts from right
        a++;
        a--;
        char c1 = 'a';   // value of a in ASCII is 97

        System.out.println(c1);  //prints "a"
        System.out.println(c1+c1);  ///prints 194

        c1 = 'B';
        System.out.println(++c1);  //prints "C"

        int i1 = 10;

        System.out.println(i1++);  //prints 10


        //operand widening
        byte b1 = 10;
        byte b2 = 10;

        short sum = b1 + b2;  //all byte, short and char values automatically widened to int when used operands for arith. ops.

        //if an arithmetic op. includes long, all operand values are widened to long.   float or double -> double

        int y = 4;
        long t = 1L;

        int sum2 = y + t;


        //final operands
        final byte b3 = 10;
        final byte b4 = 20;

        short sum4 = b3 + b4;  //this is OK

        //operator precedence
        // postfix -> unary -> mult -> add -> relational -> equality -> logical AND -> logical OR -> assignment

    }

}
