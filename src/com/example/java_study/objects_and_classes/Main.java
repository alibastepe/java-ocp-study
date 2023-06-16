//package name convention:
// all in lowercase,
// seperated by dot,
// can contain letters, digits, underscore
package com.example.java_study.objects_and_classes;

//import tempClass;  //ERROR default package classes cannot be imported from a named packaged class
import static java.util.stream.Collectors.*;

//  import java.awt.List;  //ERROR importing classes with same name


public class Main {
    public static void main(String[] args)  {
        toList();  //imported statically from Collectors

    }

    //public-static changeable. This is also valid
   /* static public void main(String... args)  {

    }*/

    //NOT runnable main method because signature is different
    public static void main(String args)  {

    }
}
