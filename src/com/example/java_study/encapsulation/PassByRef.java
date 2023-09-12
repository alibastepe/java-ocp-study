package com.example.java_study.encapsulation;

public class PassByRef {
    Person person1 = new Person("a");
    Person person2 = new Person("b");

    public PassByRef() {
        swapPersons(person1, person2);

        //reassigning object references(in swap method) does not change the original
        System.out.println(person1);  //prints "a"
        System.out.println(person2);   //prints "b"

    }


    private void swapPersons(Person p1, Person p2)  {
        Person temp = p1;
        p1 = p2;
        p2 = temp;
    }
}
