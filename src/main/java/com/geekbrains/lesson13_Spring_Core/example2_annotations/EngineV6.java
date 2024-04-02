package com.geekbrains.lesson13_Spring_Core.example2_annotations;

import org.springframework.stereotype.Component;

@Component
public class EngineV6 implements Engine{
    @Override
    public void startEngine() {
        System.out.println("starting v6 engine");
    }
}
