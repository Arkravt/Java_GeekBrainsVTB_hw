package com.geekbrains.lesson7_Multithreading_Part2.solution1;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private Semaphore tunnelCapacity;

    public Tunnel(int tunnelСapacityCount) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.tunnelCapacity = new Semaphore(tunnelСapacityCount);
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
            tunnelCapacity.acquire();
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            tunnelCapacity.release();
        }
    }
}

