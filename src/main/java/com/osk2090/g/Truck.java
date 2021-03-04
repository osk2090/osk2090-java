package com.osk2090.g;

public class Truck extends AbstractCar {
    public Truck(String model, int cc) {
        super(model, cc);
    }

    @Override
    public void run() {
        System.out.println("덜컹덜컹 달린다");
    }
}