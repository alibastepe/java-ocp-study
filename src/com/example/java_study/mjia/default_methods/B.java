package com.example.java_study.mjia.default_methods;

public interface B extends A{
    default void hello() {
        System.out.println("Hello from B");
    }
}
