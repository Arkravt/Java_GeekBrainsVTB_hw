package com.geekbrains.lesson13_Spring_Core.example2_annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {
    private Engine engine;
    private int engineTemp;


    //////// Constructor ////////
    @Autowired
    public Car(Engine engine, @Value("10") int engineTemp) {
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
