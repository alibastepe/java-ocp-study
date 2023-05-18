package com.example.java_study.mjia.optionals;

import java.util.Optional;

public class OptionalInitialize  {
    void initialize() {
        Optional.of(null); //error

        Optional.ofNullable(null); // no error

        Optional<String> optStr = Optional.empty();

    }

    void extractValue() {
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        Optional<String> name = optInsurance.map(Insurance::getName);


        //person.getCar().getInsurance().getName();
        //rewrite the above chain with optional flatMap
       /* person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
         */


        //Finding distinct insurance company names used by a list of persons
        /*(List<Person> persons) {
             persons.stream()
                    .map(Person::getCar)
                    .map(optCar -> optCar.flatMap(Car::getInsurance))
                    .map(optIns -> optIns.map(Insurance::getName))
                    .flatMap(Optional::stream)   //convert Stream<Optional<String>> to Stream<String>
                    .collect(toSet());

         */

    }

    void filtering() {
        Optional<Insurance> optInsurance = ...;
        optInsurance.filter(insurance ->
                        "CambridgeInsurance".equals(insurance.getName()))
                .ifPresent(x -> System.out.println("ok"));
    }


}
