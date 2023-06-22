package com.example.java_study.ocp.decision;

public class SwitchExamples {
    //list of all data types supported by switch statements:
    //int and Integer
    //byte and Byte
    //short and Short
    //char and Character
    //String
    //enum values
    //var (if the type resolves to one of the preceding types)

    void combinedSwitch() {
        var animal = 1;
        //with java 14 cases can be combined
        switch(animal) {
            case 1,2: System.out.print("Lion");
            case 3:   System.out.print("Tiger");
        }

        //before java 14
        switch(animal) {
            case 1: case 2: System.out.print("Lion");
            case 3:         System.out.print("Tiger");
        }

        switch(animal) {}   //  VALID


    }

    public void printDayOfWeek(short day) {
        switch(day) {
            case 0:
                System.out.print("Sunday");
                break;
            case 1:
                System.out.print("Monday");
                break;
            case 2:
                System.out.print("Tuesday");
                break;
            default:  //default can be anywhere
                System.out.print("Invalid value");
                break;
            case 3:
                System.out.print("Wednesday");
                break;
            case 4:
                System.out.print("Thursday");
                break;
            case 5:
                System.out.print("Friday");
                break;
            case 6:
                System.out.print("Saturday");
                break;

        }
    }

    public void printSeason(int month) {
        //a call to printSeason(2) will print everything   (WinterSpringUnknownSummerFall)
        //without break statement the code will execute every branch following a matching case statement,
        // including any default statements it finds
        switch(month) {
            case 1, 2, 3:    System.out.print("Winter");
            case 4, 5, 6:    System.out.print("Spring");
            default:         System.out.print("Unknown");
            case 7, 8, 9:    System.out.print("Summer");
            case 10, 11, 12: System.out.print("Fall");
        }
    }

    public void acceptableCaseValues() {
        //the values in each case statement must be compile-time constant values
        // of the same data type as the switch value

        //you can't have a case statement value that requires executing
        // a method at runtime, even if that method always returns the same value
        final int bananas = 1;
        int apples = 2;
        int numberOfAnimals = 3;
        final int cookies = getCookies();
        switch(numberOfAnimals) {
            case bananas:
            case apples:        // DOES NOT COMPILE. not constant
            case getCookies():  // DOES NOT COMPILE  must be final constant variable not a method call(runtime)
            case cookies :      // DOES NOT COMPILE
            case 3 * 5 :
        }
    }

    final int getCookies() { return 4; }

    void switchExpression() {

    }

    public void printDayOfWeekWithSwitchExpression(int day) {
        var result = switch(day) {
            case 0,8 -> "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "Invalid value";
        };
        System.out.print(result);
    }

    public void printSeasonWithExpression(int month) {
        switch(month) {
            case 1, 2, 3    -> System.out.print("Winter");
            case 4, 5, 6    -> System.out.print("Spring");
            case 7, 8, 9    -> System.out.print("Summer");
            case 10, 11, 12 -> System.out.print("Fall");
        }
    }

    void consistentDataType() {
        int measurement = 10;
        int size = switch(measurement) {
            case 5 -> 1;
            case 10 -> (short)2;
            default -> 5;
            case 20 -> "3";   // DOES NOT COMPILE   the values have to be consistent with size
            case 40 -> 4L;    // DOES NOT COMPILE  the values have to be consistent with size
            case 50 -> null;  // DOES NOT COMPILE  the values have to be consistent with size
        };
    }

    void yieldExample() {
        int fish = 5;
        int length = 12;
        //all branches must yield a value within the case block.
        var name = switch(fish) {
            case 1 -> "Goldfish";
            case 2 -> {yield "Trout";}
            case 3 -> {
                if(length > 10) yield "Blobfish";
                else yield "Green";
            }
            default -> "Swordfish";
        };

        //semicolon requirements
        var name2 = switch(fish) {
            case 1 -> "Goldfish"         // DOES NOT COMPILE (missing semicolon)
            case 2 -> {yield "Trout";}; // DOES NOT COMPILE (extra semicolon)
        }  // DOES NOT COMPILE (missing semicolon)
    }

    void coverAllPossibleValues() {
        int canis = 5;
        String type = switch(canis) { // DOES NOT COMPILE. add default branch
            case 1 -> "dog";
            case 2 -> "wolf";
            case 3 -> "coyote";
        };

        enum Season {WINTER, SPRING, SUMMER, FALL}
        Season value = null;
        //since all possible values for enum is covered, default branch is not reuqired
        String name = switch(value) {
            case WINTER -> "Cold";
            case SPRING -> "Rainy";
            case SUMMER -> "Hot";
            case FALL -> "Warm";
        };

    }


}
