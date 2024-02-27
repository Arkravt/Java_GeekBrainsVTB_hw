package com.geekbrains.lesson7.solution1;

import com.geekbrains.lesson7.solution1.Car;

public abstract class Stage {
    protected int length;
    protected String description;

    public String getDescription() {
        return description;
    }

    public abstract void go(Car c);
}