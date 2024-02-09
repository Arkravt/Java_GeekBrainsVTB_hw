package com.geekbrains.lesson2.solution1.moving;

import com.geekbrains.lesson2.solution1.obstacles.Obstacle;

public class Human implements Movable {

    private String name;
    private TypeOfMoving type;
    private int runLimit;
    private int jumpLimit;

    public Human(String name, TypeOfMoving type, int runLimit, int jumpLimit) {
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        this.name = name;
        this.type = type;
    }


    @Override
    public boolean run(int length) {
        if (length < runLimit) {
            System.out.println(type.getRussianTitle() + " " + name + " пробежал " + length);
            return true;
        }
        System.out.println(type.getRussianTitle() + " " + name + " НЕ пробежал " + length);
        return false;
    }

    @Override
    public boolean jump(int height) {
        if (height < jumpLimit) {
            System.out.println(type.getRussianTitle() + " " + name + " перепрыгнул " + height);
            return true;
        }
        System.out.println(type.getRussianTitle() + " " + name + " НЕ перепрыгнул " + height);
        return false;
    }
}
