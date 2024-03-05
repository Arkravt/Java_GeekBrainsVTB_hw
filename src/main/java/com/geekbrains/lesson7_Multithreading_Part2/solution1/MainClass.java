package com.geekbrains.lesson7_Multithreading_Part2.solution1;

import java.util.concurrent.BrokenBarrierException;

public class MainClass {

    public static void main(String[] args) {
        Race race = new Race(new Road(60), new Tunnel(2), new Road(40));
        try {
            race.startRace();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}


