package com.example.java_study.mjia.streams;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStreams {
    List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH) );

    void findSumOfCalories()  {
        //wth reduce. (boxing cost)
        int calories = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);

        //better way with IntStream
        int calories2 = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();

        //converting back and forth
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();
    }

    void optionals() {
        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        int max = maxCalories.orElse(1);
    }

    void numericRanges() {
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers.count());
    }


}
