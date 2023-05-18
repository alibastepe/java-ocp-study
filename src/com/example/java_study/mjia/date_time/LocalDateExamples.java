package com.example.java_study.mjia.date_time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalDateExamples {
    LocalDate localDate;

    void localDateInit() {
        localDate = LocalDate.of(2023, 5, 18);  //2023-05-18
        Month month = localDate.getMonth(); //MAY
        DayOfWeek dow = localDate.getDayOfWeek();  //THURSDAY
        int len = localDate.lengthOfMonth(); // 31 days in May

        LocalDate today = LocalDate.now();

        int year = localDate.get(ChronoField.YEAR);
        int month2 = localDate.get(ChronoField.MONTH_OF_YEAR);
        int day = localDate.get(ChronoField.DAY_OF_MONTH);


        LocalDate date = LocalDate.parse("2017-09-21");
    }

    void localDateManipulate() {
        LocalDate date1 = LocalDate.of(2017, 9, 21);  //2017-09-21
        LocalDate date2 = date1.withYear(2011);   //2011-09-21
        LocalDate date3 = date2.withDayOfMonth(25);  //2011-09-25
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 2);  //2011-02-25


        LocalDate date5 = LocalDate.of(2017, 9, 21);  // 2017-09-21
        LocalDate date6 = date5.plusWeeks(1);  // 2017-09-28
        LocalDate date7 = date6.minusYears(6);  // 2011-09-28
        LocalDate date8 = date7.plus(6, ChronoUnit.MONTHS);  // 2012-03-28
    }
}
