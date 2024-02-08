package com.geekbrains.lesson1.animals;

public abstract class Cat extends Animal {

    private static int count;

    public Cat(String name, int runLimit, int swimLimit) {
        super(name, runLimit, swimLimit);
        count++;
    }

    public static int getCount() {
        return count;
    }

}


