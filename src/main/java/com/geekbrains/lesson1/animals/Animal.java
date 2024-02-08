package com.geekbrains.lesson1.animals;

public abstract class Animal {

    String name;
    int runLimit;
    int swimLimit;

    private static int count;

    public Animal(String name, int runLimit, int swimLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        count++;
    }


    public void swim(int distance) {
        if (swimLimit == 0) {
            System.out.println(name + " это животное не умеет плавать");
            return;
        }

        if (swimLimit < distance)
            System.out.println(name + " не смог проплыть " + distance + " м");
        else
            System.out.println(name + " проплыл " + distance + " м");
    }

    public void run(int distance) {
        if (runLimit < distance)
            System.out.println(name + " не смог пробежать " + distance + " м");
        else
            System.out.println(name + " пробежал " + distance + " м");
    }


    public static int getCount() {
        return count;
    }

}
