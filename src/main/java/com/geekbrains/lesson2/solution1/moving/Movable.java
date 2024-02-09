package com.geekbrains.lesson2.solution1.moving;

import com.geekbrains.lesson2.solution1.obstacles.Obstacle;

public interface Movable {
    boolean run(int length);

    boolean jump(int height);

}
