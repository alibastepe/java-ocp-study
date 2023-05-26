package com.example.java_study.mjia.default_methods;

public interface A {
    default void hello() {
        System.out.println("Hello from A");
    }
}
