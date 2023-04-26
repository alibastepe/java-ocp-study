package com.example.java_study.mjia.lambda;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.function.*;

public class LambdaExample {

    class Apple {
        Integer weight;
        String country;
        Color color;

        public Integer getWeight() {
            return weight;
        }

        public String getCountry() {
            return country;
        }

        public Color getColor() {
            return color;
        }
    }

    @FunctionalInterface
    public interface BufferedReaderProcessor {
        String process(BufferedReader b) throws IOException;
    }

    public String processFile(BufferedReaderProcessor p) throws
            IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }


    // (parameters) -> expression
    // (parameters) -> {statements;}
    Comparator<Apple> byWeight =
            (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
    void myMethod() throws IOException {
        //You don’t have to enclose a single void method invocation in braces
        Runnable r1 = () -> System.out.println("hello");

        String oneLine =  processFile((BufferedReader br) -> br.readLine());

        String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());
    }

    void predicateMethod()  {
        IntPredicate evenNumbers = (int i) -> i % 2 == 0;
        evenNumbers.test(1000);  //no boxing

        //predicates have IntPredicate, LongPredicate, DoublePredicate types


    }

    void functionalInterfacesMixed()  {
        ObjIntConsumer<String> myCons = (String s, int i ) -> s.substring(0,i);

        ToIntBiFunction<String, String> myToIntBiFunction = (String s1, String s2) -> s1.length() + s2.length();

        BinaryOperator<String> myBinaryOperator = (s1, s2) -> s1.concat(s2);

        UnaryOperator<String> myUnaryOperator = (s1) -> s1.trim();

        //using i and s below is valid because of type inference
        BiFunction<Integer, String, String> myBiFunction = (i, s) -> s.concat(String.valueOf(i));
    }
    int instanceVar = 22;  //instance variables stored on heap
    void lambdaUsingLocalVariable()  {
        int myVar = 5;  //local variables live on stack
        ObjIntConsumer<String> myCons = (String s, int i ) -> s.substring(0, myVar);
        myVar = 6;  //since myVar is now not effectively final, it cannot be used in lambda (above)

        ObjIntConsumer<String> myCons2 = (String s, int i ) -> s.substring(0, instanceVar);  //no restirction in instance or static variables
        instanceVar = 33;
    }






}
