package com.geekbrains.lesson13_Spring_Core.example;

public class Car {

    private Engine engine;
    private int engineTemp;

    //////// Constructor ////////
    public Car(Engine engine, int engineTemp) {
        this.engine = engine;
        this.engineTemp = engineTemp;
    }

    public Car() {
    }
    //////// Constructor ////////

    //////// GETTER AND SETTER ////////
    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getEngineTemp() {
        return engineTemp;
    }

    public void setEngineTemp(int engineTemp) {
        this.engineTemp = engineTemp;
    }
    //////// GETTER AND SETTER ////////

    public void go() {
        engine.startEngine();
        if (engineTemp > 60)
            System.out.println("car is going ! ");
        else
            System.out.println("car is not going ! Temp is too low !!!");
    }

}
