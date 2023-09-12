package com.example.java_study.mjia.date_time;

import java.time.Duration;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;

public class InstantExamples {
    //Instant class represents the number of seconds passed since
    //the Unix epoch time, set by convention to midnight of January 1, 1970 UTC.

    //Instant is intended for use only by a machine

    void instantInit() {
        //all of the below is same (3 seconds)
        Instant.ofEpochSecond(3);
        Instant.ofEpochSecond(3, 0);
        Instant.ofEpochSecond(2, 1_000_000_000);  //One billion nanoseconds (1 second) after 2 seconds
        Instant.ofEpochSecond(4, -1_000_000_000); //One billion nanoseconds (1 second) before 4 seconds

        //instant doesn’t provide any ability to handle units of time
        //that are meaningful to humans.
        int day = Instant.now().get(ChronoField.DAY_OF_MONTH); //ERROR

        var now = Instant.now();
        var later = Instant.now();
        Duration.between(now, later).toMillis();

        //ZonedDatetime can be converted to an instant but LocalDateTime cannot becuase it does not contain zone info
        var zoned = ZonedDateTime.now();
        zoned.toInstant(); // converted to GMT
    }
}
