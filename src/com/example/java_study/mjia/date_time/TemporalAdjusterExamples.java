package com.example.java_study.mjia.date_time;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.time.temporal.TemporalAdjusters.*;

public class TemporalAdjusterExamples {
    void manipulate()  {
        LocalDate date1 = LocalDate.of(2014, 3, 18);  // 2014-03-18
        LocalDate date2 = date1.with(nextOrSame(DayOfWeek.SUNDAY));  // 2014-03-23
        LocalDate date3 = date2.with(lastDayOfMonth());  // 2014-03-31
    }

}
