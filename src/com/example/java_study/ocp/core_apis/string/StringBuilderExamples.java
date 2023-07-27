package com.example.java_study.ocp.core_apis.string;

public class StringBuilderExamples {

    void initialization() {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("animal");
        StringBuilder sb3 = new StringBuilder(10);
    }

    void commonMethodsWithString() {
        var sb = new StringBuilder("animals");
        String sub = sb.substring(sb.indexOf("a"), sb.indexOf("al"));
        int len = sb.length();
        char ch = sb.charAt(6);
        System.out.println(sub + " " + len + " " + ch);  //anim 7 s
    }

    void appending() {
        var sb = new StringBuilder().append(1).append('c');
        sb.append("-").append(true);
        System.out.println(sb);      // 1c-true
    }

    void inserting() {
        var sb = new StringBuilder("animals");
        sb.insert(7, "-");  // sb = animals-
        sb.insert(0, "-");  // sb = -animals-
        sb.insert(4, "-");  // sb = -ani-mals-
        System.out.println(sb);
    }

    void deleting() {
        var sb = new StringBuilder("abcdef");
        sb.delete(1, 3);     // sb = adef
        sb.deleteCharAt(5);  // exception

        //The delete() method is more flexible than some others when it comes to array indexes.
        //If you specify a second parameter that is past the end of the StringBuilder, Java will just assume you meant the end.
        var sb2 = new StringBuilder("abcdef");
        sb2.delete(1, 100);                  // sb = a
    }

    void replacing() {
        var builder = new StringBuilder("pigeon dirty");
        builder.replace(3, 6, "sty");
        System.out.println(builder);  // pigsty dirty

        builder = new StringBuilder("pigeon dirty");
        builder.replace(3, 100, "");
        System.out.println(builder);  //pig
    }
}
