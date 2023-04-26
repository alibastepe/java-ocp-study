package com.example.java_study.mjia.lambda;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.awt.Color.GREEN;
import static java.util.Comparator.comparing;

public class LambdaCompositions {
    void comparatorExamples()  {
        Comparator<LambdaExample.Apple> c = comparing(LambdaExample.Apple::getWeight);

        //reverse order
        List<LambdaExample.Apple> inventory = new ArrayList<>();
        inventory.sort(comparing(LambdaExample.Apple::getWeight).reversed());


        //chaining comparators
        inventory.sort(comparing(LambdaExample.Apple::getWeight)
                .reversed()   //sorts by decreasing weight
                .thenComparing(LambdaExample.Apple::getCountry));  //sort by country if two apples have same weight
    }

    void predicateExamples()  {
        Predicate<LambdaExample.Apple> redApple = (a) -> a.getColor().equals(Color.RED);
        Predicate<LambdaExample.Apple> notRedApple = redApple.negate();

        //chaining
        Predicate<LambdaExample.Apple> redAndHeavyApple =
                redApple.and(apple -> apple.getWeight() > 150);

        Predicate<LambdaExample.Apple> redAndHeavyAppleOrGreen =
                redApple.and(apple -> apple.getWeight() > 150)
                        .or(apple -> GREEN.equals(apple.getColor()));
    }

    void functionExamples()  {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);  // g(f(x))
        int result = h.apply(1);   //result is 4


        Function<Integer, Integer> f2 = x -> x + 1;
        Function<Integer, Integer> g2 = x -> x * 2;
        Function<Integer, Integer> h2 = f2.compose(g2);  // f(g(x));
        result = h2.apply(1);  //result is 3
    }

}
