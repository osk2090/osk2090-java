package com.osk2090.g;

public abstract class AbstractCar implements CarSpec {

    String model;
    int cc;

    public AbstractCar(String model, int cc) {
        System.out.printf("모델명: %s, 배기량: %d\n", model, cc);
    }

    @Override
    public void on() {
        System.out.println("시동을 켠다");
    }

    @Override
    public void off() {
        System.out.println("시동을 끈다");
    }

    @Override
    public abstract void run();
}