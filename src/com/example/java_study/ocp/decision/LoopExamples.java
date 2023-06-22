package com.example.java_study.ocp.decision;

public class LoopExamples {
    void forExamples() {
        int x = 0;
        for(long y = 0, int z = 4; x < 5; x++)  // DOES NOT COMPILE. the variables in the initialization block must all be of the same type
        System.out.print(y + " ");

        String[] names;
        for(var name : names)
            System.out.println(name);

        String birds = "Jay";
        for(String bird : birds)  // DOES NOT COMPILE. String does not implement ITerable
            System.out.print(bird + " ");

        String[] sloths = new String[3];
        for(int sloth : sloths)    // DOES NOT COMPILE. incompatible types
            System.out.print(sloth + " ");
    }

    void labelExample() {
        int[][] myComplexArray = {{5,2,1,3},{3,9,8,9},{5,7,12,7}};

        OUTER_LOOP:  for(int[] mySimpleArray : myComplexArray) {
            INNER_LOOP:  for(int i=0; i<mySimpleArray.length; i++) {
                System.out.print(mySimpleArray[i]+"\t");
            }
            System.out.println();
        }


        int frog = 15;
        BAD_IDEA: if(frog>10)
            EVEN_WORSE_IDEA: {
                frog++;
            }
    }

    void continueExample() {

        CLEANING:
        for (char stables = 'a'; stables <= 'd'; stables++) {
            for (int leopard = 1; leopard < 4; leopard++) {
                if (stables == 'b' || leopard == 2) {
                    continue CLEANING;
                }
                System.out.println("Cleaning: " + stables + "," + leopard);
            }
        }
        //the code above prints
        /*Cleaning: a,1
        Cleaning: c,1
        Cleaning: d,1 */

        //if we remove CLEANING from continue statement,
        /*Cleaning: a,1
        Cleaning: a,3
        Cleaning: c,1
        Cleaning: c,3
        Cleaning: d,1
        Cleaning: d,3 */

        //if we remove continue completely,
        /*Cleaning: a,1
        Cleaning: a,2
        Cleaning: a,3
        Cleaning: b,1
        Cleaning: b,2
        Cleaning: b,3
        Cleaning: c,1
        Cleaning: c,2
        Cleaning: c,3
        Cleaning: d,1
        Cleaning: d,2
        Cleaning: d,3 */
    }
}
