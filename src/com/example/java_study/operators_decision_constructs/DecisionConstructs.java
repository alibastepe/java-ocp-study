package com.example.java_study.operators_decision_constructs;

public class DecisionConstructs {


    void ternaryOperator()  {
        //ternary operator
        // all the three parts of the ternary operator are mandatory
        (500 > 2000) ? 15: 10    //invalid. the value returned by a ternary operator must be assigned to a variable

        //ternary operator cannot include code blocks (since result must be assigned to a variable)
        int res = (4<5) ? {} : 6;    //invalid

    }

    void switchStatement()  {
        //switch statement accepts arguments of type char, byte, short, int, String, Character, Byte, Short, Integer and Enum
        //an expression can be passed to switch statement as an argument as long as type is one of the above


        //the case value should be complie time constant

        String str = "d";

        String b = "b";
        String c = "c";

        final String d;  //NOT compile-time constant.
        final String e; // in order to be compile-time constant, value must be assigned at declaration

        switch (str) {
            case "df":
                System.out.println("not equal");
                break;
            case b+c:   //invalid. must be compile time constant
                System.out.println("");
                break;
            case d+e:  //invalid.
                System.out.println("");
                break;
            case null:  //invalid.
                System.out.println("null");
                break;
            case "d"+"f":   //valid (compile time constant)
                System.out.println("");
                break;
        }

        //if break is omitted, control will fall through all the remaining case values until first break statement is found

        int score = 50;
        String result = "";

        switch (score)  {
            case 100: result = "A";
            case 50: result = "B";
            case 10: result = "C";
            default: result = "F";
        }

        //result will be F
    }

    void forLoop()  {
        for(;;)  { }   //valid. any of the three parameter is optional

        for(int i = 0, j = 0;;)  {}   //valid. i and j are of same type

        for(int i = 0, long j = 5;;)  {} //invalid. i and j MUST be of same type

        //update clause executes after all statements defined within the for loop body



    }

    void whileLoop()  {
        int num = 10;

        while(++num > 20)  {
            num++;
        }

        System.out.println(num);   //prints 11

        num = 10;

        do {
            num++;
        } while(++num > 20);

        System.out.println(num);  //prints 12
    }

    String labeledStatements()  {

        outer:
        for(;;) {
            for(;;)  {
                //for some condition
                break outer;

            }

        }


        myCodeBlock:  {

        }

        returnStat: return "aaa";

    }
}
