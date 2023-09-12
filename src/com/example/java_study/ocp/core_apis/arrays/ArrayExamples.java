package com.example.java_study.ocp.core_apis.arrays;

import java.util.Arrays;

public class ArrayExamples {

    void initialization() {
        //asll of the below declarations is valid
        int[] arr1;
        int [] arr2;
        int [] arr3;
        int arr4[];
        int arr5 [];

        int[] ids, types;  //both of them are of type int[]
        int ids2[], types2;  // ids2 is of type int[], types is of type int
    }

    void equalityCheckAndPrinting() {
        //equals method on arrays does not look at the elements of the array.
        String[] bugs = {"cricket", "beetle", "ladybug"};
        String[] alias = bugs;
        bugs.equals(alias); // true
        bugs.toString(); // something like [Ljava.lang.String;160bc7c0
        Arrays.toString(bugs);  // [cricket, beetle, ladybug]
    }

    void castingExample()  {
        String[] strings = {"myStr"};
        Object[] objects = strings;
        String[] againStrings = (String[]) objects;
        objects[0] = new StringBuilder(); //CAREFUL. compiles but throws a runtime exception ArrayStoreException
    }

    void sorting()  {
        int[] numbers = {6, 9, 1};
        Arrays.sort(numbers);
    }

    void searching()  {
        //array must be sorted
        int[] numbers = {2,4,6,8};
        Arrays.binarySearch(numbers, 2); // 0
        Arrays.binarySearch(numbers, 3); // -2  (Negative value showing one smaller than the negative of index where a match needs to be inserted to preserve sorted order)
    }

    void comparing()  {
        //null is smaller than any value
        //numbers are smaller than letters
        //uppercase letters are smaller than lowercase letters
        //for strings, one is smaller if it is a prefix of another
        //arrays MUST be of same type
        Arrays.compare(new int[] {1,2}, new int[] {1});  //returns positive number
        Arrays.compare(new int[] {1,2}, new int[] {1,2});  //return 0 (exact match)
        Arrays.compare(new String[] {"a"}, new String[] {"aa"});  //return negative number (a is substring of aa)
    }

    void mismatchExamples()  {
        Arrays.mismatch(new int[] {1}, new int[]{1});  //returns -1
        Arrays.mismatch(new String[] {"q"}, new String[]{"Q"}); // returns 0 (first different index)
        Arrays.mismatch(new int[] {1,2}, new int[]{1}); // returns 1 (first different index)
    }

    void varargExamples() {

    }
}
