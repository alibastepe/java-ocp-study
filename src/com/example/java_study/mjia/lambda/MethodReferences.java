package com.example.java_study.mjia.lambda;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class MethodReferences {

    public MethodReferences()  {
        List<String> str = Arrays.asList("a","b","A","B");
        str.sort(String::compareToIgnoreCase);



        ToIntFunction<String> stringToInt = Integer::parseInt;
    }

    class Apple {
        int weight;
        Color color;

        public Apple(int weight) {
            this.weight = weight;
        }

        public Apple(int weight, Color color) {
            this.weight = weight;
            this.color = color;
        }

        public Apple() {

        }
    }
    void constructorReferences()  {
        Supplier<Apple> c1 = Apple::new;
        Apple a1 = c1.get();

        Function<Integer, Apple> c2 = Apple::new;
        Apple a2 = c2.apply(100);  //weight constructor

        BiFunction<Integer, Color, Apple> c3 = Apple::new;
        Apple a3 = c3.apply(105, Color.GREEN);



        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Apple> apples = map(weights, c2);


    }

    public List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for(Integer i: list) {
            result.add(f.apply(i));  //create new apple and add to list
        }
        return result;
    }

}
