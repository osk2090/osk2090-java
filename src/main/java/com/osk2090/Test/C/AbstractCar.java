package com.osk2090.Test.C;

public abstract class AbstractCar implements Car {
    @Override
    public void wheel() {}

    @Override
    public void accelerator() {}

    @Override
    public void engine() {}

    @Override
    public void handle() {}

    @Override
    public void stopBreak() {}

    public static void main(String[] args) {
        Engine engine = new Engine();
        Accelerator accelerator = new Accelerator();
        Wheel wheel = new Wheel();
        Handle handle = new Handle();
        StopBreak stopBreak = new StopBreak();

        engine.engine();
        accelerator.accelerator();
        wheel.wheel();
        handle.handle();
        stopBreak.stopBreak();
    }
}