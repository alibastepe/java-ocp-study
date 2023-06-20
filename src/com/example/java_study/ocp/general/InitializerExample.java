package com.example.java_study.ocp.general;

public class InitializerExample {
    String name = "str";

    {
        System.out.println("name is: " + name);  //name must be defined before this line
    }


    static String textBlock = """
fhdfghfghf""";
    public int $myVar;
    public String _myStr;
    //illegal exqamples
    //public double _;    single underscore is not allowed
   // int 3DPointClass;    // identifiers cannot begin with a number
    //byte hollywood@vine; // @ is not a letter, digit, $ or _
   // String *$coffee;     // * is not a letter, digit, $ or _
    //double public;       // public is a reserved word
   // short _;


    //multiple variable declaration
    int i3, i4;
    int i1, i2=0;  //only i2 initialized
    //int i5, int i6;   //illegal, if using , all variables will ber of same type
    int i7; double d8;


    //int num, String value; illegal. cannot declare diffrent types with a commaü
    char c;   //default valuer for char is '\u0000' (NUL).
    //var myVar = 5;  //ILLEGAL var only allowed in local variables

    public static void main(String[] args) {
        System.out.println(c);
    }

    public void myMethod() {

        int x;
        int y = 10;
        //int z = x + y;  //error. local variables must be initialized
    }

    public void typeInferenceWithVar()  {
        var f = 6;
        //var myVar;  //ILLEGAL. must be initialized at declaration
        // int a, var b = 3;  // DOES NOT COMPILE
        //var n = null;      // DOES NOT COMPILE
        var myStr = "";
        myStr = null;  //can be assigned to null after initializing as a reference
    }

    class Var {
        public void var() {
            var var = "var";
        }
        public void Var() {
            Var var = new Var();
        }
    }

    /*
    public int addition(var a, var b) { // DOES NOT COMPILE. "var" only allowed in local variables
        return a + b;
    }
    */

    public void findAnswer(boolean check) {
        int answer;
        int otherAnswer;
        int onlyOneBranch;
        if (check) {
            onlyOneBranch = 1;
            answer = 1;
        } else {
            answer = 2;
        }
        System.out.println(answer);
        //System.out.println(onlyOneBranch);  // DOES NOT COMPILE
    }

    public void checkAnswer() {
        boolean value;
        //findAnswer(value);  // DOES NOT COMPILE   value must be initialized
    }
}
