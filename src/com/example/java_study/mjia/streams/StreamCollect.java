package com.example.java_study.mjia.streams;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class StreamCollect {
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

    void predefinedCollectors() {
        //reducing and summarizing
        long howManyDishes = menu.stream().collect(Collectors.counting());
        long howManyDishes2 = menu.stream().count();  //same as above


        //find maximum
        Comparator<Dish> dishCaloriesComparator =
                comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish =
                menu.stream()
                        .collect(maxBy(dishCaloriesComparator));

        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));

        double averageCalories = menu.stream().collect(averagingInt(Dish::getCalories));

        //result of the method below -> IntSummaryStatistics{count=9, sum=4300, min=12 average=477.777778, max=800}
        IntSummaryStatistics menuStatistics =
                menu.stream().collect(summarizingInt(Dish::getCalories));

        //collect all dish names
        String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));  //pork, beef, chicken, french fries, rice, season fruit, pizza, prawns, salmon
    }

    void generalizedReducing() {
        int totalCalories = menu.stream().collect(reducing(
                0, Dish::getCalories, (i, j) -> i + j));

        int totalCalories2 = menu.stream().collect(reducing(
                0, Dish::getCalories, Integer::sum));

        Optional<Dish> mostCalorieDish =
                menu.stream().collect(reducing(
                        (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));


    }

    enum CaloricLevel { DIET, NORMAL, FAT }
    void grouping() {
        Map<Dish.Type, List<Dish>> dishesByType =
                menu.stream().collect(groupingBy(Dish::getType));
        //result of above is {FISH=[prawns, salmon], OTHER=[french fries, rice, season fruit, pizza],
        //MEAT=[pork, beef, chicken]}



        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                } ));


        Map<Dish.Type, List<String>> dishNamesByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                mapping(Dish::getName, toList())));

        //multievel grouping
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
                menu.stream().collect(
                        groupingBy(Dish::getType,
                                groupingBy(dish -> {
                                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT;
                                } )
                        )
                );
        //result of above -> {MEAT={DIET=[chicken], NORMAL=[beef], FAT=[pork]},
        //FISH={DIET=[prawns], NORMAL=[salmon]},
        //OTHER={DIET=[rice, seasonal fruit], NORMAL=[french fries, pizza]}}


        //subgroups
        Map<Dish.Type, Long> typesCount = menu.stream().collect(
                groupingBy(Dish::getType, counting()));
        //{MEAT=3, FISH=2, OTHER=4}



        Map<Dish.Type, Optional<Dish>> mostCaloricByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                maxBy(comparingInt(Dish::getCalories))));
        //{FISH=Optional[salmon], OTHER=Optional[pizza], MEAT=Optional[pork]}



        //Finding the highest-calorie dish in each subgroup
        Map<Dish.Type, Dish> mostCaloricByType2 =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                collectingAndThen(
                                        maxBy(comparingInt(Dish::getCalories)),
                                        Optional::get)));
    }


    void partitioning() {
        //Partitioning is a special case of grouping: having a predicate called a partitioning function
        //as a classification function
        Map<Boolean, List<Dish>> partitionedMenu =
                menu.stream().collect(partitioningBy(Dish::isVegetarian));

      /*  {false=[pork, beef, chicken, prawns, salmon],
            true=[french fries, rice, season fruit, pizza]}  */


        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType =
                menu.stream().collect(
                        partitioningBy(Dish::isVegetarian,
                                groupingBy(Dish::getType)));
        //{false={FISH=[prawns, salmon], MEAT=[pork, beef, chicken]},
        //true={OTHER=[french fries, rice, season fruit, pizza]}}

    }
}
