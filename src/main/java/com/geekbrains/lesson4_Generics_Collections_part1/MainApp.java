package com.geekbrains.lesson4_Generics_Collections_part1;

import com.geekbrains.lesson4_Generics_Collections_part1.fruits.Apple;
import com.geekbrains.lesson4_Generics_Collections_part1.fruits.Box;
import com.geekbrains.lesson4_Generics_Collections_part1.fruits.Fruit;
import com.geekbrains.lesson4_Generics_Collections_part1.fruits.Orange;

public class MainApp {
    public static void main(String[] args) {

        //String[] myArr = {"he", "2", "3", "4", "5", "6", "7", "8", "9"};

        Box<Fruit> box = new Box<>();

        Box<Orange> orangeBox = new Box<>(new Orange(1.5f));
        Box<Orange> orangeBox2 = new Box<>(new Orange(1.5f));

        Box<Apple> appleBox = new Box<>(new Apple(1.0f));
        Box<Apple> appleBox2 = new Box<>(new Apple(1.0f));

        appleBox.move(box);
        orangeBox.move(orangeBox);


        for(Fruit fruit: box.container) {
            System.out.println(fruit.getClass().getSimpleName());
        }



    }
}
