package com.example.java_study.ocp.beyond_classes.sealing.same_file_or_nested;

public sealed class Snake {  // "permits" keyword can be omitted since they are in the same file/ nested class. If "permits" is added, both classes (Cobra and MyCobra) must be added
    final class Mycobra extends Snake {

    }
}

final class Cobra extends Snake {

}
