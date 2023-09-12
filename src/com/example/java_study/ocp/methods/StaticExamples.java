package com.example.java_study.ocp.methods;

import static java.util.Arrays.asList;
public class StaticExamples {

    void wrongUseOfStaticImport() {
        Arrays.asList("one");  //does NOT compile because asList method is imported but Arrays class is NOT
    }

    class Snake {
        public static long hiss = 2;

    }

    void accessStaticData() {
        Snake s = null;
        System.out.println(s.hiss);  //compiler checks type reference instead of object
    }

    class Giraffe {
        public void eat(Giraffe g) {};  //can call both static and instance methods directly (drink() is valid)
        public void drink() {};
        public static void allGiraffeGoHome(Giraffe g) {};  //can call static methods directly, but must use instance to call eat and drink (g.eat() is valid, drink() is NOT)
        public static void allGiraffeComeOut() {};

    }

    class Panda {
        final static String name = "Ronda";  //assgined at declaration, that is OK
        static final int bamboo;
        static final double height;  //not assigned a value anywhere, so NOT compiles

        //static initializers will be called in the order they are defined (but as a best practice, try to use only one)
        static {
            bamboo = 5;  //assigned in a static initializer, tha is also OK
        }
    }
}
