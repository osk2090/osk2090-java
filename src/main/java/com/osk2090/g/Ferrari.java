package com.osk2090.g;

public class Ferrari extends AbstractCar {


    public Ferrari(String model, int cc) {
        super(model, cc);
    }

    @Override
    public void run() {
        System.out.println("부릉부릉 달린다");
    }

}