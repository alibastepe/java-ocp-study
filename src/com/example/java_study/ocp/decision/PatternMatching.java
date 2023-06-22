
package com.example.java_study.ocp.decision;

import java.util.List;

public class PatternMatching {

    void compareIntegers(Number number) {
        if(number instanceof Integer data) {
            System.out.print(data.compareTo(5));
            data = 10;  //bad practice, can be prevented like below
        }

        if(number instanceof final Integer data) {
            data = 10;  // DOES NOT COMPILE
        }

        Integer value = 123;
        if(value instanceof Integer) {}
        if(value instanceof Integer data) {}  // DOES NOT COMPILE, must be subtype


    }

    void patternMatchingWithClassAndInterface() {
        Number value = 123;
        if(value instanceof String) {}  //DOES NOT COMPILE. compiler enforces type match

        //below code compiles because compiler cannot enforce class and interface mix
        if(value instanceof List) {}
        if(value instanceof List data) {}
    }

    void printIntegersGreaterThan5(Number number) {
        if(number instanceof Integer data && data.compareTo(5)>0)
            System.out.print(data);
    }

    void printIntegersOrNumbersGreaterThan5(Number number) {
        // Flow scoping means the variable is only in scope when the compiler can definitively determine its type.
        if(number instanceof Integer data || data.compareTo(5)>0)
            System.out.print(data);
    }

    void printOnlyIntegers(Number number) {
        //when the last line of the method is reached, the input must inherit Integer,
        // and therefore data stays in scope even after the if statement ends.
        if (!(number instanceof Integer data))
            return;
        System.out.print(data.intValue());
    }

    void printOnlyIntegers2(Number number) {
        //same logic as above method
        if (!(number instanceof Integer data))
            return;
        else
            System.out.print(data.intValue());
    }
}
