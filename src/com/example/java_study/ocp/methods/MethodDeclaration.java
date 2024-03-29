package com.example.java_study.ocp.methods;

public class MethodDeclaration {


    int g;
    public void skip1() {
        g++;
    }
    default void skip2() {} // DOES NOT COMPILE
    void public skip3() {}  // DOES NOT COMPILE
    void skip4() {}

    public void bike1() {}
    public final void bike2() {}
    public static final void bike3() {}
    public final static void bike4() {}
    public modifier void bike5() {}         // DOES NOT COMPILE
    public void final bike6() {}            // DOES NOT COMPILE
    final public void bike7() {}

    int getHeight1() {
        int temp = 9;
        return temp;
    }

    public void zooAnimalCheckup(boolean isWeekend) {
        final int rest; //only final is allowed for local variable
        if(isWeekend) rest = 5; else rest = 20;
        System.out.print(rest);  //this compiles because rest is definitely assigned a value aboe line

        final var giraffe = new Animal();
        final int[] friends = new int[5];

        rest = 10;               // DOES NOT COMPILE
        giraffe = new Animal();  // DOES NOT COMPILE
        friends = null;          // DOES NOT COMPILE
    }

    public void walkDog(int start, int... steps) {
        System.out.println(steps.length);
    }

    public void callVarArg() {
        walkDog(1, null);  //compiles, but throws null pointer exception at runtime
    }

}
