package com.example.java_study.mjia.streams;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamBuild {

    void fromValues()  {
        Stream<String> stream = Stream.of("Modern ", "Java ", "In ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        Stream<String> emptyStream = Stream.empty();
    }

    void fromArray() {
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();
    }

    void fromFile()  {
        long uniqueWords = 0;

        //Files.lines returns a stream where each element is a line in the given file.
        try(Stream<String> lines =
                    Files.lines(Paths.get("data.txt"), Charset.defaultCharset())){
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        }
        catch(IOException e){
        }
    }

    void fromFunctions()  {
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        //an infinite stream of
        //ones
        IntStream ones = IntStream.generate(() -> 1);
    }
}
