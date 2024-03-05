package com.geekbrains.lesson1_OOP_basic_level.animals;

public class HouseCat extends Cat {

    private static int count;

    public HouseCat(String name, int runLimit) {
        super(name, runLimit, 0);
        count++;
    }

    public static int getCount() {
        return count;
    }

}
