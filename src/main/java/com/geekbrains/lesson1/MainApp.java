package com.geekbrains.lesson1;

import com.geekbrains.lesson1.animals.*;

public class MainApp {
    public static void main(String[] args) {

        Dog bob = new Dog("Собака Боб", 300, 40);
        Dog sam = new Dog("Собака Сэм", 200, 10);
        HouseCat tom = new HouseCat("Кот Кузя", 200);
        HouseCat barsik = new HouseCat("Кот Барсик", 250);
        Tiger tigra = new Tiger("Тигр Тигра", 500, 500);

        Animal[] animals = {bob, sam, tom, barsik, tigra};

        for (Animal animal : animals) {
            animal.run(100);
            animal.swim(50);
        }

        System.out.println("Количество собак: " + Dog.getCount());
        System.out.println("Количество домашних кошек: " + HouseCat.getCount());
        System.out.println("Количество тигров: " + Tiger.getCount());


    }
}
