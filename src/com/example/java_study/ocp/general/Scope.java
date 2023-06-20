package com.example.java_study.ocp.general;

public class Scope {

    public void eatIfHungry(boolean hungry) {
           if (hungry) {
                 int bitesOfCheese = 1;
                  {
                      var teenyBit = true;
                      System.out.println(bitesOfCheese);
                  }
           }
           System.out.println(teenyBit); // DOES NOT COMPILE
    }
}
