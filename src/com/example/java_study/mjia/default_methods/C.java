package com.example.java_study.mjia.default_methods;

public class C extends D implements A, B {
    //three resolution rules
    //1. Classes always win. A method declaration in the class or a superclass takes priority over any default method declaration.
    //2. Otherwise, subinterfaces win: the method with the same signature in the most
    //specific default-providing interface is selected.
    //3. Finally, if the choice is still ambiguous, the class inheriting from multiple interfaces
    //has to explicitly select which default method implementation to use by
    //overriding it and calling the desired method explicitly

    public static void main(String... args) {
        //prints "Hello from B". Classes always win but class D does not provide and implementation,
        //so hello() is indirectly used from A. So rule 2 applies because B is more specific,
        //if class D provided an implementation it would be effective
        new C().hello();
    }



    //method below is required if A and B are not related. Rule 3 applies
    /*
    @Override
    public void hello() {
        B.super.hello();  //since
    }
    */

}
