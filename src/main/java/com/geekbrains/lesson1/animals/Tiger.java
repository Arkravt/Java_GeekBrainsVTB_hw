package com.geekbrains.lesson1.animals;

public class Tiger extends Cat {

    private static int count;

    public Tiger(String name, int runLimit, int swimLimit) {
        super(name, runLimit, swimLimit);
        count++;
    }

    public static int getCount() {
        return count;
    }
}
