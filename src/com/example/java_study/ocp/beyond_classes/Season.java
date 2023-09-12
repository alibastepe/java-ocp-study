package com.example.java_study.ocp.beyond_classes;


public enum Season implements Weather{
    WINTER {
        @Override
        public String getHours() {
            return "10am-3pm";
        }
    },
    SPRING, SUMMER, AUTUMN;  //these use the method below, winter overrides it

    public String getHours() {
        return "";
    };

    @Override
    public int getAverageTemperature() {
        return 0;
    }

    public EnumExample() {  //constructor can only be private

    }

}

interface Weather {
    int getAverageTemperature();
}
