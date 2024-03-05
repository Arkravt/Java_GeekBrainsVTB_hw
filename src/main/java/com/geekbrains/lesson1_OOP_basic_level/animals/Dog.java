package com.geekbrains.lesson1_OOP_basic_level.animals;

public class Dog extends Animal {

    private static int count;

    public Dog(String name, int runLimit, int swimLimit) {
        super(name, runLimit, swimLimit);
        count++;
    }

    public static int getCount() {
        return count;
    }
}
