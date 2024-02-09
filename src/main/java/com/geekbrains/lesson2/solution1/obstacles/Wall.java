package com.geekbrains.lesson2.solution1.obstacles;

import com.geekbrains.lesson2.solution1.moving.Movable;

public class Wall extends Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean obstaclePassed(Movable mover) {
        return mover.jump(height);
    }
}
