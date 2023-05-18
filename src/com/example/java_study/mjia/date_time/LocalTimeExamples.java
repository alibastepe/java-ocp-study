package com.example.java_study.mjia.date_time;

import java.time.LocalTime;

public class LocalTimeExamples {
    LocalTime localTime;

    void localTimeInit() {
        localTime = LocalTime.of(13, 45, 20); // 13:45:20
        int hour = localTime.getHour();
        int minute = localTime.getMinute();
        int second = localTime.getSecond();

        LocalTime time = LocalTime.parse("13:45:20");
    }
}
