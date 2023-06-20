package com.example.java_study.data_types;

public class DataTypes {
    char c = 'a';
    byte b = 0b1;
    short s = 123; //2 bytes
    int i = 2_345;  //4 bytes
    long l = 12L; //8 bytes
    float f = 12.3f;  //4 bytes
    double d = 2345.9; //8 bytes

    //underscore limitations
    int octalValue = 0_413;
    long hexVal = 0x_10_BA_75;  //invalid. cannot follow 0x
    byte aByte = 0b_1; //invalid. cannot follow 0b
    long binVal = 0b1_0100_10_01;  //valid
    long aLong = 1231242_L;  //invalid. cannot precede L

    int i2 = 45_;  //invalid cannot be at the beginning or end

    double aDouble = 345._5;  //invalid. cannot be adjacent to decimal point
    float aFloat = 52.4_f;  //invalid cannot be prior to f,F,D or d

    //char
    char c1 = 122;
    char c2 = '\uffff';  //from \u0000 to \uffff (65535)
    char c3 = -122;  //invalid
    char c4 = (char)-122;


    //var
    //var g = 13;  //invalid. can only be used in local variables. can NOt be used in method parameters or return types


    static {
        var f = 54;
    }

    {
        var t = "ali";
    }

    public DataTypes()  {
        final var j = 12.4;  // final is allowed with var
        final int fd = 8;
        try {
            Thread.sleep(1000);
        } catch (Exception f)  {
            var n = 4;
        }

        var v1 = 10L + 0b1_001;   // v1 is long
        var v2 = 12.4 + 23.5f;  //v2 is double

        var charArr[] = {'a', 'b'};  //invalid. new char[] must be added

    }


}
