package com.example.java_study.mjia.date_time;

import java.time.*;

public class TimeZoneExamples {
    // About 40 time zones are held in instances of the ZoneRules class
    // All the region IDs are in the format "{area}/{city}"
    ZoneId romeZone = ZoneId.of("Europe/Rome");

    void timeZone() {
        //When you have a ZoneId object, you can combine it with a LocalDate, a LocalDate-Time
        // or an Instant to transform it into ZonedDateTime instances
        LocalDate date = LocalDate.of(2014, Month.MARCH, 18);
        ZonedDateTime zdt1 = date.atStartOfDay(romeZone);
        LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        ZonedDateTime zdt2 = dateTime.atZone(romeZone);
        Instant instant = Instant.now();
        ZonedDateTime zdt3 = instant.atZone(romeZone);
    }

    void zoneOffset() {
        ZoneOffset newYorkOffset = ZoneOffset.of("-05:00");
        LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        OffsetDateTime dateTimeInNewYork = OffsetDateTime.of(date, newYorkOffset);
    }
}
