package com.example.java_study.mjia.streams;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamOperations {
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

    void operations()  {

        List<String> threeHighCaloricDishNames =
                menu.stream()
                        .filter(dish -> dish.getCalories() > 300)
                        .map(Dish::getName)   //map from Dish to String    Stream<String>
                        .limit(3)
                        .collect(toList());
        System.out.println(threeHighCaloricDishNames);

        //intermediate operations
        //filter,  map  limit   sorted   distinct


        //terminal operations
        // forEach, count, collect
    }

    void filterOperation()  {
        List<Dish> vegetarianMenu = menu.stream()
                .filter(Dish::isVegetarian)   //use a method reference
                .collect(toList());

        //filter distinct elements
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }

    void onlyOneTraverse()  {
        List<String> title = Arrays.asList("Modern", "Java", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        s.forEach(System.out::println);  //ERROR
    }

    void internalExternalIteration()  {
        //collection iterations are done externally
        List<String> names = new ArrayList<>();
        Iterator<Dish> iterator = menu.iterator();
        while(iterator.hasNext()) {   //external iteration
            Dish dish = iterator.next();
            names.add(dish.getName());

        }

        //internal iteration with streams
        List<String> names2 = menu.stream()
                .map(Dish::getName)
                .collect(toList());
    }

    void slicing() {
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        //added in java 9
        /*List<Dish> slicedMenu1
                = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)   //stop at first where predicate is false. more efficient than filter n big lists
                .collect(toList());

         */

        //elements that
        //have greater than 320 calories
        /*
        List<Dish> slicedMenu2
                = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .collect(toList());

         */
    }

    void skipping() {
        List<Dish> dishes = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)  //skip first two elements
                .collect(toList());
    }

    void mapping()  {
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());
    }

    void flatMapping()  {
        List<String> words = Arrays.asList("Hello", "World");

        //find distinct characters ()wrond approach since output of map function is Stream<String[]>
        words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(toList());

        //another wrong approach
        words.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList());

        //using flatMap
        //Using the flatMap method has the effect of mapping each array not with a stream but
        //with the contents of that stream
        List<String> uniqueCharacters =
                words.stream()
                        .map(word -> word.split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(toList());
    }


    void findingAndMatching() {
        if(menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }

        boolean isHealthy = menu.stream()
                .allMatch(dish -> dish.getCalories() < 1000);

        boolean isHealthy2 = menu.stream()
                .noneMatch(d -> d.getCalories() >= 1000);  //same result as above

        Optional<Dish> dish =
                menu.stream()
                        .filter(Dish::isVegetarian)
                        .findAny();


        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                        .map(n -> n * n)
                        .filter(n -> n % 3 == 0)
                        .findFirst(); // 9
    }

    void reducing() {
        //sum all the elements of a stream
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = someNumbers.stream().reduce(0, (a, b) -> a + b);
        int sum2 = someNumbers.stream().reduce(0, Integer::sum);

        Optional<Integer> sum3 = someNumbers.stream().reduce((a, b) -> (a + b));   //no inital value, returns optional

        Optional<Integer> max = someNumbers.stream().reduce(Integer::max);
        Optional<Integer> min = someNumbers.stream().reduce(Integer::min);
    }
}
