package com.osk2090.g;

public class Sonata extends AbstractCar {

    public Sonata(String model, int cc) {
        super(model, cc);

    }
    @Override
    public void run() {
        System.out.println("씽씽 달린다");
    }
}