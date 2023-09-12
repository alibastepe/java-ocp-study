package com.example.java_study.mjia.date_time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DurationExamples {

    void durationInit() {
        Duration d0 = Duration.between(date1, date2);  //ERROR  you can’t pass a LocalDate to the between method
        Duration d1 = Duration.between(time1, time2);
        Duration d2 = Duration.between(dateTime1, dateTime2);
        Duration d3 = Duration.between(instant1, instant2);

        Duration d4 = Duration.between(date, instant);  //ERROR. cannot mix temporal and instant

        Duration threeMinutes = Duration.ofMinutes(3);
        Duration oneSecond = Duration.ofSeconds(1);
        Duration threeMinutes2 = Duration.of(3, ChronoUnit.MINUTES);

        System.out.println(threeMinutes2);  //prints PT3M

        System.out.println(Duration.ofMillis(1)); // prints PT0.001S
    }

    void periodInit()  {
        //When you need to model an amount of time in terms of years, months, and days,
        //you can use the Period class
        Period tenDays = Period.between(LocalDate.of(2017, 9, 11),
                LocalDate.of(2017, 9, 21));

        Period tenDays2 = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
        Period sixWeeks = threeWeeks.multipliedBy(2);

        //methods cannot be chained when creating a Period. Since they are static methods, last mthod will be effective
        var period = Period.ofYears(1).ofWeeks(1);  //one week

        //period cannot be used with LocalTime objects since they only contain time info

        //when you print the value of a period, Java displays any NON-ZERO parts using the format P1Y2M3D
        System.out.println(Period.ofMonths(3));  //prints P3M


    }

}
