package com.geekbrains.lesson7_Multithreading_Part2.solution1;

public abstract class Stage {
    protected int length;
    protected String description;

    public String getDescription() {
        return description;
    }

    public abstract void go(Car c);
}