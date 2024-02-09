package com.geekbrains.lesson2.solution1;

import com.geekbrains.lesson2.solution1.moving.*;
import com.geekbrains.lesson2.solution1.obstacles.*;

public class MainApp {
    public static void main(String[] args) {
        Movable[] participants = {
                new Human("Vann", TypeOfMoving.HUMAN, 2000, 2),
                new Cat("Barsik", TypeOfMoving.CAT, 300, 4),
                new Robot("Robo", TypeOfMoving.ROBOT, 5000, 7)
        };

        Obstacle[] obstacles = {
                new Treadmill(450),
                new Wall(2)
        };

        for (Movable participant : participants) {
            for (Obstacle obstacle : obstacles) {
                if (!obstacle.obstaclePassed(participant)) break;
            }
        }

    }
}