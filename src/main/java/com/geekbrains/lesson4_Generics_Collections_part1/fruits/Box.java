package com.geekbrains.lesson4_Generics_Collections_part1.fruits;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {

    public ArrayList<T> container;


    public Box() {
        this.container = new ArrayList<>();
    }

    public Box(T... fruits) {
        this.container = new ArrayList<>(Arrays.asList(fruits));
    }


    public void add(T fruit) {
        container.add(fruit);
    }

    public T get(int index) {
        return container.get(index);
    }


    public float getWeight() {
        float boxWeight = 0;
        for (T fruit : container) {
            boxWeight += fruit.getWeight();
        }
        return boxWeight;
    }

    public boolean compare(Box<?> anotherBox) {
        return getWeight() - anotherBox.getWeight() == 0;
    }

    public void move(Box<? super T> anotherBox) {

        if (this == anotherBox)
            return;

        anotherBox.container.addAll(container);
        container.clear();
    }

}
