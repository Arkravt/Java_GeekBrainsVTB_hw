package com.geekbrains.lesson2_OOP_Advanced_level.solution1.obstacles;

import com.geekbrains.lesson2_OOP_Advanced_level.solution1.moving.Movable;

public class Treadmill extends Obstacle {
    private int length;

    public Treadmill(int length) {
        this.length = length;
    }

    @Override
    public boolean obstaclePassed(Movable mover) {
        return mover.run(length);
    }
}
