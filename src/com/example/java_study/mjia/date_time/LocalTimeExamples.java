package com.example.java_study.mjia.date_time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalTimeExamples {
    LocalTime localTime;

    void localTimeInit() {
        localTime = LocalTime.of(13, 45, 20); // 13:45:20
        int hour = localTime.getHour();
        int minute = localTime.getMinute();
        int second = localTime.getSecond();

        LocalTime time = LocalTime.parse("13:45:20");
    }

    void localTimeManipulate() {
        var time1 = LocalTime.of(22, 9, 21);  //22:09:21
        var time2  = time1.plusHours(1);  //23:09:21
        var time3  = time2.withMinute(44);  //23:44:21
        var time4 = time3.with(ChronoField.MINUTE_OF_HOUR, 11);  //23:11:21
        var time5 = time4.truncatedTo(ChronoUnit.MINUTES); //23:11

        Duration duration = Duration.ofHours(4);
        var time6 = time5.plus(duration); // 03:11

    }
}
